package ejercicio3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.UnmarshalException;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.bind.Unmarshaller;

public class Main {

	public static void main(String[] args) {
		/*Ejercicios JAXB
		Ejercicio 3
		Genera un fichero guardado en la carpeta res de tu proyecto de eclipse maven
		con nombre empleados.xml que contenga la información como se muestra en
		el ejemplo siguiente:
		Salida desde el fichero XML:
		Aclaraciones sobre anotaciones:
		• @XmlRootElement(name = "nombreEtiqueta"). Define que el elemento
		raíz del objeto Java se llamará de esa manera (no tiene por qué coincidir
		con el de la clase.
		• @XmlType(propOrder = { "a", "b", "c", "d" }). Define el orden de los
		elementos dentro de otro elemento.
		• @XmlElement(name = "otroNombre"). Sirve para cambiar el nombre de
		un elemento en el documento XML. Por defecto el elemento aparece con
		el nombre del atributo de la clase Java pero podemos cambiarlo con
		esta etiqueta. Se puede utilizar en los atributos tipo lista para indicar
		cómo se llamará cada elemento de la lista.
		• @XmlElementWrapper(name = "miLista"). Para crear un wrapper
		llamado miLista que englobe la estructura XML de los objetos que tenga
		la lista
		*/

		//Creo los objetos que necesito para crear el XML en objetos
		File f = new File("salidaE3.xml");
		JAXBContext contexto = null;
		Marshaller m = null;
		try {
			contexto = JAXBContext.newInstance(Empresa.class);
			m = contexto.createMarshaller();
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
		Empresa empresa = new Empresa();
//		
//		//ESCRITURA
//		//Creo los arrays
//		Empleados empleadosObject = new Empleados();
//		ArrayList<Empleado> empleadosList = new ArrayList<Empleado>();
//		Empleado empleado = new Empleado();
//		Cargo c = new Cargo();
//		
//		c.setCargo("Administrativo");
//		c.setNivel(2);
//		empleado.setDni("12345678C");
//		empleado.setEdad(32);
//		empleado.setNombre("Manuel");
//		empleado.setCargo(c);
//		empleadosList.add(empleado);
//		
//		empleado = new Empleado();
//		c = new Cargo();
//		c.setCargo("Desarrollador");
//		empleado.setDni("12345678K");
//		empleado.setEdad(54);
//		empleado.setNombre("Natalia");
//		empleado.setCargo(c);
//		empleadosList.add(empleado);
//		
//		empleadosObject.setEmpleadosList(empleadosList);
//		
//		empresa.setCif("A12345689");
//		empresa.setEmpleadosList(empleadosObject);
//		empresa.setNombre("Desatrancos Manolo S.A");
//		
//		//Formateamos el documento
//		try {
//			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
//		} catch (PropertyException e) {
//			e.printStackTrace();
//		}
//		
//		//Imprimimos lo que estamos guardando
//		System.out.println("Contenido del fichero:");
//		try {
//			m.marshal(empresa, System.out);
//		} catch (JAXBException e) {
//			e.printStackTrace();
//		}
//		
//		//Escribimos la info en unfichero XML fisico
//		FileWriter fw;
//		try {
//			fw = new FileWriter(f);
//			m.marshal(empresa, fw);
//		} catch (IOException e) {
//			e.printStackTrace();
//		} catch (JAXBException e) {
//			e.printStackTrace();
//		}
		
		//LECTURA
		//Leemos el ffihcero e imprimimos la informacion solicitada
		Unmarshaller un = null;
		
		try {
			un = contexto.createUnmarshaller();
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
		try {
			empresa = (Empresa) un.unmarshal(f);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		//Cargamos 
		ArrayList<Empleado> empleados = empresa.getEmpleados().getEmpleadosList();
		
		System.out.println("Salida desde el fichero XLM:");
		System.out.println("Empresa:" + empresa.getNombre() + " CIF:" + empresa.getCif());
		int i = 0;
		for(Empleado e:empleados) {
			i++;
			System.out.println("Empleado " + i + ": " + e.getNombre() + " con DNI " + e.getDni() + " y " + e.getEdad() + " años");
		}
		
	}
	//IMPORTANTE CON ESTA ANOTACION:@XmlElementWrapper(name = "otroNombre") NOS AHORRARIAMOS LA CLASE EMPRESA 
}
