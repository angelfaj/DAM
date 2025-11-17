package repaso;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

public class Main {

	public static Connection conectarOracle() {
		Connection conn = null;
		try {
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			Class.forName("oracle.jdbc.driver.OracleDriver");
//			conn = DriverManager.getConnection(url, "system", "password");
			conn = DriverManager.getConnection(url, "C##BIBLIOTECA", "password");
			System.out.println("Conexión establecida");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			System.out.println("Conexión rechazada");
		}
		return conn;
	}

//	public static void crearUserBiblioteca() throws SQLException{
//		Connection conn = conectarOracle();
//		Statement st = conn.createStatement();
//		
//		try {
//			conn.setAutoCommit(false);
//			String sql = "CREATE USER C##BIBLIOTECA IDENTIFIED BY password";
//			st.addBatch(sql);
//			
//			sql = "GRANT CONNECT, RESOURCE, CREATE SESSION, CREATE TABLE TO biblioteca";
//			st.addBatch(sql);
//			
//			conn.commit();
//		}catch (SQLException e) {
//			conn.rollback();
//			e.printStackTrace();
//			System.out.println("Ejecutando rollback de user biblioteca");			
//		}finally {
//			conn.close();
//			st.close();
//		}
//	}
	
	private static void createsBiblioteca() throws SQLException {
		Connection conn = conectarOracle();
		Statement st = conn.createStatement();
		try {
			conn.setAutoCommit(false);
			String sql = "CREATE TABLE LECTORES (\n"
					+ "    ID_LECTOR NUMBER(5) PRIMARY KEY,\n"
					+ "    NOMBRE VARCHAR2(100) NOT NULL,\n"
					+ "    APELLIDO VARCHAR2(100) NOT NULL,\n"
					+ "    EMAIL VARCHAR2(100) UNIQUE,\n"
					+ "    MULTAS_PENDIENTES NUMBER(5,2) DEFAULT 0 CHECK (MULTAS_PENDIENTES >= 0)\n"
					+ ")";
			st.addBatch(sql);
			
			sql = "CREATE TABLE AUTORES (\n"
					+ "    ID_AUTOR NUMBER(4) PRIMARY KEY,\n"
					+ "    NOMBRE_AUTOR VARCHAR2(100) NOT NULL,\n"
					+ "    NACIONALIDAD VARCHAR2(50)\n"
					+ ")";
			st.addBatch(sql);
			
			sql = "CREATE TABLE LIBROS (\n"
					+ "    ISBN CHAR(13) PRIMARY KEY, -- Usamos CHAR(13) para ISBN-13\n"
					+ "    TITULO VARCHAR2(200) NOT NULL,\n"
					+ "    ANIO_PUBLICACION NUMBER(4),\n"
					+ "    NUM_COPIAS_TOTALES NUMBER(3) DEFAULT 1 CHECK (NUM_COPIAS_TOTALES >= 1),\n"
					+ "    NUM_COPIAS_DISP NUMBER(3) DEFAULT 1, -- Copias disponibles para préstamo\n"
					+ "    ID_AUTOR NUMBER(4) REFERENCES AUTORES(ID_AUTOR) NOT NULL\n"
					+ ")";
			st.addBatch(sql);
			
			sql = "CREATE TABLE PRESTAMOS (\n"
					+ "    ID_PRESTAMO NUMBER(8) PRIMARY KEY,\n"
					+ "    ID_LECTOR NUMBER(5) REFERENCES LECTORES(ID_LECTOR),\n"
					+ "    ISBN CHAR(13) REFERENCES LIBROS(ISBN),\n"
					+ "    FECHA_PRESTAMO DATE DEFAULT SYSDATE,\n"
					+ "    FECHA_DEVOLUCION DATE, -- NULL si el libro sigue prestado\n"
					+ "    FECHA_LIMITE DATE NOT NULL\n"
					+ ")";
			st.addBatch(sql);
			
			conn.commit();
			System.out.println("Creates realizados");
		}catch (SQLException e) {
			conn.rollback();
			e.printStackTrace();
			System.out.println("Ejecutando rollback de creates");			
		}finally {
			conn.close();
			st.close();
		}
	}

