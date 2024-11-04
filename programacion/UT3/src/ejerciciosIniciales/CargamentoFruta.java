package ejerciciosIniciales;

public class CargamentoFruta {
	//Atributos
	public String nombre, procedencia;
	public double kilos, precioCosteKilo, precioVentaKilo;
	public static double beneficio;
	
	//Constructores
	public CargamentoFruta(String nom, String proc, double kil, double precioKil, double precioVKil) {
		nombre = nom;
		procedencia = proc;
		kilos = kil;
		precioCosteKilo = precioKil;
		precioVentaKilo = precioVKil;
	}
	
	//Metodos
	public String getAllValues() {
		String allValues = "\nNombre: " + nombre + "\nProcedencia: " + procedencia + "\nKilos: " + kilos + "\nPrecio coste kilo: " + precioCosteKilo + "\nPrecio venta kilo: " + precioVentaKilo;
		return allValues;
	}
	
	public String getProcedencia() {
		return procedencia;
	}
	
	public boolean bajarPrecio(double rebaja) {
		boolean centinela = true;
		precioVentaKilo -= rebaja;
		if (precioVentaKilo < precioCosteKilo) {
			centinela = false;
		}
		return centinela;
	}
	
	public boolean comprobacionExistencias(double kil) {
		boolean centinela = false;
		if (kil < kilos) {
			kilos -= kil;
			centinela = true;
		}
		return centinela;
	}
	
	public String vender(double kil) {
		String resul;
		double precioVenta;
		if (comprobacionExistencias(kil)) {
			precioVenta = kilos * precioVentaKilo;
			resul = "Precio venta" + precioVenta;
			beneficio += precioVenta;
		} else {
			resul = "[ERROR]-No hay existencias suficientes para la venta";
		}
		return resul;
	}
	
	public String compararaProcedencia(CargamentoFruta cargo1, CargamentoFruta cargo2) {
		String resul;
		if (cargo1.getProcedencia().equals(cargo2.getProcedencia())) {
			resul = "COINCIDE la procedencia";
		} else {
			resul = "NO COINCIDE la procedencia";
		}
		return resul;
	}
}
