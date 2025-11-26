package boletin1ej3y6runnable;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		/*EJERCICIO 03 con runnable
		Mostrar el nombre de un atleta introducido por el usuario y simular que corre 30 km. Usa un
		retardo de tiempo de 3500 milisegundos por cada km. El atleta es el hilo.
		*/
		Scanner sc = new Scanner(System.in);
//		
//		System.out.print("Por favor introduce el nombre del atleta: ");
//		String nombre = sc.nextLine();
//		AtletaHilo at = new AtletaHilo(nombre);
//		sc.close();
//		Thread hilo = new Thread(at);
//		
//		hilo.start();
		
		/*EJERCICIO 06 con runnable
		Mostrar las estaciones del año en un array. El usuario indica una estación del año (usa Scanner)
		y el programa indica los meses que le corresponden, mostrando los meses con una escala de
		tiempo de 2000,3000 y 4000 milisegundos. Ejemplo ejecución de salida:
		*/
		
		System.out.println("primavera \nverano \notoño \ninvierno");
		System.out.print("Ingrese el nombre de la estación en minúsculas: ");
		String estacion = sc.nextLine();
		
		EstacionesHilo est = new EstacionesHilo(estacion);
		Thread h = new Thread(est);
		h.start();
		
		
		
	}

}
