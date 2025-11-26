package boletin3ej7;

public class JoinThread extends Thread{
	private int inicioSuma;
	private int finSuma;
	private int resultadoSuma;
	private String nombre;
	
	public JoinThread(String nombre, int inicioSuma, int finSuma) {
		super(nombre);
		this.inicioSuma = inicioSuma;
		this.finSuma = finSuma;
		resultadoSuma = inicioSuma;
	}
	
	public int getResultadoSuma() {
		return resultadoSuma;
	}

	@Override
	public void run() {
		boolean finBucle = false;
		while (!isInterrupted() && !finBucle) {
			for (;inicioSuma < finSuma; inicioSuma++) {
				resultadoSuma += (inicioSuma + 1);
				System.out.println(getName() + ": " + resultadoSuma);
			}
			finBucle = true;
		}
	}
	
	public static void main(String[] args) {
		/*Ejercicio 7: Sincronización con join()
		Objetivo: Entender join() como herramienta de orden.
		Descripción:
		Crear tres hilos que calculen:
		• Hilo 1 → suma de los números del 1 al 20000. Y muestra la suma parcial
		por pantalla junto al nombre del hilo.
		• Hilo 2 → suma del 20001 al 40000. Y muestra la suma parcial por pantalla
		junto al nombre del hilo.
		• Hilo 3 → suma del 40001 al 60000. Y muestra la suma parcial por pantalla
		junto al nombre del hilo.
		El hilo principal debe:
		1. Lanzar los tres hilos.
		2. Usar join() para esperar a que los tres terminen.
		3. Mostrar el resultado final de sumar las tres sumas parciales.
		4. Mostrar el tiempo total de ejecución usando System.currentTimeMillis().
		Puntos clave a evaluar:
		• Uso de join() para asegurar orden.
		• Almacenamiento de resultados en variables compartidas seguras (por
		ejemplo, campos volatile o pasar resultados a main al final).
		Reto extra: Si se quitan los join(), observar cómo puede cambiar el orden de
		ejecución.
		*/
		
		JoinThread h1 = new JoinThread("H1", 1, 20000);
		JoinThread h2 = new JoinThread("H2", 20001, 40000);
		JoinThread h3 = new JoinThread("H1", 40001, 60000);
		h1.start();
		h2.start();
		h3.start();
		
		try {
			h1.join();
			h2.join();
			h3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		if (!h1.isAlive() && !h2.isAlive() && !h3.isAlive()) {
			int resul = h1.getResultadoSuma() + h2.getResultadoSuma() + h3.getResultadoSuma();
			System.out.println("SUMA FINAL: " + resul + "\n" + "Tiempo de ejecucion: " + System.currentTimeMillis() + "mls");
		}
	}

}
