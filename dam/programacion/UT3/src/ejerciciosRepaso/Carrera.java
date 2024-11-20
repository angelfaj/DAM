package ejerciciosRepaso;
import java.lang.Math;

public class Carrera {
	//Atributos
	private final int LONGITUD = 500;
	private Corredor c1, c2;
	
	//Constructores
	public Carrera(Corredor c1, Corredor c2) {
		this.c1 = c1;
		this.c2 = c2;
	}
	
	
	//Metodos
	public String mostrarDatosCorredores() {
		return "Corredor 1: " + c1.getNombre() + "- Velocidad: " + c1.getVelocidad() +  "km/h" + "\n" + "Corredor 2: " + c2.getNombre() + "- Velocidad: " + c2.getVelocidad() +  "km/h";
	}
	
	private Corredor calcularGanador() {
		double variacion1, variacion2, tiempo1 = 0, tiempo2 = 0, v1 = c1.getVelocidad(), v2 = c2.getVelocidad(); 
		boolean sumador; 
		
		do {
			for(int i = 0; i < 5; i++) {				//Divido la pista en 5 tramos de 100m
				sumador = true;
				variacion1 = Math.random()* c1.getVelocidad();
				variacion2 = Math.random()* c2.getVelocidad();
				
				if (sumador) {
					v1 += variacion1;
					v2 -= variacion2;
				} else {
					v1 -= variacion1;
					v2 += variacion2;
				}
				
				tiempo1 += (LONGITUD/5)/v1;
				tiempo2 += (LONGITUD/5)/v2;
				
				sumador = false;
			}
		} while (tiempo1 == tiempo2);
		
		if (tiempo1 < tiempo2) {
			return c1;
		} else {
			return c2;
		}
	}
	
	public String competir() {
		Corredor ganador = calcularGanador();
		ganador.mejorarVelocidad();
		
		return "El ganador es: " + ganador.getNombre();
	}
}
