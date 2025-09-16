package practicaIV;

public abstract class Producto implements Vendible, Almacenable{
	//Atributos
	private int codigo;
	private String nombre;
	private double precio;
	private int cantidad;
	
	//Constructores
	public Producto(int codigo, String nombre, double precio, int cantidad) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.precio = precio;
		this.cantidad = cantidad;
	}

	//Metodos
	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}


	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	//Metodos que heredaran las clases hijas y deberan sobreescribir
	public abstract double calcularDescuento();
	
	public abstract void mostrarInfo();
	
	@Override
	public String toString() {				
		return "[codigo=" + codigo + ", nombre=" + nombre + ", precio=" + precio + ", cantidad=" + cantidad;
	}
	
	//Metodos implementados de las interfaces
	@Override
	public void vender(int cantidad) {
		if (this.cantidad >= cantidad) {
			System.out.println("Producto a vender: " + this.getNombre() + ", stock: " + this.cantidad + ", cantidad a vender: " + cantidad);
			this.cantidad -= cantidad;			
		}else {
			System.out.println("No hay suficiente stock para vender el producto: " + this.getNombre());
		}
	}
	
	@Override
	public void reabastecer(int cantidad) {
		this.cantidad += cantidad;
		System.out.println("Producto: " + this.getNombre() + ", cantidad tras reabastecimiento: " + this.cantidad);
	}
	
	
	
}
