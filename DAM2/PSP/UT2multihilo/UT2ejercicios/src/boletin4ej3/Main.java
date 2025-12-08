package boletin4ej3;

public class Main {

	public static void main(String[] args) {
		/*EJERCICIO 03
		Crea un programa que simula el tic-tac de un reloj mostrando las palabras Tic y Tac en
		la pantalla de manera alterna. Para ello utiliza monitores: synchronized, wait(), notify()…
		Crea un hilo que se llame Tic y muestre su nombre por pantalla y otro hilo se llame Tac
		para que muestre su nombre por pantalla. Debe mostrarse de manera alterna:
		*/
		TicTac tt = new TicTac();
		Thread hiloTic = new Thread(new HiloTicTac("Tic", tt));
		Thread hiloTac = new Thread(new HiloTicTac("Tac", tt));
		
		hiloTic.start();
		hiloTac.start();
		
		//Es aconsejable sacar los recursos compartidos a una clase a parte, crear un objeto de esa clase en el main y pasarselo a los constructores de los hilos.
	}

}
