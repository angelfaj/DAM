package hilos;

import java.util.Scanner;

public class Main extends Thread{
	

	public static void main(String[] args) {
		/*EJERCICIO 01
		Ingresar por teclado (Scanner) el nombre de dos usuarios, el día y la hora que ingreso a su
		centro de labores, e indicar si llegó temprano o tarde, cabe señalar que la hora de ingreso es a
		las 8:00 para saber si llegó temprano o tarde. Cada usuario será un hilo de ejecución e indicará
		si llegó temprano o tarde.*/
		
//		try (Scanner sc = new Scanner(System.in)) {
//			for( int i = 0; i < 2; i++) {
//				System.out.print("Ingrese el nombre del empleado: ");
//				String nombre = sc.nextLine();
//				
//				System.out.print("Ingrese el dia: ");
//				String dia = sc.nextLine();
//				
//				System.out.print("Ingrese la hora: ");
//				double hora = sc.nextDouble();
//				sc.nextLine();
//				
//				HiloEmpleado empleado = new HiloEmpleado(nombre, dia, hora);
//				empleado.start();
//				sleep(1000);
//			}
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		/*EJERCICIO 04
		Ingresar los nombres de tres mascotas y simular una carrera de 30 metros e indicar quien llegó
		a la meta. (Usa start y join). Prueba a poner distintas prioridades a tus mascotas, ¿qué sucede?*/
		
		HiloMascota perro = new HiloMascota("perro");
		HiloMascota conejo = new HiloMascota("conejo");
		HiloMascota liebre = new HiloMascota("liebre");
		
		perro.setPriority(MAX_PRIORITY);
		conejo.setPriority(NORM_PRIORITY);
		liebre.setPriority(MIN_PRIORITY);
		
		perro.start();
		conejo.start();
		liebre.start();

		try {
			perro.join();
			conejo.join();
			liebre.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
