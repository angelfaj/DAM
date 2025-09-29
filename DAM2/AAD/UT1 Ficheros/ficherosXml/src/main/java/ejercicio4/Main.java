package ejercicio4;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.bind.Unmarshaller;

import com.sun.xml.bind.v2.runtime.JAXBContextImpl.JAXBContextBuilder;

public class Main {

	public static void main(String[] args) {
		/*Ejercicio 4
		Genera un fichero guardado en la carpeta res de tu proyecto de eclipse maven
		con nombre album.xml que contenga la información como se muestra en el
		ejemplo siguiente:
		<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
		<album anio="2010">
		<artista>Queen</artista>
		<canciones>
		<cancion>
		<titulo>Bohemian Rhapsody</titulo>
		<duracion extra="no">354</duracion>
		</cancion>
		<cancion>
		<titulo>Don't Stop Me Now</titulo>
		<duracion extra="si">354</duracion>
		</cancion>
		<cancion>
		<titulo>We Will Rock You</titulo>
		<duracion extra="no">354</duracion>
		</cancion>
		</canciones>
		<nombre>Lo mejor de Queen</nombre>
		</album>
		Por pantalla indicará al finalizar: Archivo XML generado: album.xml
		Salida desde el fichero XML:
		Álbum leído desde XML:
		Artista:Queen año álbum:2010 nombre:Lo mejor de Queen
		Cancion [titulo=Bohemian Rhapsody, duracion=354 (extra: no)]
		Cancion [titulo=Don't Stop Me Now, duracion=354 (extra: si)]
		Cancion [titulo=We Will Rock You, duracion=354 (extra: no)]
		*/
		
		File f = new File("salidaE4.xml");
		JAXBContext context = null; 
		Marshaller mar = null;
		Album album = new Album();
		
//		fillAlbum(album);
//		//ESCRITURA
//		try {
//			context = JAXBContext.newInstance(Album.class);
//			mar = context.createMarshaller();
//			//Formateamos el documento e imprimimos
//			mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
//			mar.marshal(album, System.out);
//			//Escribimos en el documento
//			writeXml(f, mar, album);
//		} catch (JAXBException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		//LECTURA
		Unmarshaller un = null;
		
		try {
			context = JAXBContext.newInstance(Album.class);
			un = context.createUnmarshaller();
			album = (Album) un.unmarshal(f);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		ArrayList<Cancion> canciones = album.getCanciones().getCanciones();
		
		System.out.println("Archivo XML generado: " + f.getName());
		System.out.println("Salida desde el fichero XML:");
		System.out.println("Album leiudo desde XML:");
		System.out.println("Artista: " + album.getArtista() + " año de lanzamiento " + album.getAnio() + " nombre: " + album.getNombre());
		for (Cancion c:canciones) {
			System.out.println(c);
		}
		
		
	}

	private static void writeXml(File f, Marshaller mar, Album album) throws JAXBException, IOException {
		try(FileWriter fw = new FileWriter(f)) {
			mar.marshal(album, fw);
		}
	}

	private static void fillAlbum(Album album) {
		Canciones canciones = new Canciones();
		ArrayList<Cancion> cancionesList = new ArrayList<Cancion>();
		Cancion cancion = new Cancion();
		Duracion duracion = new Duracion();
		
		duracion.setDuracion(540);
		duracion.setExtra("si");
		cancion.setDuracion(duracion);
		cancion.setTitulo("Mi tractor amarillo");
		cancionesList.add(cancion);
		cancion = new Cancion();
		cancion.setDuracion(duracion);
		cancion.setTitulo("Mi tractor verde");
		cancionesList.add(cancion); 
		
		canciones.setCanciones(cancionesList);
		album.setCanciones(canciones);
		album.setArtista("Zapato Veloz");
		album.setNombre("Remember");
		album.setAnio(1992);
	}

}
