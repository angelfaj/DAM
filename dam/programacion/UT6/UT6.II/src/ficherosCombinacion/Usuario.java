package ficherosCombinacion;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Usuario {
	private int id;
	private String nombre;
	private String email;
	
	public Usuario(int id, String nombre, String email) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.email = email;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
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
	
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", email=" + email + "]";
	}
	
	public static ArrayList<Usuario> getArrayFromFileTxt(File txt) throws IOException {
		String linea = "";
		ArrayList<Usuario> userList = new ArrayList<Usuario>();
		
		try(FileReader fr = new FileReader(txt); BufferedReader bf = new BufferedReader(fr)){
			while((linea =bf.readLine()) != null) {
				String[] usuario = linea.split(":");
				userList.add(new Usuario(Integer.parseInt(usuario[0]), usuario[1], usuario[2]));
			}
		}
		
		return userList;
	}
	
	public static ArrayList<Usuario> getArrayFromFileBin(File bin) throws ClassNotFoundException, IOException {
		ArrayList<Usuario> userList = new ArrayList<Usuario>();
		Usuario u;
		
		FileInputStream fi = new FileInputStream(bin);
		ObjectInputStream datos = new ObjectInputStream (fi);
		
		try {
			while(true) {
				u = (Usuario) datos.readObject();
				userList.add(u);
			}
		}catch (EOFException e) {}
		datos.close();
		
		return userList;
	}
	
	public static void mergeTxtAndBinFile(File txt, File bin, File merged) throws IOException, ClassNotFoundException {
		ArrayList<Usuario> userList = getArrayFromFileTxt(txt);
		userList.addAll(getArrayFromFileBin(bin));
		
		FileOutputStream fo = null;
		ObjectOutputStream datos = null;
		
		if (!merged.exists()) {
			fo = new FileOutputStream(merged);
			datos = new ObjectOutputStream(fo);
		}else {
			fo = new FileOutputStream(merged, true);
			datos = new MiObjectOutputStream(fo);
		}
		
		for(Usuario user:userList) {
			datos.writeObject(user);
		}
		datos.close();

	}
	
	public static void readFileObject(File f) throws FileNotFoundException, IOException, ClassNotFoundException {
		Usuario u;
		
		FileInputStream fi = new FileInputStream(f);
		//conectamos el flujo de bytes al flujo de datos¿?
		ObjectInputStream datos = new ObjectInputStream (fi);
		
		try {
			while(true) {
				u = (Usuario) datos.readObject();
				System.out.println(u);
			}
		}catch (EOFException e) {}
		datos.close();
	}
	
	
}
