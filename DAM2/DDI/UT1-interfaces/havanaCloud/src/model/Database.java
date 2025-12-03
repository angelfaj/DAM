package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
	//Esta clase gestiona la conexion y desconexion con la base de datos
	// Atributos necesarios para interactuar con la db
	private static String user = ""; //Usuario de la bd
	private static String password = ""; // Contraseña
	private static String url = "jdbc:mysql://url:puerto/nombreBD";	//url de la bd

	public static Connection getConnection() throws SQLException {
	    return DriverManager.getConnection(url, user, password);
	}
	
}
