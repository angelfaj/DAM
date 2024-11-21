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
		this(c.getTitular(),c.getCantidad());
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
	
	@Override
	public boolean equals(Object o) {		//Object hace referencia a cualquier objeto, es como un comodin
		if (this == o) {					//Comprobamos si son el mismo objeto
			return true;
		}
		if (getClass() == o.getClass()) {	
			Cuenta otra = (Cuenta) o;		//Si son de la misma clase debemos castearlo para acceder a los metodos 
			if (otra.getTitular().equals(this.getTitular())) {
				return true;				
			}
		}
		return false;
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

	@Override
	public String toString() {
		return "Cuenta [titular=" + titular + ", cantidad=" + cantidad + "]";
	}
	
	
	
}
