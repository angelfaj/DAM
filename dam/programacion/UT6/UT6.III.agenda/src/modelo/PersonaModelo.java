package modelo;

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

public class PersonaModelo implements Serializable{

	private static final long serialVersionUID = 4953826061548522985L;
	private String nombre;
	private String numero;
	private static final File AGENDA = new File("agenda.bin");
	
	public PersonaModelo(String nombre, String telefono) {
		super();
		this.nombre = nombre;
		this.numero = telefono;
	}

	public PersonaModelo() {
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNumero() {
		return numero;
	}
	
	public void setNumero(String telefono) {
		this.numero = telefono;
	}
	
	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", telefono=" + numero + "]";
	}
	
	@Override	//Necesario para poder eliminarlos comparado con sus nombres y telefonos
	public boolean equals(Object obj) {
	    if (this == obj) return true;
	    if (obj == null || getClass() != obj.getClass()) return false;
	    PersonaModelo other = (PersonaModelo) obj;
	    return nombre.equals(other.nombre) && numero.equals(other.numero);
	}

	@Override
	public int hashCode() {
	    return nombre.hashCode() + numero.hashCode();
	}

	public void addPersona() throws IOException {
		FileOutputStream fo = null;
		ObjectOutputStream datos = null;
		
		if (!AGENDA.exists()) {
			fo = new FileOutputStream(AGENDA);
			datos = new ObjectOutputStream(fo);
		}else {
			fo = new FileOutputStream(AGENDA, true);
			datos = new MiObjectOutputStream(fo);
			
		}
		
		datos.writeObject(this);
		datos.close();
	}
	
	public void deletePersona() throws FileNotFoundException, ClassNotFoundException, IOException {		//Obtenemos las lista de personas guardadas, borramos la indicada y el archivo de datos y volvemos a guardar el resto
		ArrayList<PersonaModelo> lista = getPersonaObjectList();
		
		if (lista.contains(this)) {
			lista.remove(this);
		}
		
		AGENDA.delete();
		
		for (PersonaModelo p:lista) {
			p.addPersona();
		}
		
	}
	
	public static ArrayList<PersonaModelo> getPersonaObjectList() throws FileNotFoundException, IOException, ClassNotFoundException {
		ArrayList<PersonaModelo> listaPersonas = new ArrayList<PersonaModelo>();
		PersonaModelo aux;
		
		try (FileInputStream fi = new FileInputStream(AGENDA); ObjectInputStream datos = new ObjectInputStream(fi)) {
			while (true) {
				aux = (PersonaModelo) datos.readObject();
				listaPersonas.add(aux);
			}
		}catch (EOFException e) {}			//Catch OBLIGATORIO para la lectura de binarios
		
		return listaPersonas;
	}
	
	public static String[][] getPersonaMatriz() throws ClassNotFoundException, IOException {
		ArrayList<PersonaModelo> listaPersonas = getPersonaObjectList(); 
		String[][] matriz = new String[listaPersonas.size()][2];
		
		for (int i = 0; i < matriz.length; i ++) {
			for (int j = 0; j < matriz[i].length; j++) {
				if (j == 0) {
					matriz[i][j] = listaPersonas.get(i).nombre;
				}else {
					matriz[i][j] = listaPersonas.get(i).numero;
				}
			}
		}
		
		return matriz;
	}
	
	public static void showAgenda() throws FileNotFoundException, ClassNotFoundException, IOException {
		ArrayList<PersonaModelo> lista = getPersonaObjectList();
		
		for (PersonaModelo p:lista) {
			System.out.println(p);
		}
	}
	
//	Este metodo no es necesario, se consigue la misma funcion con la logica implementada en el controlador
//	public void editPersona(PersonaModelo nueva) throws FileNotFoundException, ClassNotFoundException, IOException {
//		this.deletePersona();
//		nueva.addPersona();
//	}
	
	
}
