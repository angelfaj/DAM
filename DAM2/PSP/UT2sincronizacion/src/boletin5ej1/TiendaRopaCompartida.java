package boletin5ej1;

import java.util.concurrent.Semaphore;

public class TiendaRopaCompartida {
	private static final Semaphore semaforo = new Semaphore(5);
	private String nombreTienda;
	
	public TiendaRopaCompartida(String nombreTienda) {
		this.nombreTienda = nombreTienda;
	}
	
	public void accederProbador(String nombreCliente) {
		try {
			System.out.println("El cliente " + nombreCliente + " quiere entrar al pribador");
			semaforo.acquire();
			System.out.println("El cliente " + nombreCliente + " ESTA en el probador");
			Thread.sleep(1000);
			System.out.println("El cliente " + nombreCliente + " ha salido del probador");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			semaforo.release();
		}
	}
	
}
