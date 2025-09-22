package boletin4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		/*
			Ejercicio 3
			Escribe un programa Java que pide un número entero por teclado y lo añade al
			final de un fichero binario aleatorio enteros.dat que contiene números enteros.
			El programa utiliza un método mostrarFichero() que se llama dos veces. La
			primera muestra el contenido del fichero antes de añadir el nuevo número y la
			segunda llamada muestra el fichero después de añadirlo.
		 */
//		File f = new File("enteros.dat");
//		Scanner sc = new Scanner(System.in);
//		
//		if (!f.exists()) {
//			try {
//				f.createNewFile();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//		
//		try {
//			System.out.println("Contenido previo:");
//			mostrarFichero(f);
//			escribirFichero(f, sc);
//			mostrarFichero(f);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		/*Ejercicio 4
		Escribe un programa Java para modificar un entero dentro del fichero
		enteros.dat con acceso aleatorio del ejercicio anterior. Para ello se pide la
		posición que ocupa el entero a modificar dentro del fichero, a continuación, se
		lee y muestra el valor actual, se pide el nuevo valor y finalmente se escribe el
		nuevo valor en la posición indicada, modificando de esta forma el valor antiguo
		por el nuevo.
		La posición deberá estar comprendida entre 1 y el número de enteros que
		contiene el fichero. De no ser sí, se volverá a pedir la posición al usuario hasta
		que introduzca una correcta.
		*/
		
//		File f = new File("enteros.dat");
//		Scanner sc = new Scanner(System.in);
//		int pos;
//		
//		try {
//			mostrarFichero(f);
//			pos = validarPosicion(f, sc);
//			modificaEntero(f, sc, pos);
//			mostrarFichero(f);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		/*
		Ejercicio 5
		Utilizando un fichero aleatorio, realiza un programa que le muestre al usuario
		un menú con las siguientes opciones:
		1. Añadir números de tipo double al principio del fichero. Esto hará que si
		existe alguno en esa posición se reemplace.
		2. Añadir números de tipo double al final del fichero.
		3. Mostrar el fichero creado.
		4. Sustituir un número indicado por el usuario por otro número que también te
		indique el usuario.
		Nota: Un double en JAVA ocupa 8 bytes.
		*/
		
		File f = new File("e5.dat");
		Scanner sc = new Scanner(System.in);
		int op;
		
		do {
			mostrarMenu();
			System.out.println("Introduce una opcion:");
			op = sc.nextInt();
			
			switch (op) {
			case 1:
				try {
					addDoubleInicio(sc, f);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			case 2:
				try {
					addDoubleFinal(sc, f);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			case 3:
				try {
					mostrarFicheroDoubles(f);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			case 4:
				try {
					modificaEntero(f, sc, op);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			case 9:
				break;
			}
		}while(op != 9);
		
		//EJERCICIO AULAVIRTUAL
		
	}
	//Metodos
	//Ej3
	public static void escribirFichero(File f, Scanner sc) throws FileNotFoundException, IOException {
		System.out.println("Introduce un entero:");
		int i;
		try(RandomAccessFile fr = new RandomAccessFile(f, "rw")) {
			i = sc.nextInt();
			fr.seek(fr.length());	//Colocamos el puntero al final de fichero
			fr.writeInt(i);
		}
	}
	
	public static void mostrarFichero(File f) throws FileNotFoundException, IOException {
		System.out.println("Contenido del fichero (" + f.getName() + "):");
		int i, posicion = 0;
		try(RandomAccessFile fr = new RandomAccessFile(f, "r")) {
			fr.seek(posicion); //Posicionamos el puntero en 0
			while (fr.getFilePointer() < fr.length()) {
				i = fr.readInt();
				System.out.println(i);
			}
		}
	}
	
	//Ej4
	public static void modificaEntero(File f, Scanner sc, int posicion) throws FileNotFoundException, IOException {
		int i; 
		
		try(RandomAccessFile fr = new RandomAccessFile(f, "rw")) {
			fr.seek(posicion);
			System.out.println("Numero a modificar: " + fr.readInt());
			System.out.println("Nuevo numero: ");
			i = sc.nextInt();
			fr.seek(posicion);
			fr.writeInt(i);
		}
	}
	
	public static int validarPosicion(File f, Scanner sc) throws FileNotFoundException, IOException {
		int i = -1;
		try(RandomAccessFile fr = new RandomAccessFile(f, "rw")) {
			while (i < 1 || i >= fr.length()) {
				System.out.println("Introduce una posicion valida:");
				i =(sc.nextInt()-1) * 4;	//Hacemos la conversion para que corresponda con el entero deseado (1 entero = 4 bytes), -1 para posicionar el cursor al final del predecesor. 
			}
		}
		return i;
	}
	
	//Ej5
	private static void mostrarMenu() {
		System.out.println("===================MENU===================" + "\n"
							+"1. Añadir números de tipo double al principio del fichero. Esto hará que si existe alguno en esa posición se reemplace.\n"
							+"2. Añadir números de tipo double al final del fichero.\n"
							+"3. Mostrar el fichero creado.\n"
							+"4. Sustituir un número indicado por el usuario por otro número que también te indique el usuario. ");
	}
	
	public static void addDoubleInicio(Scanner sc, File f) throws FileNotFoundException, IOException {
		try(RandomAccessFile fr = new RandomAccessFile(f, "rw")) {
			int posicion = 0;
			fr.seek(posicion);
			System.out.println("Introduce un double:");
			double d = sc.nextDouble();
			fr.writeDouble(d);
		}
	}
	
	public static void addDoubleFinal(Scanner sc, File f) throws FileNotFoundException, IOException {
		try(RandomAccessFile fr = new RandomAccessFile(f, "rw")) {
			fr.seek(fr.length());
			System.out.println("Introduce un double:");
			double d = sc.nextDouble();
			fr.writeDouble(d);
		}
	}
	
	public static void mostrarFicheroDoubles(File f) throws FileNotFoundException, IOException {
		System.out.println("Contenido del fichero (" + f.getName() + "):");
		double i;
		int posicion = 0;
		try(RandomAccessFile fr = new RandomAccessFile(f, "r")) {
			fr.seek(posicion); //Posicionamos el puntero en 0
			while (fr.getFilePointer() < fr.length()) {
				i = fr.readDouble();
				System.out.println(i);
			}
		}
	}
	
	
}
