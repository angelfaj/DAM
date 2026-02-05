package app;

import java.io.ByteArrayInputStream;

import org.basex.api.client.ClientSession;

public class InventarioApp {
	public static void main(String[] args) {
		// Configuración
		String host = "localhost";
		int puerto = 1984;
		String usuario = "admin";
		String clave = "admin";
		String baseDatos = "TiendaTech";
		
		
		/* Ejercicio repaso CRUD:
		Crear una aplicación Java que gestione el stock de una tienda de
		informática utilizando el Cliente Nativo de BaseX. Tu aplicación debe cargar el siguiente XML inicial en la base de datos
		automáticamente al arrancar. No debes crear un fichero físico, debes cargarlo
		desde un String en Java. 
		
		Requisitos de la Aplicación (InventarioApp.java)
		Debes implementar una clase Java que realice las siguientes operaciones
		secuenciales (o mediante un menú, como tú prefieras):
		A. Conexión y Limpieza (CREATE)
			1. Conectar al servidor local (puerto 1984, usuario admin).
			2. Crear una base de datos nueva llamada TiendaTech (esto borrará cualquier dato previo y la dejará abierta).
		B. Carga de Datos (ADD)
			1. Utilizando el método session.add() y ByteArrayInputStream, sube el XML
			de partida con el nombre de archivo stock_2024.xml.
		C. Operaciones CRUD (XQUERY UPDATE) Implementa métodos para realizar las siguientes acciones:
			1. Nuevo Producto (INSERT): Inserta un nuevo producto en el inventario:
				o ID: P004
				o Nombre: Teclado Mecánico
				o Precio: 45
				o Stock: 0
			2. Actualización de Precios (REPLACE VALUE): Debido a la inflación, el
			producto P001 (HP Pavilion) ha subido de precio. Modifícalo a 850.
			3. Venta de Producto (DELETE NODE): El producto P002 (Ratón) ha sido
			descatalogado. Elimina su nodo <producto> completo del XML.
		D. Consulta Final (READ)
			1. Muestra por consola el estado final del inventario.
			2. Debe aparecer formateado (puedes usar concat en XQuery o imprimir el
			XML en bruto).*/
		
		System.out.println("Conectando...");
		try (ClientSession session = new ClientSession(host, puerto, usuario, clave)) {
			//A: Conexion y creacion de db
			System.out.println("¡CONECTADO AL SERVIDOR!");
			session.execute("CREATE DB " + baseDatos);
			System.out.println("Base de datos '" + baseDatos + "' abierta.");
			
			//B: Carga de datos
			System.out.println("Insertando datos...");
			String xml = "<inventario>\n"
					+ "<producto id='P001' categoria='portatil'>\n"
					+ "<nombre>HP Pavilion</nombre>\n"
					+ "<precio moneda='EUR'>800</precio>\n"
					+ "<stock>10</stock>\n"
					+ "</producto>\n"
					+ "<producto id='P002' categoria='periferico'>\n"
					+ "<nombre>Raton Logitech</nombre>\n"
					+ "<precio moneda='EUR'>20</precio>\n"
					+ "<stock>50</stock>\n"
					+ "</producto>\n"
					+ "<producto id='P003' categoria='monitor'>\n"
					+ "<nombre>Samsung 24</nombre>\n"
					+ "<precio moneda='EUR'>150</precio>\n"
					+ "<stock>5</stock>\n"
					+ "</producto>\n"
					+ "</inventario>";

			session.add("stock_2024.xml", new ByteArrayInputStream(xml.getBytes()));
			System.out.println("Fichero xml añadido");
			
			//C: Operaciones CRUD, insert, replace y delete
			//insert
			String query = "insert node <producto id='P004'>\n"
					+ "<nombre>Teclado Mecánico</nombre>\n"
					+ "<precio moneda='EUR'>45</precio>\n"
					+ "<stock>0</stock>\n"
					+ "</producto> into /inventario";
			session.execute("XQUERY " + query);
			System.out.println("Producto insertado");
			
			//replace
			query = "replace value of node //producto[@id='P001']/precio with 850";
			session.execute("XQUERY " + query);
			System.out.println("Producto actualizado");
			
			//delete
			query = "delete node //producto[@id='P002']";
			session.execute("XQUERY " + query);
			System.out.println("Producto borrado");

			//D: Consultar todos
			query = "for $producto in /inventario/producto return concat("  +
					"'------------------------------------', '&#10;', " +
					"  'ID:        ', $producto/@id,        '&#10;', " + 
					"  'Nombre:    ', $producto/nombre,     '&#10;', " + 
					"  'Precio:    ', $producto/precio,     '&#10;', " + 
					"  'Stock:     ', $producto/stock,      '&#10;' " +  
					")";
			String resultado = session.execute("XQUERY " + query);
			System.out.println("\n--- RESULTADOS ---");
			System.out.println(resultado);
			System.out.println("------------------");
		} catch (java.net.ConnectException e) {
			System.err.println("ERROR DE CONEXIÓN: El servidor no responde.");
			System.err.println("Asegúrate de tener abierta la ventana negra de './basexserver'.");
		} catch (Exception e) {
			System.err.println(" Error: " + e.getMessage());
			e.printStackTrace();
		}
		
	}
}
