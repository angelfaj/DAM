package examenT5;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		ArrayList<Paciente> listaPacientes = new ArrayList<Paciente>(); //Lista de pacientes de tipo Paciente para que pueda albergar todos los objetos de sus clases hijas
		
		//Creamos varios pacientes de cada tipo
		PacienteAmbulatorio paciente1 = new PacienteAmbulatorio(1, "Manolo", 20, "Favorable", false, 4);
		PacienteAmbulatorio paciente2 = new PacienteAmbulatorio(2, "Laura", 30, "Favorable", false, 2);
		PacienteAmbulatorio paciente3 = new PacienteAmbulatorio(3, "Alba", 60, "Desfavorable", false, 30);
		PacienteAmbulatorio paciente4 = new PacienteAmbulatorio(4, "Ramon", 20, "Normal", false, 10);
		PacienteHospitalizado paciente5 = new PacienteHospitalizado(5, "Arantxa", 56, "Desfavorable", true, 30, 25.0, 150.10);
		PacienteHospitalizado paciente6 = new PacienteHospitalizado(6, "Diego", 6, "Bueno", true, 1, 25.0, 1000.10);
		PacienteHospitalizado paciente7 = new PacienteHospitalizado(7, "Andrea", 56, "Desfavorable", true, 300, 50.0, 1350.10);
		PacienteHospitalizado paciente8 = new PacienteHospitalizado(8, "Juan", 56, "Bueno", false, 0, 2.0, 1.10);
	
		//Añadimos los pacientes a la lista
		listaPacientes.add(paciente1);
		listaPacientes.add(paciente2);
		listaPacientes.add(paciente3);
		listaPacientes.add(paciente4);
		listaPacientes.add(paciente5);
		listaPacientes.add(paciente6);
		listaPacientes.add(paciente7);
		listaPacientes.add(paciente8);
	
		//Lista original
		System.out.println("----------------------------Lista original----------------------------");
		for (Paciente p: listaPacientes) {
			System.out.println(p);
		}
	
		//Modificamos un paciente de cada tipo
		paciente1.ingresar();
		paciente2.ingresar();
		paciente5.darAlta();
		paciente5.recibirTratamiento("Paracetamol de 1 gramo 3 veces al dia");
		paciente7.darAlta();
		paciente7.recibirTratamiento("Nolotil combinado con paracetamol, 2 veces al dia");
		
		//Lista modificada
		System.out.println("\n" + "----------------------------Lista tras modificar----------------------------");
		for (Paciente p: listaPacientes) {
			System.out.println(p);
		}
		
		//Facturas de los pacientes
		System.out.println("\n" + "----------------------------Facturas de cada paciente----------------------------");
		for (Paciente p: listaPacientes) {
			p.generarFactura();
			System.out.println();
		}
		
	}

}
