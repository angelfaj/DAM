package boletin1ej7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LanzadorSumadorEnteros {

	public static void main(String[] args) {
		
		//Creamos los objetos file necesarios
		File bin = new File("bin");
		File fOut1 = new File ("resultado1.txt");
		File fOut2 = new File ("resultado2.txt");
		
		//Creamos el copnstructor y le asignamos el directorio de trabajo
		ProcessBuilder pb1 = new ProcessBuilder("java", "boletin1ej7.SumadorEnteros", "2", "4");
		ProcessBuilder pb2 = new ProcessBuilder("java", "boletin1ej7.SumadorEnteros", "1", "4");
		pb1.directory(bin);
		pb2.directory(bin);
		
		//Redirigimos la salida a un txt y ejecutamos
		pb1.redirectOutput(fOut1);
		pb2.redirectOutput(fOut2);
		try {
			Process p1 = pb1.start();
			Process p2 = pb2.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//Leemos ambos ficheros e imprimimos el resultado de la suma
		try(FileReader fr = new FileReader(fOut1); BufferedReader br = new BufferedReader(fr)) {
			String linea;
			linea = br.readLine();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		hay que añadir isalive para asegurarse de que los procesos han terminado de escribir! tambien puede comprobarse con waitfor
	}

}
