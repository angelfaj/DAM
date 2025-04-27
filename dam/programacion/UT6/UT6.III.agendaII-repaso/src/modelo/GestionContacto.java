package modelo;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class GestionContacto {
	private static final File AGENDATXT = new File("agenda.txt");
	private static final File AGENDABIN = new File("agenda.bin");
	
	public void saveContacto(Contacto c) throws IOException {	//Metodos que guarda contactos en un txt y bin al mismo tiempo
		//Guardamos en txt
		FileWriter writer = null;
		
		if (!AGENDATXT.exists()) {
			writer = new FileWriter(AGENDATXT);
		}else {
			writer = new FileWriter(AGENDATXT, true);
		}
		
		writer.write(c + "\n");
		writer.close();
		
		//Guardamos en bin
		FileOutputStream fo = null;
		ObjectOutputStream datos = null;
		
		if (!AGENDABIN.exists()) {
			fo = new FileOutputStream(AGENDABIN);
			datos = new ObjectOutputStream(fo);
		}else {
			fo = new FileOutputStream(AGENDABIN, true);
			datos = new MiObjectOutputStream(fo);
		}
		
		datos.writeObject(c);
		datos.close();
	}
	
	public void deleteContacto(Contacto c) throws FileNotFoundException, ClassNotFoundException, IOException {
		ArrayList<Contacto> listaContactos = getArrayContactos();	//Creamos una copia temporal de los contactos
		AGENDABIN.delete();											//Borramos ambos ficheros
		AGENDATXT.delete();
		listaContactos.remove(c);									//Eliminamos el contacto del array
		
		for(Contacto con : listaContactos) {						//Guardamos los contacto restantes
			saveContacto(con);
		}
	}
	
	public ArrayList<Contacto> getArrayContactos() throws FileNotFoundException, IOException, ClassNotFoundException {	//Devolvemos un array con todos los contactos en el bin
		ArrayList<Contacto> listaContactos = new ArrayList<Contacto>();
		
		try (FileInputStream fi = new FileInputStream(AGENDABIN); ObjectInputStream datos = new ObjectInputStream(fi)){
			while (true) {
				Contacto aux = (Contacto) datos.readObject();
				listaContactos.add(aux);
			}
		}catch (EOFException e) {}
		
		return listaContactos;
	}

	public String[][] getMatrizContactos() throws FileNotFoundException, ClassNotFoundException, IOException {
		ArrayList<Contacto> listaContactos = getArrayContactos();
		String[][] matrizContactos = new String[listaContactos.size()][3];
		
		for(int i = 0; i < matrizContactos.length; i++) {
			for (int j = 0; j < matrizContactos[i].length; j++) {
				if(j == 0) {
					matrizContactos[i][j] = listaContactos.get(i).getNombre();
				}else if(j == 1) {
					matrizContactos[i][j] = listaContactos.get(i).getTelefono();
				}else if(j == 2) {
					matrizContactos[i][j] = listaContactos.get(i).isFavorito();
				}
			}
		}
		
		return matrizContactos;
	}
	
}
