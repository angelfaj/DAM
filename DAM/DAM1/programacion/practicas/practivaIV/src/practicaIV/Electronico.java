package practicaIV;

public class Electronico extends Producto{
	//Atributos
	private int garantiaMeses;

	//Constructores
	public Electronico(int codigo, String nombre, double precio, int cantidad, int garantiaMeses) {
		super(codigo, nombre, precio, cantidad);
		this.garantiaMeses = garantiaMeses;
	}

	//Metodos
	public int getGarantiaMeses() {
		return garantiaMeses;
	}

	public void setGarantiaMeses(int garantiaMeses) {
		this.garantiaMeses = garantiaMeses;
	}

	//Metodos heredados
	@Override
	public double calcularDescuento() {
		if (garantiaMeses > 12) {
			return this.getPrecio() * 0.9;	//Aplicamos el 10% de descuento
		}else {
			return this.getPrecio();
		}
	}

	@Override
	public void mostrarInfo() {
		System.out.println("Producto electronico " + super.toString() + ", garantiaMeses=" + garantiaMeses + "]");		
	}

	
		
}
