package boletin3;

import java.util.Scanner;

public class LanzadorContador {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int puerto = 5000;
		String host = "localhost";
		
		System.out.print("Numero de clientes: ");
		int nClientes = sc.nextInt();
		sc.nextLine();
		
		new ServidorContador(puerto).start();
		
		for (int i = 0; i < nClientes; i++) {
			new ClienteContador(host, puerto).start();
		}

	}

}
