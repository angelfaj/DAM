package app;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Main {

	public static void main(String[] args) {
		/*
	 	Se trata de hacer un programa que lea el fichero oposición.xml y
		guardar en un fichero oposición_resultado.txt los datos de salnifa,
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
		
		//Peticion de datos
		System.out.println("Introduce el fichero xml a leer: ");
		entradaXml = entrada.nextLine();
		fichXml = new File(entradaXml);
			
		System.out.println("Introduce el nombre del .txt donde guardar la informacion: ");
		entradaTxt = entrada.nextLine();
		fichTxt = new File(entradaTxt);
		
		entrada.close();
		
		//Lectura de fichero xml
		try {
		  DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		  DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		  Document doc = dBuilder.parse(fichXml);
		  
		  // estos métodos podemos usarlos combinados para normalizar el archivo XML
		  doc.getDocumentElement().normalize();

			  
		  // almacenamos los nodos 
		  NodeList nList = doc.getElementsByTagName("alumno");

		  String salidaTxt, apto;
		  
		  for(int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(temp);
			
			if(nNode.getNodeType() == Node.ELEMENT_NODE) {
				int media = 0;
				apto = "";
				Element eElement = (Element) nNode;
				
				//Guardamos las notas
				for (int i = 0 ; i < eElement.getElementsByTagName("examen").getLength(); i++) {
					media += Integer.parseInt(eElement.getElementsByTagName("examen").item(i).getTextContent());
				}
				
				media = media/eElement.getElementsByTagName("examen").getLength();
				//Calculamos media
				if (media >= 5) {
					apto = "APTO";
				}else {
					apto = "NO APTO";
				}
				
				//Volcamos todo el contenido en un string 
			    salidaTxt = eElement.getAttribute("nif") + "*" 
			    			+ eElement.getElementsByTagName("pruebafisica").item(0).getTextContent()+ "*"
			    			+ eElement.getElementsByTagName("psicotecnico").item(0).getTextContent() + "*"
			    			+ media + "*" + apto;
			    
			    //Guardamos en el fichero txt
			    !!!!!!
			    System.out.println(salidaTxt);
			   
			 }
		  }
		} catch(FileNotFoundException e) {
			System.out.println("El fichero xml no existe o no se encuentra");
		} catch(Exception e) {
			  e.printStackTrace();
		}
		
		
	}
}
