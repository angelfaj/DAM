package app;

import org.neodatis.odb.CorruptedDatabaseException;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.ODBRuntimeException;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.core.query.criteria.ICriterion;
import org.neodatis.odb.core.query.criteria.Or;
import org.neodatis.odb.core.query.criteria.And;
import org.neodatis.odb.core.query.criteria.*;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;
import org.neodatis.odb.OID;
import org.neodatis.odb.core.oid.OIDFactory;
import org.neodatis.odb.Values;
import org.neodatis.odb.ObjectValues;
import org.neodatis.odb.impl.core.query.values.ValuesCriteriaQuery;
import org.neodatis.odb.OID;
import org.neodatis.odb.core.oid.OIDFactory;

import java.math.BigInteger;
import java.util.Scanner;

public class SoundWaveManager {

	private static final String DB_FILE = "soundwave.db";
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int opcion = 0;

		// Bucle del menú principal
		do {
			System.out.println("\n--- SOUNDWAVE MUSIC ---");
			System.out.println("1. Registrar Artista");
			System.out.println("2. Registrar Canción");
			System.out.println("3. Consulta: Filtro Underground (Dinámico)");
			System.out.println("4. Consulta: Auditoría de Artista");
			System.out.println("5. Baja de Canción por OID");
			System.out.println("6. Salir");
			System.out.print("Elige una opción: ");

			try {
				String entrada = sc.nextLine();
				opcion = Integer.parseInt(entrada);
			} catch (NumberFormatException e) {
				opcion = -1;
			}

			switch (opcion) {
			case 1:
				registrarArtista();
				break;
			case 2:
				registrarCancion();
				break;
			case 3:
				consultaUnderground();
				break;
			case 4:
				auditoriaArtista();
				break;
			case 5:
				bajaCancionOID();
				break;
			case 6:
				System.out.println("Cerrando sistema...");
				break;
			default:
				System.out.println("Opción no válida.");
				break;
			}
		} while (opcion != 6);
	}

	// --- 1. REGISTRAR ARTISTA (CE c, g) ---
	private static void registrarArtista() {
		ODB odb = ODBFactory.open(DB_FILE);
		try {
			System.out.println("--- Nuevo Artista ---");
			System.out.print("ID Artista: ");
			String id = sc.nextLine();
			
			Objects<Artista> artistas = odb.getObjects(Artista.class);
			
			boolean existe = false;
			while (artistas.hasNext() && !existe) {
				Artista a = artistas.next();
				if (id.equals(a.getId()))
					existe = true;
			}
			
			if (existe) {
				System.out.println("ERROR: El ID ya existe.");
			} else {
				System.out.print("Nombre: ");
				String nombre = sc.nextLine();
				System.out.print("Género Musical: ");
				String genero = sc.nextLine();
				System.out.print("Oyentes Mensuales: ");
				int oyentes = Integer.parseInt(sc.nextLine());
				
				Artista a = new Artista(id, nombre, genero, oyentes);
				odb.store(a);
				System.out.println("Artista registrado.");
			}
			
		}catch (Exception e) {
			System.out.println("ERROR, vuelve a intentarlo por favor.");
			odb.rollback();
		}
		odb.close();
	}

	// --- 2. REGISTRAR CANCIÓN (CE d) ---
	private static void registrarCancion() {
		ODB odb = ODBFactory.open(DB_FILE);
		
		try {
			Artista artistaObjeto = null;
			
			System.out.println("--- Nueva Canción ---");
			System.out.print("ID Artista (Dueño): ");
			String idArtista = sc.nextLine();
			
			Objects<Artista> artistas = odb.getObjects(Artista.class);
			
			boolean artistaExiste = false;
			while (artistas.hasNext() && !artistaExiste) {
				artistaObjeto = artistas.next();
				if (idArtista.equals(artistaObjeto.getId()))
					artistaExiste = true;
			}
			
			if (!artistaExiste) {
				System.out.println("ERROR: El artista no existe. Debe registrarlo primero.");
			}else {
				System.out.print("ID Canción: ");
				String id = sc.nextLine();
				
				Objects<Cancion> canciones = odb.getObjects(Cancion.class);
				
				boolean cancionExiste = false;
				while (canciones.hasNext() && !cancionExiste) {
					Cancion c = canciones.next();
					if (id.equals(c.getId()))
						cancionExiste = true;
				}
				
				if (cancionExiste) {
					System.out.println("ERROR: ID de canción duplicado.");
				}else {
					System.out.print("Título: ");
					String titulo = sc.nextLine();
					System.out.print("Duración (segundos): ");
					int duracion = Integer.parseInt(sc.nextLine());
					System.out.print("Reproducciones: ");
					int repro = Integer.parseInt(sc.nextLine());
					System.out.print("¿Es explícita? (true/false): ");
					boolean explicita = Boolean.parseBoolean(sc.nextLine());
					
					Cancion c = new Cancion(id, titulo, duracion, repro, explicita, artistaObjeto);
					odb.store(c);
					System.out.println("Canción registrada y vinculada a " + artistaObjeto.getNombre());
				}
			}
		}catch (Exception e) {
			System.out.println("ERROR, vuelve a intentarlo por favor.");
			odb.rollback();
		}
		odb.close();
	}

	// --- 3. CONSULTA UNDERGROUND ACTUALIZADA (CE e) ---
	// Criterio: Canciones con Duración < 2 min y también los que tengan el Artista
	// del género introducido por teclado
	private static void consultaUnderground() {
		ODB odb = ODBFactory.open(DB_FILE);
		
		try {
			System.out.println("\n--- Playlist Underground (Navegación) ---");
			System.out.print("Introduce el género (ej. Indie): ");
			String genero = sc.nextLine();
			
			ICriterion crit = new Or()
					.add(Where.lt("duracionSegundos", 120))
					.add(Where.equal("artista.generoMusical", genero));
			IQuery consulta = new CriteriaQuery(Cancion.class, crit);
			Objects<Cancion> resultados = odb.getObjects(consulta);
			
			if (resultados.size() == 0) {
				System.out.println("No hay canciones que cumplan el criterio.");
			}else {
				while (resultados.hasNext()) System.out.println(resultados.next().toString());
			}
			
		}catch (NumberFormatException e) {
			System.out.println("ERROR debes introducir caracteres válidos");
		}catch (Exception e) {
			System.out.println("ERROR desconocido, vuelve a intentarlo por favor.");
		}
		odb.close();
	}

	// --- 4. AUDITORÍA (CE e) ---
	private static void auditoriaArtista() {
		ODB odb = ODBFactory.open(DB_FILE);
		
		try {
			System.out.print("Introduce ID del artista a auditar: ");
			String idBusqueda = sc.nextLine();
			
			ICriterion crit = Where.equal("artista.id", idBusqueda);
			Values resultados = odb.getValues(new ValuesCriteriaQuery(Cancion.class, crit).count("id"));
			ObjectValues ov = resultados.getFirst();
			BigInteger nCanciones = (BigInteger) ov.getByIndex(0);
			
			System.out.println("Total de canciones de ese artista: " + nCanciones);
			
		}catch (NumberFormatException e) {
			System.out.println("ERROR debes introducir caracteres válidos");
		}catch (Exception e) {
			System.out.println("ERROR desconocido, vuelve a intentarlo por favor.");
		}
		odb.close();
	}

	// --- 5. BAJA POR OID (CE f) ---
	private static void bajaCancionOID() {
		// Si te resulta más cómodo puedes mostrar los OIDs por pantalla (es opcioanl,
		// no es obligatorio)
		// conviertiendo el OID de cada Canción a String con el método oidToString()
		// Ejemplo: OID miOID quiero mostrarlo por pantalla: miOID.oidToString()
		ODB odb = ODBFactory.open(DB_FILE);
		
		try {
			OID oid;
			
			System.out.println("--- OIDs Disponibles ---");
			Objects<Cancion> canciones = odb.getObjects(Cancion.class);
			while (canciones.hasNext()) {
				Cancion c = canciones.next();
				oid = odb.getObjectId(c);
				System.out.println("OID: " + oid + " -> " + c.getTitulo());
			}
			
			System.out.print("\nEscribe el OID (número) para recuperar y borrar: ");
			long oidNum = Long.parseLong(sc.nextLine());
			oid = OIDFactory.buildObjectOID(oidNum);
			Cancion c = null;
			
			c = (Cancion) odb.getObjectFromId(oid);
			
			// Mostrar datos para confirmar que hemos accedido a sus atributos (opcional)
			System.out.println("Canción recuperada (titulo): " + c.getTitulo());
			System.out.println("Procediendo a borrar canción con ID interno: " + c.getId());
			
			odb.delete(c);
			System.out.println("Eliminación exitosa.");
			
		}catch (ODBRuntimeException e) {
			System.out.println("ERROR: No se encontró un objeto con ese OID o hubo un fallo.");
		}catch (NumberFormatException e) {
			System.out.println("ERROR debes introducir caracteres válidos");
		}catch (Exception e) {
			System.out.println("ERROR desconocido, vuelve a intentarlo por favor.");
		}
		odb.close();
	}
}