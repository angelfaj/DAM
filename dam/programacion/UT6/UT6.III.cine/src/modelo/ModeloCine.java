package modelo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ModeloCine implements Serializable{
	private static final long serialVersionUID = 1L;
	private String email;
	private String film;
	private boolean disabledPerson;
	private int seat;
	private static final File facturaBin = new File("factura.bin"); 
	private static final File facturaTxt= new File("factura.txt"); 
	
	public ModeloCine() {
		super();
	}
	
	public ModeloCine(String email, String film, boolean disabledPerson, int seat) {
		super();
		this.email = email;
		this.film = film;
		this.disabledPerson = disabledPerson;
		this.seat = seat;
	}

	public void saveFactura() throws IOException {
		//Guardfamos en el txt
		FileWriter writer = null;
		
		if (!facturaTxt.exists()) {
			writer = new FileWriter(facturaBin);
		}else {
			writer = new FileWriter(facturaBin, true);
		}
		writer.write(this + "");
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
	
	public String showTxt() {
		String txt = "", line = "";
		
		return txt;
	}
	
	public String showBin() {
		String txt = "";
		
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

	public int getSeat() {
		return seat;
	}

	public void setSeat(int seat) {
		this.seat = seat;
	}
	
	
}
