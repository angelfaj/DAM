package repasoObj;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class Main {

	public static void main(String[] args) {
		// Practica de lectura y escritura de ficheros de objetos con la clase Utensilio
		File ficheroUtensilio = new File("ficheroObj.dat");
		Utensilio[] muestra = {
		            new Utensilio("tijeras", 7),
		            new Utensilio("alicates", 5),
		            new Utensilio("cafetera", 1),
		            new Utensilio("batidora", 2),
		            new Utensilio("cafetera", 4),
		            new Utensilio("tijeras", 6)
		        };
		
		 try {
			saveArrayUtensilio(ficheroUtensilio, muestra);
			printFileObjetos(ficheroUtensilio);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	
	public static void saveArrayUtensilio(File f, Utensilio[] arrUt) throws IOException {
		FileOutputStream fo;
		ObjectOutputStream datos;
		
		//Serializamos los objetos y los conectamos al flujo de datos
		if (!f.exists()) {
			fo = new FileOutputStream(f);
			datos = new ObjectOutputStream(fo);
		}else {
			fo = new FileOutputStream(f, true);
			datos = new MiObjectOutputStream(fo);
		}
		
		//Extraemos cada objeto del array y lo guardamos
		for (Utensilio utensilio:arrUt) {
			datos.writeObject(utensilio);
		}
		
		//Cerramos ambos flujos
		datos.close();
	}
	
	public static void printFileObjetos(File f) throws IOException, ClassNotFoundException {
		if (!f.exists()) {
			System.out.println("El fichero " + f.getName() + " no existe");
		} else {
			try(FileInputStream fi = new FileInputStream(f); ObjectInputStream datos = new ObjectInputStream(fi)) {
				while (true) {
					Utensilio aux = (Utensilio) datos.readObject();
					System.out.println(aux);
				}
			}catch (EOFException e) {
				System.out.println("Fin de la lectura");
			}
		}
	}

}
