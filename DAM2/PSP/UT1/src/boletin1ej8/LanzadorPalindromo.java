package boletin1ej8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LanzadorPalindromo {

	public static void main(String[] args) {
		File bin = new File("bin");
		File inputFile = new File("inputEj08.txt");
		File outFile = new File("salida08.txt");

		
		//Type es el homonimo de cat para cmd
		//En linux sustituir por: "cat", "../inputEj08.txt"
		ProcessBuilder pbVolcado = new ProcessBuilder("cmd.exe", "/c", "type ..\\inputEj08.txt");
		pbVolcado.directory(bin);
		pbVolcado.redirectOutput(ProcessBuilder.Redirect.to(outFile));

		
		try {
			//Lanzamos el proceso de volcar la salida y esperamos a que termine
			Process pVolcado = pbVolcado.start();
//			while (pVolcado.isAlive()) {}	//Forma mas correxta de esperar a que termine de escribir
			Thread.sleep(5000); //Suspendemos el programa principar

			String posiblePalin = "";
			try (FileReader fr = new FileReader(outFile); BufferedReader bf = new BufferedReader(fr)){
				while ((posiblePalin = bf.readLine()) != null) {
					ProcessBuilder pbComprobar= new ProcessBuilder("java", "boletin1ej8.Palindromo", posiblePalin);
					pbComprobar.directory(bin);
					pbComprobar.inheritIO();	//Para ver la salida por consola de la clase palindromo
					Process pComprobar = pbComprobar.start();
					pComprobar.waitFor();
			}
		} 
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
