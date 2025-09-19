package ficherosTxt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class App {

	public static void main(String[] args) {
		/*
			Crea un programa en java 17 que realice lo siguiente:
			- Escritura con FileWriter introduciendo la información por teclado.
			- Lectura con FileReader introduciendo el nombre del fichero y su ruta por teclado. Muestra la información por pantalla.

			Crea un programa en java 17 que realice lo siguiente:
			- Escritura con BufferedWriter introduciendo la información por teclado.
			- Lectura con BufferedReader introduciendo el nombre del fichero y su ruta por teclado. Muestra la información por pantalla.
		*/
		
		Scanner sc = new Scanner(System.in);
		int op;
		File fichero;
		
		do {
			showMenu();
			op = sc.nextInt();
			sc.nextLine();
			fichero = createObjectFile(sc);
			
			switch (op) {
			case 1: 
				try {
					writeMethod(fichero, sc);
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			case 2: 
				try {
					readMethod(fichero);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			case 3: 
				try {
					writerBuffMethod(fichero, sc);
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			case 4: 
				try {
					readerBuffMethod(fichero, sc);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			case 5: 
				System.out.println("Programa terminado.");
				break;
			}
		}while (op != 5);
		sc.close();

		
		
	}
	//Metodos
	
	//Útiles
	public static void showMenu() {					
		System.out.println("\t\t-----------------MENÚ-----------------\n"
				+ "  1 Escritura con FileWriter introduciendo la información por teclado.\n"
				+ "  2 Lectura con FileReader introduciendo el nombre del fichero y su ruta por teclado. Muestra la información por pantalla.\n"
				+ "  3 Escritura con BufferedWriter introduciendo la información por teclado.\n"
				+ "  4 Lectura con BufferedReader introduciendo el nombre del fichero y su ruta por teclado. Muestra la información por pantalla.\n"
				+ "  5 Fin del programa.\n"
				+ "  Introduce una opción:");
	}
	
	public static void fileComprobation(File fichero) {				//Informativo
		if (fichero.exists()) {
			System.out.println("abriendo fichero existente...");
		}else {
			System.out.println("creando nuevo fichero...");
		}
	}
	
	public static File createObjectFile(Scanner sc) {				//Devuelve un objeto file a partir de la entrada por teclado
		String nombreFichero;
		System.out.println("Nombre del fichero:");
		nombreFichero = sc.nextLine();
		
		return new File(nombreFichero);
	}
	
	//Escritura de fichero con fileWriter
	public static void writeMethod(File fichero, Scanner sc) throws IOException {
		String line = "", text = "";
		
		fileComprobation(fichero);
		try(FileWriter writer = new FileWriter(fichero, true)) {	
			System.out.println("Texto a guardar en el fichero. ('fin' para terminar): ");
			do {
				line = sc.nextLine();
				text += line + "\n";
			}while(!line.equalsIgnoreCase("fin"));
			writer.write(text);
		}
	}

	//Lectura de fichero con fileReader
	public static void readMethod(File fichero) throws FileNotFoundException, IOException {
		if (!fichero.exists()) {
			System.out.println("el fichero no existe");
		}else {
			char caracter;
			int i;
			try(FileReader reader = new FileReader(fichero)) {
				while((i = reader.read()) != -1) {
					caracter = (char) i;
					System.out.print(caracter);
				}
			}
		}

	}
	
	//Escritura de fichero con BufferedWriter
	public static void writerBuffMethod(File fichero, Scanner sc) throws IOException {
		String text= "";
		
		fileComprobation(fichero);
		try(FileWriter fw = new FileWriter(fichero, true); BufferedWriter bw = new BufferedWriter(fw)) {
			System.out.println("Texto a guardar en el fichero. ('fin' para terminar): ");
			do {
				text = sc.nextLine();
				bw.write(text);
				bw.newLine();
			}while (!text.equalsIgnoreCase("fin"));
		}
	}
	
	//Lectura de fichero con BufferedReader
	public static void readerBuffMethod(File fichero, Scanner sc) throws FileNotFoundException, IOException {
		if (!fichero.exists()) {
			System.out.println("el fichero no existe");
		}else {
			String linea = "";
			
			try(FileReader fr = new FileReader(fichero); BufferedReader bf = new BufferedReader(fr)){
				while ((linea = bf.readLine()) != null) {
					System.out.println(linea);
				}
			}
		}
	}
}

