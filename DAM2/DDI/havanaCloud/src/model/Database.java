package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
	// Atributos necesarios para interactuar con la db
	private static String bd = "XE"; // Nombre de la bd
	private static String login = ""; //Usuario de la bd
	private static String password = ""; // Contraseña
	private static Connection connection = null;
	private static String url = "jdbc:oracle:thin:@localhost:1521:" + bd;
	private static String oracleDriver = "oracle.jdbc.driver.OracleDriver";

	public static void conectar() {
		try {
			// Driver para oracle
			Class.forName(oracleDriver);
			connection = DriverManager.getConnection(url, login, password);
			if (connection != null) {
				System.out.println("Conexión realizada correctamente");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void cerrar() throws SQLException {
		if (connection != null) {
			connection.close();
		}
	}
	
	public static Connection getConnection() throws SQLException {
	        return DriverManager.getConnection(url, login, password);
	}
	
}
