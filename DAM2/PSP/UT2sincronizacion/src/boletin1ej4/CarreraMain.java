package boletin1ej4;

public class CarreraMain implements Runnable {
	private String nombre;
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 30; i++) {
			System.out.println(nombre + " " + i + "km");
		}
	}

	public static void main(String[] args) {
		/*EJERCICIO 04
		Ingresar los nombres de tres mascotas y simular una carrera de 30 metros e indicar quien llegó
		a la meta. (Usa start y join). Prueba a poner distintas prioridades a tus mascotas, ¿qué sucede?
		Ejemplo de una salida:*/
		CarreraMain tortuga = new CarreraMain();
		tortuga.setNombre("Tortuga");
		Thread hilo1 = new Thread(tortuga);
		hilo1.setPriority(Thread.MAX_PRIORITY);
		
		CarreraMain perro = new CarreraMain();
		perro.setNombre("Perro");
		Thread hilo2 = new Thread(perro);
		hilo2.setPriority(Thread.MIN_PRIORITY);
		
		CarreraMain liebre = new CarreraMain();
		liebre.setNombre("Liebre");
		Thread hilo3 = new Thread(liebre);
		hilo3.setPriority(Thread.NORM_PRIORITY);
		
		hilo1.start();
		hilo2.start();
		hilo3.start();

	}

}
