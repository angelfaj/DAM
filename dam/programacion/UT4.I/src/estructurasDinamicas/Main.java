package estructurasDinamicas;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.math.*;

public class Main {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		/*Ejercicio 1
		Realizar un programa que lea tantos números enteros como desee el
		usuario (se pedirá dicha información al usuario) y los introduzca en una
		lista (ArrayList).
		Muestra la lista, intercambia los números que se encuentren en la 2a y 4a
		posición, y muestra de nuevo la lista por pantalla. Utiliza al menos 3
		métodos: uno para introducir los datos, otro para mostrarlos y otro para
		intercambiarlos.
		
		
		ArrayList<Integer> enteros = new ArrayList<Integer>();
		boolean op = true;
		int opcion;
		
		
		
		while (op) {
			System.out.println("1. Introducir un numero" + "\n" + "2. Finalizar lectura");
			opcion = entrada.nextInt();
			switch (opcion) {
			case 1:
				System.out.println("Numero: ");
				enteros.add(entrada.nextInt());				
				break;
			case 2:
				System.out.println("Adios!");
				op = false;
				break;
			}
			
		}
		entrada.close();
		System.out.println("La lista contiene los siguientes elementos: " + enteros);
		int aux = enteros.get(3);
		enteros.set(3, enteros.get(1));
		enteros.set(1, aux);
		
		
		
		System.out.println("La lista contiene los siguientes elementos: " + enteros);
		*/
		
		
		/*Ejercicio 2
		Un supermercado nos pide que hagamos una pequeña aplicación que
		almacene los productos pasados por el escáner.
		La aplicación debe almacenar Productos (clase), cada producto al crearse
		contiene un nombre, cantidad y un precio. Calcular el precio total de una
		lista (ArrayList) de entre 1 y 8 productos (se pide por consola introducir
		productos hasta que se introduzca ”FIN”). Mostrar un ticket con todo lo
		vendido y el precio final como se hacen en los supermercados. Más o
		menos con este formato, lo importante son los datos, no el estilo:
		***********Cantidad****Precio*******Total
		Jamón 5 3.5 17.5
		Queso 7 2.5 17.5
		Precio final
		35
		
		boolean continuar = true;
		String nombre;
		int cantidad, i = 0;
		final int LIMITE = 8;
		double precio;
		ArrayList<Producto> listaProductos = new ArrayList<Producto>();		//Lista para manipular los productos en el main
		
		while (continuar & (i < LIMITE)) {
			System.out.println("FIN para terminar" + "\n" + "Nombre del producto:");
			nombre = entrada.nextLine();
			if (nombre.equalsIgnoreCase("fin")) {
				continuar = false;
			} else {
				System.out.println("Cantidad (int):");
				cantidad = entrada.nextInt();
				System.out.println("Precio (double):");
				precio = entrada.nextDouble();
				entrada.nextLine();
				Producto p = new Producto(nombre, cantidad, precio);
				listaProductos.add(p);
			}
			i++;
		}
		
		System.out.println(Producto.showTicket());
		
		*/
		
