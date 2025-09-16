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
		
		//Ejercicio3
		CargamentoFruta cargo1 = new CargamentoFruta("Naranjas", "Valencia", 1000, 0.5, 1);
		CargamentoFruta cargo2 = new CargamentoFruta("Peras", "Valencia", 10000, 0.2, 2);
		CargamentoFruta cargo3 = new CargamentoFruta("Platanos", "Canarias", 10000, 0.2, 2);
		
		System.out.println("---Cargamento1---" + cargo1.getAllValues());
		System.out.println("---Cargamento2---" + cargo2.getAllValues());
		System.out.println("---Cargamento3---" + cargo3.getAllValues());
		
		System.out.println(CargamentoFruta.compararaProcedencia(cargo1, cargo2));
		
		if (cargo3.bajarPrecio(0.3)) {			
			System.out.println("El precio ha sido rebajado");
		} else  {
			System.out.println("El precio de venta no puede ser inferior al costo x kilo");
		}
		
		System.out.println("Venta 100K cargo1-" + cargo1.vender(100) + "\nVenta 1000K cargo2-" + cargo2.vender(1000) + "\nVenta 10000K cargo3-" + cargo3.vender(10000));
		
		System.out.println("EL beneficio obtenido es de: " + CargamentoFruta.beneficio + "€");
		
		//Ejercicio 9
		System.out.println(Ejercicios9y10.printPosition("Manolo", "Pepe", "Laura"));
		
		//Ejercicio10		
		Ejercicios9y10.sumParam(9, 10, 11, 12);
		System.out.println("La suma de los parametros recibidos es: " + Ejercicios9y10.getSuma());
		
		//Ej11
		Ejercicios9al11.sumParam(10, 20, 11.32, 12.54);
		System.out.println("La suma de los parametros recibidos es: " + Ejercicios9al11.getSuma());
		
		//Ejercicio7 Resuelto en el 8
		Billete billete1 = new Billete("Manolo", "45679801V");
		
		//Ejercicio5- OMITIDO - El profesorado quiere una soluciópn sin arrays y no estoy dispuesto a usar 30 if else, saludos.
		Alumno a1 = new Alumno(456, 7, 8, 8);
		Alumno a2 = new Alumno(457, 4, 5, 4);
		Alumno a3 = new Alumno(458, 6, 5, 7);

		Alumno.calculaMedia(a1, a2, a3);
		System.out.println("Las medias son: " + Alumno.getMedias());
		
		//Ejercicio6
		Cliente c1 = new Cliente("Maria", "Barcelona", "56326792Z");
		Carro p1 = new Carro();
		Carro p2 = new Carro();
		Carro p3 = new Carro();
		Carro p4 = new Carro();
		Carro p5 = new Carro();
		Carro p6 = new Carro();
		
		
		p1.addProduct("Platanos", 1.0, 10);
		p2.addProduct("Peras", 2.0, 15);
		p3.addProduct("Manzanas", 4.0, 20);
		p4.addProduct("Melones", 3.0, 10);
		p5.addProduct("Sandias", 4.5, 15);
		p6.addProduct("Mangos", 6.2, 20);
		
		p1.removeProduct();
		p3.removeProduct();
		
		System.out.println("CLiente: " + c1.getClientNif());
		System.out.println(Carro.getLista(p1, p2, p3, p4, p5, p6));
		
		//Ejercicio8
		Billete b1 = new Billete("Manolo", "45679801V", "turista");
		Billete b2 = new Billete("Marta", "45679325V", "business");
		
		b1.facturar(346, 3);
		b2.facturar(34, 5, true, false);
		
		System.out.println("Precio billete1: " + b1.getTotal());
		System.out.println("Precio billete2: " + b2.getTotal());
		 */				

		//Ejercicio12
		System.out.println("El numero mayor es: " + Calcula.mayor(3, 5, 7, 23));
		System.out.println("La cadena mayor es: " + Calcula.mayor("hola", "holaa", "holaaaaaaa"));
		System.out.println("El numero menor es: " + Calcula.menor(3, 5, 7, 23));
	}

}