	private static void insertsBiblioteca() throws SQLException{
		Connection conn = conectarOracle();
		Statement st = conn.createStatement();
		try {
			conn.setAutoCommit(false);
			String sql = "INSERT INTO AUTORES VALUES (101, 'Gabriel García Márquez', 'Colombia')";
			st.addBatch(sql);
			
			//Autores
			sql = "INSERT INTO AUTORES VALUES (102, 'Jane Austen', 'Reino Unido')";
			st.addBatch(sql);
			
			sql = "INSERT INTO AUTORES VALUES (103, 'George Orwell', 'Reino Unido')";
			st.addBatch(sql);
			
			sql = "INSERT INTO AUTORES VALUES (104, 'Isabel Allende', 'Chile')";
			st.addBatch(sql);
			
			//Lectores
			sql = "INSERT INTO LECTORES (ID_LECTOR, NOMBRE, APELLIDO, EMAIL) VALUES (2001, 'Javier', 'Pérez', 'javier.perez@mail.com')";
			st.addBatch(sql);
			
			sql = "INSERT INTO LECTORES (ID_LECTOR, NOMBRE, APELLIDO, EMAIL) VALUES (2002, 'Ana', 'Gómez', 'ana.gomez@mail.com')";
			st.addBatch(sql);
			
			sql = "INSERT INTO LECTORES (ID_LECTOR, NOMBRE, APELLIDO, EMAIL, MULTAS_PENDIENTES) VALUES (2003, 'Carlos', 'Ruiz', 'carlos.ruiz@mail.com', 5.50)";
			st.addBatch(sql);
			
			//Libros
			sql = "INSERT INTO LIBROS VALUES ('9788497592208', 'Cien años de soledad', 1967, 5, 3, 101)";
			st.addBatch(sql);
			
			sql = "INSERT INTO LIBROS VALUES ('9788437604947', 'Crónica de una muerte anunciada', 1981, 2, 2, 101)";
			st.addBatch(sql);
			
			sql = "INSERT INTO LIBROS VALUES ('9788491051515', 'Orgullo y prejuicio', 1813, 3, 3, 102)";
			st.addBatch(sql);

			sql = "INSERT INTO LIBROS VALUES ('9788499890901', '1984', 1949, 4, 4, 103)";
			st.addBatch(sql);
			
			sql = "INSERT INTO LIBROS VALUES ('9788401345991', 'La casa de los espíritus', 1982, 1, 0, 104)";
			st.addBatch(sql);
			
			//Prestamos
			sql = "INSERT INTO PRESTAMOS (ID_PRESTAMO, ID_LECTOR, ISBN, FECHA_PRESTAMO, FECHA_LIMITE) VALUES (SEQ_PRESTAMOS.NEXTVAL, 2001, '9788497592208', SYSDATE - 20, SYSDATE - 10)";
			st.addBatch(sql);
			
			sql = "INSERT INTO PRESTAMOS (ID_PRESTAMO, ID_LECTOR, ISBN, FECHA_PRESTAMO, FECHA_LIMITE) VALUES (SEQ_PRESTAMOS.NEXTVAL, 2002, '9788497592208', SYSDATE - 5, SYSDATE + 5)";
			st.addBatch(sql);
			
			sql = "INSERT INTO PRESTAMOS VALUES (SEQ_PRESTAMOS.NEXTVAL, 2003, '9788437604947', SYSDATE - 30, SYSDATE - 15, SYSDATE - 10)";
			st.addBatch(sql);
			
			conn.commit();
			System.out.println("Inserts realizados");
		}catch (SQLException e) {
			conn.rollback();
			e.printStackTrace();
			System.out.println("Ejecutando rollback de inserts");			
		}finally {
			conn.close();
			st.close();
		}
	}

