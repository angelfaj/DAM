package boletin4ej2;

public class HiloSumador implements Runnable{
	private int[] arraySuma;
	private String nombre;
	private ResultadoSuma resultadoSuma;
	
	public HiloSumador(String nombre, int[] arraySuma, ResultadoSuma resultadoSuma) {
		this.nombre = nombre;
		this.arraySuma = arraySuma;
		this.resultadoSuma = resultadoSuma;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public void run() {
		int result = resultadoSuma.sumArray(arraySuma, this);
		System.out.println("Suma para " + this.getNombre() + ": " + result);
	}



}
