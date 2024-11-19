package ejerciciosInicialesv2;

public class Cuenta {
	//Atributos
	private String titular;
	private double cantidad;
	
	//Constructores
	public Cuenta(String tit) {
		titular = tit;
	}
	
	public Cuenta(String tit, double cant) {
		this(tit);
		cantidad = cant;
	}
	
	//Constructor copia
	public Cuenta(Cuenta c) {
		titular = c.getTitular();
		cantidad = c.getCantidad();
	}
	
	//Metodos
	public String getTitular() {
		return titular;
	}
	
	public double getCantidad() {
		return cantidad;
	}
	
	public static boolean equals(Cuenta c1, Cuenta c2) {
		boolean iguales = false;
		if (c1.equals(c2)) {
			iguales = true;
		}
		return iguales;
	}
	
	public void ingresar(double cant) {
		if (cant > 0) {
			cantidad += cant;
		}
	}
	
	public void retirar(double cant) {
		cantidad -= cant;
		if (cantidad < 0) {
			cantidad = 0;
		}
	}
	
}
