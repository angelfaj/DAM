package estructurasDinamicas;

import java.util.ArrayList;

public class Producto {
	//Atributos
	private String nombre;
	private int cantidad;
	private double precio;
	private static ArrayList<Producto> listaProductos = new ArrayList<Producto>();
	
	//Constructores
	public Producto(String nombre, int cantidad, double precio) {
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
	
	public static String showTicket() {
		String ticket = "Producto" + "\t" + "Cantidad" + "\t" + "Precio" + "\t" + "Total";
		double total = 0;
		for (Producto p: listaProductos) {
			ticket += "\n" + p.getNombre() + "\t\t" + p.getCantidad() + "\t" + p.getPrecio() + "\t\t" + p.getSum();
			total += p.getSum();
		}
		ticket += "\n" + "Precio final" + "\t" + "\t" + "\t\t" + total;
		return ticket;
	}
	
}
