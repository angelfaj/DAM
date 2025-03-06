package practicaIV;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		ArrayList<Producto> inventario = new ArrayList<Producto>(); //Lista de productos
		
		//Creamos productos de cada tipo para comprobar el correcto funcionamiento
		Electronico portatilAsus = new Electronico(1, "Asus 4000", 345.67, 70, 4);
		Electronico portatilAcer = new Electronico(2, "ACER 4000", 445.67, 40, 14);
		Electronico portatilMSI = new Electronico(3, "MSI 4000", 1345.67, 20, 24);
		
		Perecedero salmon = new Perecedero(100, "Salmon noruego", 5.65, 500, 7);
		Perecedero mayonesa = new Perecedero(101, "Mayonesa de la abuela", 1.65, 200, 3);
		Perecedero patatas = new Perecedero(102, "Patatas para freir", 3.65, 700, 30);
		
		inventario.add(mayonesa);
		inventario.add(patatas);
		inventario.add(salmon);
		inventario.add(portatilAcer);
		inventario.add(portatilAsus);
		inventario.add(portatilMSI);
		
		
		System.out.println("********************Inventario original********************");
		for (Producto p:inventario) {
			p.mostrarInfo();
			System.out.println("Precio tras descuento: " + p.calcularDescuento() + "\n");
		}
		
		System.out.println("--------VENTAS--------");
		salmon.vender(501);
		mayonesa.vender(198);
		patatas.vender(740);
		
		portatilAcer.vender(36);
		portatilAsus.vender(60);
		portatilMSI.vender(36);
		
		System.out.println("\n" + "********************Inventario tras vender********************");
		for (Producto p:inventario) {
			p.mostrarInfo();
			System.out.println("Precio tras descuento: " + p.calcularDescuento() + "\n");
		}

		System.out.println("--------REABASTECIMIENTO--------");
		salmon.reabastecer(501);
		mayonesa.reabastecer(198);
		patatas.reabastecer(740);
		
		portatilAcer.reabastecer(36);
		portatilAsus.reabastecer(60);
		portatilMSI.reabastecer(36);
		
		System.out.println("\n" + "********************Inventario tras reabastecer********************");
		for (Producto p:inventario) {
			p.mostrarInfo();
			System.out.println("Precio tras descuento: " + p.calcularDescuento() + "\n");
		}
		
	}

}
