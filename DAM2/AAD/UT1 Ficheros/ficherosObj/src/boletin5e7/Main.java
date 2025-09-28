package boletin5e7;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		
	/*
	Ejercicio 7
	● Escribe un fichero de acceso aleatorio con el siguiente contenido:
	● Añade un método en el que dado un número de línea, muestre el
	nombre del utensilio y las unidades del mismo que están almacenados
	en dicha línea.
	● A continuación, dada una clase Utensilio, con los atributos privados:
	private String nombre;
	private int unidades;
	● Almacena la información del fichero en un array de objetos de tipo
	Utensilio.
	● Posteriormente, vuelca el contenido del array en un fichero de objetos.
	● Muestra la información de dicho fichero.
	● Además, la clase contendrá un método que recorrerá el fichero de
	objetos y al final mostrará el nombre del objeto y cuántas unidades hay
	del mismo almacenados en el fichero. La salida será:
	● Realizar otro método similar al anterior, pero en vez de escribir el
	resultado en la consola, éste se almacenará en un fichero de texto
	llamado utensilios.txt. Este método se implementará sin la utilización de
	arrays.
	*/
	
	File f = new File ("inventario.dat");
	Scanner sc = new Scanner(System.in);
	}
	//Metodos
	public static int lineSize = 24; //10 chars + 1 int = 20 + 4
	public static void saveUtilOnRaf(File f, Utensilio u) throws FileNotFoundException, IOException {
		try(RandomAccessFile raf = new RandomAccessFile(f, "rw")) {
			String nombre = u.getNombre();
			raf.seek(raf.length());
			
			for (int i = 0; i < nombre.length(); i++) {
				raf.writeChar(nombre.charAt(i));
			}
			raf.writeInt(u.getCantidad());
		}
	}
	
	public static ArrayList<Utensilio>  getArrFromRaf(File f) throws FileNotFoundException, IOException {
		ArrayList<Utensilio> arrUt = new ArrayList<Utensilio>();
		try(RandomAccessFile raf = new RandomAccessFile(f, "r")) {
			StringBuilder sb = new StringBuilder();
			String nombre;
			
			while (raf.getFilePointer() < raf.length()) {
				for (int i = 0; i < 10; i++) {
					sb.append(raf.readChar());
				}
				nombre = sb.toString();
				arrUt.add(new Utensilio(nombre, raf.readInt()));
			}
		}
		return arrUt;
	}
	
	public static int validarPosicion(File f, Scanner sc) throws FileNotFoundException, IOException {
		int i = -1;
		try (RandomAccessFile raf = new RandomAccessFile(f, "r")) {
			while (i < 1 || i >= raf.length()) {
				System.out.println("Introduce una posición valida");
				i = ((sc.nextInt()-1) * 24); //Hacemos la conversion, 24 ocupa cada linea
			}
		}
		return i;
	}
	
	
}

	


