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

import ficherosObject.Persona;

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
	
	public static void readFileTxt(File f) throws FileNotFoundException, IOException {
		String linea = "";
		
		try(FileReader fr = new FileReader(f); BufferedReader bf = new BufferedReader(fr)) {
			while ((linea = bf.readLine()) != null) {
				System.out.println(linea);
			}
		}
		
	}
	
	public static void readFileObject(File f) throws FileNotFoundException, IOException, ClassNotFoundException {
		Cliente c;
		
		FileInputStream fi = new FileInputStream(f);
		//conectamos el flujo de bytes al flujo de datos¿?
		ObjectInputStream datos = new ObjectInputStream (fi);
		
		try {
			while(true) {
				c = (Cliente) datos.readObject();
				System.out.println(c);
			}
		}catch (EOFException e) {}
		datos.close();
	}
	
	public static ArrayList<Cliente> getClientTxtList(File txtFile) throws IOException, ClassNotFoundException {	//Devuelve un array de los clientes almacenados en el fichero txt pasado por parametro
		ArrayList<Cliente> clientTxtList = new ArrayList<Cliente>();
		String linea = "";
		
		try(FileReader fr = new FileReader(txtFile); BufferedReader bf = new BufferedReader(fr)) {
			while ((linea = bf.readLine()) != null) {	//Lectura del fichero de texto. 
				String[] id = linea.split(":");
				clientTxtList.add(new Cliente(id[1], Integer.parseInt(id[0])));
			}
		}
		return clientTxtList;
	}
	
	public static ArrayList<Cliente> getClientObjectList(File objFile) throws IOException, ClassNotFoundException {	//Devuelve un array de los clientes almacenados en el fichero de objetos pasado por parametro
		ArrayList<Cliente> clientObjectList = new ArrayList<Cliente>();
		Cliente aux;
		
		try(FileInputStream fi = new FileInputStream(objFile); ObjectInputStream datosLectura = new ObjectInputStream(fi)) {
			while (true) {								//Lectura del fichero de objetos
				aux = (Cliente) datosLectura.readObject();
				clientObjectList.add(aux);
			}	
		}catch (EOFException e) {}
		
		return clientObjectList;
	}
	
	public static void compareSavedData(File txtF, File datF, File diferencias) throws FileNotFoundException, IOException, ClassNotFoundException { //Este metodo compara el contenido de los ficheros pasados por parametroo (fichero txt y fichero de objetos) y guarda las diferencias en otro fichero pasado por parametro
		ArrayList<Cliente> clientesEnTxt = getClientTxtList(txtF);
		ArrayList<Cliente> clientesEnObject = getClientObjectList(datF);
		int muestra;
		
		for (int i = 0; i < clientesEnObject.size(); i++) {	//Comparamos cada cliente del fichero de objetos con todos los del fichero de texto
			muestra = clientesEnObject.get(i).getId();
			int j = 0;
			boolean continuar = true;
			
			do {
				if (muestra == clientesEnTxt.get(j).getId()) {//Si encontramos una coincidencia los eliminamos de ambas listas y pasamos al siguiente
					clientesEnTxt.remove(i);
					clientesEnObject.remove(j);				 
					i--;
					continuar = false;						
				}
			}while(j < clientesEnTxt.size() && continuar);
			
			//En este punto solo quedaran aquellos que solo existan en el fichero de objetos asi que los volcamos en el fichero diferencias
			if (clientesEnObject.get(i) != null) {			
				clientesEnObject.get(i).writeClienteFile(diferencias);
			}
		}
		//En este punto solo quedaran aquellos que solo existan en el fichero de texto asi que los volcamos en el fichero diferencias
		if (!clientesEnObject.isEmpty()) {
			for (int i = 0; i < clientesEnObject.size(); i++) {
				clientesEnObject.get(i).writeClienteFile(diferencias);
			}
		}
	}
	
}
