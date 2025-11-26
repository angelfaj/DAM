package repasoEj2;

public class MonitorEstudiante {
	private boolean hiloA = false;
	private boolean hiloB = false;
	private boolean hiloC = false;
	
	public synchronized void darTurno(String nombreHilo, int turnoHilo) {
		int turno = (turnoHilo % 3) + 1;
		
		if (turno == 2) { //Hilo A
			while (hiloB || hiloC) {
				try {
					wait();
				}catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("Hilo " + nombreHilo + " esta HABLANDO.");
			hiloA = true;
			notifyAll();
		}else if (turno == 3){	//Hilo B
			while (!hiloA || hiloC ) {
				try {
					wait();
				}catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("Hilo " + nombreHilo + " esta HABLANDO.");
			hiloB = true;
			notifyAll();
			
		}else if (turno == 1) {	//Hilo C
			while (!hiloA || !hiloB ) {
				try {
					wait();
				}catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("Hilo " + nombreHilo + " esta HABLANDO.");
			hiloC = true;
			notifyAll();
		}
	}

	//Solucion del profesor :/ 
//	public synchronized void hablar(String nombre, int miTurno) {
//        try {
//            // Mientras no sea mi turno, espero
//            while (turno != miTurno) {
//                wait();
//            }
//            // Cuando llega mi turno, hablo
//            System.out.println("Soy " + nombre + " y hablo en mi turno.");
//            // Paso el turno al siguiente
//            turno = (miTurno % 3) + 1;
//            // Aviso a los demás hilos
//            notifyAll();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
}
