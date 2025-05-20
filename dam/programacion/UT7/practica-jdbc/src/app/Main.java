package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {

	private static String bd = "xe";
	private static String login = "C##COLEGIO";
	private static String password = "password";

	// Ruta del servidor, nosotros localhost
	private static String url = "jdbc:oracle:thin:@localhost:1521:" + bd;
	static Connection connection = null;
	private static Statement st;
	private static ResultSet rs;

	public static void conectar() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection(url, login, password);
			if (connection != null)
				System.out.println("Conexión realizada correctamente");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void cerrar() {
		if (rs != null)
			try {
				rs.close();
				if (st != null)
					st.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		System.out.println("Conexión cerrada.");
	}

	public static void listarAlumnosOrdenadosPorID() throws SQLException {
		int id, edad;
		String nombre;
		double nota;
		st = connection.createStatement();
		rs = st.executeQuery("select id, nombre, edad, nota from alumnos order by id asc");

		System.out.println("ID" + "\t" + "Nombre" + "\t" + "Edad" + "\t" + "Nota");
		System.out.println("-----------------------------");
		while (rs.next()) {
			id = rs.getInt("id");
			nombre = rs.getString("nombre");
			edad = rs.getInt("edad");
			nota = rs.getDouble("nota");
			System.out.println(id + "\t" + nombre + "\t" + edad + "\t" + nota);
		}
		System.out.println("-----------------------------");
	}
	
	public static void updateAlumnoById(int id, Alumno alumno) throws SQLException {
		PreparedStatement ps=connection.prepareStatement("update alumnos set nombre = ?, edad = ?, nota = ? where id = ?");
		//Los parámetros empiezan a contar desde el 1
		ps.setString(1, alumno.getNombre());
		ps.setInt(2, alumno.getEdad());
		ps.setDouble(3, alumno.getNota());
		ps.setInt(4, id);
		ps.executeUpdate();
	}

	public static void insertAlumno(Alumno alumno) throws SQLException {
		
		PreparedStatement ps=connection.prepareStatement("insert into alumnos values (?, ?, ?)");
		//Los parámetros empiezan a contar desde el 1
		ps.setString(1, alumno.getNombre());
		ps.setInt(2, alumno.getEdad());
		ps.setDouble(3, alumno.getNota());
		ps.executeUpdate();
	}
	
	public static void deleteAlumnoById(int id) throws SQLException {
		PreparedStatement ps=connection.prepareStatement("delete from alumnos where id = ?");
		//Los parámetros empiezan a contar desde el 1
		ps.setInt(1, id);
		ps.executeUpdate();
	}
	
	public static void listarAlumnosNotaMayorOIgual(double notaReferencia) throws SQLException {
		int id, edad;
		String nombre;
		double nota;
		
		PreparedStatement ps=connection.prepareStatement("select id, nombre, edad, nota from alumnos where nota >= ? order by nota desc");
		ps.setDouble(1, notaReferencia);
		rs = ps.executeQuery();
		
		System.out.println("ID" + "\t" + "Nombre" + "\t" + "Edad" + "\t" + "Nota");
		System.out.println("-----------------------------");
		while (rs.next()) {
			id = rs.getInt("id");
			nombre = rs.getString("nombre");
			edad = rs.getInt("edad");
			nota = rs.getDouble("nota");
			System.out.println(id + "\t" + nombre + "\t" + edad + "\t" + nota);
		}
		System.out.println("-----------------------------");
	}
	
	public static void listarAlumnosDeEdadConcreta(int edadReferencia) throws SQLException {
		int id, edad;
		String nombre;
		double nota;
		
		PreparedStatement ps=connection.prepareStatement("select id, nombre, edad, nota from alumnos where edad = ?");
		ps.setDouble(1, edadReferencia);
		rs = ps.executeQuery();
		
		System.out.println("ID" + "\t" + "Nombre" + "\t" + "Edad" + "\t" + "Nota");
		System.out.println("-----------------------------");
		while (rs.next()) {
			id = rs.getInt("id");
			nombre = rs.getString("nombre");
			edad = rs.getInt("edad");
			nota = rs.getDouble("nota");
			System.out.println(id + "\t" + nombre + "\t" + edad + "\t" + nota);
		}
		System.out.println("-----------------------------");
	}

	public static void listarAlumnosMejorNota() throws SQLException {
		int id, edad;
		String nombre;
		double nota;
		st = connection.createStatement();
		rs = st.executeQuery("select id, nombre, edad, nota from alumnos order by nota desc limit 3");  
//		rs = st.executeQuery("select * from (select id, nombre, edad, nota from alumnos order by nota desc ) where rownum = 3");
		
		System.out.println("ID" + "\t" + "Nombre" + "\t" + "Edad" + "\t" + "Nota");
		System.out.println("-----------------------------");
		while (rs.next()) {
			id = rs.getInt("id");
			nombre = rs.getString("nombre");
			edad = rs.getInt("edad");
			nota = rs.getDouble("nota");
			System.out.println(id + "\t" + nombre + "\t" + edad + "\t" + nota);
		}
		System.out.println("-----------------------------");
	}
	
	public static double notaMediaAlumnos() throws SQLException {
		double media;
		st = connection.createStatement();
		rs = st.executeQuery("select avg(nota) as notaMedia from alumnos");
		rs.next();

		media = rs.getDouble("notaMedia");
		
		return media;
	}
	
	public static int numeroAprobados() throws SQLException {
		int nAlumnos = 0;
		st = connection.createStatement();
		rs = st.executeQuery("select count(id) as aprobados from alumnos where nota >= 5");
		
		while (rs.next()) {
			nAlumnos = rs.getInt("aprobados");
		}
		
		return nAlumnos;
	}
	
	public static int numeroSuspensos() throws SQLException {
		int nAlumnos = 0;
		st = connection.createStatement();
		rs = st.executeQuery("select count(id) as suspensos from alumnos where nota < 5");
		
		while (rs.next()) {
			nAlumnos = rs.getInt("suspensos");
		}
		
		return nAlumnos;
	}
	
	public static void estadisticasGenerales() throws SQLException {
		System.out.println("Aprobados" + "\t" + "Suspensos" + "\t" + "Media");
		System.out.println("-----------------------------------------");
		System.out.println(numeroAprobados() + "\t\t" + numeroSuspensos() + "\t\t" + notaMediaAlumnos());
	}
	
	public static int validarInt(Scanner scanner) {
		do {
			if (scanner.hasNextInt()) {
			    int number = scanner.nextInt();
			    return number;
			} else {
			    System.out.println("Por favor introduce un numero válido");
			}
		}while (true);
	}
	
	public static double validarDouble(Scanner scanner) {
		do {
			if (scanner.hasNextDouble()) {
				double number = scanner.nextDouble();
				return number;
			} else {
				System.out.println("Por favor introduce un numero válido");
			}
		}while (true);
	}
	
	public static void showMenu() throws SQLException {
		boolean continuar = true;
		int opcion;
		Scanner entrada = new Scanner(System.in);
		
		do {
			System.out.println("***************************** MENÚ *****************************"
					+ "1. Listar todos los alumnos ordenados por ID.\n"
					+ "2. Insertar un nuevo alumno (nombre, edad, nota).\n"
					+ "3. Actualizar un alumno existente por ID.\n"
					+ "4. Eliminar un alumno por ID.\n"
					+ "5. Listar alumnos con nota superior o igual a un valor dado.\n"
					+ "6. Listar alumnos de una edad concreta.\n"
					+ "7. Mostrar los 3 alumnos con mejor nota.\n"
					+ "8. Mostrar estadísticas generales. \n"
					+ "9. Salir del programa"
					+ "Introduce una opcion: ");
			
			opcion = entrada.nextInt();
			entrada.next(); //Limpiamos el buffer
			
			switch (opcion) {
			case 1: {
				listarAlumnosOrdenadosPorID();
				break;
			}
			case 2: {
				String nombre;
				int edad;
				double nota;
				
				System.out.println("Por favor introduce el nombre del nuevo alumno");
				nombre = entrada.nextLine();
				System.out.println("Por favor introduce la edad del nuevo alumno");
				edad = entrada.nextInt();
				entrada.next();
				System.out.println("Por favor introduce la nota del nuevo alumno");
				nota = entrada.nextDouble();
				entrada.next();
				
				Alumno alumno = new Alumno(edad, nombre, nota);
				insertAlumno(alumno);
				System.out.println("Alumno introducido correctamente");
				break;
			}
			case 3: {
				String nombre;
				int edad, id;
				double nota;
				
				System.out.println("Introduce el ID del alumno que quieres actualizar");
				id = validarInt(entrada);
				entrada.next();
				System.out.println("Por favor introduce el nombre del nuevo alumno");
				nombre = entrada.nextLine();
				System.out.println("Por favor introduce la edad del nuevo alumno");
				edad = validarInt(entrada);
				entrada.next();
				System.out.println("Por favor introduce la nota del nuevo alumno");
				nota = validarDouble(entrada);
				entrada.next();
				
				Alumno alumno = new Alumno(edad, nombre, nota);
				updateAlumnoById(id, alumno);
				break;
			}
			case 4: {
				System.out.println("Introduce el ID del alumno que quieres eliminar");
				int id = validarInt(entrada);
				entrada.next();
				
				deleteAlumnoById(id);
				System.out.println("Alumno eliminado correctamente");
				break;
			}
			case 5: {
				System.out.println("Introduce la nota de referencia");
				double nota = validarDouble(entrada);
				entrada.next();
				
				listarAlumnosNotaMayorOIgual(nota);
				break;
			}
			case 6: {
				System.out.println("Introduce la edad de referencia");
				int edad = validarInt(entrada);
				entrada.next();
				
				listarAlumnosDeEdadConcreta(edad);
				break;
			}
			case 7: {
				listarAlumnosMejorNota();
				break;
			}
			case 8: {
				estadisticasGenerales();
				break;
			}
			case 9: {
				System.out.println("Adios!");
				continuar = false;
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + opcion);
			}
			
			
		}while(continuar);
	}

	
	public static void main(String[] args) {
		/*Objetivo de la práctica:
		Desarrollar una aplicación Java de consola que permita gestionar los
		datos de alumnos almacenados en una base de datos Oracle 11g.
		La aplicación utilizará JDBC para realizar operaciones de inserción,
		consulta, actualización y borrado.
		Funcionalidades requeridas
		1. Listar todos los alumnos ordenados por ID.
		2. Insertar un nuevo alumno (nombre, edad, nota).
		3. Actualizar un alumno existente por ID.
		4. Eliminar un alumno por ID.
		5. Listar alumnos con nota superior o igual a un valor dado.
		6. Listar alumnos de una edad concreta.
		7. Mostrar los 3 alumnos con mejor nota.
		8. Mostrar estadísticas generales:
		o Nota media.
		o Número de aprobados.
		o Número de suspensos.
		Requisitos técnicos
		• Conexión a base de datos Oracle 11g mediante JDBC
		(ojdbc11.jar).
		• Aplicación por consola con menú interactivo y validación de
		entradas.
		• Demostrar el uso de Statement y PreparedStatement.
		• Crea el proyecto en eclipse con java 17.*/
		
		
//		comprobar funcionamiento y resolver el limit 3 que no funciona
		conectar();
		try {
			showMenu();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			cerrar();
		}

//		prepared statement admite parametros 
//		statemen no admite parametros
	
	}
}
