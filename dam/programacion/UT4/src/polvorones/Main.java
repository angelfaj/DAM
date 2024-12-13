package polvorones;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		/*
	    Se creará una matriz de 2x3 (2 filas y 3 columnas) que va a simular una cesta con huecos para introducir los polvorones de Navidad. Inicialmente está vacía.
	    Cada polvorón tendrá el sabor y precio que cuesta.
	    Crea un programa principal que inserte, busque, actualice y borre los polvorones de la cesta. No puede haber polvorones con sabores repetidos, por tanto para saber si existe el polvorón o no será mediante esta característica. No se podrá tampoco eliminar/modificar los polvorones que no existan. Además tendrás que poder mostrar la cesta entera indicando lo que hay en cada posición y dibujando por pantalla la matriz simulando los "huecos" y los polvorones.
	    Para mayor flexibilidad en el programa, crea un menú con las distintas opciones para que el usuario interactue con la aplicación:

		1- Añadir
		
		2- Buscar
		
		3- Eliminar
		
		4- Modificar
		
		5- Mostrar cesta

			
		*/
		
		int opcion, bucleActivo = 0;
		Scanner entrada = new Scanner(System.in);
		
		Polvoron limon = new Polvoron("Limon", 2.2);
		Polvoron mantequilla = new Polvoron("Mantequilla", 1.2);
		Polvoron chocolate = new Polvoron("Chocolate", 2.0);
		Polvoron almendra = new Polvoron("Almendra", 1.4);
		Polvoron naranja = new Polvoron("Naranja", 3.0);
		
		boolean continuar = true;
		
		while(continuar) {
			System.out.println("*****************MENÚ CESTA*****************" + "\r" + "¿Qué deseas hacer?" +"\r" + "1- Añadir" + "\r" + "2- Buscar" + "\r" + "3- Eliminar" + "\r" + "4- Modificar" + "\r" + "5- Mostrar" + "\r" + "6- Terminar programa" + "\r" + "Introduce un numero para continuar: ");
			opcion = entrada.nextInt();
			
			switch (opcion) {
			case 1:
				Cesta.addPolvoron(naranja);
				Cesta.addPolvoron(limon);
				Cesta.addPolvoron(chocolate);
				Cesta.addPolvoron(almendra);
				Cesta.addPolvoron(mantequilla);
				break;
			case 2:
				if (Cesta.searchPolvoron(naranja)) {
					System.out.println("El polvoron de " + naranja.getSabor() + " SI está en la cesta");
				} else System.out.println("El polvoron de " + naranja.getSabor() + " NO está en la cesta");
				break;
			case 3:
				if (Cesta.deletePolvoron(limon)) {
					System.out.println("Se ha eliminado eel polvoron de " + limon.getSabor());
				}else System.out.println("No se puede eliminar el polvoron de " + limon.getSabor() + " ya que no esta en la cesta");
				break;
			case 4:
				if (Cesta.modifyPolvoron(naranja, chocolate)) {
					System.out.println("Se ha modificado el polvoron de " + naranja.getSabor() + " por el de " + chocolate.getSabor());
				}else System.out.println("No se ha podido modificar el polvoron");
				break;
			case 5:
				Cesta.showCesta();
				break;
			case 6: 
				continuar = false;
				break;
			}
			
		}
		


		
		
	}
}
