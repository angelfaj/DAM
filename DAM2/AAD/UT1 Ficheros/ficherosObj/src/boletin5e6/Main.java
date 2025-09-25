package boletin5e6;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		/*
		Ejercicio 6
		Escribe un programa que lea cadenas de caracteres desde teclado hasta que se
		introduzca la cadena fin.
		a) Si la cadena leída es convertible a un número entero, se convertirá a número
		entero y se grabará en un fichero binario con acceso aleatorio. NOTA: es
		obligatorio crear este fichero con el programa.
		b) Si la cadena leída no es convertible a un número entero, se contabilizarán
		sus caracteres para mostrar un resumen al final del programa.
		c) Al final del programa se mostrarán los números contenidos en el fichero
		creado omitiendo mostrar repetidos.
		Ejemplos de entrada y salida de ejecución del programa:
		*/
		File f= new File("cadenas.dat");
		String cadena = "";
		Scanner sc = new Scanner(System.in);
		int charCounter = 0;
		int entero;
		
		System.out.println("Introduce datos (fin) para terminar:");
		do {
			System.out.print("Entrada:");
			cadena = sc.nextLine();
			try {
				entero = Integer.parseInt(cadena);
				saveInt(f, entero);
			}catch (NumberFormatException e) {
				System.out.println("SIN TERMINAR");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}while (!cadena.equalsIgnoreCase("fin"));
		
		try {
			System.out.println("Valores numéricos:");
			printFileContent(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	
	}
	//Metodos
	public static void saveInt(File f, int entero) throws FileNotFoundException, IOException {
		if (!f.exists()) {
			f.createNewFile();
		}
		try(RandomAccessFile raf = new RandomAccessFile(f, "rw")) {
			raf.seek(raf.length());	//SIN ESTA LINEA SOBREESCRIBIREMOS EL FICHERO CON CADA LLAMADA AL METODO
			raf.writeInt(entero);
		}
	}
	
	public static void printFileContent(File f) throws FileNotFoundException, IOException {
		ArrayList<Integer> enteros = null;
		try(RandomAccessFile raf = new RandomAccessFile(f, "r")){
			enteros = new ArrayList<Integer>();
			while (raf.getFilePointer() < raf.length()) {
				Integer entero = raf.readInt(); 
				if (!enteros.contains(entero)) {
					enteros.add(entero);
				}
			}
		}
		for (Integer i:enteros) {
			System.out.println(i);
		}
	}

}
