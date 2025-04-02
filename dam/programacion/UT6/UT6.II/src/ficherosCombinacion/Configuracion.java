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
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Configuracion implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4970923104669163709L;
	private HashMap<String, String> mapa;
	
	public Configuracion() {
		mapa = new HashMap<String, String>();
	}
	
	public Map<String, String> fillMapFromTxt(File txtFile) throws IOException, ClassNotFoundException {	//Devuelve un array de los clientes almacenados en el fichero txt pasado por parametro
		String linea = "";
		
		try(FileReader fr = new FileReader(txtFile); BufferedReader bf = new BufferedReader(fr)) {
			while ((linea = bf.readLine()) != null) {	//Lectura del fichero de texto. 
				String[] id = linea.split("=");
				mapa.put(id[0], id[1]);
			}
		}
		return mapa;
	}
	
	public void saveMapInBinFile(File f) throws IOException {
		FileOutputStream fo = null;
		ObjectOutputStream datos = null;
		
		if (!f.exists()) {
			fo = new FileOutputStream(f);
			datos = new ObjectOutputStream(fo);
		}else {
			fo = new FileOutputStream(f, true);
			datos = new MiObjectOutputStream(fo);
		}
		
		//No se pueden guardar estructuras de datos en un fichero asi que volcamos el contenido del mapa 
		Iterator<String> it = mapa.keySet().iterator(); 
		
		while(it.hasNext()) {
			String id = it.next();
			datos.writeObject(new Cliente(mapa.get(id), Integer.parseInt(id)));		//Convertimos los pares clave vbalor en un objeto cliente y lo guardamos en el binario
		}
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

	@Override
	public String toString() {
		return "Mapa: " + mapa;
	}
	
}
