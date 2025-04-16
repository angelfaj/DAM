package aplicacion;

import java.io.IOException;
import java.util.ArrayList;

import controlador.ControladorPersona;
import modelo.PersonaModelo;
import vista.UI;

public class Main {

	public static void main(String[] args) {
		
		/*Test
		Persona p1 = new Persona("Raul", "12345");
		Persona p2 = new Persona("Riqui", "234");
		Persona p3 = new Persona("Rocio", "45");
		Persona p4 = new Persona("Ramon", "67");
		Persona p5 = new Persona("Rebeca", "89");
		Persona p6 = new Persona("Roro", "01");
		Persona p7 = new Persona("Ramon", "00");
		
		try {
			p1.addPersona();
			p2.addPersona();
			p3.addPersona();
			p4.addPersona();
			p5.addPersona();
			p6.addPersona();
			p7.addPersona();
			String [][] matriz = Persona.getPersonaMatriz();
			for (int i = 0; i < matriz.length; i ++) {
				for (int j = 0; j < matriz[i].length; j++) {
					System.out.print(matriz[i][j] + "\t");
				}
				System.out.println();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	*/
		
		/*MVC:
		1. Crea un objeto para la vista y el modelo
		2. Crea un objeto para el controlador pasando como parámetros los objetos anteriores
		3. Establece al controlador como responsable de responder a los eventos de la vista
		4. Arranca la vista*/
	
	UI vista = new UI();
	PersonaModelo modelo = new PersonaModelo();
	new ControladorPersona(vista, modelo);
	
	}
}
