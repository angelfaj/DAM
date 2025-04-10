package agenda;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Persona implements Serializable{

	private static final long serialVersionUID = 4953826061548522985L;
	private String nombre;
	private String telefono;
	private static File agenda = new File("agenda.bin");
	
	public Persona(String nombre, String telefono) {
		super();
		this.nombre = nombre;
		this.telefono = telefono;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getTelefono() {
		return telefono;
	}
	
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", telefono=" + telefono + "]";
	}
	
	public void addPersona() throws IOException {
		
		FileOutputStream fo = null;
		ObjectOutputStream datos = null;
		
		if (!agenda.exists()) {
			fo = new FileOutputStream(agenda);
			datos = new ObjectOutputStream(fo);
		}else {
			fo = new FileOutputStream(agenda, true);
			datos = new ObjectOutputStream(fo);
			
		}
		
		datos.writeObject(this);
		datos.close();
	}
	
	public void deletePersona() throws FileNotFoundException, ClassNotFoundException, IOException {		//Obtenemos las lista de personas guardadas, borramos la indicada y el archivo de datos y volvemos a guardar el resto
		ArrayList<Persona> lista = getPersonaObjectList();
		
		if (lista.contains(this)) {
			lista.remove(this);
		}
		
		agenda.delete();
		
		for (Persona p:lista) {
			p.addPersona();
		}
		
	}
	
	public static ArrayList<Persona> getPersonaObjectList() throws FileNotFoundException, IOException, ClassNotFoundException {
		ArrayList<Persona> listaPersonas = new ArrayList<Persona>();
		Persona aux;
		
		try (FileInputStream fi = new FileInputStream(agenda); ObjectInputStream datos = new ObjectInputStream(fi)) {
			while (true) {
				aux = (Persona) datos.readObject();
				listaPersonas.add(aux);
			}
		}catch (EOFException e) {}			//Catch OBLIGATORIO para la lectura de binarios
		
		return listaPersonas;
	}
	
	public static void showAgenda() throws FileNotFoundException, ClassNotFoundException, IOException {
		ArrayList<Persona> lista = getPersonaObjectList();
		
		for (Persona p:lista) {
			System.out.println(p);
		}
	}
	
	public void editPersona(Persona nueva) throws FileNotFoundException, ClassNotFoundException, IOException {
		this.deletePersona();
		nueva.addPersona();
	}
	
	
}
