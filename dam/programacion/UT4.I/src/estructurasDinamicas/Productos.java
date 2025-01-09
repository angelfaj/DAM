package estructurasDinamicas;

import java.util.ArrayList;

public class Productos {
	//Atributos
	private String nombre;
	private int cantidad;
	private double precio;
	private ArrayList<Productos> listaProductos = new ArrayList<Productos>();
	
	//Constructores
	public Productos(String nombre, int cantidad, double precio) {
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.precio = precio;
		listaProductos.add(this);
	}

	//Metodos
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	private double getSum() {
		double total = this.getPrecio() * this.getCantidad();
		return total;
	}
	
	public String showTicket() {
		String ticket = "Producto" + "\t" + "Precio" + "\t" + "\t" + "Total";
		double total = 0;
		for (Productos p: listaProductos) {
			ticket += "\n" + p.getNombre() + "\t" + p.getCantidad() + "\t" + p.getPrecio() + "\t" + p.getSum();
			total += p.getSum();
		}
		ticket += "\n" + "Precio final" + "\t" + "\t" + "\t" + "\t" + total;
		return ticket;
	}
	
}
