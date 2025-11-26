package boletin4ej4;

public class Main {

	public static void main(String[] args) {
		/*EJERCICIO 04
		Se va a simular un ascensor de una empresa con las siguientes características. En un ascensor
		pueden salir varios empleados a la vez, pero entrar sólo puede hacerlo de uno en uno. Si hay
		empleados saliendo tiene que esperar a entrar. Inicialmente hay prioridad en los empleados
		que entran frente a los que salen. Pista: utiliza synchronized, notifyAll() y wait(). Por ejemplo,
		pido con 3 hilos entrar y con 3 hilos salir:
		*/
		EntrandoSaliendo es = new EntrandoSaliendo();
		
		Thread entrante1 = new Thread(new HiloEmpleado("H1", "entrante", es));
		Thread entrante2 = new Thread(new HiloEmpleado("H2", "entrante", es));
		Thread entrante3 = new Thread(new HiloEmpleado("H3", "entrante", es));
		Thread saliente1 = new Thread(new HiloEmpleado("H4", "saliente", es));
		Thread saliente2 = new Thread(new HiloEmpleado("H5", "saliente", es));
		Thread saliente3 = new Thread(new HiloEmpleado("H6", "saliente", es));
		
		entrante1.start();
		entrante2.start();
		entrante3.start();
		saliente1.start();
		saliente2.start();
		saliente3.start();
	}

}
