package boletin1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		/*Ejercicio 1 - ASTROS
		Define una jerarquía de clases que permita almacenar datos sobre los planetas y
		satélites (lunas) que forman parte del sistema solar.
		Algunos atributos que necesitaremos almacenar son:
		● Masa del cuerpo.
		● Diámetro medio.
		● Período de rotación sobre su propio eje.
		● Período de traslación alrededor del cuerpo que orbitan.
		● Distancia media a ese cuerpo.
		Define las clases necesarias conteniendo:
		● Constructores.
		● Métodos para recuperar y almacenar atributos.
		● Método para mostrar la información del objeto.
		Define un método, que dado un objeto del sistema solar (planeta o satélite), imprima
		toda la información que se dispone sobre el mismo (además de su lista de satélites
		si los tuviera).
		El diagrama UML sería:
		Una posible solución sería crear un array de objetos, insertar los planetas y satélites
		(directamente mediante código o solicitandonos por pantalla) y luego mostrar un
		pequeño menú que permita al usuario imprimir la información del astro que elija.
		
		FALTA TERMINAR 
		 
		Ejercicio 2 - MASCOTAS
		Implementa una clase llamada Inventario que utilizaremos para almacenar
		referencias a todos los animales existentes en una tienda de mascotas.
		Esta clase debe cumplir con los siguientes requisitos:
		● En la tienda existirán 4 tipos de animales: perros, gatos, loros y canarios.
		● Los animales deben almacenarse en un Array privado dentro de la clase
		Inventario.
		● La clase debe permitir realizar las siguientes acciones:
		○ Mostrar la lista de animales (solo tipo y nombre, 1 línea por animal).
		○ Mostrar todos los datos de un animal concreto.
		○ Mostrar todos los datos de todos los animales.
		○ Insertar animales en el inventario.
		○ Eliminar animales del inventario.
		○ Vaciar el inventario.
		Implementa las demás clases necesarias para la clase Inventario.

		
		Perro perro = new Perro("Ramon", "10/1/1999", 26, Estado.VIVO, "Doberman", false);
		Gato gato = new Gato("Ares", "10/1/1999", 26, Estado.VIVO, "Negro", true);
		Loro loro = new Loro("Chan", "10/7/2024", 1, Estado.VIVO, true, false, "Puerto Rico", false);
		Canario canario= new Canario("Perico", "10/7/2024", 1, Estado.VIVO, true, false, "Amarillo", false);
		
		Mascota inventario[] = new Mascota[10];
		
		inventario[0] = perro;
		inventario[1] = gato;
		inventario[2] = loro;
		inventario[3] = canario;
		
		Scanner entrada = new Scanner(System.in);
		boolean continuar = true;
		int opcion, opcionAnimal, posicion;
		String nombre = "";
		
		do {
			System.out.println("************MENU TIENDA************");
			System.out.println("1. Mostrar inventario");
			System.out.println("2. Mostrar informacion de un animal");
			System.out.println("3. Mostrar informacion de todos los animales");
			System.out.println("4. Insertar animal");
			System.out.println("5. Eliminar animal");
			System.out.println("6. Vaciar inventario");
			System.out.println("7. Terminar programa");
			System.out.println("Introduce un numero paa continuar: ");
			
			opcion = entrada.nextInt();
			entrada.nextLine();
			
			switch(opcion) {
			case 1:
				for (Mascota m:inventario) {
					if (m != null) {
						System.out.println("Tipo: " + m.getClass() + " nombre: " + m.getNombre());						
					}
				}
				break;
			case 2:
				System.out.println("Introduce el nombre del animal a mostrar: ");
				nombre = entrada.nextLine();
				boolean encontrado = false;
				int i = 0;
				do {
					Mascota m = inventario[i]; 
					if (m != null) {
						if (m.getNombre().equalsIgnoreCase(nombre)) {
							m.muestra();
							encontrado = true;
						}
					}
					i++;
				}while(!encontrado);
				break;
			case 3: 
				for (Mascota m:inventario) {
					if (m != null) {
						m.muestra();						
					}
				}
				break;
			case 4:
				System.out.println("Elige el animal a insertar: ");
				System.out.println("1. Perro");
				System.out.println("2. Gato");
				System.out.println("3. Loro");
				System.out.println("4. Canario");
				System.out.println("Introduce un numero para continuar: ");
				opcionAnimal = entrada.nextInt();
				System.out.println("Introduce la posicion en la que insertarlo: ");
				posicion = entrada.nextInt();
				entrada.nextLine();
				
				switch(opcionAnimal) {
				case 1:
					inventario[posicion] = perro;
					break;
				case 2:
					inventario[posicion] = gato;
					break;
				case 3: 
					inventario[posicion] = loro;
					break;
				case 4: 
					inventario[posicion] = canario;
				break;
				}
				
				break;
			case 5: 
				System.out.println("Introduce el nombre del animal a eliminar: ");
				nombre = entrada.nextLine();
				boolean hayado= false;
				int h = 0;
				do {
					Mascota m = inventario[h]; 
					if (m != null) {
						if (m.getNombre().equalsIgnoreCase(nombre)) {
							inventario[h] = null;
							hayado = true;
						}
					}
					h++;
				}while(!hayado);
				
				break;
			case 6: 
				for (int j = 0; j < inventario.length; j++) {
					inventario[j] = null;
				}
				System.out.println("Inventario vaciado exitosamente");
				break;
			case 7: 
				System.out.println("Fin del programa, Adiós!");
				continuar = false;
				break;
			}
			
			
		}while(continuar);
		entrada.close();
		
		
		
		Ejercicio 4 – EMPRESA Y EMPLEADOS
		Vamos a implementar dos clases que permitan gestionar datos de empresas y sus
		empleados.
		Los empleados tienen las siguientes características:
		● Un empleado tiene nombre, DNI, sueldo bruto (mensual), edad, teléfono y
		dirección.
		● El nombre y DNI de un empleado no pueden variar.
		● Es obligatorio que todos los empleados tengan al menos definido su nombre,
		DNI y el sueldo bruto. Los demás datos no son obligatorios.
		● Será necesario un método para imprimir por pantalla la información de un
		empleado.
		● Será necesario un método para calcular el sueldo neto de un empleado. El
		sueldo neto se calcula descontando del sueldo bruto un porcentaje que
		depende del IRPF. El porcentaje del IRPF depende del sueldo bruto anual del
		empleado (sueldo bruto x 12 pagas).(*)
		● Por ejemplo, un empleado con un sueldo bruto anual de 17.000 € tendrá un
		30% de IRPF. Para calcular su sueldo neto mensual se descontará un 30% a
		su sueldo bruto mensual.
		Sueldo bruto anual
		IRPF
		Inferior a 12.000 € 20%
		De 12.000 a 25.000 € 30%
		Más de 25.000 € 40%
		Las empresas tienen las siguientes características:
		● Una empresa tiene nombre y CIF (datos que no pueden variar), además de
		teléfono, dirección y empleados. Cuando se crea una nueva empresa esta
		carece de empleados.
		● Serán necesarios métodos para:
		○ Añadir y eliminar empleados a la empresa.
		○ Mostrar por pantalla la información de todos los empleados.
		○ Mostrar por pantalla el DNI, sueldo bruto y neto de todos los
		empleados.
		○ Calcular la suma total de sueldos brutos de todos los empleados.
		○ Calcular la suma total de sueldos netos de todos los empleados.
		Implementa las clases Empleado y Empresa con los atributos oportunos, un
		constructor, los getters/setters oportunos y los métodos indicados. Puedes añadir
		más métodos si lo ves necesario. Estas clases no deben realizar ningún tipo de
		entrada por teclado.
		Implementa también una clase Programa con una función main para realizar
		pruebas: Crear una o varias empresas, crear empleados, añadir y eliminar
		empleados a las empresas, listar todos los empleados, mostrar el total de sueldos
		brutos y netos, etc.
		(*) El IRPF realmente es más complejo pero se ha simplificado para no complicar
		demasiado este ejercicio.
		*/
		
		//Falta el main
		
		
		
		/*Ejercicio 5 - VEHÍCULOS
		Es aconsejable hacer el diseño UML antes de empezar a programar.
		Debes crear varias clases para un software de una empresa de transporte.
		Implementa la jerarquía de clases necesaria para cumplir los siguientes criterios:
		·
		Los vehículos de la empresa de transporte pueden ser terrestres, acuáticos
		y aéreos. Los vehículos terrestres pueden ser coches y motos. Los vehículos
		acuáticos pueden ser barcos y submarinos. Los vehículos aéreos pueden ser
		aviones y helicópteros.
		·
		Todos los vehículos tienen matrícula y modelo (datos que no pueden
		cambiar). La matrícula de los coches terrestres deben estar formadas por 4 números
		y 3 letras. La de los vehículos acuáticos por entre 3 y 10 letras. La de los vehículos
		aéreos por 4 letras y 6 números.
		● Los vehículos terrestres tienen un número de ruedas (dato que no puede
		cambiar).
		● Los vehículos acuáticos tienen eslora (dato que no puede cambiar).
		● Los vehículos aéreos tienen un número de asientos (dato que no puede
		cambiar).
		● Los coches pueden tener aire acondicionado o no tenerlo.
		● Las motos tienen un color.
		● Los barcos pueden tener motor o no tenerlo.
		● Los submarinos tienen una profundidad máxima.
		● Los aviones tienen un tiempo máximo de vuelo.
		● Los helicópteros tienen un número de hélices.
		● No se permiten vehículos genéricos, es decir, no se deben poder instanciar
		objetos que sean vehículos sin más. Pero debe ser posible instanciar
		vehículos terrestres, acuáticos o aéreos genéricos (es decir, que no sean
		coches, motos, barcos, submarinos, aviones o helicópteros).
		● El diseño debe obligar a que todas las clases de vehículos tengan un método
		imprimir() que imprima por pantalla la información del vehículo en una sola
		línea.
		
		Implementa todas las clases necesarias con: atributos, constructor con parámetros,
		getters/setters y el método imprimir. Utiliza abstracción y herencia de la forma más
		apropiada.
		
		Implementa también una clase Programa para hacer algunas pruebas: Instancia
		varios vehículos de todo tipo (coches, motos, barcos, submarinos, aviones y
		helicópteros) así como vehículos genéricos (terrestres, acuáticos y aéreos). Crea un
		vector y añade todos los vehículos. Recorre el array y llama al método imprimir de
		todos los vehículos.
		
		
		vehiculos abstract (matricula, modelo):
			terrestres (numeroRuedas):
				coches (boolean aireAcondicionado)
				motos (color)
				
				acuaticos (eslora):
					barcos (boolean motor)
					submarinos (profundidadMaxima)
					
					aereos (numeroAsientos):
						aviones (tiempoVueloMaximo)
						helicopteros (numeroHelices)
						
						sysos para todos
		*/
		//Usar expresiones regulares para comprobar las matriculas
		
		Vehiculo vehiculos[] = new Vehiculo[10];
		
		String matriculaTerrestre = "", matriculaAerea = "", matriculaAcuatica = "";
		boolean continuar = false;
		int flag = 0;
		
		do {
			switch (flag) {
			case 0:
				System.out.println("introduce una matricula terrestre (4 números + 3 letras)");
				matriculaTerrestre = entrada.nextLine();
				if (matriculaTerrestre.matches("\\d{4}[a-z | A-Z]{3}")) {
					flag++;
				}
				break;
			case 1:
				System.out.println("introduce una matricula acuatica (entre 3 y 10 letras)");
				matriculaAcuatica = entrada.nextLine();
				if (matriculaAcuatica.matches("[a-z | A-Z]{3,10}")) {
					flag++;
				}
				break;
			case 2:
				System.out.println("introduce una matricula aerea (4 letras + 6 números)");
				matriculaAerea= entrada.nextLine();
				if (matriculaAerea.matches("[a-z | A-Z]{4}\\d{6}")) {
					continuar = true;
				}
				break;
			}
		} while(!continuar);
		
		System.out.println("Matricula Terrestre: " + matriculaTerrestre);
		System.out.println("Matricula Aerea: " + matriculaAerea);
		System.out.println("Matricula Acuatica: " + matriculaAcuatica);
		
		
		
		
		//FIN MAIN
	}
}