	private static void procedimientosBiblioteca() throws SQLException {
		Connection conn = conectarOracle();
		Statement st = conn.createStatement();
		try {
			conn.setAutoCommit(false);
			
			//PROCEDURE: Para probar el CallableStatement con IN y OUT 
			//Registra una devolución, actualiza disponibilidad y devuelve el título.
			String sql = "CREATE OR REPLACE PROCEDURE REGISTRAR_DEVOLUCION (\n"
					+ "    p_id_prestamo IN NUMBER,\n"
					+ "    p_titulo_devuelto OUT VARCHAR2 -- Parámetro OUT [cite: 154]\n"
					+ ")\n"
					+ "AS\n"
					+ "    v_isbn CHAR(13);\n"
					+ "BEGIN\n"
					+ "    -- 1. Marcar el préstamo como devuelto\n"
					+ "    UPDATE PRESTAMOS\n"
					+ "    SET FECHA_DEVOLUCION = SYSDATE\n"
					+ "    WHERE ID_PRESTAMO = p_id_prestamo\n"
					+ "    RETURNING ISBN INTO v_isbn;\n"
					+ "\n"
					+ "    -- 2. Incrementar la disponibilidad de la copia\n"
					+ "    UPDATE LIBROS\n"
					+ "    SET NUM_COPIAS_DISP = NUM_COPIAS_DISP + 1\n"
					+ "    WHERE ISBN = v_isbn;\n"
					+ "\n"
					+ "    -- 3. Obtener el título devuelto para el OUT\n"
					+ "    SELECT TITULO INTO p_titulo_devuelto\n"
					+ "    FROM LIBROS\n"
					+ "    WHERE ISBN = v_isbn;\n"
					+ "\n"
					+ "    COMMIT;\n"
					+ "EXCEPTION\n"
					+ "    WHEN NO_DATA_FOUND THEN\n"
					+ "        p_titulo_devuelto := 'Préstamo no encontrado';\n"
					+ "END;";
			st.addBatch(sql);
			
			//FUNCTION: Para probar la llamada a una función con CallableStatement\n"
			//Calcula la multa total acumulada de un lector, basado en la diferencia de días y 0.50/día\n"
			sql = "CREATE OR REPLACE FUNCTION CALCULAR_MULTA_LECTOR (\n"
					+ "    p_id_lector IN NUMBER -- Parámetro IN [cite: 159]\n"
					+ ")\n"
					+ "RETURN NUMBER\n"
					+ "AS\n"
					+ "    v_multa NUMBER(5,2);\n"
					+ "BEGIN\n"
					+ "    -- La multa se calcula sobre préstamos activos y retrasados\n"
					+ "    SELECT SUM(\n"
					+ "            0.50 * (TRUNC(SYSDATE) - TRUNC(FECHA_LIMITE))\n"
					+ "           ) INTO v_multa\n"
					+ "    FROM PRESTAMOS\n"
					+ "    WHERE ID_LECTOR = p_id_lector\n"
					+ "      AND FECHA_DEVOLUCION IS NULL\n"
					+ "      AND TRUNC(SYSDATE) > TRUNC(FECHA_LIMITE);\n"
					+ "\n"
					+ "    RETURN NVL(v_multa, 0);\n"
					+ "END;";
			st.addBatch(sql);
			
			//PROCEDURE: Para probar el CallableStatement con IN/OUT\n"
			//Actualiza la multa de un lector y devuelve el nuevo valor\n"
			sql = "CREATE OR REPLACE PROCEDURE ACTUALIZAR_MULTA_INOUT (\n"
					+ "    p_id_lector IN NUMBER,\n"
					+ "    p_monto_adicional IN OUT NUMBER -- Parámetro IN/OUT [cite: 161]\n"
					+ ")\n"
					+ "AS\n"
					+ "    v_nueva_multa NUMBER(5,2);\n"
					+ "BEGIN\n"
					+ "    -- 1. Actualizar la multa existente con el monto adicional\n"
					+ "    UPDATE LECTORES\n"
					+ "    SET MULTAS_PENDIENTES = MULTAS_PENDIENTES + p_monto_adicional\n"
					+ "    WHERE ID_LECTOR = p_id_lector\n"
					+ "    RETURNING MULTAS_PENDIENTES INTO v_nueva_multa;\n"
					+ "\n"
					+ "    -- 2. Devolver el nuevo valor de la multa a través del parámetro IN/OUT\n"
					+ "    p_monto_adicional := v_nueva_multa;\n"
					+ "\n"
					+ "    COMMIT;\n"
					+ "END;";
			st.addBatch(sql);
			
			conn.commit();
			System.out.println("Funciones y procedimientos creados");
		}catch (SQLException e) {
			conn.rollback();
			e.printStackTrace();
			System.out.println("Ejecutando rollback de creacion de funciones y procedimientos");			
		}finally {
			conn.close();
			st.close();
		}
	}
	
	public static void crearBibliotecaDB() throws SQLException {
		createsBiblioteca();
		insertsBiblioteca();
		procedimientosBiblioteca();
	}
	
