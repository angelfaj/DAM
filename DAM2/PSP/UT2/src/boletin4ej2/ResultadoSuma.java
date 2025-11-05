package boletin4ej2;

public class ResultadoSuma {
	private static int resultado;
	
	public synchronized int sumArray(int[] arraySuma2, HiloSumador hilo) {
		resultado = 0;
		
		for (int i = 0; i < arraySuma2.length; i++) {
			resultado += arraySuma2[i];
			System.out.println("Total acumulado de " + hilo.getNombre() + ":" + resultado);
		}
		
		return resultado;
	}
		
}
