package polvorones;

public class Polvoron {
	//Atributos
	private String sabor;
	private double precio;
	
	//Cosntructores
	public Polvoron(String sabor, double precio) {
		this.sabor = sabor;
		this.precio = precio;
	}
	
	//Metodos
	public String getSabor() {
		return sabor;
	}

	public void setSabor(String sabor) {
		this.sabor = sabor;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	
	
}
