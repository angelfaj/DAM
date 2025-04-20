package modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

public class ModeloLista {
	private static final File listaTareasTxt = new File("listaTareas.txt");
	private String descripcion;
	
	public ModeloLista() {}

	public ModeloLista(String descripcion) {
		super();
		this.descripcion = descripcion;
	}

	public void saveTarea() throws IOException {
		if (!listaTareasTxt.exists()) {
			listaTareasTxt.createNewFile();
		}
			
		try (FileWriter writer = new FileWriter(listaTareasTxt, true)){
			writer.write(this.getDescripcion() + "\n");
		}
	}
	
	public static String getAllTareas() throws IOException {
		String tareas = "", line = "";
		
		if(!listaTareasTxt.exists()) {
			listaTareasTxt.createNewFile();
		}
		
		try(FileReader reader = new FileReader(listaTareasTxt); BufferedReader buffer = new BufferedReader(reader)) {
			while ((line = buffer.readLine()) != null) {
				tareas += line + "\n";
			}
		}
		return tareas;
	}
	
	public void deleteTarea() throws FileNotFoundException, IOException {
		String tareas = "", line = "";
		
		try(FileReader reader = new FileReader(listaTareasTxt); BufferedReader buffer = new BufferedReader(reader)) {
			while ((line = buffer.readLine()) != null ) {
				if (!line.equalsIgnoreCase(getDescripcion())) {
					tareas += line + "\n";
				}
			}
		}
		deleteAll();
		
		String tareasNew = removeEmptyLine(tareas);
		
		//Importante dejar fuera del try, sino quedara en memoria el contenido anterior y no borrara correctamente
		ModeloLista aux = new ModeloLista(tareasNew);
		aux.saveTarea();
	}
	
	private String removeEmptyLine(String txt) {
		String txtNew = "";
		for (String s : txt.split("\n")) {
			txtNew += s + "\n";
		}
		return txtNew;
	}
	
	public void deleteAll() {
		listaTareasTxt.delete();
	}

	@Override
	public String toString() {
		return "ModeloLista [descripcion=" + descripcion + "]";
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
