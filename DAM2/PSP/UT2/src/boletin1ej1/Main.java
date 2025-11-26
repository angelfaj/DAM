package boletin1ej1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		/*
		EJERCICIO 01
		Ingresar por teclado (Scanner) el nombre de dos usuarios, el día y la hora que ingreso a su
		centro de labores, e indicar si llegó temprano o tarde, cabe señalar que la hora de ingreso es a
		las 8:00 para saber si llegó temprano o tarde. Cada usuario será un hilo de ejecución e indicará
		si llegó temprano o tarde
		*/
		
		Scanner sc = new Scanner(System.in);
		String nombreEmpleado;
		String dia;
		double hora;
		
		for (int i = 0; i < 2; i++) {
			System.out.print("Ingrese el nombre del empleado: ");
			nombreEmpleado = sc.nextLine();
			
			System.out.print("Ingrese el dia: ");
			dia = sc.nextLine();
			
			System.out.print("Ingrese la hora: ");
			hora = sc.nextDouble();
			sc.nextLine();
			
			HiloHora h1 = new HiloHora(nombreEmpleado, dia, hora);
			h1.start();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		sc.close();
	}

}
