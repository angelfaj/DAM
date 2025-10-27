package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) {
		/*Ejercicio 1: Conexión y Cierre
		Crea la clase ConexionBase con un método estático conectar() y cerrar(). En el
		método main de una clase de prueba, llama a conectar() y cerrar() para verificar
		que la conexión a Oracle se establece y se finaliza correctamente. Debes usar
		el driver JDBC.
		Ejercicio 2: SELECT Básico
		Implementa un método listarAutores() que establezca una conexión, ejecute
		una consulta SELECT para obtener el ID_AUTOR, NOMBRE_AUTOR y
		NACIONALIDAD de todos los autores de la tabla AUTORES. El método debe
		iterar sobre el ResultSet y mostrar los datos por consola.
		Ejercicio 3: INSERT
		Crea un método insertarLector(int id, String nombre, String apellido, String
		email). Este método debe crear una sentencia INSERT INTO (usando
		concatenación de strings) y ejecutarla con Statement.executeUpdate() para
		añadir un nuevo lector a la tabla LECTORES.
		*/
		
		
	}
	//Atributos necesarios para interactuar con la db
	private static String bd = "XE"; //Nombre de la bd
	private static String login = "alumno"; //Usuario de la bd
	private static String password = "alumno"; //Contraseña
	private static Connection connection = null;
	private static Statement st = null;
	private static ResultSet rs = null;	//alamacenara la respuesta de la consulta lanzada
	private static String url = "jdbc:oracle:thin:@localhost:1521:" + bd;
	private static String oracleDriver = "oracle.jdbc.driver.OracleDriver";
	
	public static void conectar() {
		try {
			//Driver para oracle
			Class.forName(oracleDriver);
			connection = DriverManager.getConnection(url, login, password);
			if (connection != null) {
				System.out.println("Conexión realizada correctamente");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void cerrar() throws SQLException {
		if (rs != null) {
			rs.close();
		}
		if (st != null) {
			st.close();
		}
		if (connection != null) {
			connection.close();
		}
	}
}
