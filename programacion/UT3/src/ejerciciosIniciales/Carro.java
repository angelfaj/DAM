package ejerciciosIniciales;

public class Carro {
	//Atributos
	public String nombre;
	public double precioBase, precioTotal;
	public int iva;
	public static double totalCarro;
	
	//Constructores
	
	
	//Metodos
	public void addProduct(String nom, double preci, int iv) {
		nombre = nom;
		precioBase = preci;
		iva = iv / 100;
		precioTotal = precioBase * iva;
		totalCarro += precioTotal;
	}
	
	public void removeProduct(String nom, double preci) {
		
	}
}