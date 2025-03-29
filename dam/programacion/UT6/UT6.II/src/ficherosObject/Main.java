package ficherosObject;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.tools.FileObject;

public class Main {

	public static void writePersona(File f, Persona p) throws FileNotFoundException, IOException {
		
		FileOutputStream fo = null;
		//conectamos el flujo de bytes al flujo de datos¿?
		ObjectOutputStream datos = null;
		
		if (!f.exists()) {
			fo = new FileOutputStream(f);
			datos = new ObjectOutputStream(fo);
		}
		else {
			fo = new FileOutputStream(f, true);	//True indica que añada al final del archivo sin el lo sobreescribiriamos
			datos = new MiObjectOutputStream(fo);
		}
		
		datos.writeObject(p);		//Este metodo crea el fichero automaticamente :)
		datos.close();
	}
	
	public static void readPersona(File f) throws FileNotFoundException, IOException, ClassNotFoundException {
		Persona persona;
		
		FileInputStream fi = new FileInputStream(f);
		//conectamos el flujo de bytes al flujo de datos¿?
		ObjectInputStream datos = new ObjectInputStream (fi);
		
		try {
			while(true) {
				persona = (Persona) datos.readObject();
				System.out.println(persona);
			}
		}catch (EOFException e) {}
		datos.close();
	}
	
	public static void writeAlumno(File f, Alumno a) throws FileNotFoundException, IOException {
		
		FileOutputStream fo = null;
		//conectamos el flujo de bytes al flujo de datos¿?
		ObjectOutputStream datos = null;
		
		if (!f.exists()) {
			fo = new FileOutputStream(f);
			datos = new ObjectOutputStream(fo);
		}
		else {
			fo = new FileOutputStream(f, true);	//True indica que añada al final del archivo sin el lo sobreescribiriamos
			datos = new MiObjectOutputStream(fo);
		}
		
		datos.writeObject(a);		//Este metodo crea el fichero automaticamente :)
		datos.close();
	}
	
