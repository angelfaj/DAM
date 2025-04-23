package modelo;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ModeloCine implements Serializable{
	private static final long serialVersionUID = 1L;
	private String email;
	private String film;
	private boolean disabledPerson;
	private String seat;
	private static final File facturaBin = new File("factura.bin"); 
	private static final File facturaTxt= new File("factura.txt"); 
	
	public ModeloCine() {
		super();
	}
	
	public ModeloCine(String email, String film, boolean disabledPerson, String seat) throws IOException {
		super();
		this.email = email;
		this.film = film;
		this.disabledPerson = disabledPerson;
		this.seat = seat;
		saveFactura();
	}

	public void saveFactura() throws IOException {
		//Guardfamos en el txt
		FileWriter writer = null;
		
		if (!facturaTxt.exists()) {
			facturaTxt.createNewFile();
			writer = new FileWriter(facturaTxt);
		}else {
			writer = new FileWriter(facturaTxt, true);
		}
		writer.write(this + "\n");
		writer.close();
		
		//Guardfamos en el bin
		FileOutputStream fo = null;
		ObjectOutputStream datos = null;
		
		if (!facturaBin.exists()) {
			fo = new FileOutputStream(facturaBin);
			datos = new ObjectOutputStream(fo);
		}else {
			fo = new FileOutputStream(facturaBin, true);
			datos = new MiObjectOutputStream(fo);
		}
		
		datos.writeObject(this);
		datos.close();
	}
	
	public String showFacturaTxt() throws FileNotFoundException, IOException {
		String line = "";
		
		try (FileReader reader = new FileReader(facturaTxt); BufferedReader buffer = new BufferedReader(reader)) {
			while ((line = buffer.readLine()) != null) {
				if (line.equalsIgnoreCase(this.toString())) {
					return line;
				}
			}
		}
		return null;
	}
	
	public String showAllFacturaTxt() throws FileNotFoundException, IOException {
		String line = "", txt = "";
		
		try (FileReader reader = new FileReader(facturaTxt); BufferedReader buffer = new BufferedReader(reader)) {
			while ((line = buffer.readLine()) != null) {
				txt += line + "\n";
			}
		}
		return txt;
	}
	
	public String showFacturaBin() throws FileNotFoundException, IOException, ClassNotFoundException {
		ModeloCine aux = null;
		
		try (FileInputStream fi = new FileInputStream(facturaBin); ObjectInputStream datos = new ObjectInputStream(fi)) {
			while (true) {
				aux = (ModeloCine) datos.readObject();
				if (aux.toString().equalsIgnoreCase(this.toString())) {
					return aux.toString();
				}
			}
		}catch (EOFException e) {}
		
		
		return null;
	}
	
	public String showAllFacturaBin() throws FileNotFoundException, IOException, ClassNotFoundException {
		String txt = "";
		ModeloCine aux = null;
		
		try (FileInputStream fi = new FileInputStream(facturaBin); ObjectInputStream datos = new ObjectInputStream(fi)) {
			while (true) {
				aux = (ModeloCine) datos.readObject();
				txt += aux.toString() + "\n";
			}
		}catch (EOFException e) {}
		
		
		return txt;
	}
	
	@Override
	public String toString() {
		return "Reserva [email=" + email + ", film=" + film + ", disabledPerson=" + disabledPerson + ", seat=" + seat
				+ "]";
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFilm() {
		return film;
	}

	public void setFilm(String film) {
		this.film = film;
	}

	public boolean isDisabledPerson() {
		return disabledPerson;
	}

	public void setDisabledPerson(boolean disabledPerson) {
		this.disabledPerson = disabledPerson;
	}

	public String getSeat() {
		return seat;
	}

	public void setSeat(String seat) {
		this.seat = seat;
	}
	
	
}
