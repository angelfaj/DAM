package boletin4ej2;

public class HiloSumador implements Runnable{
	private int[] arraySuma;
	private String nombre;
	private static int resultado;
	
	public HiloSumador(String nombre, int[] arraySuma) {
		this.nombre = nombre;
		this.arraySuma = arraySuma;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public void run() {
		int result = sumArray(arraySuma, this);
		System.out.println("Suma para " + this.getNombre() + ": " + result);
	}

	public synchronized int sumArray(int[] arraySuma2, HiloSumador hilo) {
		resultado = 0;
		
		for (int i = 0; i < arraySuma2.length; i++) {
			resultado += arraySuma2[i];
			System.out.println("Total acumulado de " + hilo.getNombre() + ":" + resultado);
		}
		
		return resultado;
	}


}