		/*Ejercicio 3
		Escribe un programa que contenga un método que acepte como
		parámetro una lista (ArrayList) de números enteros mayores
		que 0, pudiendo contener elementos duplicados. Implementa un método
		que sustituya cada valor repetido por 0. Para terminar, realiza un método
		que muestre el array modificado.
		Nota: Necesitarás otro método para rellenar la lista de enteros. Le irá
		pidiendo números al usuario hasta que este introduzca un número
		negativo
		
		
		
		OperaArray listaEnteros = new OperaArray();
		
		listaEnteros.fillArray();

		System.out.println("La lista original es: " + listaEnteros.toString());
		listaEnteros.verifyArray();
		System.out.println("La lista tras modificar los repes es: " + listaEnteros.toString());
		.*/
		
		
		/*EJERCICIO 1
		Crea un programa en Java para la gestión de temperaturas. Inicialmente, se presenta un
		menú en pantalla para elegir la opción deseada:
		1. Añadir temperatura
		2. Mostrar temperatura media
 		3. Mostrar temperaturas extremas
		4. Mostrar la lista de temperaturas
		5. Busca la temperatura y muestra su posición
		6. Borrar la temperatura
		7. Salir
		
		El menú se volverá a presentar de nuevo en la pantalla tras completar cualquiera de las 6
		primeras opciones.
		Cada número de menú se implementará en un método estático que nos permite llevar a cabo la
		operación con la lista de temperaturas que se defina en el programa. Los datos se solicitarán al
		usuario, utiliza la clase Scanner para ello. Se guardará en un ArrayList las temperaturas.
		
		int op;
		boolean continuar = true;
		
		while (continuar) {
			Temperatura.showMenu();
			op = entrada.nextInt();
			
			switch (op) {
			case 1:
				System.out.println("Introduce la temperatura a continuacion: ");
				Temperatura.addTemp(entrada.nextDouble());
				break;
			case 2: 
				System.out.println("La temperatura media es: " + Temperatura.showAverage());
				break;
			case 3: 
				System.out.println("Ls temperaturas extremas son: " + Temperatura.showExtreme());
				break;
			case 4: 
				System.out.println("Las temperaturas almacenadas son: " + Temperatura.getListaTemperaturas());
				break;
			case 5: 
				System.out.println("Introduce la temperatura a buscar: ");
				int pos = Temperatura.searchTemp(entrada.nextDouble());
				if (pos >= 0) {
					System.out.println("La temperatura se encuentra en la posicion: " + pos);					
				} else System.out.println("La temperatura no se encuentra en la lista");
				break;
			case 6: 
				System.out.println("Introduce la temperatura a borrar: ");
				Temperatura.deleteTemp(entrada.nextDouble());
				break;
			case 7: 
				System.out.println("Fin del programa. Adiós!");
				continuar = false;
				break;
			}
		}
		entrada.close();
		
		/*EJERCICIO 4
		Crea un ArrayList con los nombres de 6 compañeros de clase. A continuación, muestra esos
		nombres por pantalla. Utiliza para ello un bucle for que recorra todo el ArrayList sin usar ningún
		índice.
		
		ArrayList<Alumno> lista= new ArrayList<Alumno>();
		Alumno a1 = new Alumno("Adriano");
		Alumno a2 = new Alumno("Filip");
		Alumno a3 = new Alumno("Carla");
		Alumno a4 = new Alumno("Andrea");
		Alumno a5 = new Alumno("Adrian");
		Alumno a6 = new Alumno("Moncef");
		
		lista.add(a1);
		lista.add(a2);
		lista.add(a3);
		lista.add(a4);
		lista.add(a5);
		lista.add(a6);
		
		for (Alumno a:lista) {
			System.out.println("Alumno: " + a.getNombre());
		}
		
		
		EJERCICIO 5
		Realiza un programa que introduzca valores aleatorios (entre 0 y 100) en un ArrayList y que
		luego calcule la suma, la media, el máximo y el mínimo de esos números. El tamaño de la lista
		también será aleatorio y podrá oscilar entre 10 y 20 elementos ambos inclusive. 
		
		
		ArrayList<Integer> randomList = new ArrayList<Integer>();
		int n, suma = 0, media, maximo = 9, minimo = 21, tamanio = (int)(Math.random()*20+10);		
		
		
		for (int i = 0; i < tamanio; i++) {
			n = (int)(Math.random()*100+0);
			randomList.add(n);		
			suma += n;
			if (n > maximo) {
				maximo = n;
			} 
			if (n < minimo) {
				minimo = n;
			}
		}
		
		media = suma / tamanio;
		
		System.out.println("La suma es: " + suma);
		System.out.println("La media es: " + media);
		System.out.println("El maximo es: " + maximo);
		System.out.println("El minimo es: " + minimo);
		
		
		Ejercicio 8
		Crea un conjunto (HashSet) al que se le va a llamar jugadores. Implementa
		los siguientes métodos:
		● Inserta en el conjunto los jugadores del FC Barcelona: Jordi Alba,
		Pique, Busquets, Iniesta, Messi.
		● Realiza un bucle sobre los jugadores del conjunto y muestra sus
		nombres.
		● Consulta si en el conjunto existe el jugador “Neymar JR”. Avisa si
		existe o no.
		● Crea un segundo conjunto jugadores2 con los jugadores “Piqué” y
		“Busquets”.
		● Consulta si todos los elementos de jugadores2 existen en jugadores.
		● Realiza una unión de los conjuntos jugadores y jugadores2 y observa
		el resultado.
		● Elimina todos los jugadores del conjunto jugadores2 y muestra el
		número de jugadores que tiene el conjunto jugadores2 (debería
		ahora ser cero).
		
		Jugador alba = new Jugador("Jordi Alba");
		Jugador pique = new Jugador("Piqué");
		Jugador iniesta = new Jugador("Iniesta");
		Jugador messi = new Jugador("Messi");
		Jugador busquets = new Jugador("Busquets");
		
		HashSet<Jugador> jugadores = new HashSet<Jugador>();
		
		jugadores.add(busquets);
		jugadores.add(iniesta);
		jugadores.add(pique);
		jugadores.add(alba);
		jugadores.add(messi);
		
		System.out.println(Jugador.showList(jugadores));
		
		Jugador neymar = new Jugador("Neymar JR");
		
		if (jugadores.contains(neymar)) {
			System.out.println("El jugador está en la lista");
		} else System.out.println("El jugador NO está en la lista");
		
		HashSet<Jugador> jugadores2 = new HashSet<Jugador>();
		
		jugadores2.add(busquets);
		jugadores2.add(pique);
		
		if (jugadores.containsAll(jugadores2)) {
			System.out.println("Pique yt busquets estan en ambas listas");
		}else System.out.println("Pique yt busquets NO estan en ambas listas");
		
		jugadores.addAll(jugadores2);
		System.out.println(Jugador.showList(jugadores));
		
		jugadores2.clear();
		System.out.println(jugadores2.size());

		
		EJERCICIO 8
		Implementa el control de acceso al área restringida de un
		programa. Se debe pedir un
		nombre de usuario y una contraseña. Si el usuario introduce los datos correctamente, el
		programa dirá "Ha accedido al área restringida". El usuario tendrá un máximo de 3
		oportunidades. Si se agotan las oportunidades el programa dirá "Lo siento, no tiene acceso al
		área restringida". Los nombres de usuario con sus correspondientes contraseñas deben estar
		almacenados en una estructura de la clase HasMap.
		
		HashMap<String, String> credentials = new HashMap<String, String>();
		credentials.put("Manolo", "1234");
		boolean continuar = true;
		int intentos = 0;
		
		do {
			intentos++;
			System.out.println("Introduce el nombre de usuario: ");
			String user = entrada.nextLine();
			System.out.println("Introduce la contraseña: ");
			String pass = entrada.nextLine();
			
			if ((credentials.get(user) != null) && (credentials.get(user).equals(pass))) {
				System.out.println("Has accedido al area restringida!");
				continuar = false;
			} else {
				System.out.println("Credenciales incorrectas, te quedan " + (3 - intentos) + " intentos");
			}
		}while (continuar & intentos < 3);

		System.out.print("Adios!");
		entrada.close(); 
		
		Ejercicio 11
		Escribe un programa que utilizando una colección HashMap:
		● Almacene los siguientes colores: Red, Green, Black, White y Blue. La
		clave será un entero, de tal forma que, Red->1, Green-> 2, etc.
		● Muestra la clave y su valor asociado (cada uno en una línea).
		● Muestra el total de colores almacenados en el HashMap.
		● Crea otro HashMap con los siguientes colores: Pink, Orange, Purple
		y claves 6, 7 y 8, respectivamente. Copia todos los valores de este
		HashMap en el primero (revisa la API). Muestra la información que
		contiene ahora el primer HashMap (toda en la misma línea).
		● Elimina todos los elementos del segundo HashMap (utilizando un
		único método). Imprime su contenido.
		● Crea un tercer HashMap igual que el primero, pero con los valores
		invertidos, es decir, ahora la clave será el color y el valor la posición.
		Comprueba si existe el color Green dentro de este HashMap y
		muestra un mensaje al usuario informándole en qué posición se
		encuentra. Idem para el color Brown.
		● Comprueba ahora si el valor Green existe en el primer HashMap.
		Idem con el color Brown. Informa al usuario.
		
		HashMap<Integer, String> colorsA = new HashMap<Integer, String>();
		
		colorsA.put(1, "Red");
		colorsA.put(2, "Green");
		colorsA.put(3, "Black");
		colorsA.put(4, "White");
		colorsA.put(5, "Blue");
		
		for (int key:colorsA.keySet()) {
			System.out.println("Clave-valor: " + key + "-" + colorsA.get(key));
		}
		
		System.out.println("Total colores almacenados: " + colorsA.size());
		
		
		HashMap<Integer, String> colorsB = new HashMap<Integer, String>();
		
		colorsA.put(6, "Pink");
		colorsA.put(7, "Orange");
		colorsA.put(8, "Purple");
		
		colorsA.putAll(colorsB);
		System.out.println("Valores tras juntar ambos maps");
		for (int key:colorsA.keySet()) {
			System.out.println("Clave-valor: " + key + "-" + colorsA.get(key));
		}
		
		colorsB.clear();
		System.out.println("Valores tras limpiar segundo map");
		for (int key:colorsB.keySet()) {
			System.out.println("Clave-valor: " + key + "-" + colorsB.get(key));
		}
		
		
		HashMap<String, Integer> colorsC = new HashMap<String, Integer>();
		
		colorsC.put("Red", 1);				//Esto lo puedo hacer con un for mendrugo
		colorsC.put("Green", 2);
		colorsC.put("Black", 3);
		colorsC.put("White", 4);
		colorsC.put("Blue", 5);
		
		System.out.println("Buscando el Green y el Brown en el tercer mapa");
		for (String key:colorsC.keySet()) {
			if (key.equalsIgnoreCase("Green")) {
				System.out.println("El Green se encuentra en la posicion " + colorsC.get(key));
			}
			if (key.equalsIgnoreCase("Brown")) {
				System.out.println("El Brown se encuentra en la posicion " + colorsC.get(key));
			}
		}
		
		System.out.println("Buscando el Green y el Brown en el primer mapa");
		for (int key:colorsA.keySet()) {
			if (colorsA.get(key).equalsIgnoreCase("Green")) {
				System.out.println("El Green se encuentra en la posicion " + key);
			}
			if (colorsA.get(key).equalsIgnoreCase("Brown")) {
				System.out.println("El Brown se encuentra en la posicion " + key);
			}
		}
		
		
		EJERCICIO 1
		Realiza un programa que escoja al azar 10 cartas de la baraja española (10 objetos de la clase
		Carta). Emplea un objeto de la clase ArrayList para almacenarlas y asegúrate de que no se
		repite ninguna. La clase Carta será:
		private static String[] n = {"as", "dos", "tres", "cuatro", "cinco",
		"seis", "siete", "sota", "caballo", "rey"};
		private static String[] p = {"bastos", "copas", "espadas", "oros"};
		private String numero;
		private String palo;
		public Carta() {
		this.numero = n[(int)(Math.random()*10)];
		this.palo = p[(int)(Math.random()*4)];
		}
		Incluye los métodos de los atributos número y palo. También sobrescribe el método toString y
		el método equals.
		
		EJERCICIO 2
		Modifica el programa anterior de tal forma que las cartas se muestren ordenadas. Primero se
		ordenarán por palo: bastos, copas, espadas, oros. Cuando coincida el palo, se ordenará por
		número: as, 2, 3, 4, 5, 6, 7, sota, caballo, rey.
		

		ArrayList<Carta> mano = new ArrayList<Carta>();
		Carta c;
		
		for (int i = 0; i < 10; i ++) {
			do {
				c = new Carta();
			}while (mano.contains(c));
			mano.add(c);
		}
		
		for (Carta aux:mano) {
			System.out.println(aux);
		}
		
		Collections.sort(mano);
		System.out.println("\n" + "Tras ordenarlas por palo y numero");
		for (Carta aux:mano) {
			System.out.println(aux);
		}
		
		
		EJERCICIO 3
		Escribe un programa que genere una secuencia de 5 cartas de la baraja española y que sume
		los puntos según el juego de la brisca. El valor de las cartas se debe guardar en una estructura
		HashMap que debe contener parejas (figura, valor), por ejemplo ("caballo", 3).
		La secuencia de cartas debe ser una estructura de la clase ArrayList que con ene objetos de la
		clase Carta. El valor de las cartas es el siguiente: as → 11, tres →10, sota → 2, caballo → 3, rey
		→ 4; el resto de cartas no vale nada.
		Ejemplo:
		as de oros
		cinco de bastos
		caballo de espadas
		sota de copas
		tres de oros
		Tienes 26 puntos
		
		HashMap<String, Integer> valores = new HashMap<String, Integer>();
		valores.put("as", 11);
		valores.put("tres", 10);
		valores.put("sota", 2);
		valores.put("caballo", 3);
		valores.put("rey", 4);
		
		ArrayList<Carta> mano = new ArrayList<Carta>();
		Carta c;
		int total = 0;
		for (int i = 0;i < 5;i++) {
			mano.add(c = new Carta());
			switch (c.getNumero()) {
			case 0:
				total += valores.get("as");
				break;
			case 3:
				total += valores.get("tres");
				break;
			case 7:
				total += valores.get("sota");
				break;
			case 8: 
				total += valores.get("caballo");
				break;
			case 9:
				total += valores.get("rey");
			}
		}
		
		
		for (Carta d:mano) {
			System.out.println(d);
		}
		
		System.out.println("Tienes " + total + " puntos");
		
		EJERCICIO 4
		Escribe un programa de una enda ecológica donde se venden los siguientes productos al
		precio que indica la tabla:
		
		PRODUCTO									PRECIO
		AVENA										2.21
		GARBANZOS									2.39
		TOMATE										1.59
		JENGIBRE									3.13
		QUINOA										4.5
		GUISANTES									1.6
		
		Guarda esta información en un HashMap. Después pide al usuario introducir el nombre del
		producto y la can dad del mismo por teclado hasta que escriba la palabra fin. Ves guardando
		en unos ArrayList los productos y can dades que se van introduciendo.
		Por úl mo, muestra la factura a pagar indicando: el producto, el precio, la can dad y el
		subtotal de cada producto que ha pedido y al final muestra el total a pagar.
		

		HashMap<String, Double> productos = new HashMap<String, Double>();
		productos.put("avena", 2.21);
		productos.put("garbanzos", 2.39);
		productos.put("tomate", 1.59);
		productos.put("jengibre", 3.13);
		productos.put("quinoa", 4.5);
		productos.put("guisantes", 1.6);
		
		ArrayList<String> productNom= new ArrayList<String>();
		ArrayList<Integer> productCant= new ArrayList<Integer>();
		
		boolean continuar = true;
		String nombre = "";
		int cantidad = 0;
		double subtotal = 0, total = 0;
		
		do {
			System.out.println("Producto: ");
			nombre = entrada.next();
			
			if (nombre.equalsIgnoreCase("fin")) {
				continuar = false;
				break;
			} else productNom.add(nombre);
			
			System.out.println("Cantidad: ");
			cantidad = entrada.nextInt();
			productCant.add(cantidad);
			entrada.nextLine();
		}while (continuar);
		
		System.out.println("Producto" + "\t" + "Precio" + "\t" + "Cantidad" + "\t" + "Subtotal" + "\n" + "---------------------------------------------------------");
		for (int i = 0; i < productNom.size(); i++) {
			subtotal = productCant.get(i) * productos.get(productNom.get(i));
			System.out.println(productNom.get(i) + "\t" + "\t" + productos.get(productNom.get(i)) + "\t" + productCant.get(i) + "\t" + "\t" + subtotal);
			total += subtotal;
		}
		System.out.print("\n" + "---------------------------------------------------------" + "\n" + "TOTAL: " + total);


		EJERCICIO 5
		Actualiza el programa anterior, verificando si ya existe el producto que solicita el cliente
		comprar antes de incluirlo en la lista. En caso de exis r, incrementa la can dad del producto
		que tenía pedido en las unidades pedidas ahora.
		Además, antes de mostrar el total a pagar, solicita al usuario si ene un cupón descuento
		“ECODTO”, en caso de tenerlo, aplícale el 10% de descuento al total de su compra.
		
//		rehacer con indexof y sin el segundo mapa!!!!

		HashMap<String, Double> productos = new HashMap<String, Double>();
		productos.put("avena", 2.21);
		productos.put("garbanzos", 2.39);
		productos.put("tomate", 1.59);
		productos.put("jengibre", 3.13);
		productos.put("quinoa", 4.5);
		productos.put("guisantes", 1.6);
		
		HashMap<String, Integer> cesta = new HashMap<String, Integer>();
		
		boolean continuar = true;
		String desc = "", nombre = "";
		int cantidad = 0;
		double subtotal = 0, total = 0, descuento = 0;
		final String DESCUENTO = "ECODTO"; 
		
		do {
			System.out.println("Producto: ");
			nombre = entrada.next();
			
			if (nombre.equalsIgnoreCase("fin")) {
				entrada.nextLine();
				System.out.println("Introduzca un codigo de descuento (INTRO si no tiene ninguno): ");
				desc = entrada.nextLine();
				continuar = false;
				break;
			} else if (cesta.containsKey(nombre)) {
				System.out.println("Cantidad: ");
				cantidad = entrada.nextInt();
				cantidad += cesta.get(nombre);
				cesta.replace(nombre, cesta.get(nombre), cantidad);
			} else {
				System.out.println("Cantidad: ");
				cantidad = entrada.nextInt();
				cesta.put(nombre, cantidad);
			}			
			entrada.nextLine();
		}while (continuar);
		
		System.out.println("Producto" + "\t" + "Precio" + "\t" + "Cantidad" + "\t" + "Subtotal" + "\n" + "---------------------------------------------------------");
		for (String s:cesta.keySet()) {
			subtotal = cesta.get(s) * productos.get(s);
			System.out.println(s + "\t" + "\t" + productos.get(s) + "\t" + cesta.get(s) + "\t" + "\t" + subtotal);
			total += subtotal;
		}
		if (desc.equalsIgnoreCase(DESCUENTO)) {
			descuento = total * 0.1;
			total -= descuento;
		}
		System.out.print("\n" + "---------------------------------------------------------" + "\n" + "Descuento: " + descuento + "\n" + "---------------------------------------------------------" + "\n" + "TOTAL: " + total);		
		
		
		//Creando la clase producto seria mas sencillo :)
		
		
		Ejercicio 1
		Tenemos un taller de reparación de coches y queremos realizar un programa con el que gestionar los coches que entran, salen y están en el taller.
		Los datos de cada coche que queremos registrar son: propietario, matricula, marca y si está reparado.
		Las opciones que queremos dar son:
		1.- Entrada nueva reparación: Se registran todos los datos del coche que se recepciona. Se recepciona como reparado = false
		2.- Salida de coche reparado: Se busca el coche en el taller por el nombre de propietario. Localizado el coche, se cambia a reparado = true y se entrega al propietario, saliendo del taller. En caso de haber más de un coche de ese propietario, se realiza con el primero que encuentre.
		3.- Listado de vehículos: Se listan todos los vehículos en el taller, mostrando todos los parámetros
		4.- Ordena los coches por marca y en caso de tener varios iguales, por matrícula en los iguales.
		5.- Ordena los coches por matrícula.
		6.- Salir: salir del programa		
		
		boolean continuar = true;
		int opcion;
		Coche c;
		
		do {
			String matricula = "", marca = "", propietario = "";
			Taller.showMenu();
			System.out.println("Opcion: ");
			opcion = entrada.nextInt();
			entrada.nextLine();
			
			switch (opcion) {
			case 1:
				System.out.println("Propietario:");
				propietario = entrada.nextLine();
				System.out.println("Matricula:");
				matricula = entrada.nextLine();
				System.out.println("Marca:");
				marca = entrada.nextLine();
				System.out.println("Los datos del coche son: propietario-" + propietario + " matricula-" + matricula + " marca-" + marca);
				
				c = new Coche(propietario, matricula, marca);
				Taller.carIn(c);
				break;
			case 2:
				System.out.println("Nombre del propietario del vehículo a sacar?: ");
				propietario = entrada.nextLine();
				Taller.carOut(Taller.findCoche(propietario));
				System.out.println("El coche ha salido del taller su estado reparado es: " );
				break;
			case 3:
				System.out.println(Taller.show());
				break;
			case 4:
				Taller.sortMarcaTaller();
				break;
			case 5:
				
				break;
			case 6:
				System.out.println("Fin del programa, adios!");
				continuar = false;
				break;
				
			}
			
		}while (continuar);
		 */
		
