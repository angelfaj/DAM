package repasoEj2;

public class Main {

	public static void main(String[] args) {
		/*Ejercicio 2:Turnos de estudiantes
		• Tres hilos representan estudiantes que deben hablar en orden: A → B →
		C.
		• Usar un objeto monitor que controle el turno.
		• Cada estudiante espera hasta que sea su turno.
		Nota: para pasar al siguiente turno usa la fórmula:
		turno = (miTurno % 3) + 1;*/
		
//		System.out.println(2%3 + 1);
		
		MonitorEstudiante moni = new MonitorEstudiante();
		Thread A = new Thread(new HiloEstudiante("A", moni));
		Thread B = new Thread(new HiloEstudiante("B", moni));
		Thread C = new Thread(new HiloEstudiante("C", moni));

		A.start();
		B.start();
		C.start();
	}

}
