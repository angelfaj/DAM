package modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class GestionMoneda {
	private final static File HISTORICOTXT = new File("historico.txt");
	private final static File HISTORICOBIN = new File("historico.bin");
	
	public void saveOperacionTxt(Operacion operacion) throws IOException {
		FileWriter writer = null;
		
		if (!HISTORICOTXT.exists()) {
			writer = new FileWriter(HISTORICOTXT);
		}else {
			writer = new FileWriter(HISTORICOTXT, true);
		}
		
		writer.write(operacion+ "\n");
		writer.close();
	}
	
	public void saveOperacionBin(Operacion operacion) throws FileNotFoundException, IOException {
		FileOutputStream fo = null;
		ObjectOutputStream datos = null;
		
		if (!HISTORICOBIN.exists()) {
			fo = new FileOutputStream(HISTORICOBIN);
			datos = new ObjectOutputStream(fo);
		}else {
			fo = new FileOutputStream(HISTORICOBIN, true);
			datos = new MiObjectOutputStream(fo);
		}
		datos.writeObject(operacion);
		datos.close();
	}
	
	public String[][] getMatrizOperaciones() throws IOException {
		ArrayList<String> arr = getArrayOperacionesTxt();
		String[][] matriz = new String[arr.size()][2];
		
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				matriz[i][j] = arr.get(i).split(" - ")[j];		//Tomamos cada linea del array y lo dividimos en dos para almacenarlo en la matriz
			}
		}
		return matriz;
	}
	
	public ArrayList<String> getArrayOperacionesTxt() throws IOException {
		ArrayList<String> arr = new ArrayList<String>();
		String line;
		
		try(FileReader reader = new FileReader(HISTORICOTXT); BufferedReader buffer = new BufferedReader(reader)) {
			while ((line = buffer.readLine()) != null) {
				arr.add(line);			
			}
		}
		return arr;
	}
}
