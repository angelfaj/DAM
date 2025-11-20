package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

	public static Connection conectarSQLite() {
		Connection conn = null;
		try {
			String url = "jdbc:sqlite:cocina.db";
			conn = DriverManager.getConnection(url);
		}catch (SQLException e) {
			System.out.println("Error en la conexion: " + e.getMessage());
		}
		return conn;
	}
	
	public static void crearTablaRecetas() {
		String sql = "CREATE TABLE IF NOT EXISTS recetas (\r\n"
				+ "    id_receta INTEGER PRIMARY KEY AUTOINCREMENT,\r\n"
				+ "    nombre TEXT,\r\n"
				+ "    tiempo_minutos INTEGER TEXT\r\n"
				+ ")";
		try (Connection conn = conectarSQLite();
				Statement stmt = conn.createStatement()) {
			stmt.execute(sql);
			System.out.println("Tabla 'recetas' creada correctamente.");
		} catch (SQLException e) {
			System.out.println("Error al crear tabla: " + e.getMessage());
		}
	}
	
	public static void crearTablaIngredientes() {
		String sql = "CREATE TABLE IF NOT EXISTS ingredientes (\r\n"
				+ "    id_ingrediente INTEGER PRIMARY KEY AUTOINCREMENT,\r\n"
				+ "    nombre TEXT,\r\n"
				+ "    calorias INTEGER TEXT\r\n"
				+ ")";
		try (Connection conn = conectarSQLite();
				Statement stmt = conn.createStatement()) {
			stmt.execute(sql);
			System.out.println("Tabla 'ingredientes' creada correctamente.");
		} catch (SQLException e) {
			System.out.println("Error al crear tabla: " + e.getMessage());
		}
	}
	
	public static void crearTablaRecetaIngrediente() {
		String sql = "CREATE TABLE IF NOT EXISTS receta_ingrediente (\r\n"
				+ "    id_relacion INTEGER PRIMARY KEY AUTOINCREMENT,\r\n"
				+ "    cantidad TEXT,\r\n"
				+ "    id_receta INTEGER \r\n,"
				+ "    id_ingrediente INTEGER \r\n,"
				+ "    FOREIGN KEY(id_ingrediente) REFERENCES ingredientes(id_ingrediente)\r\n,"
				+ "    FOREIGN KEY(id_receta) REFERENCES receta(id_receta)\r\n"
				+ ")";
		try (Connection conn = conectarSQLite();
				Statement stmt = conn.createStatement()) {
			stmt.execute(sql);
			System.out.println("Tabla 'ingredientes' creada correctamente.");
		} catch (SQLException e) {
			System.out.println("Error al crear tabla: " + e.getMessage());
		}
	}
	
	public static void crearBD() {
		crearTablaRecetas();
		crearTablaIngredientes();
		crearTablaRecetaIngrediente();
	}
	
	public static void añadirReceta( String nombre, int tiempo) {
		String sql = "INSERT INTO recetas(nombre, tiempo_minutos) VALUES(?, ?)";
        try (Connection conn = conectarSQLite();
        		PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, nombre);
            ps.setInt(2, tiempo);
            ps.executeUpdate();

            System.out.println("Receta insertada correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al insertar receta: " + e.getMessage());
        }
	}
	

	public static void añadirIngrediente(String nombre, int calorias) {
		String sql = "INSERT INTO ingredientes(nombre, calorias) VALUES(?, ?)";
        try (Connection conn = conectarSQLite();
        		PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, nombre);
            ps.setInt(2, calorias);
            ps.executeUpdate();

            System.out.println("Ingrediente insertado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al insertar ingrediente: " + e.getMessage());
        }
	}
	
	public static void añadirRecetaIngrediente(int idReceta, int idIngrediente, String cantidad) {
		String sql = "INSERT INTO receta_ingrediente(id_receta, id_ingrediente, cantidad) VALUES(?, ?, ?)";
        try (Connection conn = conectarSQLite();
        		PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idReceta);
            ps.setInt(2, idIngrediente);
            ps.setString(3, cantidad);
            ps.executeUpdate();

            System.out.println("Relación insertada correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al insertar relación: " + e.getMessage());
        }
	}	
	
	public static void consultarIngredientesDeReceta(String nombreReceta) {
		String sql = "SELECT i.nombre AS Ingrediente, ri.cantidad AS Cantidad, i.calorias AS Calorias "
				+ "FROM ingredientes i JOIN receta_ingrediente ri on ri.id_ingrediente = i.id_ingrediente "
				+ "JOIN recetas r ON ri.id_receta = r.id_receta "
				+ "WHERE r.nombre = ?";
		
		try (Connection conn = conectarSQLite();
				PreparedStatement ps = conn.prepareStatement(sql)) {
			
			ps.setString(1, nombreReceta);
			ResultSet rs = ps.executeQuery();
			
			System.out.println("=============" + nombreReceta.toUpperCase() + "=============");
			System.out.println("Ingrediente\t" + "Cantidad\t" + "Calorias");
			System.out.println("-----------------------------------------");
			while (rs.next()) {
				String ingrediente = rs.getString("Ingrediente");
				String cantidad = rs.getString("Cantidad");
				int calorias = rs.getInt("Calorias");
				System.out.println(ingrediente + "\t" + cantidad + "\t" + calorias);
			}
			rs.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		//Creamos el esquema
		crearBD();
		
		//Añadimos un par de recetas
		añadirReceta("tarta de queso", 60);			//id: 1
		añadirReceta("natillas", 50);				//id: 2
		//Añadimos 4 ingredientes
		añadirIngrediente("queso crema", 300);		//id: 1
		añadirIngrediente("mantequilla", 600);		//id: 2
		añadirIngrediente("galleta maria", 100);	//id: 3
		añadirIngrediente("azucar", 400);			//id: 4
		//Añadimos las relaciones de la primera receta
		añadirRecetaIngrediente(1, 1, "500 gramos");
		añadirRecetaIngrediente(1, 2, "200 gramos");
		añadirRecetaIngrediente(1, 3, "1 paquete");
		añadirRecetaIngrediente(1, 4, "200 gramos");
		//Añadimos las relaciones de la segunda receta
		añadirRecetaIngrediente(2, 3, "1 por ración");
		añadirRecetaIngrediente(2, 4, "120 gramos");
		
		//Consulta
		consultarIngredientesDeReceta("tarta de queso");
		
		
		
		
	}

}
