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

public class ModeloFormulario implements Serializable {
	private static final long serialVersionUID = 1L;
	private String nombre;
	private String email;
	private boolean desayuno;
	private static final File DATOS = new File("formulario.dat");
	
	public ModeloFormulario() {
		
	}
	
	public ModeloFormulario(String nombre, String email, boolean desayuno) {
		super();
		this.nombre = nombre;
		this.email = email;
		this.desayuno = desayuno;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public boolean isDesayuno() {
		return desayuno;
	}

	public void setDesayuno(boolean desayuno) {
		this.desayuno = desayuno;
	}
	
	public String getDesayuno() {
		if (desayuno) {
			return "Si";
		}else {
			return "No";
		}
	}

	@Override
	public String toString() {
		return "ModeloFormulario [nombre=" + nombre + ", email=" + email + ", desayuno=" + getDesayuno() + "]";
	}

	public void saveClient() throws IOException {
		FileOutputStream fo = null;
		ObjectOutputStream datos = null;
		
		if (!DATOS.exists()) {
			fo = new FileOutputStream(DATOS);
			datos = new ObjectOutputStream(fo);
		} else {
			fo = new FileOutputStream(DATOS, true);
			datos = new MiObjectOutputStream(fo);
		}
		
		datos.writeObject(this);
		datos.close();
	}
	
	public static ArrayList<ModeloFormulario> showAllClient() throws FileNotFoundException, IOException, ClassNotFoundException {
		FileInputStream fi = new FileInputStream(DATOS);
		ObjectInputStream datos = new ObjectInputStream(fi);
		
		ArrayList<ModeloFormulario> clientList = new ArrayList<ModeloFormulario>(); 
		ModeloFormulario aux = null;
		
		try {
			while (true) {
				aux = (ModeloFormulario) datos.readObject();
				clientList.add(aux);
			}
		}catch (EOFException e) {}
		
		datos.close();
		return clientList;
	}
	
	public static ModeloFormulario showClient(String name) throws FileNotFoundException, IOException, ClassNotFoundException {
		FileInputStream fi = new FileInputStream(DATOS);
		ObjectInputStream datos = new ObjectInputStream(fi);
		
		ModeloFormulario aux = null;
		try {
			while (true) {
				aux = (ModeloFormulario) datos.readObject();
				if (aux.getNombre().equalsIgnoreCase(name)) {
					return aux;
				}
			}
		}catch (EOFException e) {}
		
		datos.close();
		return null;
	}
}