		/*Repaso
		Ejercicio 3
		Escribe un programa que contenga un método que acepte como
		parámetro una lista (ArrayList) de números enteros mayores
		que 0, pudiendo contener elementos duplicados. Implementa un método
		que sustituya cada valor repetido por 0. Para terminar, realiza un método
		que muestre el array modificado.
		Nota: Necesitarás otro método para rellenar la lista de enteros. Le irá
		pidiendo números al usuario hasta que este introduzca un número
		negativo.
		
		ArrayList<Integer> enteros = new ArrayList<Integer>();
		
		int tamanio = (int) (Math.random()*10);
		int entero = (int) (Math.random()*10);
		
		for (int i = 0; i < tamanio; i ++) {
			enteros.add(entero);
			entero = (int) (Math.random()*10);
		}
		
		for (int i:enteros) {
			System.out.print(i + "\t");
		}
			
		int aux;
		int contador;
		
		for (int i:enteros) {
			aux = i;
			contador = 0;
			for (int j = 0; j < enteros.size(); j++) {
				int numero = enteros.get(j);
				if (aux == numero) {
					contador++;
					if (contador > 1) {
						enteros.set(j, 0);
					}
				}
			}
		}
		
		System.out.println();
		for (int i:enteros) {
			System.out.print(i + "\t");
		}
		
		
		EJERCICIO 1
		Realiza un programa que escoja al azar 10 cartas de la baraja española (10 objetos de la clase
		Carta). Emplea un objeto de la clase ArrayList para almacenarlas y asegúrate de que no se
		repite ninguna. La clase Carta será:
		private static String[] n = {"as", "dos", "tres", "cuatro", "cinco",
		"seis", "siete", "sota", "caballo", "rey"};
		private static String[] p = {"bastos", "copas", "espadas", "oros"};
		private String numero;
		private String palo;
		public Carta() {
		this.numero = n[(int)(Math.random()*10)];
		this.palo = p[(int)(Math.random()*4)];
		}
		Incluye los métodos de los atributos número y palo. También sobrescribe el método toString y
		el método equals.
		
		EJERCICIO 2
		Modifica el programa anterior de tal forma que las cartas se muestren ordenadas. Primero se
		ordenarán por palo: bastos, copas, espadas, oros. Cuando coincida el palo, se ordenará por
		número: as, 2, 3, 4, 5, 6, 7, sota, caballo, rey.
		
		ArrayList<RepasoCarta> mano = new ArrayList<RepasoCarta>();
		int tamanioMano = 10;
		RepasoCarta c;
		
		for (int i = 0; i < tamanioMano; i++) {
			do {
				c = new RepasoCarta();
			}while (mano.contains(c));
			mano.add(c);
		}
		
		for (RepasoCarta e:mano) {
			System.out.println(e);
		}
		System.out.println();
		
		Collections.sort(mano);
		System.out.println("==========Mano ordenanda==========");
		for (RepasoCarta e:mano) {
			System.out.println(e);
		}
		
		
		EJERCICIO 9
		Crea un mini-diccionario español-inglés que contenga, al menos, 20 palabras (con su
		traducción). <p> Utiliza un objeto de la clase <code>HashMap</code> para almacenar las
		parejas de palabras. El programa pedirá una palabra en español y dará la correspondiente
		traducción en inglés.
		EJERCICIO 10
		Realiza un programa que escoja al azar 5 palabras en español del minidiccionario del ejercicio
		anterior. El programa irá pidiendo que el usuario teclee la traducción al inglés de cada una de
		las palabras y comprobará si son correctas. Al final, el programa deberá mostrar cuántas
		respuestas son válidas y cuántas erróneas. */
		
