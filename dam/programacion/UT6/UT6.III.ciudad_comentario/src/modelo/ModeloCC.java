package modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ModeloCC {
	private String ciudad;
	private String comentario;
	private static final File reservas = new File("reservas.txt");
	
	public ModeloCC() {}
	
	public ModeloCC(String ciudad, String comentario) {
		super();
		this.ciudad = ciudad;
		this.comentario = comentario;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	@Override
	public String toString() {
		return "Ciudad: " + ciudad + "\n" + "Comentarios: " + comentario;
	}
	
	public void saveReserva() throws IOException {
		if (!reservas.exists()) {
			reservas.createNewFile();
		}
		
		try (FileWriter writer = new FileWriter(reservas, true)) {
			writer.write(this + "\n");
		}
	}
	
	public static String readReservas() throws FileNotFoundException, IOException {
		String texto = "", linea = "";
		
		try(FileReader reader = new FileReader(reservas); BufferedReader buffer = new BufferedReader(reader)) {
			while ((linea = buffer.readLine()) != null) {
				texto += linea + "\n";
			}
		}
		return texto;
	}
}
