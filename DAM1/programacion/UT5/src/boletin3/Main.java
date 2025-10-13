package boletin3;

public class Main {

	public static void main(String[] args) {
		/*EJERCICIO 2
		Vamos a crearnos una pequeña aplicación de una peluquería. Nos tendremos que crear
		la clase persona con las características comunes a los peluqueros y los clientes. Estas
		características son: dni, nombre, apellidos, edad.
		Después tendremos la clase Peluquero que tendrá un salario y número de horas de
		trabajo. Por su parte, la clase Cliente tendrá número que identifica al cliente (un número
		entero). Además, tendrá que disponer del método double calculaPrecioServicio (double
		precio) que calculará cuánto costará el servicio aplicando un 10% de IVA.
		Debes crear los constructores, métodos y atributos que consideres.
		Crea una clase Peluquería que tendrá el programa principal. En esta clase se creará 2
		peluqueros y 3 clientes. El segundo peluquero será un peluquero copia del primero,
		después modifica el DNI y nombre del segundo peluquero. Los peluqueros se guardarán
		en un array y los clientes en una lista dinámica.
		Por otro lado, en tu peluquería tendrás que tener un mapa donde guardes el tipo de
		servicio y el precio que tiene. Comprueba previamente que no existe el servicio en tu
		mapa antes de insertar la información.
		Una vez tengas todos los objetos creados, cada uno de los clientes pedirán un servicio.
		El programa debe calcular cuánto le va a costar el servicio al cliente. Si el precio le parece
		adecuado, entonces se le realizará y cobrará el servicio al cliente. Al finalizar el programa
		debes mostrar por pantalla cuánto dinero ha ganado la caja de la peluquería.*/
		
		Peluquero p1 = new Peluquero("Manolo", "El del Bombo", "12345678A", 340, 50000, 1000);
		Peluquero p2 = new Peluquero("Manolo", "El del Bombo", "12345678A", 340, 50000, 1000);
		
		p2.setDni("23456789B");
		p2.setNombre("Manuela");

		Cliente c1 = new Cliente("Wally", "Steel", "12345678A", 3000, 1);
		Cliente c2 = new Cliente("Eva", "Titanium", "12345678A", 30, 2);
		
		
	}

}
