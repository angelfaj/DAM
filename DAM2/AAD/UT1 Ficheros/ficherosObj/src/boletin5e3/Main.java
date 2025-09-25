package boletin5e3;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {

	public static void main(String[] args) {
		/*
		Ejercicio 3 - SERIALIZACIÓN Y CLASES COMPUESTAS
		** Cuando una clase contiene un atributo que es una referencia a otro objeto,
		la clase a la que pertenece dicho atributo también debe ser serializable.
		Escribe un programa que escribe en un fichero tres objetos de tipo Alumno.
		Alumno es una clase derivada de Persona y contiene un atributo Fecha que es a
		su vez una clase formada por tres atributos: día, mes y año.
		A continuación, imprime el contenido del fichero por pantalla
		*/

		File f = new File("datos.dat");
		Alumno[] alumnos = {new Alumno("12345678N", "Paco", 56, new Fecha(1, 1, 1960)), new Alumno("78945678N", "Olga", 67, new Fecha(1, 1, 1960)), new Alumno("12345654N", "Paula", 56, new Fecha(1, 1, 1960))};
		
		try {
			saveObject(f, alumnos);
			System.out.println("Contenido del fichero" + f.getName() + ":");
			readFile(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	//Metodos
	public static void saveObject(File f, Alumno[] alumnos) throws FileNotFoundException, IOException {
		FileOutputStream fo = null;
		ObjectOutputStream datos = null;
		
		if (!f.exists()) {
			fo = new FileOutputStream(f);
			datos = new ObjectOutputStream(fo);
		}else {
			fo = new FileOutputStream(f, true);
			datos = new MiObjectOutputStream(fo);
		}
		
		for (int i = 0; i < alumnos.length; i++) {
			Alumno a = new Alumno(alumnos[i].getNif(), alumnos[i].getNombre(), alumnos[i].getEdad(), alumnos[i].getFecha());
			datos.writeObject(a);
		}
		
		datos.close();
	}
	
	public static void readFile(File f) throws FileNotFoundException, ClassNotFoundException,  IOException {
		try (FileInputStream fi = new FileInputStream(f); ObjectInputStream datos = new ObjectInputStream(fi)) {
			while(true) {
				Alumno a = (Alumno) datos.readObject();
				System.out.println(a);
			}
		}catch (EOFException e) {}
	}
}
