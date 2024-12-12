package ejerciciosArraysI;

import java.util.Scanner;
import java.util.Arrays;

public class Polvoron {
	//Atributos
	private String sabor;
	private double precio;
	private static String cesta[][] = new String[2][3];
	
	//Cosntructores
	public Polvoron(String sabor, double precio) {
		this.sabor = sabor;
		this.precio = precio;
	}
	
	//Metodos
	public String getSabor() {
		return sabor;
	}

	public void setSabor(String sabor) {
		this.sabor = sabor;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	
	
}
