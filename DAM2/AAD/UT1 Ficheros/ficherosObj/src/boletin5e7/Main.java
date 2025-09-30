package boletin5e7;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

import boletin5e3.MiObjectOutputStream;


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
		
		File fRaf = new File ("inventarioRAF.dat");
		Scanner sc = new Scanner(System.in);
	
		if (!fRaf.exists()) {
			try {
				fRaf.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		//Lenamos el fichero
		Utensilio[] muestra = {new Utensilio("tijeras", 7), new Utensilio("alicates", 5), new Utensilio("cafetera", 1), new Utensilio("batidora", 2), new Utensilio("cafetera", 4), new Utensilio("tijeras", 6)};
		for (Utensilio u: muestra) {
			try {
				saveUtilOnRaf(fRaf, u);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		//Pedimos una linea y mostramos contenido de la misma
		try {
			prinfRafFile(fRaf);
			int i = validarPosicion(fRaf, sc);
			getUtensilioInLine(fRaf, i);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	//Metodos
	public static int lineSize = 24; //10 chars + 1 int = 20 + 4
	public static int utilSize = 10;
	public static int cuantitySize = 4;
	
	public static void getUtensilioInLine(File f, int linea) throws FileNotFoundException, IOException {
		try (RandomAccessFile raf = new RandomAccessFile(f, "r")) {
			raf.seek(linea);
			int i = 0;
			while (i < utilSize) {
				i++;
				System.out.print(raf.readChar());
			}
			System.out.print(raf.readInt());
		}
	}
	
	public static void prinfRafFile(File f) throws FileNotFoundException, IOException {
		try(RandomAccessFile raf = new RandomAccessFile(f, "r")) {
			while (raf.getFilePointer() < raf.length() ) {
				StringBuilder util = new StringBuilder();
				int cantidad;
				for (int i = 0; i < utilSize; i++) {
					util.append(raf.readChar());
				}
				cantidad = raf.readInt();
				System.out.println(util + "" + cantidad);
			}
		}
	}
	
	public static void saveUtilOnRaf(File f, Utensilio u) throws FileNotFoundException, IOException {	//Guarda el objeto utensilio en un random acces file
		try(RandomAccessFile raf = new RandomAccessFile(f, "rw")) {
			StringBuilder nombre = new StringBuilder();
			nombre.append(u.getNombre());
			nombre.setLength(10);
			raf.seek(raf.length());
			
			for (int i = 0; i < nombre.length(); i++) {
				raf.writeChar(nombre.charAt(i));
			}
			raf.writeInt(u.getCantidad());
		}
	}
	
	public static void printRafFile(File f) throws FileNotFoundException, IOException {
		ArrayList<Utensilio> arrUt = getArrFromRaf(f);
		for (Utensilio u: arrUt) {
			System.out.println(u);
		}
	}
	
	public static ArrayList<Utensilio>  getArrFromRaf(File f) throws FileNotFoundException, IOException {	//Devuelve un ArrayList del fichero pasado por parametro
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
	
	public static void saveArrOnObjectFile(File f, ArrayList<Utensilio> arrUt) throws IOException {	//Vuelca el contenido array pasado por parametro en unfichero de objetos
		FileOutputStream fo = null;
		ObjectOutputStream datos = null;
		
		if(!f.exists()) {
			fo = new FileOutputStream(f);
			datos = new ObjectOutputStream(fo);
		} else {
			fo = new FileOutputStream(f, true);
			datos = new MiObjectOutputStream();
		}
		
		for (Utensilio u:arrUt) {
			datos.writeObject(u);
		}
		datos.close();
	}
	
	public static int validarPosicion(File f, Scanner sc) throws FileNotFoundException, IOException {	//Valida la posicion introducida por teclado para que sea un numero de linea existente
		int i = -1;
		try (RandomAccessFile raf = new RandomAccessFile(f, "r")) {
			while (i < 0 || i >= raf.length()) {
				System.out.println("Introduce una posición valida");
				i = ((sc.nextInt()-1) * 24); //Hacemos la conversion, 24 ocupa cada linea
			}
		}
		return i;
	}
	
	public static void printFileObject(File f) throws FileNotFoundException, IOException, ClassNotFoundException {
		try(FileInputStream fi = new FileInputStream(f); ObjectInputStream datos = new ObjectInputStream(fi)) {
			while (true) {
				Utensilio u = (Utensilio) datos.readObject();
				System.out.println(u);
			}
		}catch (EOFException e) {}
	}
	
	public static void printOrSaveTotalByUtil(File f, boolean flag)  throws FileNotFoundException, IOException, ClassNotFoundException {	//Volcamos los valores en un hash map y vamos sumando los repes. False para imprimir por consola, true para guardar en fichero de texto
		HashMap<String, Integer> mapUtils = new HashMap<String, Integer>();

		try(FileInputStream fi = new FileInputStream(f); ObjectInputStream datos = new ObjectInputStream(fi)) {
			int unidades = 0;
			while (true) {
				Utensilio u = (Utensilio) datos.readObject();
				if (mapUtils.containsKey(u.getNombre())) {		//Si ya existe el utensilio sobrreescribimos la cantidad sumando el viejo valor al nuevo
					unidades = mapUtils.get(u.getNombre()) + u.getCantidad();
					mapUtils.replace(u.getNombre(), unidades);
				}else {
					mapUtils.put(u.getNombre(), u.getCantidad());
				}
			}
		}catch (EOFException e) {}
		
		Iterator<String> it = mapUtils.keySet().iterator();		//Volcamos los nombres (claves del mapa) e un iterator
		
		while(it.hasNext()) {
			String util = it.next();	//Guardamos el nombre y lo utilizamos para obtener la cantidad asociada a el
			if (!flag) {
				System.out.println(util + "-->" + mapUtils.get(util));
			}else {
				writeUtilInTxt(f, new Utensilio(util, mapUtils.get(util)));
			}
		}
	}

	private static void writeUtilInTxt(File f, Utensilio utensilio) throws IOException {	//Escribe el objeto utensilioo en un fichero txt
		try(FileWriter writer = new FileWriter(f)) {
			writer.write(utensilio.getNombre() + utensilio.getCantidad() + "\n");
		}
	}
	
	
}

	


