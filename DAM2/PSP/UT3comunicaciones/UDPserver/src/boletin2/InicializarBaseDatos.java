package boletin2;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InicializarBaseDatos {

    public static void main(String[] args) {
    	/*Enunciado: Sistema de Inventario (TCP/Multicast/SQLite)
		Objetivo:Implementar una arquitectura híbrida secuencial (sin hilos): un cliente (Activo)
		solicita información de inventario al servidor vía TCP. El servidor consulta una
		base de datos SQLite y, con la información, notifica el resultado mediante UDP
		Multicast a todos los clientes suscritos (incluyendo un cliente Pasivo y el propio
		cliente Activo).Debido a la restricción de no usar hilos, el servidor y los clientes operarán de
		forma bloqueante, atendiendo una solicitud a la vez. Requisitos de Configuración 
		Componente Protocolo / Tecnología Parámetro Valor
		Petición (Activo → Servidor) TCP Puerto TCP 9000
		Respuesta (Servidor → Clientes)
		UDP Multicast IP Grupo Multicast 235.10.10.1
		Respuesta (Servidor → Clientes)
		UDP Multicast Puerto Multicast 8080
		Persistencia SQLite (Embebida) Archivo DB inventario.db
		Red NetworkInterface IP Local
		Su IP de red interna o virtual (Ej.192.168.56.10).
		1. Tarea Preliminar: Base de Datos SQLite (Este código Java es el que debes ejecutar una vez en su proyecto de Eclipse
		para configurar la base de datos inventario.db en el servidor). Está disponible en InicializarBaseDatos.java
		ID NOMBRE STOCK
		1 Teclado Mecánico 50
		2 Mouse Óptico 120
		3 Monitor 24" 30
		2. Tarea Servidor: ServidorCentral.java (Sin Hilos)
		El servidor es totalmente secuencial. Acepta una conexión TCP, la procesa completamente y luego vuelve a esperar otra conexión.
		1. Bucle de Operación: Crea un ServerSocket en el puerto 9000. Entra en un bucle infinito que:
		o Acepta Petición (Bloqueante): Ejecuta serverSocket.accept() y espera al cliente activo.
		o Consulta SQLite: Lee la petición TCP (Ej: CONSULTA:2) y consulta la base de datos inventario.db.
		o Construcción de Respuesta: Genera la cadena de respuesta:
		ID:[ID]|NOMBRE:[NOMBRE]|STOCK:[STOCK].
		o Emisión Multicast: Abre un MulticastSocket, configura la
		NetworkInterface y envía la respuesta a 235.10.10.1:8080.
		o Cierre: Cierra la conexión TCP con el cliente activo y el MulticastSocket de envío.
		o Vuelve a accept() para esperar al siguiente cliente.
		3. Tarea Cliente 1: El Activo Solicitante (ClienteActivo.java)
		Este cliente realiza la petición TCP y luego se detiene para escuchar la respuesta Multicast.
		1. Petición TCP:
		o Pide al usuario el ID del producto.
		o Abre el Socket TCP y envía la petición (CONSULTA:[ID]).
		o Cierra el socket TCP.
		2. Recepción Multicast (Bloqueante):
		o Abre un MulticastSocket en el puerto 8080.
		o Configura la NetworkInterface y se une al grupo.
		o Ejecuta ms.receive(paquete) y se bloquea, esperando la respuesta.
		o Al recibir el paquete, imprime el resultado y se desconecta del grupo/socket.
		4. Tarea Cliente 2: El Pasivo Monitor (ClientePasivo.java)
		Este cliente solo escucha los anuncios, sin hacer peticiones.
		1. Recepción Multicast (Bloqueante):
		o El cliente solo se dedica a la escucha.
		o Abre el MulticastSocket, configura la NetworkInterface y se une al grupo.
		o Ejecuta ms.receive(paquete) y se bloquea, esperando el anuncio del servidor (que fue disparado por el ClienteActivo).
		o Imprime el resultado y se desconecta del grupo/socket.
		Prueba del Sistema
		El ejercicio se prueba de forma secuencial:
		1. Iniciar ServidorCentral.java (Se queda bloqueado en accept()).
		2. Iniciar ClientePasivo.java (Se queda bloqueado en receive()).
		3. Iniciar ClienteActivo.java (Envía TCP y se queda bloqueado en receive()).
		4. El Servidor atiende la petición y envía el Multicast, despertando a ambos clientes y finalizando la prueba.
		AMPLIACIÓN: no cierres conexión después de la primera petición del cliente, imagina que quiere hacer varias peticiones y cuando envíe FIN será cuando
		deban de cerrar las comunicaciones.*/

        Connection conn = null;
        Statement stmt = null;
        
        // 1. Cargar el driver de SQLite
        try {
            // Asegúrate de que el driver esté en el classpath
            Class.forName("org.sqlite.JDBC"); 
            
            // 2. Conectar (crea el archivo 'inventario.db' si no existe)
            conn = DriverManager.getConnection("jdbc:sqlite:inventario.db");
            System.out.println("Base de datos 'inventario.db' conectada/creada exitosamente.");

            stmt = conn.createStatement();
            
            // 3. Borrar tabla si existe (para limpieza en caso de ejecuciones anteriores)
            String sqlDrop = "DROP TABLE IF EXISTS PRODUCTOS;";
            stmt.executeUpdate(sqlDrop);
            
            // 4. Crear la tabla PRODUCTOS
            String sqlCreate = "CREATE TABLE PRODUCTOS " +
                               "(ID INTEGER PRIMARY KEY, " +
                               " NOMBRE TEXT NOT NULL, " +
                               " STOCK INTEGER)";
            stmt.executeUpdate(sqlCreate);
            
            // 5. Insertar datos de prueba
            String sqlInsert1 = "INSERT INTO PRODUCTOS (ID, NOMBRE, STOCK) VALUES (1, 'Teclado Mecánico', 50);";
            String sqlInsert2 = "INSERT INTO PRODUCTOS (ID, NOMBRE, STOCK) VALUES (2, 'Mouse Óptico', 120);";
            String sqlInsert3 = "INSERT INTO PRODUCTOS (ID, NOMBRE, STOCK) VALUES (3, 'Monitor 24\"', 30);";
            
            stmt.executeUpdate(sqlInsert1);
            stmt.executeUpdate(sqlInsert2);
            stmt.executeUpdate(sqlInsert3);
            
            System.out.println("Tabla PRODUCTOS creada y datos insertados.");

        } catch ( Exception e ) {
            System.err.println( "Error de BD: " + e.getClass().getName() + ": " + e.getMessage() );
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                // Manejo de error de cierre
            }
        }
    }
}
