package boletin3ej1;

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
		/*EJERCICIO 1
		Crea un programa en Java utilizando la librería JAXB que permita generar un
		archivo XML de empleados. El archivo debe contener una lista de empleados,
		donde cada empleado tiene los siguientes datos:
		1. Nombre (Texto).
		2. Edad (Número, como atributo del empleado).
		3. Categoría (Texto, indicando el puesto del empleado: "Empleado" o
		"Gerente").
		4. La categoría puede tener un atributo opcional llamado plus, que
		representa un bono salarial en caso de que el empleado sea un "Gerente".
		El archivo XML debe ser similar al siguiente ejemplo:
		<?xml version="1.0" encoding="UTF-8"?>
		<listaempleados>
		<empleado edad="27">
		<nombre>Pepe Perez</nombre>
		<categoria>Empleado</categoria>
		</empleado>
		<empleado edad="34">
		<nombre>Juan Sanchez</nombre>
		<categoria plus="200">Gerente</categoria>
		</empleado>
		<empleado edad="45">
		<nombre>Juan Sanchez</nombre>
		<categoria plus="1000">Gerente</categoria>
		</empleado>
		</listaempleados>
		Ampliación: Añade un pequeño menú que permita agregar empleados
		manualmente y luego generar el archivo XML.
		*/
		
		File outFile = new File("salidaListaEmpleados.xml");
		JAXBContext context = null;
		Marshaller mar = null;
		
		ListaEmpleados listaEmpleados = new ListaEmpleados();
		
		//Escrituara del fichero
		fillListaEmpleados(listaEmpleados);
		
		try (FileWriter fw = new FileWriter(outFile)){
			context = JAXBContext.newInstance(ListaEmpleados.class);
			mar = context.createMarshaller();
			
			//Formatemos documento e imprimos por consola
			mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			mar.marshal(listaEmpleados, System.out);
			
			//Por ultimo escribimos el xml
			mar.marshal(listaEmpleados, fw);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JAXBException e) {
			e.printStackTrace();
		} 
		
		
		//Lectura
		Unmarshaller un = null;
		try {
			un = context.createUnmarshaller();
			listaEmpleados = (ListaEmpleados) un.unmarshal(outFile);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
		ArrayList<Empleado> empleados = listaEmpleados.getListaEmpleados();
		System.out.println("Contenido del Array lista de empleados:");
		for (Empleado e: empleados) {
			System.out.println(e);
		}
	}

	private static void fillListaEmpleados(ListaEmpleados listaEmpleados) {
		ArrayList<Empleado> lista = new ArrayList<Empleado>();
		Empleado e = new Empleado();
		Categoria c = new Categoria();
		
		c.setCategoria("Gerente");
		c.setPlus(200);
		e.setCategoria(c);
		e.setEdad(32);
		e.setNombre("Manuel");
		lista.add(e);
		
		c = new Categoria();
		e = new Empleado();
		c.setCategoria("Empleado");
		e.setCategoria(c);
		e.setEdad(52);
		e.setNombre("Mario");
		
		lista.add(e);
		
		listaEmpleados.setListaEmpleados(lista);
	}
}
