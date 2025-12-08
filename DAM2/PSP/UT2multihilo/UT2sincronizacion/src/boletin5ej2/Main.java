package boletin5ej2;

public class Main {

	public static void main(String[] args) {
		/*EJERCICIO 2
		En un consultorio médico, se tienen 5 médicos. Los pacientes son atendidos conforme van
		llegando a la sala de espera. Muchos de los pacientes que no encuentran lugar tienen que
		esperar su turno para ser atendidos. Realiza un programa con semáforos donde puedan entrar
		los 5 primeros pacientes a la consulta de alguno de los médicos y después los otros 5 pacientes
		que lleguen después tienen que esperar a que se quede alguna consulta libre para entrar ellos.*/

		ConsultorioCompartido consultorio = new ConsultorioCompartido();
		
		Paciente[] pacientes = new Paciente[10];
		
		for (int i = 0; i < 20; i++) {
			Thread hilo = new Thread(new Paciente(("H" + i), consultorio));
			hilo.start();
		}
		
	}

}
