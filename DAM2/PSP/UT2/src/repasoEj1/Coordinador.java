package repasoEj1;

public class Coordinador {
	private static int contador;

	
	public synchronized void aumentarContador(int numeroHilos) {
		contador++;
		if (contador == numeroHilos) {
			System.out.println("Fase completada");
		}
	}
	
	public synchronized void esperar(int numeroHilos) {
		if(contador < numeroHilos) {			//con una condicion whle se queda congelado, buscar explicacion
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			contador = 0;
			notifyAll();
		}
	}
}
