package ejercicio2;

import java.util.ArrayList;
/**
 * Clase principal que contiene el método main y lanza la simulación.
 */
public class Main {  
	    // Total de coches que intentarán entrar al parking
	    private static final int NUM_COCHES = 6;

	    public static void main(String[] args) {
	        
	        // 1. Inicializar el parking
	        Parking parking = new Parking();
	        
	        // Lista para guardar las referencias a los hilos
	        ArrayList<Thread> hilosCoches = new ArrayList<>();

	        System.out.println("INICIANDO SIMULACIÓN DE PARKING con 3 plazas y 6 coches.");
	        System.out.println("-------------------------------------------------------\n");

	        // 2. Crear y lanzar los 6 hilos 
	        int i = 1;
	       
	        while (i <= NUM_COCHES) {
	            Coche coche = new Coche(parking, "Coche-" + i);
	            Thread hilo = new Thread(coche);
	            hilo.start();
	            hilosCoches.add(hilo);
	            i = i + 1;
	        }

	        // 3. Esperar a que todos los hilos finalicen
	        i = 0;
	        while (i < hilosCoches.size()) {
	            try {
	                // El Main espera activamente a que cada Coche finalice su ciclo completo (entrar, aparcar, salir)
	                hilosCoches.get(i).join();
	            } catch (InterruptedException e) {
	                Thread.currentThread().interrupt();
	                System.out.println("El hilo principal fue interrumpido.");
	            }
	            i = i + 1;
	        }

	        // 4. Mostrar estadísticas (Cierre del parking)
	        System.out.println("\n-------------------------------------------------------");	        
	        parking.mostrarEstadisticas();
	    }
	}