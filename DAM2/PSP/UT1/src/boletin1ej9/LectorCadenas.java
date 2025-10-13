package boletin1ej9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class LectorCadenas {

	public static void main(String[] args) {
		/*Ejercicio 9
		a) Crea un programa en Java que lea cadenas desde un fichero de texto de
		entrada y las muestre por pantalla hasta recibir * en una sola línea. Si el
		asterisco,*, viene en una línea con otro texto continua leyendo.
		b) A continuación, crea otro programa que ejecute el anterior y se envía la salida a
		un fichero de texto de manera adicional a lo que ya tuviera el fichero de salida.
		En caso de producirse algún error debe escribirlo en un fichero de texto
		también.
		*/
		
		File ficheroEntrada = new File("entradaE09.txt");
		try {
			fillFile(ficheroEntrada);
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Contenido del fichero " + ficheroEntrada.getName() + ":");
		try(FileReader fr = new FileReader(ficheroEntrada); BufferedReader reader = new BufferedReader(fr)) {
			String linea;
			boolean continuar = true;
			while ((linea = reader.readLine()) != null && continuar) {
				if (linea.equals("*")) {
					continuar = false;
				}else {
					System.out.println(linea);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void fillFile(File f) throws IOException {
		try(FileWriter fr = new FileWriter(f); BufferedWriter writer = new BufferedWriter(fr)) {
			writer.write("Hola mundo\r\n"
					+ "Esto es una prueba\r\n"
					+ "* Esta línea si debería mostrarse\r\n"
					+ "Esta es la ultima linea que deberia mostrarse\r\n"
					+ "*\r\n"
					+ "Esta línea no debería mostrarse\r\n"
					+ "Otra más\r\n"
					+ "");
		}
	}
}
