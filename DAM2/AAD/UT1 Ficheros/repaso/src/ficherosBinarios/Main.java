package ficherosBinarios;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		/* 
		EJERCICIO 1
		Programa que lee enteros por teclado y los escribe en el fichero binario datos.dat.
		La lectura de datos acaba cuando se introduce -1. A continuación, muestra el
		contenido del fichero.
		Nota: practica sin usar buffer.
		*/
//		File ficheroDatos = new File("datos.dat");
//		
//		if (!ficheroDatos.exists() ) {
//			ficheroDatos.createNewFile();
//		}
//		
//		FileInputStream fi = new FileInputStream(ficheroDatos);
//		FileOutputStream fo = null;
//		
//		int i = 0;
//		Scanner sc = new Scanner(System.in);
//		
//		if (!ficheroDatos.exists()) {
//			fo = new FileOutputStream(ficheroDatos);
//		}else {
//			fo = new FileOutputStream(ficheroDatos, true);
//		}
//		
//		while (i != -1) {
//			System.out.println("Introduce un entero (-1 para finalizar): ");
//			i = sc.nextInt();
//			fo.write(i);
//		}
//		fo.close();
//		sc.close();
//		
//		System.out.println("Contenido del fichero " + ficheroDatos.getAbsolutePath() + ":");
//		while ((i = fi.read()) != -1) {
//			System.out.println(i);
//		}
//		fi.close();
		
		
		/*
	  	EJERCICIO 2
		Se trata de crear un fichero binario de números aleatorios todos distintos. Genera n
		números aleatorios comprendidos entre 1 y 1000 (n debe ser un valor aleatorio
		comprendido entre 500 y 800). Guarda los números generados en el fichero, pero
		sin repeticiones. Si hay repeticiones cuenta cuántas hay en total en el trascurso de
		generar n números aleatorios.
		Muestra posteriormente en pantalla el contenido del fichero y un mensaje que
		indique cuántos números aleatorios se han generado en total y cuántos se han
		almacenado en el fichero. Para ello crea los siguientes métodos:
		● int generaAleatorio(int menor,int mayor): genera y devuelve un número
		aleatorio comprendido entre el rango pasado por parámetro.
		● boolean existe(int num,File f): comprueba si existe el número pasado por
		parámetro o no en el fichero f. Si no existe y entonces este método llama a
		void escribir(int num, File f) para añadir el número al fichero f.
		*/ 
//		File f = new File("numeros.dat");
//		if (!f.exists()) {
//			f.createNewFile();
//		}
//		
//		int nMayor = 10, nMenor = 1, n = generaAleatorio(nMenor, nMayor);
//		int numero = 0, repetidos = 0, generados = 0;
//		
//		for (int i = 0; i < n; i++) {
//			numero = generaAleatorio(5, 8);
//			generados++;
//			if (!existe(numero, f)) {
//				escribir(numero, f);
//			}else {
//				repetidos++;
//			}
//		}
//		System.out.println("Numeros generados " + generados + "\n"
//				+ "Numeros repetidos " + repetidos + "\n");
//		
//		leer(f);
	
		/*
	 	EJERCICIO 4
		Crea una aplicación que almacene los datos básicos de un vehículo como la
		matricula(String), marca (String), tamaño de depósito (double) y modelo (String) en
		ese orden y de uno en uno usando la clase DataInputStream.
		Los datos anteriores se pedirán por teclado y se irán añadiendo al fichero (no se
		sobrescriben los datos) cada vez que ejecutemos la aplicación. El fichero siempre
		será el mismo, en todos los casos. A continuación, muestra todos los datos de cada
		coche.
		Crea dos métodos introduceDatos y muestraDatos para hacer los dos bloques de
		operaciones del ejercicio: recogida de datos para escribir en fichero y lectura del
		fichero. Trata las excepciones posibles en el main.
		 */
		Scanner sc = new Scanner((System.in));
		File f = new File("vehiculos.dat");
		int op;
		
		do {
			System.out.println("-------------------INVENTARIO DE VEHICULOS-------------------" + "\n" +
								"1. Introducir vehiculo." + "\n" + 
								"2. Mostrar vehiculos guardados." + "\n" + 
								"3. Borrar fichero." + "\n" +
								"9. Terminar programa." + "\n" + 
								"Introduce una opcion: ");
			op = sc.nextInt();
			sc.nextLine();
			
			switch (op) {
			case 1:
				try {
					introduceDatos(f, sc);
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			case 2:
				try {
					muestraDatos(f);
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			case 3:
				f.delete();
				System.out.println("Fichero borrado.");
				break;
			case 9: 
				System.out.println("Adiós!");
				break;
			}
		}while (op != 9);
	
		sc.close();
	}
	
	//Metodos
	//EJ2
	public static int generaAleatorio(int menor, int mayor) {
		return (int) (Math.random()*mayor+menor);
	}
	
	public static boolean existe(int num, File f) throws IOException {
		FileInputStream fi = new FileInputStream(f);
		int m;
		while ((m = fi.read()) != -1) {
			if (m == num) {
				fi.close();
				return true;
			}
		}
		fi.close();
		return false;
	}
	
	public static void escribir(int num, File f) throws IOException, FileNotFoundException {
		FileOutputStream fo = new FileOutputStream(f, true);
		fo.write(num);
		fo.close();
	}
	
	public static void leer(File f) throws IOException {
		FileInputStream fi = new FileInputStream(f);
		int n;
		
		System.out.println("Contenido del fichero " + f.getAbsolutePath() + ":");
		while ((n = fi.read()) != -1) {
			System.out.println(n);
		}
		fi.close();
	}
	
	//EJ4
	public static void introduceDatos(File f, Scanner sc) throws IOException {
		String matricula, modelo, marca;
		double deposito;
		
		System.out.println("Matricula: ");
		matricula = sc.nextLine(); 
		System.out.println("Marca: ");
		marca= sc.nextLine();
		System.out.println("Modelo: ");
		modelo = sc.nextLine();
		System.out.println("Deposito: ");
		deposito = sc.nextDouble();
		sc.nextLine();
		new Vehiculo(matricula, marca, modelo, deposito);
		
		try(DataOutputStream dOut = new DataOutputStream(new FileOutputStream(f, true))) {
			dOut.writeUTF(matricula);//MUY IMPORTANTE ESCRIBIR CON LOS MISMOS METODOS QUE VAYAMOS A LEER, SINO DARA ERROR
			dOut.writeUTF(marca);
			dOut.writeUTF(modelo);
			dOut.writeDouble(deposito);
		}
	}
	
	public static void muestraDatos(File f) throws IOException {
		String matricula, modelo, marca;
		double deposito;
		int nV = 0;
		try(DataInputStream dIn = new DataInputStream(new FileInputStream(f))) {
			while (true) {
				nV++;
				matricula = dIn.readUTF();	
				marca = dIn.readUTF();
				modelo = dIn.readUTF();
				deposito = dIn.readDouble();
				
				System.out.println("V" + nV + ": " + matricula + "-" + marca + "-" + modelo + "-" + deposito);
			}
		}catch (EOFException e) {}
	}
	
	
}
