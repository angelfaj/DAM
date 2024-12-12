package ejerciciosArraysI;

import java.util.Arrays;
import java.util.Scanner;

public class Cesta {
	//Atributos
	private static Polvoron cesta[][] = new Polvoron[2][3];

	//Contructores
	
	//Metodos
	public static void addPolvoron(Polvoron polvoron) {
		boolean flag = false;
		for (int i = 0; i < cesta.length; i++) {
			for (int j = 0; j < cesta[i].length; j++) {
				Polvoron p = cesta[i][j];
				if (p.getSabor().equals(polvoron.getSabor())) {
					System.out.println("Ya existe un polvorón del mismo sabor en la cesta");
				}
			}
		}
		
		Scanner entrada = new Scanner(System.in);
		System.out.println("Introduce la fila: ");
		int indexFila = entrada.nextInt();
		System.out.println("Introduce la columna: ");
		int indexColumna = entrada.nextInt();
		
		cesta[indexFila][indexColumna] = polvoron;
	}
	
	public static boolean searchPolvoron(Polvoron polvoron) {
		boolean flag = false;
		
		for (int i = 0; i < cesta.length; i++) {
			for (int j = 0; j < cesta[i].length; j++) {
				if ((Arrays.binarySearch(cesta, polvoron)) > 0) {
					flag = true;										//Estos bucle será mas apropiados con while ya que involucra una flag
				}
			}
		}
		return true;
	}
	
	public static boolean deletePolvoron(Polvoron polvoron) {
		boolean flag = false;
		for (int i = 0; i < cesta.length; i++) {
			for (int j = 0; j < cesta[i].length; j++) {
				if ((Arrays.binarySearch(cesta, polvoron)) > 0) {
					cesta[i][j] = null;
					flag = true;
				}
			}
		}
		return flag;
	}
	
	public static boolean modifyPolvoron(Polvoron oldPol, Polvoron newPol) {
		boolean flag = false;
		
		for (int i = 0; i < cesta.length; i++) {
			for (int j = 0; j < cesta[i].length; j++) {
				if ((Arrays.binarySearch(cesta, oldPol)) > 0) {
					cesta[i][j] = newPol;
					flag = true;
				}
			}
		}
		return flag;
	}
	
	public static void showCesta() {
		for (int i = 0; i < cesta.length; i++) {
			for (int j = 0; j < cesta[i].length; j++) {
				Polvoron p = cesta[i][j];
				System.out.print(p.getSabor() + "\t");
				}
			System.out.println();
			}
		}
	
	
	
	
}
