package app;

import java.sql.*;

public class GestorBD {

    private Connection conn = null;
    private static int idLogPedidos = 1;

    // Sustituye estos con tus datos de Oracle
    private final String URL_CONEXION = "jdbc:oracle:thin:@localhost:1521:XE";
    private final String USUARIO = "C##MINITIENDA"; 
    private final String PASSWORD = "password";

    /**
     * Criterio d: Establece la conexión con la base de datos Oracle.
     * Criterio c: Usa el driver específico de Oracle.
     */
    public void conectar() {
    	try {
    		Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(URL_CONEXION, USUARIO, PASSWORD);
			System.out.println("Conexión establecida con Oracle.");
		}catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			System.err.println("ERROR: No se pudo conectar a la BD Oracle.");
		}
    }
    
    /**
     * Criterio i: Cierra la conexión.
     */
    public void desconectar() {
    	try {
    		if (conn != null) {
				conn.close();
				System.out.println("\nDesconexión exitosa.");
    		}
    	} catch (SQLException e) {
    		// TODO Auto-generated catch block
    		System.err.println("ERROR al cerrar conexión: ");
    		e.printStackTrace();
    	}
    }

    /**
     * Tarea A - Criterio k: Consulta stock usando un Procedimiento Almacenado.
     * Criterio g: Gestión del parámetro de salida.
     */
    public void consultarStock(int productoId) {
        System.out.println("\n--- Tarea 1: Consultar Stock (ID: " + productoId + ") ---");
        
        try (CallableStatement cs = conn.prepareCall("{call consultar_stock(?, ?)}")){
        	
        	cs.setInt(1, productoId);
        	cs.registerOutParameter(2, Types.INTEGER);
        	cs.execute();
        	int stockActual = cs.getInt(2);
        	System.out.println("Stock actual del Producto " + productoId + ": " + stockActual + " unidades.");
        }catch (SQLException e) {
        	System.err.println("ERROR al consultar stock: " + e.getMessage());
		}
    }

    /**
     * Tarea B - Criterio f, j: Procesa un pedido completo y su log de manera atómica.
     */
    public void procesarPedido(int productoId, int cantidad) {
        System.out.println("\n--- Tarea 2: Procesar Pedido (Prod: " + productoId + ", Cant: " + cantidad + ") ---");

        try (Statement st = conn.createStatement()){
	        System.out.println("    [Transacción Iniciada]");
	        conn.setAutoCommit(false);

	        String sql = "UPDATE productos set stock =" + cantidad + " WHERE id=" + productoId;
	        st.executeUpdate(sql);
	        
	        sql = "INSERT INTO log_pedidos(id, producto_id, cantidad_solicitada) VALUES(" + idLogPedidos + ", " + productoId + ", " + cantidad + ")";
	        st.executeUpdate(sql);
	        
	        conn.commit();
	        idLogPedidos++; //Aumentamos secuencia
	        System.out.println("Pedido procesado y STOCK actualizado.");
        }catch (SQLException e) {
        	try {
        		conn.rollback();
        		System.err.println("ERROR procesando pedido. Detalle: " + "El producto no existe o ID incorrecto.");
        		System.out.println("Cambios deshechos.");
        	}catch (SQLException e1) {
        		System.err.println("ERROR al deshacer cambios: " + e1.getMessage());
			}
        }
    }

    /**
     * Tarea D - Criterio h, g: Consulta 1
     */
    public void listarPedidosDetallados() {
        System.out.println("\n--- Tarea 4: Consulta con JOIN (Pedidos Detallados) ---");
        
        String sql = "SELECT p.nombre as nombre, l.cantidad_solicitada as cantidad "
        		+ "FROM productos p JOIN log_pedidos l on p.id = l.producto_id "
        		+ "ORDER BY l.fecha DESC";
        
        try(PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
        	System.out.println("    ---------------------------------------------------------");
        	while (rs.next()) {
        		String nombre = rs.getString(1);
        		String cantidad = rs.getString(2);
        		System.out.printf("    Producto:" + nombre + "		| Cantidad: " + cantidad +"\n");
        		System.out.println("    ---------------------------------------------------------");
        	}
        }catch (SQLException e) {
        	System.err.println("ERROR al listar pedidos detallados: " + e.getMessage());
        }
    }

    /**
     * Tarea E - Criterio h, g: Consulta 2
     */
    public void productosAltaDemanda(int limite) {
        System.out.println("\n--- Tarea 5: Consulta con HAVING (Demanda > " + limite + ") ---");

        String sql = "SELECT p.nombre as nombre, l.cantidad_solicitada as cantidad "
        		+ "FROM productos p JOIN log_pedidos l on p.id = l.producto_id "
        		+ "GROUP BY p.nombre, l.cantidad_solicitada "
        		+ "HAVING (l.cantidad_solicitada > " + limite +")";
        
        try(PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
        	System.out.println("    Productos con demanda total superior a " + limite + " unidades:");
        	System.out.println("    ---------------------------------------------------------");
        	while (rs.next()) {
        		String nombre = rs.getString(1);
        		String demanda = rs.getString(2);
        		System.out.printf("    Producto:" + nombre + "		| Cantidad: " + demanda +"\n");
        		System.out.println("    ---------------------------------------------------------");
        	}
        }catch (SQLException e) {
        	System.err.println("ERROR en consulta 2: " + e.getMessage());
        }
    }

    /**
     * Criterio i: Método auxiliar para cerrar recursos de forma segura.
     */
//    private void cerrar() {
//    		System.err.println("Error al cerrar recurso: " + e.getMessage());
//    }

	public Connection getConn() {
		return conn;
	}
    
    
}