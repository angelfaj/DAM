package app;

import java.io.File;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		/*
	 	Se trata de hacer un programa que lea el fichero oposición.xml y
		guardar en un fichero oposición_resultado.txt los datos de salida,
		que serán:
		Nif*pruebafisica*psicotécnico*media nota exámenes*apto o no
		apto
		Un alumno será apto si tienes las tres notas mayor o igual a 5, en
		el fichero que os mando el resultado seria:
		55555m*6.7*5.3*6*APTO
		44444m*4.7*6.3*5*NO APTO
		 */
		
		File fichXml, fichTxt; 
		String entradaXml, entradaTxt;
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Introduce el fichero xml a leer: ");
		entradaXml = entrada.nextLine();
		fichXml = new File(entradaXml);

		System.out.println("Introduce el nombre del .txt donde guardar la informacion: ");
		entradaTxt = entrada.nextLine();
		fichTxt = new File(entradaTxt);
		
		entrada.close();
		
	}
}
