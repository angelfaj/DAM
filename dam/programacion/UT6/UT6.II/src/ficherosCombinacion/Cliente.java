package ficherosCombinacion;

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
import java.util.ArrayList;

public class Cliente implements Serializable{
	private String nombre;
	private int id;
	
	public Cliente(String nombre, int id) {
		super();
		this.nombre = nombre;
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Ciente [nombre=" + nombre + ", id=" + id + "]";
	}

	public void writeClienteFile(File f) throws IOException {
		if (!f.exists() ) {
			f.createNewFile();
		}
		try(FileWriter fr = new FileWriter(f, true)){
			fr.write(this.id + ":" + this.nombre + "\n");
		}
	}
	
	public void writeClienteObject(File f) throws IOException {
		FileOutputStream fo = null;
		ObjectOutputStream datos = null;
		
		if (!f.exists()) {
			fo = new FileOutputStream(f);
			datos = new ObjectOutputStream(fo);
		}else {
			fo = new FileOutputStream(f, true);
			datos = new MiObjectOutputStream(fo);
		}
		
		datos.writeObject(this);
		datos.close();
	}
	
	public static void compareSavedData(File txtF, File datF) {
		
	}
	
	public static void compareIds(File f) throws FileNotFoundException, IOException, ClassNotFoundException {
		String linea = "";
		Cliente c;
		
		try(FileReader fr = new FileReader(f); BufferedReader bf = new BufferedReader(fr); 
			FileInputStream fi = new FileInputStream(f); ObjectInputStream datos = new ObjectInputStream(fi)) {
			while ((linea = bf.readLine()) != null) {
				String[] id = linea.split(":");
				boolean continuar = true;
				try {
					while(continuar) {
						c = (Cliente) datos.readObject();
						if ((c.getId()+"").equals(id[0])) {
							ES POCO EFICIENTE YA QUE CADA VEZ QUE LEA UN ID DEL TXT RECORRERA EL FICHERO DE OBJETOS
							MEJOR CON PARSEINT Y QUIZA UN ARRAY
						}
					}
				}catch (EOFException e) {}
				
			}
		}	
	}
	
	public static void readFileTxt(File f) throws FileNotFoundException, IOException {
		String linea = "";
		
		try(FileReader fr = new FileReader(f); BufferedReader bf = new BufferedReader(fr)) {
			while ((linea = bf.readLine()) != null) {
				System.out.println(linea);
			}
		}
		
	}

	
}
