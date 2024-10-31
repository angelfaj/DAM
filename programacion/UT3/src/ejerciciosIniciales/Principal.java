package ejerciciosIniciales;
import java.util.Scanner;

public class Principal {


	//Ejemplo
	static void cumpleaños (Edad años) {
		int valor = años.getAños();
		valor++;
		
		años.setAños(valor);
	}
	
	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);
		/*
		
		Coche mycar = new Coche();
		Coche yourcar = new Coche("BMW", "Serie3");
		
		//Ejercicio1
		System.out.println("Mi coche es un: " + mycar.marca + mycar.modelo + " el tuyo es un: " + yourcar.marca + yourcar.modelo);
		
		//EJercicio2
		System.out.println("mycar.velocidad es: " + mycar.velocidad + " getvelocidad: " + mycar.getVelocidad() + " void acelera con incremento en 40: " );
		mycar.acelera(40);
		System.out.println(mycar.velocidad + "" + mycar.getVelocidad());
		
		//A continuacion podemos ver como primero sumamos cuarenta a la velocidad, la guardamos en una variable y luego la mostramos 
		mycar.acelera(40);
		int velocidad = mycar.getVelocidad();
		System.out.println(velocidad);
		
		//Ejercicio3
		double valor;
		
		System.out.println("Por favor introduce el valor actual del dolar respecto al euro: ");
		valor = entrada.nextDouble();
		
		Finanzas opera = new Finanzas(valor);
		
		System.out.println(opera.dolarsToEuros(50));
		System.out.println(opera.eurosToDolars(50));

		//Ejercicio4
		int numero;
		
		System.out.print("Por favor introduce un numero: ");
		numero = entrada.nextInt();
		
		Minumero cuarenta = new Minumero(numero);
		System.out.println("Doble:" + cuarenta.getDoble() + " triple:" + cuarenta.getTriple() + " cuadruple:" + cuarenta.getCuadruple());
		
		//Ejercicio6
		int numero;
		
		System.out.println("Por favor introduce un nuevo numero: ");
		numero = entrada.nextInt();
		
		Numero primerNumero = new Numero(numero);
		
		primerNumero.añade(5);
		System.out.println("Suma: " + primerNumero.getValor());
		
		primerNumero.resta(3);
		System.out.println("Resta: " + primerNumero.getValor());
		
		System.out.println("Por favor introduce un nuevo numero: ");
		numero = entrada.nextInt();
		primerNumero.setNumero(numero);
		
		primerNumero.añade(5);
		System.out.println("Nuevo valor: " + primerNumero.getValor());
		 */
		//Ejemplo
		Edad edad = new Edad(18);
		cumpleaños(edad);
		
		System.out.println(edad.getAños());
		
		
	}

}
