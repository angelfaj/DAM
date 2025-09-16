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

public class ModeloFormulario implements Serializable{
	private static final long serialVersionUID = 1L;
	private String nombre;
	private int edad;
	private static final File DATOS = new File("datos.bin");
	
	public ModeloFormulario() {}
	
	public ModeloFormulario(String nombre, int edad) {
		super();
		this.nombre = nombre;
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	@Override
	public String toString() {
		return "ModeloFormulario [nombre=" + nombre + ", edad=" + edad + "]";
	}
	
	public void saveData() throws IOException, FileNotFoundException {
		FileOutputStream fo = null;
		ObjectOutputStream datos = null;
		
		if (!DATOS.exists()) {
			fo = new FileOutputStream(DATOS);
			datos = new ObjectOutputStream(fo);
		}else {
			fo = new FileOutputStream(DATOS, true);
			datos = new MiObjectOutputStream(fo);
		}
		
		datos.writeObject(this);
		datos.close();
	}
	
	public static ModeloFormulario showData(String nombre) throws IOException, FileNotFoundException, ClassNotFoundException { //Devolvera el elemento cuyo nombre coincida con aquel pasado por parametro
		ModeloFormulario aux = null;
		
		try (FileInputStream fi = new FileInputStream(DATOS); ObjectInputStream datos = new ObjectInputStream(fi)) {
			while (true) {
				aux = (ModeloFormulario) datos.readObject();
				if (aux.getNombre().equalsIgnoreCase(nombre)) {
					return aux;
				}
			}
		}catch (EOFException e) {}
		
		return aux;
	}
	
	public static ArrayList<ModeloFormulario> showAllData() throws FileNotFoundException, IOException, ClassNotFoundException {	//Devuelve un array con todos los clientes guardados
		ArrayList<ModeloFormulario> listaClientes = new ArrayList<ModeloFormulario>();
		
		try(FileInputStream fi = new FileInputStream(DATOS); ObjectInputStream datos = new ObjectInputStream(fi)) {
			while (true) {
				listaClientes.add((ModeloFormulario)datos.readObject());
			}
		}catch (EOFException e) {}
		
		return listaClientes;
	}
}
