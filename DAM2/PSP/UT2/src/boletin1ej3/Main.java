package boletin1ej3;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		/*EJERCICIO 03
		Mostrar el nombre de un atleta introducido por el usuario y simular que corre 30 km. Usa un
		retardo de tiempo de 3500 milisegundos por cada km. El atleta es el hilo.
		*/
		
		Scanner sc = new Scanner(System.in);
		String nombreAtleta;
		
		System.out.print("Introduce el nombre del atleta: ");
		nombreAtleta = sc.nextLine();
		
		HiloAtleta hilo = new HiloAtleta(nombreAtleta);
		hilo.start();
		
		sc.close();
	}

}
