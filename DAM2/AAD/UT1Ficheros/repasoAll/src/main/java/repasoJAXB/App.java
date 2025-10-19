package repasoJAXB;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.bind.Unmarshaller;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListaEmpleados listaempleados = new ListaEmpleados();
		File xmlFile = new File("empleados.xml");
		JAXBContext context = null;
		Marshaller mar = null;
		
		try {
			context = JAXBContext.newInstance(ListaEmpleados.class);
			mar = context.createMarshaller();
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
		if (!xmlFile.exists()) {
			try {
				xmlFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		fillListaEmpleados(listaempleados);
		//Escritura
		try {
			mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			mar.marshal(listaempleados, System.out);
			mar.marshal(listaempleados, xmlFile);
		} catch (PropertyException e) {
			e.printStackTrace();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Lectura
		Unmarshaller un = null;
		try {
			 un = context.createUnmarshaller();
			 listaempleados = (ListaEmpleados) un.unmarshal(xmlFile);
			 ArrayList<Empleado> list = listaempleados.getListaempleados();
			 printInfo(list);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
	}

	private static void printInfo(ArrayList<Empleado> list) {
		for (Empleado e:list) {
			System.out.println("-------------------------------");
			System.out.println("Nombre: " + e.getNombre());
			System.out.println("Edad: " + e.getEdad());
			Categoria c = e.getCategoria();
			System.out.println("Categoria: " + c.getCategoria());
			if (c.getPlus() != 0) {
				System.out.println("Plus: " + c.getPlus());
			}
		}
		
	}

	private static void fillListaEmpleados(ListaEmpleados lista) {
		ArrayList<Empleado> listaempleados = new ArrayList<Empleado>();
		Empleado e = new Empleado();
		e.setEdad(13);
		e.setNombre("Ramon");
		Categoria c = new Categoria();
		c.setCategoria("Gerente");
		c.setPlus(1000);
		e.setCategoria(c);
		listaempleados.add(e);

		e = new Empleado();
		e.setEdad(35);
		e.setNombre("Laura");
		c = new Categoria();
		c.setCategoria("CEO");
		c.setPlus(10000);
		e.setCategoria(c);
		listaempleados.add(e);
		
		e = new Empleado();
		e.setEdad(52);
		e.setNombre("Juna");
		c = new Categoria();
		c.setCategoria("Seguridad");
		e.setCategoria(c);
		listaempleados.add(e);
		
		lista.setListaempleados(listaempleados);
	}

}
