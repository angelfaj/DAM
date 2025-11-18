package repasoEj1;

public class Coordinador {
	 private int contador = 0;       // contador de hilos que han llegado
	    private int esperando = 0;      // hilos que están esperando en la barrera

	    public synchronized void esperar(int numeroHilos) {
	        contador++;                 // este hilo ha llegado
	        esperando++;                // este hilo se apunta a la espera

	        if (contador == numeroHilos) {
	            System.out.println("Fase completada");
	            notifyAll();            // despierta a todos
	        } else {
	            while (contador < numeroHilos) {
	                try {
	                    wait();         // espera hasta que todos lleguen
	                } catch (InterruptedException e) {
	                    e.printStackTrace();
	                }
	            }
	        }

	        esperando--;                // este hilo ya pasó la barrera
	        if (esperando == 0) {       // último hilo que sale reinicia el contador
	            contador = 0;
	        }
	    }
	}