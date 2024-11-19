package ejerciciosIniciales;

public class Carro {
	//Atributos
	public String nombre;
	public double precioBase, precioTotal, iva;
	public boolean productStay;
	public static double totalCarro;
	
	//Constructores
	
	
	//Metodos
	public void addProduct(String nom, double preci, double iv) {
		nombre = nom;
		precioBase = preci;
		iva = iv / 100.0;
		precioTotal = ((precioBase * iva) + precioBase);
		totalCarro += precioTotal;
		productStay = true;
	}
	
	public String getProductName() {
		return nombre;
	}
	
	public double getPrecioBase() {
		return precioBase;
	}

	public double getPrecioTotal() {
		return precioTotal;
	}
	
	public void removeProduct() {
		totalCarro -= precioTotal;
		productStay = false;
	}
	
	public boolean productStatus() {
		return productStay;
	}
	
	public double getTotal() {
		return totalCarro;
	}
	
	public static String getLista(Carro... c) {			
		String lista = "TICKET DE COMPRA" + "\n" + "Artículo" + "\t" + "P.Base" + "\t" + "P.IVA" + "\n" + "*****************************" + "\n";
		for (int i = 0; i < c.length; i++) {
			if (c[i].productStatus()) {
				lista += c[i].getProductName() + "\t" + "\t" + c[i].getPrecioBase() + "\t" + c[i].getPrecioTotal() + "\n"; 
			}
		}
		lista += "TOTAL" + "\t" + "\t" + "\t" + totalCarro + " €";
		return lista;
	}
	
	
}