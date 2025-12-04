package app;

import modelo.Cliente;
import modelo.Direccion;
import modelo.Pedido;
import servicio.ClienteService;
import servicio.DireccionService;
import servicio.PedidoService;

import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {
    	/*Hibernate 6 y Oracle 11
		one to one y one to many
		En este ejercicio deberás implementar un pequeño sistema de gestión de
		clientes
		utilizando
		Hibernate
		6
		y
		Oracle
		11.
		Deberás crear el modelo, las relaciones, las operaciones CRUD y probar su
		funcionamiento mediante un programa principal.
		1. Modelo a implementar
		Crea un proyecto Maven siguiendo la misma organización de paquetes usada en
		clase. Debes implementar las siguientes entidades:
		1.1. Cliente
		Un cliente debe tener:
		•Identificador numérico (generado mediante secuencia)
		•Nombre
		•Una dirección principal
		•Una lista de pedidos asociados
		1.2. Dirección
		Una dirección debe tener:
		•Identificador numérico (generado mediante secuencia)
		•Calle
		•Ciudad
		Cada cliente tendrá una única dirección principal.
		1.3. Pedido
		Un pedido debe tener:
		•Identificador numérico (generado mediante secuencia)
		•Descripción
		•El cliente al que pertenece
		Un cliente puede tener varios pedidos.2. Requisitos técnicos
		1. Las relaciones deben configurarse con anotaciones JPA.
		2. Debes utilizar secuencias de Oracle 11 para la generación de las claves
		primarias.
		3. Las operaciones de persistencia deben gestionarse mediante DAOs.
		4. Debe existir un servicio que utilice dichos DAOs para realizar las
		operaciones.
		5. Las sesiones deben abrirse y cerrarse correctamente.
		6. Toda operación que modifique datos debe realizarse dentro de una
		transacción.
		3. Operaciones que se deben implementar
		Debes de poder hacer las operaciones CRUD para cualquiera de las 3 entidades.
		En cliente, deberás además añadirle, borrar, actualizar datos de sus hijos.*/
        Scanner sc = new Scanner(System.in);

        ClienteService clienteService = new ClienteService();
        DireccionService direccionService = new DireccionService();
        PedidoService pedidoService = new PedidoService();

        int opcion = -1;

        while (opcion != 0) {
            System.out.println("\n======== MENU GENERAL ========");
            System.out.println("1. CRUD Cliente");
            System.out.println("2. CRUD Dirección");
            System.out.println("3. CRUD Pedido");
            System.out.println("0. Salir");
            System.out.print("Opción: ");

            opcion = Integer.parseInt(sc.nextLine());

            if (opcion == 1) menuCliente(sc, clienteService);
            if (opcion == 2) menuDireccion(sc, direccionService);
            if (opcion == 3) menuPedido(sc, pedidoService);
        }

        sc.close();
        System.out.println("FIN");
    }

    // --------------------------------------
    // SUBMENÚ CLIENTE
    // --------------------------------------
    static void menuCliente(Scanner sc, ClienteService service) {

        Long idCliente = null;
        int opc = -1;

        while (opc != 0) {

            System.out.println("\n--- CLIENTE ---");
            System.out.println("1. Crear cliente");
            System.out.println("2. Mostrar cliente");
            System.out.println("3. Modificar nombre");
            System.out.println("4. Eliminar dirección del cliente");
            System.out.println("5. Eliminar pedido del cliente");
            System.out.println("6. Borrar cliente");
            System.out.println("0. Volver");
            System.out.print("Opción: ");

            opc = Integer.parseInt(sc.nextLine());

            if (opc == 1) {
                System.out.print("Nombre: ");
                Cliente c = new Cliente();
                c.setNombre(sc.nextLine());

                System.out.print("Calle: ");
                String calle = sc.nextLine();

                System.out.print("Ciudad: ");
                String ciudad = sc.nextLine();

                Direccion d = new Direccion(calle, ciudad);

                System.out.print("Número de pedidos: ");
                int num = Integer.parseInt(sc.nextLine());

                int i = 0;
                java.util.ArrayList<Pedido> pedidos = new java.util.ArrayList<Pedido>();

                while (i < num) {
                    System.out.print("Descripción pedido " + (i + 1) + ": ");
                    pedidos.add(new Pedido(sc.nextLine()));
                    i++;
                }

                idCliente = service.crearClienteCompleto(c, d, pedidos);
                System.out.println("Cliente creado. ID: " + idCliente);
            }

            if (opc == 2) {
                System.out.print("ID cliente: ");
                Long id = Long.parseLong(sc.nextLine());
                Cliente c = service.obtenerCliente(id);
                if (c == null) System.out.println("No existe");
                else {
                    System.out.println("Nombre: " + c.getNombre());
                    
                    
                    System.out.println("Direccion: " + (c.getDireccion() != null ? c.getDireccion().getCalle() : "NULL"));

                    System.out.println("Pedidos:");
                    int i = 0;
                    while (i < c.getPedidos().size()) {
                        Pedido p = c.getPedidos().get(i);
                        System.out.println("  " + i + ": " + p.getDescripcion());
                        i++;
                    }
                }
            }

            if (opc == 3) {
                System.out.print("ID cliente: ");
                Long id = Long.parseLong(sc.nextLine());

                System.out.print("Nuevo nombre: ");
                service.modificarNombre(id, sc.nextLine());
                System.out.println("Nombre actualizado.");
            }

            if (opc == 4) {
                System.out.print("ID cliente: ");
                Long id = Long.parseLong(sc.nextLine());

                service.eliminarDireccion(id);
                System.out.println("Dirección eliminada.");
            }

            if (opc == 5) {
                System.out.print("ID cliente: ");
                Long id = Long.parseLong(sc.nextLine());

                System.out.print("Índice del pedido: ");
                int idx = Integer.parseInt(sc.nextLine());

                service.eliminarPedido(id, idx);
                System.out.println("Pedido eliminado.");
            }

            if (opc == 6) {
                System.out.print("ID cliente: ");
                Long id = Long.parseLong(sc.nextLine());
                service.borrarCliente(id);
                System.out.println("Cliente borrado.");
            }
        }
    }

    // --------------------------------------
    // SUBMENÚ DIRECCION
    // --------------------------------------
    static void menuDireccion(Scanner sc, DireccionService service) {

        int opc = -1;

        while (opc != 0) {
            System.out.println("\n--- DIRECCIÓN ---");
            System.out.println("1. Crear dirección");
            System.out.println("2. Mostrar dirección");
            System.out.println("3. Modificar dirección");
            System.out.println("4. Eliminar dirección");
            System.out.println("0. Volver");
            System.out.print("Opción: ");

            opc = Integer.parseInt(sc.nextLine());

            if (opc == 1) {
                System.out.print("Calle: ");
                String calle = sc.nextLine();
                System.out.print("Ciudad: ");
                String ciudad = sc.nextLine();

                Direccion d = new Direccion(calle, ciudad);
                Long id = service.crearDireccion(d);
                System.out.println("Dirección creada con ID = " + id);
            }

            if (opc == 2) {
                System.out.print("ID dirección: ");
                Direccion d = service.obtenerDireccion(Long.parseLong(sc.nextLine()));
                if (d == null) System.out.println("No existe");
                else System.out.println(d.getCalle() + ", " + d.getCiudad());
            }

            if (opc == 3) {
                System.out.print("ID dirección: ");
                Long id = Long.parseLong(sc.nextLine());
                Direccion d = service.obtenerDireccion(id);
                if (d != null) {
                    System.out.print("Nueva calle: ");
                    d.setCalle(sc.nextLine());
                    System.out.print("Nueva ciudad: ");
                    d.setCiudad(sc.nextLine());
                    service.actualizarDireccion(d);
                    System.out.println("Actualizada.");
                }
            }

            if (opc == 4) {
                System.out.print("ID dirección: ");
                service.borrarDireccion(Long.parseLong(sc.nextLine()));
                System.out.println("Dirección eliminada.");
            }
        }
    }

    // --------------------------------------
    // SUBMENÚ PEDIDO
    // --------------------------------------
    static void menuPedido(Scanner sc, PedidoService service) {

        int opc = -1;

        while (opc != 0) {
            System.out.println("\n--- PEDIDO ---");
            System.out.println("1. Crear pedido");
            System.out.println("2. Mostrar pedido");
            System.out.println("3. Modificar pedido");
            System.out.println("4. Eliminar pedido");
            System.out.println("0. Volver");
            System.out.print("Opción: ");

            opc = Integer.parseInt(sc.nextLine());

            if (opc == 1) {
                System.out.print("Descripción: ");
                Pedido p = new Pedido(sc.nextLine());
                Long id = service.crearPedido(p);
                System.out.println("Pedido creado con ID = " + id);
            }

            if (opc == 2) {
                System.out.print("ID pedido: ");
                Pedido p = service.obtenerPedido(Long.parseLong(sc.nextLine()));
                if (p == null) System.out.println("No existe");
                else System.out.println("Descripcion: " + p.getDescripcion());
            }

            if (opc == 3) {
                System.out.print("ID pedido: ");
                Long id = Long.parseLong(sc.nextLine());
                Pedido p = service.obtenerPedido(id);
                if (p != null) {
                    System.out.print("Nueva descripción: ");
                    p.setDescripcion(sc.nextLine());
                    service.actualizarPedido(p);
                    System.out.println("Pedido actualizado.");
                }
            }

            if (opc == 4) {
                System.out.print("ID pedido: ");
                service.borrarPedido(Long.parseLong(sc.nextLine()));
                System.out.println("Pedido eliminado.");
            }
        }
    }
}