		HashMap<String, String> diccionario = new HashMap<String, String>();
		
		diccionario.put("Hola", "Hi");
		diccionario.put("Mano", "Hand");
		diccionario.put("Pie", "Foot");
		diccionario.put("Puño", "Fist");
		diccionario.put("Azul", "Blue");
		diccionario.put("Rojo", "Red");
		diccionario.put("Amarillo", "Yellow");
		diccionario.put("Adios", "Bye");
		
		boolean continuar = true;
		int opcion;
		
		do {
			System.out.println("==========MENU==========" + "\n" + "1. El programa traduce" + "\n" + "2. Yo traduzco" + "\n" + "3. Fin");
			opcion = entrada.nextInt();
			entrada.nextLine();
			
			switch(opcion) {
			case 1:
				Iterator<String> it;
				boolean traducir;
				
				do  {
					it = diccionario.keySet().iterator();
					traducir = true;
					System.out.println("Diccionario:");
					while (it.hasNext()) {
						System.out.print(it.next() + "\t");				
					}
					System.out.print("\n" + "Traductor: ");
					String respuesta = entrada.nextLine();
					if (respuesta.equalsIgnoreCase("fin")) {
						traducir = false;
					} else {
						System.out.println("La traduccion es: " + diccionario.get(respuesta));
					}				
				}while (traducir);
				break;
			case 2:
				int correctas = 0;
				int erroneas = 0;
				
				int palabras[] = new int[5];
				//POR AQUI
				
				break;
			case 3:
				System.out.println("Fin del programa, Adios!");
				continuar = false;
				break;
			}
		}while (continuar);
		
		
		
		
	}

}
