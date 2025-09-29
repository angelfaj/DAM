package ejercicio3;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;

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
		JAXBContext contexto;
		Marshaller m = null;
		try {
			contexto = JAXBContext.newInstance(Empresa.class);
			m = contexto.createMarshaller();
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
		Empresa empresa = new Empresa();
		
		//Creo los arrays
		Empleados empleados = new Empleados();
		ArrayList<Empleado> empleadosList = new ArrayList<Empleado>();
		Empleado empleado = new Empleado();
		Cargo c = new Cargo();
		
		c.setCargo("Administrativo");
		c.setNivel(2);
		empleado.setDni("12345678C");
		empleado.setEdad(32);
		empleado.setNombre("Manuel");
		empleado.setCargo(c);
		empleadosList.add(empleado);
		
		empleado = new Empleado();
		c = new Cargo();
		c.setCargo("Desarrollador");
		empleado.setDni("12345678K");
		empleado.setEdad(54);
		empleado.setNombre("Natalia");
		empleado.setCargo(c);
		empleadosList.add(empleado);
		
		empleados.setEmpleadosList(empleadosList);
		
		empresa.setCif("A12345689");
		empresa.setEmpleadosList(empleados);
		empresa.setNombre("Desatrancos Manolo S.A");
		
		//Formateamos el documento
		try {
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		} catch (PropertyException e) {
			e.printStackTrace();
		}
		
		//Imprimimos lo que estamos guardando
		terminar esta parte
		try {
			m.marshal(empresa, System.out);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
		//Escribimos la info en unfichero XML fisico
		FileWriter fw;
		try {
			fw = new FileWriter("salidaE3.xml");
			m.marshal(empresa, fw);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
	}

	
	//IMPORTANTE CON ESTA ANOTACION:@XmlElementWrapper(name = "otroNombre") NOS AHORRARIAMOS LA CLASE LISTA 
}
