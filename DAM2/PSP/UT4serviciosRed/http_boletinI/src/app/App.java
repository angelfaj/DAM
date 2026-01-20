package app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class App {
	
	public static void saveHtmlFromUrl(String urlTxt, String fileWhereToSave) {
		File ficheroVolcado = new File(fileWhereToSave);
		if (ficheroVolcado.exists()) ficheroVolcado.delete();
		
		try {
			//Creamo la url de forma segura URI -> URL así evitamos problemas con espacios o caracteres raros
			URL url = URI.create(urlTxt).toURL();
			
			//Abrimos conexión y la configuramos
			HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
			conexion.setRequestMethod("GET"); //Indicamos que vamos a leer datos
			
			conexion.setRequestProperty("User-Agent", "Mozilla/5.0"); //Nos hacemos pasar por un navegador para evitar problemas de visualizacion de caracteres
			
			int codigoRespuesta = conexion.getResponseCode(); //Guardamos la respuesta el servidor
			System.out.println("Codigo de respuesta del servidor: " + codigoRespuesta);
			
			if(codigoRespuesta == HttpURLConnection.HTTP_OK) {	//Si devuelve ok (200) 
				System.out.println("Comienzo de la descarga");
				
				InputStream entrada = conexion.getInputStream();
				InputStreamReader lector = new InputStreamReader(entrada, StandardCharsets.UTF_8); //Codificacion UTF8
				BufferedReader buff = new BufferedReader(lector);
				FileWriter escritor = new FileWriter(ficheroVolcado); 
				String linea;
				
				while ((linea = buff.readLine()) != null) {
					escritor.write(linea);
				}
				
				System.out.println("Fin de la descarga");
				//Cerramos recursos
				buff.close();
				lector.close();
				escritor.close();
				entrada.close();
			}
			conexion.disconnect();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		/*Ejercicio 2
		Pide por pantalla al usuario una dirección web completa. El programa Java debe
		de descargar dicha web con el protocolo HTTP de Java dejando el resultado en
		un fichero.html la respuesta ubicada en la raíz del proyecto de eclipse. Este
		fichero será utilizado posteriormente para pruebas con FTP.*/
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduce la url de una web a continuación: ");
		String urlUser = sc.nextLine();
		String fileName = "fichero.html";

		saveHtmlFromUrl(urlUser, fileName);
		
		sc.close();
	}

}
