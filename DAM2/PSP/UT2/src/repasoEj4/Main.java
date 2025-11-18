package repasoEj4;

public class Main {

	public static void main(String[] args) {
		/*Ejercicio 4: Carrera de relevos
		• Cuatro hilos representan corredores.
		• Cada corredor debe esperar a que el anterior termine.
		• Usar un objeto monitor para pasar el "testigo" con notify()*/
		
		Monitor monitor = new Monitor();
		HiloCorredor c1 = new HiloCorredor("C1", monitor);
		HiloCorredor c2 = new HiloCorredor("C2", monitor);
		HiloCorredor c3 = new HiloCorredor("C3", monitor);
		HiloCorredor c4 = new HiloCorredor("C4", monitor);
		HiloCorredor c5 = new HiloCorredor("C5", monitor);
		
		c1.start();
		c2.start();
		c3.start();
		c4.start();
		c5.start();
	}

}
