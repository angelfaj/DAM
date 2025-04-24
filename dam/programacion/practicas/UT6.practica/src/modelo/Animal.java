package modelo;

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

public class Animal implements Serializable{
    private static final long serialVersionUID = 1L;
	private String nombre;
    private String especie;
    private int edad;
    transient private double peso;
    private String sexo;
    private static final File ANIMALESTXT = new File("animales.txt");
    private static final File ANIMALESDAT= new File("animales.dat");
    

    public Animal(String nombre, String especie, int edad, double peso, String sexo) {
        this.nombre = nombre;
        this.especie = especie;
        this.edad = edad;
        this.peso = peso;
        this.sexo = sexo;
    }

    public Animal() {
	}
    
    public void saveAnimalTxt() throws IOException {
		//Guardfamos en el txt
		FileWriter writer = null;
		
		if (!ANIMALESTXT.exists()) {
			ANIMALESTXT.createNewFile();
			writer = new FileWriter(ANIMALESTXT);
		}else {
			writer = new FileWriter(ANIMALESTXT, true);
		}
		writer.write(this + "\n");
		writer.close();
	}
    
    public void saveAnimalDat() throws IOException {
    	//Guardfamos en el bin
    	FileOutputStream fo = null;
    	ObjectOutputStream datos = null;
    	
    	if (!ANIMALESDAT.exists()) {
    		fo = new FileOutputStream(ANIMALESDAT);
    		datos = new ObjectOutputStream(fo);
    	}else {
    		fo = new FileOutputStream(ANIMALESDAT, true);
    		datos = new MiObjectOutputStream(fo);
    	}
    	
    	datos.writeObject(this);
    	datos.close();
    }
    
    public String showAnimalesTxt() throws FileNotFoundException, IOException {
		String line = "", txt = "";
		
		try (FileReader reader = new FileReader(ANIMALESTXT); BufferedReader buffer = new BufferedReader(reader)) {
			while ((line = buffer.readLine()) != null) {
				txt += line + "\n";
			}
		}
		return txt;
	}

    public String showAnimalesDat() throws FileNotFoundException, IOException, ClassNotFoundException {
		String txt = "";
		Animal aux = null;
		
		try (FileInputStream fi = new FileInputStream(ANIMALESDAT); ObjectInputStream datos = new ObjectInputStream(fi)) {
			while (true) {
				aux = (Animal) datos.readObject();
				txt += aux.toString() + "\n";
			}
		}catch (EOFException e) {}
		
		
		return txt;
	}
    
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	@Override
    public String toString() {
        return nombre + " - " + especie + " - " + edad + " años - " + peso + "kg - " + sexo;
    }
}