	public static void readAlumno(File f) throws FileNotFoundException, IOException, ClassNotFoundException {
		Alumno a;
		
		FileInputStream fi = new FileInputStream(f);
		//conectamos el flujo de bytes al flujo de datos¿?
		ObjectInputStream datos = new ObjectInputStream (fi);
		
		try {
			while(true) {
				a = (Alumno) datos.readObject();
				System.out.println(a);
			}
		}catch (EOFException e) {}
		datos.close();
	}
	
	
	public static void main(String[] args) {
		/*Ejercicio 1
		Escribe un programa que escribe 3 objetos de tipo Persona en el fichero
		personas.dat. Cada persona tiene asociada la siguiente información: nif,
		nombre y edad. Las personas a escribir serán:
		● p = new Persona("12345678A","Lucas González", 30);
		● p = new Persona("98765432B","Anacleto Jiménez", 28);
		● p = new Persona("78234212Z","María Zapata", 35);
		A continuación, imprime el contenido del fichero por pantalla.*/
		/*
		File f = new File("personas.dat");
		Persona p;

		try {
			p = new Persona("12345678A","Lucas González", 30);
			writePersona(f, p);
			p = new Persona("98765432B","Anacleto Jiménez", 28);
			writePersona(f, p);
			p = new Persona("78234212Z","María Zapata", 35);
			writePersona(f, p);
			readPersona(f);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		*/
		
		/*Ejercicio 2 - SERIALIZACIÓN Y HERENCIA
		** Para serializar objetos de una jerarquía solamente la clase padre tiene que
		implementar el interface Serializable. No es necesario que las subclases
		implementen la interfaz.
		Escribe un programa Java que escribe en un fichero tres objetos de tipo
		Empleado. Empleado es una clase derivada de la clase Persona del ejercicio
		anterior que tiene a mayores un atributo sueldo. Como la clase Persona es
		serializable, no es necesario indicar que la clase Empleado también lo es.
		Empleado es serializable por el hecho de heredar de Persona. Los empleados a
		escribir son:
		● emp = new Empleado("12345678A","Lucas González", 30, 1200.40);
		● emp = new Empleado("98765432B","Anacleto Jiménez", 28, 1000);
		● emp = new Empleado("78234212Z","María Zapata", 35, 1100.25);
		A continuación, imprime el contenido del fichero por pantalla.*/
		
		
		
		
		/*Ejercicio 3 - SERIALIZACIÓN Y CLASES COMPUESTAS
		** Cuando una clase contiene un atributo que es una referencia a otro objeto,
		la clase a la que pertenece dicho atributo también debe ser serializable.
		Escribe un programa que escribe en un fichero tres objetos de tipo Alumno.
		Alumno es una clase derivada de Persona y contiene un atributo Fecha que es a
		su vez una clase formada por tres atributos: día, mes y año.
		A continuación, imprime el contenido del fichero por pantalla.
		*/
		/*
		File f = new File("alumno.dat"); //Cada ficher contendra un tipo de objeto diferente no pudiendo mezclarlos en el mismo binario
		Alumno a;

		try {
			a = new Alumno("12345678A","Lucas González", 30, new Fecha(1, 1, 1990));
			writeAlumno(f, a);
			a = new Alumno("98765432B","Anacleto Jiménez", 28, new Fecha(5, 4, 1950));
			writeAlumno(f, a);
			a = new Alumno("78234212Z","María Zapata", 35, new Fecha(17, 11, 1980));
			writeAlumno(f, a);
			readAlumno(f);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		*/
		
		/*Ejercicio 4
		Dados los datos de los siguientes arrays con datos de vehículos de un taller:
		● String matricula[] = {"1234-ABC", "2345-FGT", "7412-RET", "5285-NBN",
		"7896-JNB", "9632-POI", "1289-GTR"};
		● long km[]={100000,200000,150000,1200,3000,40000,180000};
		● int caballos[]={95,110,150,125,110,150,180};
		Escribe una aplicación java con las siguientes funcionalidades:
		1. Crear un fichero de objetos con los datos de los vehículos anteriores:
		● Debes crear la clase vehículo con los siguientes atributos: id, matricula,
		km, caballos.
		● A cada vehículo que se escriba en el fichero se le asignará un
		identificador numérico, comenzando en 1.
		2. Crea un método que realice un recorrido secuencial del fichero y muestre su
		contenido en pantalla.
		3. Crea un método para añadir los datos de los siguientes vehículos:
		matricula="2374-TRE";
		km=130000;
		caballos=110;
		matricula ="8521-PER";
		km=2500;
		caballos=1200;
		4. Recorre de nuevo el fichero y comprueba que se han grabado los registros
		nuevos.
		5. Escribe un método que dado un código de vehículo consulte y muestre el
		resto de sus datos obtenidos del fichero.*/
		
		File f = new File("vehiculos.dat");
		
		try {
			Vehiculo.addVehiculos(f);
			System.out.println("*************Fichero con vehiculos originales*************");
			Vehiculo.readVehiculos(f);
			Vehiculo.addExtraVehiculos(f);
			System.out.println();
			System.out.println("*************Fichero con vehiculos extra*************");
			Vehiculo.readVehiculos(f);
			System.out.println();
			System.out.println("*************Datos del vehiculo con id 1*************");
			Vehiculo.readVehiculos(f, 1);
			
		}catch (FileNotFoundException fn) {
			fn.getStackTrace();
		}catch (IOException io) {
			io.getStackTrace();
		}catch (ClassNotFoundException cn) {
			cn.getStackTrace();
		}
		
		/*Ejercicio 5
		Realiza un programa en JAVA en el que le pidas al usuario las notas de las 6
		asignaturas del Ciclo de DAM y las guarde en un fichero. Posteriormente leerá
		el fichero y te calculará la nota media del curso. Deberás tener en cuenta:
		● Cada una de las asignaturas serán un objeto que se encuentran
		almacenadas en un array de 6 posiciones y cuyos atributos serán el
		nombre y la nota. Tendrás un método rellenaArray que te cargará las 6
		asignaturas en el array llamando al método constructor de la clase
		Asignatura.
		● En el constructor podrás asignar directamente el nombre de la
		asignatura al crear el objeto. En cambio, el atributo nota, será el usuario
		quien lo introduzca mediante un método que controle que la nota tenga
		un valor entre 0 y 10. Si la nota no es válida debes pedirla de nuevo hasta
		que sea válida.Los pasos a seguir en el método principal son:
		1. Declarar el array de 6 posiciones que almacenará las asignaturas. Al llamar al
		constructor os pedirá la nota de dicha asignatura (ya comentado arriba).
		2. Llamada al método rellenaArray() para cargar las asignaturas junto con sus
		notas.
		3. Llamada al método escribirFichero(Asignatura[] curso) para escribir las
		asignaturas en el fichero.
		4. Llamada al método leerFichero() que muestre el contenido del fichero.
		5. Llamada al método calcularMedia() que mostrará la media obtenida por el
		alumno.*/

		
		
		
		
		
		
		
		//Fin main
	}

}
