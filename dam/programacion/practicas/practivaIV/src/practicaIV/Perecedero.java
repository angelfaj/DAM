package practicaIV;

public class Perecedero extends Producto{
	//Atributos
	private int diasParaVencer;
	
	//Constructores
	public Perecedero(int codigo, String nombre, double precio, int cantidad, int diasParaVencer) {
		super(codigo, nombre, precio, cantidad);
		this.diasParaVencer = diasParaVencer;
	}

	//Metodos
	public int getDiasParaVencer() {
		return diasParaVencer;
	}

	public void setDiasParaVencer(int diasParaVencer) {
		this.diasParaVencer = diasParaVencer;
	}

	//Metodos heredados
	@Override				
	public double calcularDescuento() {
		if (diasParaVencer < 5) {
			return this.getPrecio() * 0.7;	//Aplicamos el 30% de descuento
		}else {
			return this.getPrecio();
		}
	}

	@Override
	public void mostrarInfo() {
		System.out.println("Producto perecedero " + super.toString() + ", diasParaVencer=" + diasParaVencer + "]");		
	}
	
	
	
}
