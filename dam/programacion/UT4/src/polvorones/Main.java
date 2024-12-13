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

		Crea un método extra para saber el precio de la cesta calculaPrecio(). Sabiendo que la cesta donde se guardan los polvorones vale 3 euros y los polvorones el precio que tiene cada uno. Añade esta opción en tu menú para utilizar este método y ver el precio de la cesta en cada momento que el usuario lo solicite.	
		*/
		
		int opcion;
		Scanner entrada = new Scanner(System.in);
		
		Polvoron limon = new Polvoron("Limon", 2.2);
		Polvoron manteca = new Polvoron("Mantequilla", 1.2);
		Polvoron chocolate = new Polvoron("Chocolate", 2.0);
		Polvoron almendra = new Polvoron("Almendra", 1.4);
		Polvoron naranja = new Polvoron("Naranja", 3.0);
		Polvoron vegano = new Polvoron("Vegano", 3.0);
		
		boolean continuar = true;
		boolean flag = false;
		
		while(continuar) {
			System.out.print("\n" + "*****************MENÚ CESTA*****************" + "\r" + "¿Qué deseas hacer?" +"\r" + "1- Añadir" + "\r" + "2- Buscar" + "\r" + "3- Eliminar" + "\r" + "4- Modificar" + "\r" + "5- Mostrar" + "\r" + "6- Mostrar el valor de la cesta" + "\r" + "7- Terminar programa" + "\r" + "Introduce un numero para continuar: ");
			opcion = entrada.nextInt();
			
			switch (opcion) {
			case 1:
				if (!flag) {
					Cesta.addPolvoron(limon);
					Cesta.addPolvoron(vegano);
					Cesta.addPolvoron(naranja);
					Cesta.addPolvoron(manteca);
					Cesta.addPolvoron(almendra);				
					flag = true;
				} else if (flag) {
					Cesta.addPolvoron(manteca);
				}
				
				break;
			case 2:
				int pos[] = Cesta.searchPolvoron(vegano);
				if ((pos[0] < 0)) {
					System.out.println("El polvorón " + vegano.getSabor() + " NO esta en la cesta");
				} else {
					System.out.println("El polvorón " + vegano.getSabor() + " esta en la fila: " + pos[0] + " y columna: " + pos[1]);
				}
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
				System.out.println("El valor de la cesta es: " + Cesta.cestaPrice());
				break;
			case 7: 
				System.out.println("Adiós!");
				continuar = false;
				break;
			}
			
		}
		entrada.close();
		


		
		
	}
}
