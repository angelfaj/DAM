package ficherosObject;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Vehiculo implements Serializable{
	private static String vector_matricula[] = {"1234-ABC", "2345-FGT", "7412-RET", "5285-NBN", "7896-JNB", "9632-POI", "1289-GTR"};
	private static long vector_km[]={100000,200000,150000,1200,3000,40000,180000};
	private static int vector_caballos[]={95,110,150,125,110,150,180};
	private static int n_id = 0;
	
	private int id;
	private String matricula;
	private double km;
	private int caballos;

	public Vehiculo(String matricula, double km, int caballos) {
		super();
		n_id++;
		this.matricula = matricula;
		this.km = km;
		this.caballos = caballos;
		this.id = n_id;
	}

	public int getId() {
		return id;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public double getKm() {
		return km;
	}

	public void setKm(double km) {
		this.km = km;
	}

	public int getCaballos() {
		return caballos;
	}

	public void setCaballos(int caballos) {
		this.caballos = caballos;
	}
	
	public static void addVehiculos(File f) throws IOException, FileNotFoundException {
		FileOutputStream fo = null;
		ObjectOutputStream datos = null;
		
		if (!f.exists()) {
			fo = new FileOutputStream(f);
			datos = new ObjectOutputStream(fo);
		} else {
			fo = new FileOutputStream(f, true);
			datos = new MiObjectOutputStream(fo);
		}
		
		for (int i = 0; i < vector_matricula.length; i++)  {
			datos.writeObject(new Vehiculo(vector_matricula[i], vector_km[i], vector_caballos[i]));
		}
		datos.close();
	}
	
	public static void addExtraVehiculos(File f) throws FileNotFoundException, IOException {
		String aux_vector_matricula[] = {"2374-TRE", "8521-PER"};
		long aux_vector_km[]={130000, 2500};
		int aux_vector_caballos[]={110, 1200};
		
		FileOutputStream fo = null;
		ObjectOutputStream datos = null;
		
		if (!f.exists()) {
			fo = new FileOutputStream(f);
			datos = new ObjectOutputStream(datos);
		} else {
			fo = new FileOutputStream(f, true);	//El valor true añade al final del fichero, sino sobreescribiria
			datos = new MiObjectOutputStream(fo);
		}
		
		for (int i = 0; i < aux_vector_matricula.length; i++)  {
			datos.writeObject(new Vehiculo(aux_vector_matricula[i], aux_vector_km[i], aux_vector_caballos[i]));
		}
		datos.close();
		
	}

	//Metodo para mostrar el contenido del fichero
	public static void readVehiculos(File f) throws FileNotFoundException, IOException, ClassNotFoundException {
		Vehiculo v;
		
		FileInputStream fi = new FileInputStream(f);
		ObjectInputStream datos = new ObjectInputStream(fi);
		
		try {
			while(true) {
				v = (Vehiculo) datos.readObject();
				System.out.println(v);
			}
		}catch (EOFException e) {}
		datos.close();
	}
	
	//Metodo sobrecargado para mostrar solo los datos del vehiculo solicitado
	public static void readVehiculos(File f, int id) throws FileNotFoundException, IOException, ClassNotFoundException {
		Vehiculo v;
		boolean continuar = true;
		
		FileInputStream fi = new FileInputStream(f);
		ObjectInputStream datos = new ObjectInputStream(fi);
		
		try {
			while(continuar) {
				v = (Vehiculo) datos.readObject();
				if (v.getId() == id) {
					System.out.println("Los datos del vehiculo son: " + v);
					continuar = false;
				}
			}
		}catch (EOFException e) {}
		datos.close();
	}
	
	
	@Override
	public String toString() {
		return "Vehiculo [id=" + id + ", matricula=" + matricula + ", km=" + km + ", caballos=" + caballos + "]";
	}
	
	
	
}
