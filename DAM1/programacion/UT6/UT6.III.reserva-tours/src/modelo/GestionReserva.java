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
import java.util.ArrayList;

public class GestionReserva {
	private static final File RESERVASTXT = new File("reservas.txt");
	private static final File RESERVASBIN = new File("reservas.bin");
	
	public boolean saveReservaTxt(Reserva reserva) throws IOException {	//True si guarda 
		FileWriter writer = null;
		boolean guardado = false;		//Necesario para poder cerrar el writer
		
		if (!RESERVASTXT.exists()) {
			writer = new FileWriter(RESERVASTXT);
		}else {
			writer = new FileWriter(RESERVASTXT, true);
		}
		
		if (!searchReservaTxt(reserva)) {
			writer.write(reserva + "\n");
			guardado = true;
		}
		writer.close();
		
		return guardado;
	}
	
	public boolean searchReservaTxt(Reserva reserva) throws FileNotFoundException, IOException {	//True si existe la reserva
		String linea;
		try (FileReader reader = new FileReader(RESERVASTXT); BufferedReader bufer = new BufferedReader(reader)) {
			while ((linea = bufer.readLine()) != null) {
				if (linea.startsWith(reserva.getNombre())) {
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean modificarReservaTxt(Reserva reserva) throws FileNotFoundException, IOException {	//True si modifica la reserva
		ArrayList<Reserva> reservas = getReservasTxt();
		
		if (reservas.contains(reserva)) {							//Buscamos la reserva a modificar y guardamos su posicion, eliminamos el fichero y volcamos de nuevo la informacion actualizada							
			int posicion = reservas.indexOf(reserva);
			reservas.remove(posicion);
			reservas.add(posicion, reserva);
			
			RESERVASTXT.delete();
			for(Reserva r : reservas) {
				saveReservaTxt(r);
			}
			return true;
		}
		return false;
		
	}
	
	public boolean cancelarReservaTxt(Reserva reserva) throws FileNotFoundException, IOException {	//True si borra la reserva
		ArrayList<Reserva> reservas = getReservasTxt();

		if (reservas.contains(reserva)) {							//Eliminamos la reserva, eliminamos el fichero y volcamos de nuevo la informacion actualizada
			reservas.remove(reserva);
			
			RESERVASTXT.delete();
			for(Reserva r : reservas) {
				saveReservaTxt(r);
			}
			return true;
		}
		return false;
	}
	
	public ArrayList<Reserva> getReservasTxt() throws FileNotFoundException, IOException {	//Devuelve un arraylist con todas las reservas del txt
		ArrayList<Reserva> reservas = new ArrayList<Reserva>();
		String linea;
		String[] reserva = new String[4];
		
		try (FileReader reader = new FileReader(RESERVASTXT); BufferedReader bufer = new BufferedReader(reader)) {
			while ((linea = bufer.readLine()) != null) {
				reserva = linea.split("-");
				if (reserva.length == 4) {							//Comprobacion obligatoria por la linea adicional introducida al guardar cada reserva
					reservas.add(new Reserva(reserva[0], reserva[1], reserva[2], reserva[3]));	//Creamos un objeto reserva a partir de la linea leida
				}
			}
		}
		return reservas;
	}
	
	
	//Guardado en objetos//
	public boolean saveReservaBin(Reserva reserva) throws IOException, ClassNotFoundException {	//True si guarda 
		FileOutputStream fo = null;
		ObjectOutputStream datos = null;
		boolean guardado  = false;
		
		if (!RESERVASBIN.exists()) {
			fo = new FileOutputStream(RESERVASBIN);
			datos = new ObjectOutputStream(fo);
		}else {
			fo = new FileOutputStream(RESERVASBIN, true);
			datos = new MiObjectOutputStream(fo);
		}
		
		if (!searchReservaBin(reserva)) {
			datos.writeObject(reserva);
			guardado = true;
		}
		datos.close();
		return guardado;
	}
	
	public boolean searchReservaBin(Reserva reserva) throws FileNotFoundException, IOException, ClassNotFoundException {	//True si existe la reserva
		ArrayList<Reserva> reservas = getReservasBin();
		
		if (reservas.contains(reserva)) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean modificarReservaBin(Reserva reserva) throws FileNotFoundException, IOException, ClassNotFoundException {	//True si modifica la reserva
		ArrayList<Reserva> reservas = getReservasBin();
		
		if (reservas.contains(reserva)) {										//Guardamos la posicion de la reserva antigua, añadimos la nueva, borramos el fichero y los guardamos todo
			int posicion = reservas.indexOf(reserva);
			reservas.remove(reserva);
			reservas.add(posicion, reserva);
			
			RESERVASBIN.delete();
			for(Reserva r : reservas) {
				saveReservaBin(r);
			}
			return true;
		}else {
			return false;
		}
	}
	
	public boolean cancelarReservaBin(Reserva reserva) throws FileNotFoundException, IOException, ClassNotFoundException {	//True si borra la reserva
		ArrayList<Reserva> reservas = getReservasBin();
		
		if (reservas.contains(reserva)) {										//Borramos la reserva, borramos el fichero y los guardamos todo
			reservas.remove(reserva);
			
			RESERVASBIN.delete();
			for(Reserva r : reservas) {
				saveReservaBin(r);
			}
			return true;
		}else {
			return false;
		}
		
	}
	
	public ArrayList<Reserva> getReservasBin() throws FileNotFoundException, IOException, ClassNotFoundException {	//Devuelve un arraylist con todas las reservas del bin
		ArrayList<Reserva> reservas = new ArrayList<Reserva>();
		
		try(FileInputStream fi = new FileInputStream(RESERVASBIN); ObjectInputStream datos = new ObjectInputStream(fi)) {
			while(true) {
				reservas.add((Reserva) datos.readObject());
			}
		}catch (EOFException e) {}
		return reservas;
	}
	
}
