package boletinI;

import java.io.ByteArrayInputStream;

import org.basex.api.client.ClientSession;

public class App {

	public static void main(String[] args) {
		// Configuración
		String host = "localhost";
		int puerto = 1984;
		String usuario = "admin";
		String clave = "admin";
		String baseDatos = "Clase1";
		
		
		/* Ejercicio 1: Filtrado y Formato (Lectura)
		Objetivo: Listar libros baratos mostrando toda la información de cada libro.
		Reto: pon la información “bonita” con saltos de línea por cada dato que des de
		libro y separando cada libro con “-------------“*/
		
		System.out.println("Conectando...");
		// Usamos try-with-resources para que cierre la conexión solo al acabar
		try (ClientSession session = new ClientSession(host, puerto, usuario, clave)) {
			System.out.println("¡CONECTADO AL SERVIDOR!");
		// 1. Abrimos la base de datos
			session.execute("OPEN " + baseDatos);
			System.out.println("Base de datos '" + baseDatos + "' abierta.");
		// 2. Consulta XQuery
			System.out.println("Ejecutando consulta...");
		// Aquí pones tu consulta XQuery tal cual
			String query = "for $l in //libro where $l/precio < 20 return $l";
		// Ejecutar y obtener respuesta como String
			String resultadoRaw = session.execute("XQUERY " + query);
			System.out.println("\n--- RESULTADOS ---");
			String resultado = resultadoRaw.replaceAll("<libro[%]>", "Libro: ");
			resultado = resultado.replaceAll("</libro>", "");
			System.out.println(resultado);
			System.out.println("------------------");
		} catch (java.net.ConnectException e) {
			System.err.println("ERROR DE CONEXIÓN: El servidor no responde.");
			System.err.println("Asegúrate de tener abierta la ventana negra de './basexserver'.");
		} catch (Exception e) {
			System.err.println(" Error: " + e.getMessage());
			e.printStackTrace();
		}
		
		/*Ejercicio 2: Insertar un nuevo libro (Escritura)
		Objetivo: Aprender que también pueden modificar la BD desde Java.
		• Nota: usa el comando XQUERY igual, pero con sintaxis insert.
		Después ejecuta el ejercicio1 de nuevo para ver los resultados.*/
		

//		System.out.println("Conectando...");
//		// Usamos try-with-resources para que cierre la conexión solo al acabar
//		try (ClientSession session = new ClientSession(host, puerto, usuario, clave)) {
//			System.out.println("¡CONECTADO AL SERVIDOR!");
//		// 1. Abrimos la base de datos
//			session.execute("OPEN " + baseDatos);
//			System.out.println("Base de datos '" + baseDatos + "' abierta.");
//			String consulta =
//			"insert node <libro id='L008'><titulo>Laura</titulo><autor>Jef</autor></libro>" +
//			"into //libro";
////			"into //libro[@id='L001']";
//			session.execute("XQUERY " + consulta);
//			System.out.println("Nodo stock insertado");
//		} catch (java.net.ConnectException e) {
//			System.err.println("ERROR DE CONEXIÓN: El servidor no responde.");
//			System.err.println("Asegúrate de tener abierta la ventana negra de './basexserver'.");
//		} catch (Exception e) {
//			System.err.println(" Error: " + e.getMessage());
//			e.printStackTrace();
//		}
		
		/*Ejercicio 3: Consulta Dinámica (Reto Java)
		Objetivo: Pedir al usuario (con Scanner) un autor y buscar sus libros para
		mostrarlos por pantalla.*/

//		String autor = "Miguel de Cervantes";
//		
//		System.out.println("Conectando...");
//		// Usamos try-with-resources para que cierre la conexión solo al acabar
//		try (ClientSession session = new ClientSession(host, puerto, usuario, clave)) {
//			System.out.println("¡CONECTADO AL SERVIDOR!");
//		// 1. Abrimos la base de datos
//			session.execute("OPEN " + baseDatos);
//			System.out.println("Base de datos '" + baseDatos + "' abierta.");
//		// 2. Consulta XQuery
//			System.out.println("Ejecutando consulta...");
//		// Aquí pones tu consulta XQuery tal cual
//			String query = "for $l in //libro where $l//autor = '" + autor + "' return $l";
//		// Ejecutar y obtener respuesta como String
//			String resultado = session.execute("XQUERY " + query);
//			System.out.println("\n--- RESULTADOS ---");
//			System.out.println(resultado);
//			System.out.println("------------------");
//		} catch (java.net.ConnectException e) {
//			System.err.println("ERROR DE CONEXIÓN: El servidor no responde.");
//			System.err.println("Asegúrate de tener abierta la ventana negra de './basexserver'.");
//		} catch (Exception e) {
//			System.err.println(" Error: " + e.getMessage());
//			e.printStackTrace();
//		}
	}

}
