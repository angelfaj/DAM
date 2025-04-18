package modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ModeloHotel {
	private static final File DESCRIPCIONES = new File("descripciones.txt");
	
	public ModeloHotel() throws IOException {
		fillFichero();
	}
	
	public void fillFichero() throws IOException {
		String descripcionesTxt = "Habitación simple: 1 cama, 1 baño, TV." + "\n" + "Habitación doble: 2 camas, TV, 1 baño, minibar." + "\n" + "Habitación suite: 1 cama King size, minibar ilimitado, TV+ cine, regalo bienvenida.";
		
		if (!DESCRIPCIONES.exists()) {
			DESCRIPCIONES.createNewFile();
			try(FileWriter writer = new FileWriter(DESCRIPCIONES)) {
				writer.write(descripcionesTxt);
			}
		}
		
	}
	
	public String readFichero() throws FileNotFoundException, IOException {
		String descripcionesTxt = "", linea = "";
		try(FileReader reader = new FileReader(DESCRIPCIONES); BufferedReader buffer = new BufferedReader(reader)) {
			while ((linea = buffer.readLine()) != null) {
				descripcionesTxt += linea;
			}
		}
		return descripcionesTxt;
	}
	
	public String readFicheroPattern(int searchLine) throws FileNotFoundException, IOException {		//Recibe el numero de linea en el que se encuentra la descripcion a devolver
		String line = "";
		int actualLine = 0;
		
		try (FileReader reader = new FileReader(DESCRIPCIONES); BufferedReader buffer = new BufferedReader(reader)) {
			while((line = buffer.readLine()) != null) {
				if (actualLine == searchLine) {
					return line;
				}
				actualLine++;
			}
		}
		return "";
	}
	
	
}
