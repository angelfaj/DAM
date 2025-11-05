package boletin4ej1;

public class MiHilo implements Runnable{
	private static int resultado;
	private int n1, n2;
	private String op;
	private String nombre;
	
	public MiHilo(String nombre, int n1, int n2, String op) {
		this.nombre = nombre;
		this.n1 = n1;
		this.n2 = n2;
		this.op = op;
	}
	
	@Override
	public void run() {
		realizarOperacion(n1, n2, op);
	}

	private synchronized void realizarOperacion(int num1, int num2, String opcion) {
		if (opcion.equalsIgnoreCase("suma")) {
			resultado = num1 + num2;
		}else if(opcion.equalsIgnoreCase("resta")) {
			resultado = num1 - num2;
		}
		System.out.println("Resultado de la operacion del hilo " + nombre + " :" + resultado);
	}

}
