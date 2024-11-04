package ejerciciosIniciales;
import java.util.Scanner;
import java.lang.Math;

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

		//Ejemplo
		Edad edad = new Edad(18);
		cumpleaños(edad);
		
		System.out.println(edad.getAños());
		
		//PARTE II
		//Ejercicio1
		String nombre;
		int edad, numeroEmpleado;
		double salario;
		
		
		System.out.println("Introduce numero de empleado, edad, salario y nombre en este orden separados por espacios: ");
		numeroEmpleado = entrada.nextInt();
		edad = entrada.nextInt();
		salario = entrada.nextDouble();
		nombre = entrada.nextLine();
				
		//Empleado empleado1 = new Empleado(nombre, edad, numeroEmpleado, salario);
		Empleado empleadoVacio = new Empleado();
		
		System.out.println("Estos son los datos de empleadoVacio: "+ empleadoVacio.getAllValues());
		
		empleadoVacio.setAllValues(nombre, edad, numeroEmpleado, salario);
		
		//Ejercicio2
		final int CONVERSION = 10;
		int userElection, machineElection;
		double doubleMachineElection;
		
		System.out.println("Introduce un numero del 1 al 3, PIEDRA = 1, PAPEL = 2, TIJERA = 3");
		userElection = entrada.nextInt();
		
		do {														//Podemos cambiar el do while por machineElection = (int)Math.random()*(4-1)+1; 
			doubleMachineElection = Math.random() * CONVERSION;
			machineElection = (int)doubleMachineElection;	
		} while ((machineElection > 3) || (machineElection == 0)); 
		
		System.out.println("Ahora elegiré yo..." + machineElection);
		 */
		
		//Ejercicio3
		CargamentoFruta cargo1 = new CargamentoFruta("Naranjas", "Valencia", 1000, 0.5, 1);
		CargamentoFruta cargo2 = new CargamentoFruta("Peras", "Valencia", 10000, 0.2, 2);
		CargamentoFruta cargo3 = new CargamentoFruta("Platanos", "Canarias", 10000, 0.2, 2);
		
		System.out.println("---Cargamento1---" + cargo1.getAllValues());
		System.out.println("---Cargamento2---" + cargo2.getAllValues());
		System.out.println("---Cargamento3---" + cargo3.getAllValues());
		
		
	}

}
