package modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ModeloEditor {
	private static final File FILE = new File("fichero.txt");
	
	public static void addText(String txt) throws IOException {
		if (!FILE.exists()) {
			FILE.createNewFile();
		}
		try(FileWriter writer = new FileWriter(FILE, true)) {
			writer.write(txt + "\n");
		}
	}

	public static void rewriteText(String txt) throws IOException {
		if (!FILE.exists()) {
			FILE.createNewFile();
		}
		try(FileWriter writer = new FileWriter(FILE)) {
			writer.write(txt + "\n");
		}
	}
	
	public static String uploadText() throws FileNotFoundException, IOException {
		String linea = "", texto = ""; 
		try(FileReader reader = new FileReader(FILE); BufferedReader bufer = new BufferedReader(reader)) {
			while ((linea = bufer.readLine()) != null) {
				texto += linea + "\n";
			}
		}
		return texto;
	}
	
}
