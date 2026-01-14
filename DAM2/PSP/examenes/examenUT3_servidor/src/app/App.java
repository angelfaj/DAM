package app;

public class App {

	public static void main(String[] args) {

		int puertoTCP = 8888;
		
		new Servidor(puertoTCP).start();
	}

}
