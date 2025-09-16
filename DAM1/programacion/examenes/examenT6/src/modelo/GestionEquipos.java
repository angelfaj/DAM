package modelo;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class GestionEquipos {
	private final static File EQUIPOSTXT = new File("equipos.txt");
	private final static File EQUIPOSDAT = new File("equipos.dat");
	
	public void saveEquipoTxt(Equipo equipo) throws IOException {
		FileWriter writer = null;
		
		if (!EQUIPOSTXT.exists()) {
			writer = new FileWriter(EQUIPOSTXT);
		}else  {
			writer = new FileWriter(EQUIPOSTXT, true);
		}
		
		writer.write(equipo + "\n");
		writer.close();
	}
	
	public void saveEquipoDat(Equipo equipo) throws IOException {
		FileOutputStream fo = null;
		ObjectOutputStream datos = null;
		
		if (!EQUIPOSDAT.exists()) {
			fo = new FileOutputStream(EQUIPOSDAT);
			datos = new ObjectOutputStream(fo);
		}else  {
			fo = new FileOutputStream(EQUIPOSDAT, true);
			datos = new MiObjectOutputStream(fo);
		}
		
		datos.writeObject(equipo);
		datos.close();
	}
	
	public String searchEquipoTxt(String numeroSerie) throws IOException {
		if (!EQUIPOSTXT.exists()) {			//Evitamos que lance un error si el archivo no existe 
			EQUIPOSTXT.createNewFile();
		}
		
		String line, equipo;
		
		try(FileReader reader = new FileReader(EQUIPOSTXT); BufferedReader buffer = new BufferedReader(reader)) {
			while ((line = buffer.readLine()) != null) {
				
				if (line.split(" - ")[0].equalsIgnoreCase(numeroSerie)) {	//Comparo el primer elemento de cada linea, si coincide con el n de serie devuelvo la linea
					equipo = line;
					return equipo;
				}
			}
		}
		return null;		//De no encontrarlo devuelve null
	}
	
	public String countPcTipes(String tipe) throws ClassNotFoundException, IOException {	//Cuenta cuantos equipos existen del tipo pasado por parametro	
		ArrayList<String> equiposArr = getArrEquiposTxt();
		int cantidad = 0;
		
		for (String equipo : equiposArr) {			//Recorremos cada linea buscando equipos del mismo tipo
			if (equipo.split(" - ")[3].split(" ")[0].equalsIgnoreCase(tipe)) {	//En el primer split tomamos desde el tipo de portatil hasta el final, al hacer un segundo splic eliminamos las caracteristicas (ram, wifi.. ) y nos quedamos unicamente con el tipo de portatil
				cantidad++;
			}
		}
		
		return "Actualmente hay " + cantidad + " equipos de tipo " + tipe + " guardados en el fichero";
		
	}
	
	public ArrayList<String> getArrEquiposTxt() throws IOException, ClassNotFoundException{		//Lee el fichero de text y devuelve un array de string con todo su contenido
		ArrayList<String> equiposArr = new ArrayList<String>();
		
		if (!EQUIPOSTXT.exists()) {	//Evitamos que lance un error si el archivo no existe 
			EQUIPOSTXT.createNewFile();
		}
		
		String line;
		try(FileReader reader = new FileReader(EQUIPOSTXT); BufferedReader buffer = new BufferedReader(reader)) {
			while ((line = buffer.readLine()) != null) {
				equiposArr.add(line);
			}
		}
		return equiposArr;
	}
	
	public ArrayList<String> getArrEquiposDat() throws IOException, ClassNotFoundException{		//Lee el fichero de objetos y devuelve un array de string con todo su contenido
		ArrayList<String> equiposArr = new ArrayList<String>();
		
		if (!EQUIPOSDAT.exists()) {	//Evitamos que lance un error si el archivo no existe 
			EQUIPOSDAT.createNewFile();
		}
		
		try (FileInputStream fi = new FileInputStream(EQUIPOSDAT); ObjectInputStream datos = new ObjectInputStream(fi)) {
			while (true) {
				Equipo aux = (Equipo) datos.readObject();
				equiposArr.add(aux.toString());
			}
		}catch (EOFException e) {}
		
		return equiposArr;
	}
	
	public String getAllEquiposDat() throws ClassNotFoundException, IOException {	//Devuelve un string con todos los equipos guardados en el fichero de objetos
		String equipos = "";
		
		for (String linea : getArrEquiposDat()) {
			equipos += linea + "\n";
		}
		return equipos;
	}
}
