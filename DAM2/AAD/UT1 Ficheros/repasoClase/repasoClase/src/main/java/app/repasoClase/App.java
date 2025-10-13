package app.repasoClase;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class App {
    public static void main(String[] args) {
    	/*Genera un fichero guardado en la carpeta res de tu proyecto de eclipse maven con nombre concesionario.xml que contenga la información como se muestra en el ejemplo siguiente. Utiliza JAXB. 
		Además, la información que se guarde en concesionario.xml será mostrada por pantalla como se indica a continuación e indicará al finalizar la creación del fichero xml:
		*/
    	File salida = new File("concesionario.xml");
    	JAXBContext context = null; 
    	Marshaller mar = null;
    	
    	Concesionario concesionario = new Concesionario();
    	
    	//Escritura
    	fillListaVehiculos(concesionario);
    	try {
    		context = JAXBContext.newInstance(Concesionario.class);
    		mar = context.createMarshaller();
    		//Formateamos texto 
    		mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
    		//Imprimimos por consola
    		mar.marshal(concesionario, System.out);
    		//Escribimos en el documento
    		mar.marshal(concesionario, salida);
    	}catch (JAXBException e) {
    		e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    	//Lectura
    	Unmarshaller un = null;
    	
    	try {
    		context
    	}
    	
    }

	private static void fillListaVehiculos(Concesionario c) {
		ArrayList<Vehiculo> arrVehiculo = new ArrayList<Vehiculo>();
		Vehiculos listaVehiculos = new Vehiculos();
		Vehiculo v = new Vehiculo();
		v.setAnio(2022);
		v.setMarca("Toyota");
		v.setModelo("Corolla");
		v.setPrecio(25000.12);
		v.setVendedor("Pepito Perez");
		arrVehiculo.add(v);
		
		v = new Vehiculo();
		v.setAnio(2024);
		v.setMarca("BMX");
		v.setModelo("M4");
		v.setPrecio(250000.12);
		v.setVendedor("Mario Martinez");
		arrVehiculo.add(v);
		
		listaVehiculos.setVehiculos(arrVehiculo);
		c.setNombre("Autos Deluxe");
		c.setUbicacion("Calle salobreña 12, Orcasur Madrid");
		c.setVehiculos(listaVehiculos);
	}
}
