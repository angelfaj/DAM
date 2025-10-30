package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
	//Atributos necesarios para interactuar con la db
	private static String bd = "XE"; //Nombre de la bd
	private static String login = "C##BIBLIOTECA"; //Usuario de la bd
	private static String password = "password"; //Contraseña
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
	
	public static void main(String[] args) {
		/*Ejercicio 1: Conexión y Cierre
		Crea la clase ConexionBase con un método estático conectar() y cerrar(). En el
		método main de una clase de prueba, llama a conectar() y cerrar() para verificar
		que la conexión a Oracle se establece y se finaliza correctamente. Debes usar
		el driver JDBC.
		*/
		
//		conectar();
//		try {
//			cerrar();
//			System.out.println("Conexión cerrada correctamente");
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		/*Ejercicio 2: SELECT Básico
		Implementa un método listarAutores() que establezca una conexión, ejecute
		una consulta SELECT para obtener el ID_AUTOR, NOMBRE_AUTOR y
		NACIONALIDAD de todos los autores de la tabla AUTORES. El método debe
		iterar sobre el ResultSet y mostrar los datos por consola.*/
		
//		listarAutores();
		
		
		
		
		
		
		/*Ejercicio 3: INSERT
		Crea un método insertarLector(int id, String nombre, String apellido, String
				email). Este método debe crear una sentencia INSERT INTO (usando
						concatenación de strings) y ejecutarla con Statement.executeUpdate() para
		añadir un nuevo lector a la tabla LECTORES.
		*/
		
		
		
		
		/*Ejercicio 4: UPDATE
		Implementa un método actualizarEmail(int idLector, String nuevoEmail) que
		actualice el campo EMAIL de la tabla LECTORES para el ID dado. Muestra por
		consola el número de filas afectadas que devuelve el método executeUpdate().*/
		
//		conectar();
//		
//		try {
//			actualizarEmail(2002, "pacoperez@fmail.com");
//			cerrar();
//			System.out.println("Conexión cerrada correctamente");
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		/*Ejercicio 5: DELETE y Filas Afectadas
		Crea un método eliminarLector(int idLector) que elimine un registro de la tabla
		LECTORES por su ID. El método debe devolver el número de filas borradas.
		(Nota: Debes probarlo con un lector que no tenga préstamos para evitar
		errores de clave foránea).*/
		
//		conectar();
//		
//		try {
//			eliminarLector(2005);
//			cerrar();
//			System.out.println("Conexión cerrada correctamente");
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		/*Ejercicio 6: SELECT Parametrizado
		Implementa el método buscarLibrosPorAnio(int anio). El método debe usar un
		PreparedStatement cuya sentencia SQL contenga WHERE
		ANIO_PUBLICACION = ?. Debes usar ps.setInt(1, anio) antes de ejecutar la
		consulta. Lista el ISBN y el Título de los resultados.*/
		
//		conectar();
//		
//		try {
//			buscarLibrosPorAnio(1967);
//			cerrar();
//			System.out.println("Conexión cerrada correctamente");
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		/*Ejercicio 7: INSERT Parametrizado
		Modifica el Ejercicio 3 creando un nuevo método registrarNuevoAutorPS(int
		id, String nombre, String nacionalidad). Usa un PreparedStatement con tres
		parámetros (?) y los métodos ps.setInt() y ps.setString() para insertar el autor.*/
		
//		conectar();
//		
//		try {
//			registrarNuevoAutorPS(105 , "Roberto Saviano", "Italia");
//			cerrar();
//			System.out.println("Conexión cerrada correctamente");
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		/*Ejercicio 8: UPDATE Parametrizado
		Desarrolla un método cambiarCopiasDisponibles(String isbn, int
		nuevasCopias) que actualice el campo NUM_COPIAS_DISP de la tabla
		LIBROS. El PreparedStatement debe tener dos parámetros: uno String (ISBN) y uno int (copias).*/
		
//		conectar();
//		
//		try {
//			cambiarCopiasDisponibles("9788497592208", 8);
//			cerrar();
//			System.out.println("Conexión cerrada correctamente");
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		/*Ejercicio 9: Consulta con JOIN
		Crea un método listarLibrosDeAutor(String nombreAutor). Utiliza un
		PreparedStatement con un JOIN entre LIBROS y AUTORES para listar todos
		los títulos de libros escritos por el autor cuyo nombre se pasa como parámetro.*/
		
//		conectar();
//		
//		try {
//			listarLibrosDeAutor("Jane Austen");
//			cerrar();
//			System.out.println("Conexión cerrada correctamente");
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		/*Ejercicio 10: Ejercicio Desafío (SELECT con WHERE)
		Crea un método buscarLectoresConMultas(). Debe usar un
		PreparedStatement para buscar y listar el ID_LECTOR, NOMBRE, y
		MULTAS_PENDIENTES de todos los lectores que tienen una multa superior a 0.*/
		
		conectar();
		
		try {
			buscarLectoresConMultas();
			cerrar();
			System.out.println("Conexión cerrada correctamente");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		IMPORTANTE HACER COMMIT SI MODIFICAMOS DATOS EN ORACLE DEVELOPER
		DE LO CONTRARIO JAVA SE QUEDARA COLGADO AL CONSULTAR LA BD POR TENER ESA TABLA BLOQUEADA.
	}
	private static void buscarLectoresConMultas() throws SQLException {
		PreparedStatement ps = connection.prepareStatement(
				"select id_lector, nombre, multas_pendientes "
				+ "from lectores where multas_pendientes > 0");
		
		rs = ps.executeQuery();
		while(rs.next()) {
			int id = rs.getInt(1);
			String nombre = rs.getString(2);
			int multas = rs.getInt(3);
			
			System.out.println("Persona: " + id + " " + nombre + " " + multas);
		}
		
	}

	private static void listarLibrosDeAutor(String autor) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(
				"select l.titulo from libros l "
				+ "join autores a on l.id_autor = a.id_autor "
				+ "where a.nombre_autor = ?");
		ps.setString(1, autor);
		rs = ps.executeQuery();
		
		while(rs.next()) {
			String titulo = rs.getString(1);
			System.out.println("Libro: " + titulo);
		}
		
	}

	private static void cambiarCopiasDisponibles(String isbn, int copias) throws SQLException {
		PreparedStatement ps = connection.prepareStatement("update libros set num_copias_totales = ? where isbn = ?");
		ps.setInt(1, copias);
		ps.setString(2, isbn);
		int filasModificadas = ps.executeUpdate();
		System.out.println("Filas modificadas " + filasModificadas);
	}

	private static void registrarNuevoAutorPS(int id, String nombre, String nacionalidad) throws SQLException {
		PreparedStatement ps = connection.prepareStatement("insert into autores(id_autor, nombre_autor, nacionalidad) values (?, ?, ?)");
		ps.setInt(1, id);
		ps.setString(2, nombre);
		ps.setString(3, nacionalidad);
		int filasAfectadas = ps.executeUpdate();
		System.out.println("Filas afectadas " + filasAfectadas);
	}

	private static void buscarLibrosPorAnio(int anio) throws SQLException {
		PreparedStatement ps = connection.prepareStatement("select titulo, isbn from libros where anio_publicacion = ?" );
		ps.setInt(1, anio);
		rs = ps.executeQuery();
		
		while (rs.next()) {
			String titulo = rs.getString(1);
			String isbn = rs.getString(2);
			System.out.println("Libro: " + titulo + " " + isbn);
		}
		ps.close();
	}

	private static void eliminarLector(int idLector) throws SQLException {
		String sql = "delete from lectores where id_lector=" + idLector;
		st = connection.createStatement();
		int filasAfectadas = st.executeUpdate(sql);
		System.out.println("Filas afectadas " + filasAfectadas);
	}

	private static void listarAutores() {
		// TODO Auto-generated method stub
		
	}
	private static void actualizarEmail(int idLector, String nuevoEmail) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "update lectores set email='" + nuevoEmail + "' where id_lector=" + idLector;
		st = connection.createStatement();
		int filasAfectadas = st.executeUpdate(sql);
		System.out.println("Filas afectadas " + filasAfectadas);
	}
}