	public static void listarAutores() {
		String sql = "SELECT id_autor, nombre_autor, nacionalidad FROM autores";
		
		try (Connection conn = conectarOracle();
				Statement st = conn.createStatement()) {
			
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt(1);
				String nombre = rs.getString(2);
				String nacionalidad = rs.getString(3);
				System.out.println(id + ":" + nombre + ":" + nacionalidad);
			}
			
			rs.close();
		}catch (SQLException e) {
			// TODO: handle 
			e.printStackTrace();
		}
	}
	
	public static void buscarLectoresConMultas() {
		String sql = "select id_lector, nombre, multas_pendientes from lectores where multas_pendientes > 0";
		
		try (Connection conn = conectarOracle(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(1);
				String nombre = rs.getString(2);
				double cantidad = rs.getDouble(3);
				System.out.println(id + ":" + nombre + ":" + cantidad);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void procesarDevolucion(int idPrestamo) {
		try (Connection con = conectarOracle();
				CallableStatement cs = con.prepareCall("{call registrar_devolucion (?, ?)}")) {
			cs.setInt(1, idPrestamo);
			cs.registerOutParameter(2, Types.VARCHAR);
			cs.execute();
			System.out.println("Titulo: " + cs.getString(2));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void obtenerMulta(int idLector) {
		try (Connection conn = conectarOracle(); 
				CallableStatement cs = conn.prepareCall("{? = call calcular_multa_lector(?)}")) {
			cs.registerOutParameter(1, Types.DOUBLE);
			cs.setInt(2, idLector);
			cs.execute();
			System.out.println("Multa por valor de: " + cs.getDouble(1));
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
//		try {
//			crearBibliotecaDB();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		/*Ejercicios de JDBC con Java y Oracle 11g
		Ejercicio 2: SELECT Básico
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
		Ejercicio 4: UPDATE
		Implementa un método actualizarEmail(int idLector, String nuevoEmail) que
		actualice el campo EMAIL de la tabla LECTORES para el ID dado. Muestra por
		consola el número de filas afectadas que devuelve el método executeUpdate().
		Ejercicio 6: SELECT Parametrizado
		Implementa el método buscarLibrosPorAnio(int anio). El método debe usar un
		PreparedStatement cuya sentencia SQL contenga WHERE
		ANIO_PUBLICACION = ?. Debes usar ps.setInt(1, anio) antes de ejecutar la
		consulta. Lista el ISBN y el Título de los resultados.
		Ejercicio 7: INSERT Parametrizado
		Modifica el Ejercicio 3 creando un nuevo método registrarNuevoAutorPS(int
		id, String nombre, String nacionalidad). Usa un PreparedStatement con tres
		parámetros (?) y los métodos ps.setInt() y ps.setString() para insertar el autor.
		Ejercicio 8: UPDATE Parametrizado
		Desarrolla un método cambiarCopiasDisponibles(String isbn, int
		nuevasCopias) que actualice el campo NUM_COPIAS_DISP de la tabla
		LIBROS. El PreparedStatement debe tener dos parámetros: uno String (ISBN) y
		uno int (copias).
		Ejercicio 9: Consulta con JOIN
		Crea un método listarLibrosDeAutor(String nombreAutor). Utiliza un
		PreparedStatement con un JOIN entre LIBROS y AUTORES para listar todos
		los títulos de libros escritos por el autor cuyo nombre se pasa como parámetro.
		Ejercicio 10: Ejercicio Desafío (SELECT con WHERE)
		Crea un método buscarLectoresConMultas(). Debe usar un
		PreparedStatement para buscar y listar el ID_LECTOR, NOMBRE, y
		MULTAS_PENDIENTES de todos los lectores que tienen una multa superior a 0.*/

//		buscarLectoresConMultas();
		
		/*Ejercicio 11: CallableStatement (Parámetro OUT)
		Implementa el método procesarDevolucion(int idPrestamo) que llama al
		procedimiento almacenado REGISTRAR_DEVOLUCION de Oracle. Debes usar
		CallableStatement, registrar el parámetro OUT con registerOutParameter(), y
		recuperar el título del libro devuelto tras la ejecución.*/
		
//		procesarDevolucion(1);
		
		/*Ejercicio 12: CallableStatement (Llamada a Función)
		Crea el método obtenerMulta(int idLector). Este método debe llamar a la
		función de Oracle CALCULAR_MULTA_LECTOR (usando la sintaxis {? = call
		FUNCION_PLSQL(?) }). Muestra el valor numérico devuelto por la función.
		Ejercicio 13: Transacciones (COMMIT)
		Implementa registrarPrestamoSeguro(int idLector, String isbn). Deshabilita
		el auto-commit. Dentro de un bloque try, realiza dos operaciones (Insert y
		Update) usando PreparedStatement. Si ambas son exitosas, llama a
		connection.commit().*/
		conectarOracle();
//		obtenerMulta(2005);
		
		/*Ejercicio 14: Transacciones (ROLLBACK)
		Modifica el ejercicio anterior para que, si el UPDATE falla (ej. si el número de
		copias es insuficiente y se genera una excepción en Java o al intentar actualizar
		a un número negativo), se ejecute connection.rollback() en el bloque catch.
		Imprime un mensaje indicando que la transacción fue revertida.
		Ejercicio 15: CallableStatement (Parámetro IN/OUT)
		Desarrolla aplicarMulta(int idLector, double montoAdicional). Este método
		debe llamar al procedimiento ACTUALIZAR_MULTA_INOUT. El parámetro
		montoAdicional se debe registrar como IN/OUT. Debes: 1) Establecer su valor
		de entrada con cs.setDouble(), 2) Ejecutar, y 3) Recuperar el nuevo saldo total
		de la multa del lector con cs.getDouble().
		*/
		
		
		
	}

}
