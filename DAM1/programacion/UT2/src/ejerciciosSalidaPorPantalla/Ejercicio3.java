package ejerciciosSalidaPorPantalla;

public class Ejercicio3 {

	public static void main(String[] args) {
		/*Crea una parte del menú de un restaurante donde el título se
		escriba en mayúsculas por el formateo con %S, los nombres de los
		platos en minúsculas %s y los precios con dos decimales (el ancho
		del número será de 5). Debes poner en una columna el nombre de
		los platos y en otra columna los precios.*/
		
		System.out.printf("%S","entrantes");
		
		System.out.printf("%s","\ncalamares\t");
		double $precioCal = 3.25;
		System.out.printf("%6.2f", $precioCal);

		System.out.printf("%s","\nbravas\t\t");
		double $precioBrav = 5.50;
		System.out.printf("%6.2f", $precioBrav);
		
		System.out.printf("%s","\nensalada mixta\t");
		double $precioMix = 3.76;
		System.out.printf("%6.2f", $precioMix);
		

		
	}

}
