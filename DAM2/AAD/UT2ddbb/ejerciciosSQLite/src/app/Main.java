package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
	private static Connection conn = null;
	
	public static Connection conectarSQLite() {
		try {
			String url = "jdbc:sqlite:miDB.db";
			conn = DriverManager.getConnection(url);
			System.out.println("Conexion con SQLite realizada correctamente");
		}catch (SQLException e) {
			System.out.println("Error en la conexion: " + e.getMessage());
		}
		return conn;
	}
	
	public static void desconectar() {
		try {
			if (conn != null) {
				conn.close();
				System.out.println("Conexión cerrada.");
			}
		} catch (SQLException e) {
			System.out.println("Error al cerrar conexión: " + e.getMessage());
		}
	}
	
	public static Connection conectarOracle() {
		try {
			String bd = "XE"; // Nombre de la bd
			String login = "C##BIBLIOTECA"; //Usuario de la bd
			String password = "password"; // Contraseña
			String urlOracle = "jdbc:oracle:thin:@localhost:1521:" + bd;
			// Driver para oracle
			String oracleDriver = "oracle.jdbc.driver.OracleDriver";
			Class.forName(oracleDriver);
			conn = DriverManager.getConnection(urlOracle, login, password);
			System.out.println("Conexion con ORACLE realizada correctamente");
			if (conn != null) {
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void crearTablaCanciones() {
		String sql = "CREATE TABLE IF NOT EXISTS canciones (\r\n"
						+ "    id INTEGER PRIMARY KEY AUTOINCREMENT,\r\n"
						+ "    titulo TEXT,\r\n"
						+ "    artista TEXT,\r\n"
						+ "    genero TEXT,\r\n"
						+ "    duracion_segundos INTEGER,\r\n"
						+ "    año_lanzamiento INTEGER\r\n"
						+ ")";
		try (Statement stmt = conn.createStatement()) {
			stmt.execute(sql);
			System.out.println("Tabla 'canciones' creada correctamente.");
		} catch (SQLException e) {
			System.out.println("Error al crear tabla: " + e.getMessage());
		}

	}
	
	public static void añadirCancion(String titulo, String artista, String genero, int duracion, int año) {
		String sql = "INSERT INTO canciones(titulo, artista, genero, duracion_segundos, año_lanzamiento) VALUES(?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, titulo);
            ps.setString(2, artista);
            ps.setString(3, genero);
            ps.setInt(4, duracion);
            ps.setInt(5, año);
            ps.executeUpdate();

            System.out.println("Cancion insertada correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al insertar cancion: " + e.getMessage());
        }
	}
	
	public static void main(String[] args) {
		/*1. Ejercicio de Configuración y Creación de la Base de Datos (Connection
		& CREATE)
		1. Asegura que el driver sqlite-jdbc.jar está correctamente añadido como
		External JAR en las propiedades de tu proyecto Eclipse (Java Build
		Path).
		2. Crea una clase GestorBD (o similar) e implementa la lógica para
		establecer la conexión a la base de datos musica.db.
		3. Dentro del método de conexión, incluye la sentencia SQL para crear la
		tabla CANCIONES con el esquema inicial (si no existe).
		4. Implementa un método desconectar() que cierre la conexión.*/

//		conectarSQLite();
//		crearTablaCanciones();
//		desconectar();
		
		/*2. Ejercicio de Inserción de Datos (CREATE - Altas)
		1. Crea un método llamado añadirCancion(String titulo, String artista, String
		genero, int duracion, int año).
		2. Utiliza un objeto PreparedStatement para insertar una nueva canción en
		la tabla.
		3. Inserta al menos 4 canciones distintas, asegurándote de usar los
		métodos setXXX() del PreparedStatement para evitar inyección SQL.*/
		
//		conectarSQLite();
//		añadirCancion("She Will", "Lil Wayne", "Trap", 5, 2011);
//		desconectar();

		/*3. Ejercicio de Consulta Específica (READ - Consultas con filtro)
		1. Crea un método llamado consultarCancionesPorGenero(String genero)
		que reciba el nombre del género a buscar.
		2. Utiliza un PreparedStatement para ejecutar la sentencia SELECT
		filtrando por el género recibido (WHERE genero = ?).
		3. Recorre el ResultSet devuelto y muestra por consola el Título, Artista y
		Duración de cada canción encontrada.
		4. Asegúrate de cerrar el ResultSet y el PreparedStatement.*/
		
//		conectarSQLite();
//		desconectar();
		
		/*4. Ejercicio de Modificación de Datos (UPDATE - Actualización)
		1. Crea un método llamado actualizarDuracionCancion(int idCancion, int
		nuevaDuracion).
		2. Utiliza un PreparedStatement y la sentencia UPDATE para cambiar el
		campo duracion_segundos de la canción cuyo id coincida con idCancion.
		3. Verifica que el método executeUpdate() devuelva 1 (una fila afectada)
		para confirmar la modificación.*/
		
//		conectarSQLite();
//		desconectar();
		
		/*5. Ejercicio de Consulta General (READ - Listado Completo)
		1. Crea un método llamado listarTodasLasCanciones() que no reciba
		parámetros.
		2. Ejecuta la sentencia SELECT * FROM CANCIONES.
		3. Recorre el ResultSet y muestra por consola un listado completo y legible
		con todos los campos de cada canción.*/
		
//		conectarSQLite();
//		desconectar();
		
		/*6. Ejercicio de Eliminación de Datos (DELETE - Bajas)
		1. Crea un método llamado eliminarCancionesAntiguas(int añoLimite) que
		reciba un año.
		2. Utiliza un PreparedStatement y la sentencia DELETE para eliminar todas
		las canciones cuyo año_lanzamiento sea anterior al añoLimite dado.
		3. Muestra por consola el número de canciones que han sido eliminadas
		(valor devuelto por executeUpdate()).*/
		
//		conectarSQLite();
//		desconectar();
	}

}
