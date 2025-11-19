package sincronizacion;

public class Main {

	public static void main(String[] args) {
		/*EJERCICIO 03
		Crea un programa que simula el tic-tac de un reloj mostrando las palabras Tic y Tac en
		la pantalla de manera alterna. Para ello utiliza monitores: synchronized, wait(), notify()…
		Crea un hilo que se llame Tic y muestre su nombre por pantalla y otro hilo se llame Tac
		para que muestre su nombre por pantalla. Debe mostrarse de manera alterna*/
		
		ThreadGroup tt = new ThreadGroup("tt");
		Thread tic = new Thread(tt, new HiloTicTac("tic"));
		Thread tac = new Thread(tt, new HiloTicTac("tac"));

		tic.start();
		tac.start();
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		tt.interrupt();
	}

}
