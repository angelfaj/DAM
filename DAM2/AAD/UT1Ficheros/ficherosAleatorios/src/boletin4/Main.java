package boletin4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
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
//			pos = validarPosicionInt(f, sc);
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
		
//		File f = new File("e5.dat");
//		Scanner sc = new Scanner(System.in);
//		int op;
//		
//		do {
//			mostrarMenu();
//			System.out.println("Introduce una opcion:");
//			op = sc.nextInt();
//			
//			switch (op) {
//			case 1:
//				try {
//					addDoubleInicio(sc, f);
//				} catch (FileNotFoundException e) {
//					e.printStackTrace();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//				break;
//			case 2:
//				try {
//					addDoubleFinal(sc, f);
//				} catch (FileNotFoundException e) {
//					e.printStackTrace();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//				break;
//			case 3:
//				try {
//					mostrarFicheroDoubles(f);
//				} catch (FileNotFoundException e) {
//					e.printStackTrace();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//				break;
//			case 4:
//				try {
//					int posicion = validarPosicionDouble(f, sc);
//					modificaDouble(f, sc, posicion);
//				} catch (FileNotFoundException e) {
//					e.printStackTrace();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//				break;
//			case 9:
//				System.out.println("Adiós!");
//				break;
//			}
//		}while(op != 9);
		
		/*
		BOLETIN 4 - extra
		Ejercicio 1
		Escribe un programa Java que haga lo siguiente:
		1- Recupera la información de los datos de alumnos en una lista de alumnos. Cada alumno tendrá una nota entera y un nombre (será único para simplificar)
		2 - Escriba la información completa de todos los alumnos de la lista en un fichero binario alumnos.dat
		3 - Muestre la información completa de alumnos.dat
		4 - Modifique la nota de un alumno en el fichero alumnos.dat a partir del nombre del alumno.
		5 - Realiza el apartado anterior para modificar la nota del último alumno.
		6 - Muestre la información completa de alumnos.dat
		Utiliza fichero binario aleatorio para todos los apartados.
		 */
		
		Scanner sc = new Scanner(System.in);
		File f= new File("alumnos.dat");
		int op;
		ArrayList<Alumno> arrAlum = new ArrayList<Alumno>(); 
		
		
		do {
			mostrarMenuAlumno();
			System.out.println("Introduce una opcion:");
			op = sc.nextInt();
			sc.nextLine();
			
			switch (op) {
			case 0:
				f.delete();
				break;
			case 1:
				arrAlum = fillArrAlumno(sc);
				break;
			case 2:
				try {
					saveFromArr(f, arrAlum);
					arrAlum.clear();;	//Vaciamos el array tras volcar su contenido
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			case 3:
				try {
					mostrarFicheroAlumno(f);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			case 4:
				String nombre = validarNombre(sc);
				System.out.println("Nueva nota:");
				int nota = sc.nextInt();
				sc.nextLine();
				try {
					modificaNotaGuardada(f, nombre, nota);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			case 5:
				System.out.println("Nueva nota:");
				nota = sc.nextInt();
				sc.nextLine();
				try {
					modificaUltimaNotaGuardada(f, nota);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			case 6:
				System.out.println("Adiós!");
				break;
			}
		}while (op != 6);
		
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
	
	public static int validarPosicionInt(File f, Scanner sc) throws FileNotFoundException, IOException {
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
							+"4. Sustituir un número indicado por el usuario por otro número que también te indique el usuario. \n"
							+"9. Terminar programa.");
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
	
	public static void modificaDouble(File f, Scanner sc, int posicion) throws FileNotFoundException, IOException {
		double i; 
		
		try(RandomAccessFile fr = new RandomAccessFile(f, "rw")) {
			fr.seek(posicion);
			System.out.println("Numero a modificar: " + fr.readDouble());
			System.out.println("Nuevo numero: ");
			i = sc.nextDouble();
			fr.seek(posicion);
			fr.writeDouble(i);
		}
	}
	
	public static int validarPosicionDouble(File f, Scanner sc) throws FileNotFoundException, IOException {
		int i = -1;
		try(RandomAccessFile fr = new RandomAccessFile(f, "rw")) {
			while (i < 1 || i >= fr.length()) {
				System.out.println("Introduce una posicion valida:");
				i =(sc.nextInt()-1) * 8;	//Hacemos la conversion para que corresponda con el entero deseado (1 entero = 4 bytes), -1 para posicionar el cursor al final del predecesor. 
			}
		}
		return i;
	}	

	//BOLETIN 4 - extra
	public static ArrayList<Alumno> getArrAlumnoFromFile(File f) throws FileNotFoundException, IOException {	//Devuelve un array de alumnos a partir de un fichero de datos
		ArrayList<Alumno> arrAlum = new ArrayList<Alumno>();
		char[] n = new char[10];
		
		try(RandomAccessFile raf = new RandomAccessFile(f, "r")) {
			raf.seek(0);
			while (raf.getFilePointer() < raf.length()) {
				for (int i = 0; i < n.length; i++) {
					n[i] = raf.readChar();
				}
				Alumno aux = new Alumno(new String(n).trim(), raf.readInt()); //Convertimos el vector de caracteres a string y eliminamos los espacios en blanco 
				arrAlum.add(aux);
			}
		}
		return arrAlum;
	}
	
	public static ArrayList<Alumno> fillArrAlumno(Scanner sc) {		//Llena el array a partir de los datos introducidos por teclado
		ArrayList<Alumno> arrAlum = new ArrayList<Alumno>();
		int op;
		do {
			subMenu();
			System.out.println("Introduce una opcion:");
			op = sc.nextInt();
			sc.nextLine();
			
			switch (op) {
			case 1:
				String nombre = validarNombre(sc);
				System.out.println("Nota (int):");
				int nota = sc.nextInt();
				sc.nextLine();
				arrAlum.add(new Alumno(nombre, nota));
				break; 
			case 2:
				for (Alumno a:arrAlum) {
					System.out.println(a);
				}
				break;
			case 3:
				
				break;
			}
		}while(op != 3);
		return arrAlum;
	}
	
	private static String validarNombre(Scanner sc) {
		boolean continuar = true;
		String nombre;
		do {
			System.out.println("Introduce un nombre válido (3 caracteres min, 10 max): ");
			nombre = sc.nextLine();
			if (nombre.length() <= 10 && nombre.length() >= 3) {
				for (int i = 0; i < 10 && nombre.length() < 10; i++) {	//Añadimos espacios en blanco hasta llegar a 10 caracteres
					nombre = nombre + " ";
				}
				continuar = false;
			}
		}while (continuar);
		
		return nombre;
	}
	private static void subMenu() {
		System.out.println("---------Array---------\n" 
							+ "1. Añadir alumno\n"
							+ "2. Mostrar alumnos introducidos\n"
							+ "3. Terminar\n");
	}
	
	public static void saveFromArr(File f, ArrayList<Alumno> arrAlum) throws FileNotFoundException, IOException {	//Vuelkca el contenido del array en el fichero pasado por parametro
		if (arrAlum.size() !=  0) {
			char[] nom;		//Vector para albergar el nombre de cada alumno
	
			try(RandomAccessFile raf = new RandomAccessFile(f, "rw")) {
				raf.seek(raf.length());
				for(Alumno a:arrAlum) {
					nom = new char[10];
					a.getNombre().getChars(0, 10, nom, 0); //Volcamos el nombre en un vector de chars
					for(int i = 0; i < nom.length; i++) {
						raf.writeChar(nom[i]);
					}
					raf.writeInt( a.getNota());
				}
			}
		}else {
			System.out.println("El array esta vacío, debes llenarlo previamente con la opcion 1 del menú");
		}
	}
	
	public static void mostrarFicheroAlumno(File f) throws FileNotFoundException, IOException {	//Llama al metodo que copia el fichero en un array y lo imprime
		if (!f.exists()) {
			System.out.println("No existe el fichero " + f.getName());
		}else {
			System.out.println("Contenido del fichero " + f.getName() + ":");
			for(Alumno a:getArrAlumnoFromFile(f)) {
				System.out.println(a);
			}
		}
	}
	
	public static void modificaNotaGuardada(File f, String nombre, int nota) throws FileNotFoundException, IOException {	//Modifica la nota a partir del nombre 
		char[] nom = new char[10];
		boolean encontrado = false;
		String nombreGuardado;
		
		try(RandomAccessFile raf = new RandomAccessFile(f, "rw")) {
			raf.seek(0);
			while (raf.getFilePointer() != raf.length() && !encontrado) {
				for(int i = 0; i < 10; i++) {		//10 es el tamaño maximo decidido para el nombre de los alumnos
					nom[i] = raf.readChar();
				}
				nombreGuardado = new String(nom);
				if (nombre.equalsIgnoreCase(nombreGuardado)) {
					raf.writeInt(nota);
					encontrado = true;
				}
				raf.seek(raf.getFilePointer() + 4); //Saltamos las notas de cada alumno
			}
		}
	}
	
	public static void modificaUltimaNotaGuardada(File f, int nota) throws FileNotFoundException, IOException { //Modifica la ultima nota guardada en el fichero
		try(RandomAccessFile raf = new RandomAccessFile(f, "rw")) {
			raf.seek(raf.length() - 4);
			raf.writeInt(nota);
		}
	}
	
	public static void mostrarMenuAlumno() {
		System.out.println("-------------------MENU-------------------\n"
				+ "0 - Borrar fichero\n"
				+ "1 - Llenar lista de alumnos. Cada alumno tendrá una nota entera y un nombre (será único para simplificar)\n"
				+ "2 - Guardar el contenido de la lista en un fichero binario alumnos.dat\n"
				+ "3 - Muestre la información completa de alumnos.dat\n"
				+ "4 - Modifique la nota de un alumno en el fichero alumnos.dat a partir del nombre del alumno.\n"
				+ "5 - Modificar la nota del último alumno.\n"
				+ "6 - Terminar programa");
	}
}
