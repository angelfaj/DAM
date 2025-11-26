package boletin1ej3y6runnable;

import java.util.Map;

public class EstacionesHilo implements Runnable{
	private static final String[][] estacionesMatriz = {
			{"primavera", "Marzo", "Abril", "Mayo"},
			{"verano", "Junio", "Julio", "Agosto"},
			{"otoño", "Septiembre", "Octubre", "Noviembre"},
			{"invierno", "Diciembre", "Enero", "Febrero"}
	};
	private static final Map<String, Integer> estacionesMap = Map.of(
			"primavera", 0,
			"verano", 1,
			"otoño", 2,
			"invierno", 3			
			);
	private String estacion;
	
	public EstacionesHilo(String estacion) {
		this.estacion = estacion;
	}

	@Override
	public void run() {
		int fila = estacionesMap.get(estacion);
		for (int i = 1 ; i < estacionesMatriz[fila].length; i++) {
			try {
				Thread.sleep(1000 + i * 1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(estacionesMatriz[fila][i]);
		}
	}
	
	
	
}
