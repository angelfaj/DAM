package boletin5ej1;

public class Main {

	public static void main(String[] args) {
		/*EJERCICIO 1
		Crea una aplicación que represente una tienda de ropa en la que tenemos 5 probadores y
		tenemos 20 clientes(hilos) que desean entrar a esos probadores y tomarse su tiempo decidiendo
		si comprar la ropa o no, al tener 5 probadores nos interesa que se utilicen por el mayor número
		de clientes(hilos) a la vez. Define un semáforo con 5 permisos disponibles ya que podemos tener
		hasta un máximo de 5 clientes usando los probadores, las operaciones que utilizarán los
		semáforos serán las siguientes:
		• Adquirir permiso/acquire() : Si el número de permisos disponibles es mayor que cero
		entonces permitirá el acceso a un hilo y decrementa el número de permisos en 1 unidad,
		en caso de ser igual a 0 pondrá al cliente(hilo) en espera hasta que haya un permiso
		disponible para este.
		• Liberar permiso/release() : Cuando un cliente(hilo) usa este método significa que deja
		un probador(permiso) disponible por lo que incrementamos el número de permisos en
		1 unidad, si hay un cliente esperando entonces este cliente adquirirá el permiso(un
		cliente aleatorio).
		Entonces podemos modelar los 5 probadores usando un semáforo de 5 permisos, los clientes
		que no estén dentro de un probador tendrán que adquirir un permiso o esperar hasta que haya
		un permiso disponble, para el uso de semáforos emplearemos la clase Semaphore que
		implementa Java.*/
		TiendaRopaCompartida tienda = new TiendaRopaCompartida("Tienda");
		
		Thread hilo1 = new Thread(new Cliente("H1", tienda));
		Thread hilo2 = new Thread(new Cliente("H2", tienda));
		Thread hilo3 = new Thread(new Cliente("H3", tienda));
		Thread hilo4 = new Thread(new Cliente("H4", tienda));
		Thread hilo5 = new Thread(new Cliente("H5", tienda));
		Thread hilo6 = new Thread(new Cliente("H6", tienda));
		Thread hilo7 = new Thread(new Cliente("H7", tienda));
		Thread hilo8 = new Thread(new Cliente("H8", tienda));
		
		hilo1.start();
		hilo2.start();
		hilo3.start();
		hilo4.start();
		hilo5.start();
		hilo6.start();
		hilo7.start();
		hilo8.start();
	}

}
