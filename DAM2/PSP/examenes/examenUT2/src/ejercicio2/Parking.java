package ejercicio2;


public class Parking {
	private final int plazasTotales = 3;
	private int plazasDisponibles = plazasTotales;
	private double precioDia = 5;
	private int cochesTotales = 0;
	
	public synchronized void entrar(Coche c) {
		if(plazasDisponibles == 0) {	//Informamos de que el parking esta lleno e informamos de que dejamos el coche en espera hasta que haya nuevas plazas
			System.out.println("-> Coche " + c.getNombre() + ": Parking lleno. Esperando. Plazas ocupadas: " + plazasTotales);
			while (plazasDisponibles == 0) {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		//Coche entra, sumamos al contador total de coches, restamos una plaza y mostramos info 
		cochesTotales++;
		plazasDisponibles--;
		mostrarInfo(c, "HA ENTRADO");
	}
	
	public void aparcar(Coche c) {
		//Coche se queda durante un tiempo aleatorio
		int tiempoEspera = ((int) ((Math.random() * (10 - 1)) + 1)) * 100;
		try {
			Thread.sleep(tiempoEspera);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//Mostramos info 
		System.out.println("\t--> Coche "+ c.getNombre() + ": aparcado por " + tiempoEspera + " milisegundos...");
	}

	public synchronized void salir(Coche c) {
		//Coche sale, dejamos una plaza libre, mostramos info y notificamos
		plazasDisponibles++;
		mostrarInfo(c, "HA SALIDO");
		notifyAll();
	}

	private void mostrarInfo(Coche c, String accion) { //Metodo auxiliar para mostrar info
		System.out.println("<- Coche " + c.getNombre() + ": " + accion + ". Plazas restantes: " + plazasDisponibles);
	}
	
	public void mostrarEstadisticas() {
		System.out.println("=====================================================================");
		System.out.println("                       FIN DEL DÍA Y CIERRE DEL PARKING               ");
		System.out.println("=====================================================================");
		System.out.println("Total plazas en el parking: " + plazasTotales);
		System.out.println("Coches que han usado el parking: " + cochesTotales);
		System.out.println("Ganancia total obtenida: " + (cochesTotales*precioDia) + "€");
		System.out.println("=====================================================================");
	}

}
