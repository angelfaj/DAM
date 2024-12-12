package ejerciciosArraysI;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random; 

public class Main {

	public static void main(String[] args) {
		/*Hacer un programa que almacene en un vector de 5 elementos las ventas anuales de cada una
		de las 5 tiendas de una cadena de supermercados (asignárselos al vector al declararlo). A
		continuación calcular cuál fue la tienda que menos vendió, cuál fue la que más vendió y el
		importe total de ventas de las 5 tiendas.
		
		double ventas[] = {500056.34, 306578.43, 566666.78, 306578.43, 566666.78};
		double mayor = ventas[0], menor = ventas [0], suma = 0;
		
		for (int i = 0; i < ventas.length; i++) {
		
			if (ventas[i] < menor) {
				menor = ventas[i];
			}
			if (ventas[i] > mayor) {
				mayor = ventas[i];
			}
			suma += ventas[i];
		}
		
		System.out.println("La tienda que menos vendio fue: " + menor);
		System.out.println("La tienda que mas vendio fue: " + mayor);
		System.out.println("La suma total de las ventas es: " + suma);

		
		/*Almacenar en un vector 5 numeros enteros leidos por teclado. Leer a continuación otro
		número y comprobar si está en el vector o no. En el caso de que esté visualizar que posición
		ocupa; sino indicarlo mediante un mensaje. Visualizar tambien el elemento más pequeño, el
		más grande y la posición de ambos.
		
		Scanner entrada = new Scanner(System.in);
		int numeros[] = new int[5], ultimoNumero = -1; 
		boolean vuelta = false, flag = false;							//flag sirve para saber si ha encontrado coincidencia con el ultimo numero
		int mayor = numeros[0], menor = 1000000000, posMenor = 0, posMayor = -1;
		String mensaje = "";
		
		for (int i = 0; i < numeros.length; i++) {
			int posicion = i;
			
			if (vuelta == false) {										//Evitamos que en el segundo ciclo entre de nuevo
				System.out.println("Introduce un numero: ");
				numeros[i] = entrada.nextInt();
				
				if (numeros[i] < menor) {
					menor = numeros[i];
					posMenor = i;
				}
				if (numeros[i] > mayor) {
					mayor = numeros[i];
					posMayor = i;
				}
			}
			
			if (ultimoNumero == numeros[i]) {							//Aqui guardamos la posicion en caso de encontrarlo
				mensaje = "El numero " + ultimoNumero + " ya se encuentra en el vector en la posición " + posicion;
				flag = true;
			}
			
			if ((i == (numeros.length - 1)) && (vuelta == false)){			//Entra aqui al teerminar la primera ejecucion del for y lo reinicia
				System.out.println("Introduce el ULTIMO numero: ");
				ultimoNumero = entrada.nextInt();
				i = -1;
				vuelta = true;
			}
		}
		entrada.close();
		
		if (flag == false) {
			mensaje = "El numero " + ultimoNumero + " NO se encuentra en el vector";
		}
		mensaje += "\n" + "El menor de los elementos es: " + menor + " y su posicion es " + posMenor + ", el mayor de los elementos es: " + mayor + " y su posicion " + posMayor;
		System.out.println(mensaje);
		
		
		
		/*Diseñar una clase de nombre Test que nos permita representar una pregunta tipo test, la cual
		estará compuesta de un enunciado, cuatro posibles respuestas y la respuesta correcta. Estas
		tres propiedades privadas de la clase tendrán los nombres:
		- Número de pregunta (int)
		- enunciado.
		- opciones. Array de 4 strings.
		- valida. De tipo carácter. Guarda cual es la respuesta correcta
		La clase tiene que implementar los métodos siguientes:
		- setNumero, setEnunciado, setOpciones, setValida que asignarán cada uno de ellos lo valores
		de cada una de las propiedades.
		- getNumero, getEnunciado, getValida, getOpciones que devuelven de manera respectiva cada
		una de las tres propiedades de la clase.
		- Método de nombre presenta, que escribe de manera adecuada en pantalla la pregunta, y las
		cuatro posibles respuestas, precedidas de las letras a, b, c, d.
		Comprobar el funcionamiento de la clase Test declarando dos objetos de dicha clase, y evaluar
		el funcionamiento de los métodos definidos.
		
		String opciones[] = {"Se levantará descansado", "Se levantará cansado", "No se levantará", "Comerá arroz"};
		Test tema1 = new Test(1, "Si Adriano no respeta los ciclos del sueño que ocurrirá: ", opciones, 'B');
		Scanner entrada = new Scanner(System.in);
		char respuesta;
		
		tema1.presenta();
		System.out.println("Por favor introduce tu respuesta: ");
		respuesta = entrada.next().charAt(0);
		
		if (respuesta == tema1.getCorrecta()) {
			System.out.println("Acertaste");
		} else {
			System.out.println("Has fallado");
		}
		
		/*Hacer un programa en el que se declare un vector de 10 datos de tipo Test, asignándole valores
		al declararlo. Plantear a continuación un examen con las 5 preguntas almacenadas en el vector
		seleccionándolas de manera aleatoria y sin que haya preguntas repetidas. Se visualizará el
		número de preguntas acertadas y falladas.
		
		//Esto lo omito con el for de la clase test
		String opciones1[] = {"Se sentirá motivado", "Se sentirá desmotivado", "Tendrá hambre", "Estará aburrido"};
		Test tema1 = new Test(1, "¿Qué sentirá Juan después de hacer ejercicio?", opciones1, 'B');

		String opciones2[] = {"Se divertirá", "Se enojará", "Se cansará", "Se quedará dormido"};
		Test tema2 = new Test(2, "¿Qué hará Pedro después de correr?", opciones2, 'C');

		String opciones3[] = {"Gozará de buena salud", "Estará estresado", "Dormirá más tarde", "Estará más productivo"};
		Test tema3 = new Test(3, "¿Qué beneficios se esperan si Ana duerme 8 horas?", opciones3, 'A');

		String opciones4[] = {"Tendrá más energía", "Se sentirá cansado", "Se distraerá fácilmente", "No hará nada"};
		Test tema4 = new Test(4, "¿Qué efecto tendrá el café en Luis?", opciones4, 'A');

		String opciones5[] = {"Se olvidará de todo", "Recordará lo que estudió", "Se distraerá con música", "No aprenderá nada"};
		Test tema5 = new Test(5, "¿Qué pasará si María estudia la noche anterior al examen?", opciones5, 'B');

		String opciones6[] = {"Le dolerá la cabeza", "Estará relajado", "Tendrá hambre", "Sentirá calor"};
		Test tema6 = new Test(6, "¿Qué pasará si Juan no toma suficiente agua?", opciones6, 'A');

		String opciones7[] = {"Será muy puntual", "Llegará tarde", "Se olvidará del lugar", "Se sentirá nervioso"};
		Test tema7 = new Test(7, "¿Qué pasará si Roberto no se prepara para su presentación?", opciones7, 'B');

		String opciones8[] = {"Se despertará temprano", "Se quedará dormido", "Tendrá pesadillas", "Se despertará varias veces"};
		Test tema8 = new Test(8, "¿Qué pasará si una persona tiene insomnio?", opciones8, 'C');

		String opciones9[] = {"El clima será soleado", "Lloverá todo el día", "Habrá tormenta", "Estará nublado"};
		Test tema9 = new Test(9, "¿Qué se espera para el clima mañana?", opciones9, 'D');

		String opciones10[] = {"Se hará amigo de todos", "Se sentirá incómodo", "Tendrá éxito", "Se aburrirá"};
		Test tema10 = new Test(10, "¿Qué hará Pedro en la fiesta?", opciones10, 'A');
		
		Test muestrario[] = {tema1, tema2, tema3, tema4, tema5, tema6, tema7, tema8, tema9, tema10};
		
		System.out.println(tema1.toString());
		
		INCOMPLETO
		 */
		
		/*Hacer un programa en el que se declaren 3 vectores de nombres: nombre, apellido1 y
		apellido2, que tengan cada uno de ellos 10 nombres y 10 apellidos, dándole valores al
		declararlos sin que haya valores repetidos.
		Declarar otro vector de nombre nombresApellidos de longitud 30, que contenga el contenido
		de los 3 vectores anteriores. Primero irán los nombres y después los apellidos. Asignarle
		valores a este vector utilizando el método arrayCopy.
		a) Escribir a continuación el nombre y apellidos de 5 personas, eligiendo aleatoriamente los
		valores de los vectores nombre, apellido1 y apellido2. Estos 5 valores tienen que almacenarse
		previamente en un vector de 5 Strings de nombre nombresCompletos. Escribir los nombres
		ordenados alfabéticamente
		a) Repetir el apartado a) eligiendo los valores del vector nombresApellidos.
		b) (opcional) Los nombres y apellidos no pueden estar repetidos
		
		//Creamos los vectores
		String nombre[] = {"Lucia", "Patricia", "Laura", "Maria", "Andrea", "Diana", "Veronica", "Raquel", "Carla", "Marta"};
		String apellido1[] = {"Gómez", "Pérez", "Martínez", "López", "Sánchez", "Rodríguez", "Fernández", "García", "Martín", "Jiménez"};
		String apellido2[] = {"Torres", "Vázquez", "Ramírez", "Moreno", "Muñoz", "Hernández", "Díaz", "Álvarez", "Ruiz", "Domínguez"};
		
		String nombresApellidos[] = new String [30];	
		
		//Recogemos los tres vectores en uno solo
		System.arraycopy(nombre, 0, nombresApellidos, 0, nombre.length);
		System.arraycopy(apellido1, 0, nombresApellidos, nombre.length, nombre.length);
		System.arraycopy(apellido2, 0, nombresApellidos, (nombre.length + apellido1.length), nombre.length);
			
		String nombreCompleto[] = new String[5];
		
		
		//Sacamos valores aleatorios y los eliminamos del vector para conseguir nombres unicos
			for (int i = 0; i < nombreCompleto.length; i++) {
				int b = 0;
				
				do {
					int c = (int)(Math.random()*10);
					b = c;
				} while (nombre[b] == null || apellido1[b] == null || apellido2[b] == null);
				
				String fullName = nombre[b] + " " + apellido1[b] + " " + apellido2[b];
				nombre[b] = null;
				apellido1[b] = null;
				apellido2[b] = null;
				nombreCompleto[i] = fullName;
			}
		
		//Ordenamos e imprimimos
		Arrays.sort(nombreCompleto);
		 for (String s:nombreCompleto) {
			 System.out.println(s);
		 }
		.*/
		
		
		/*Asignarle a un vector 100 valores de tipo entero comprendidos entre 1 y 200. Leer por teclado
		un número y comprobar si coincide con alguno de los elementos del vector. Utilizar el método
		binarySearch
		
		Scanner entrada = new Scanner(System.in);
		int num;
		int hundred[] = new int[100];

		
		
		for (int i = 0; i < hundred.length; i++) {
			int c = -1;
			do {
				c = (int)(Math.random()*hundred.length);
				Arrays.sort(hundred);
			} while (Arrays.binarySearch(hundred, c) >= 0);			//Revisar por que guarda ceros al principio
			hundred[i] = c;				
		}
			

		System.out.println("introduce un numero: ");
		num = entrada.nextInt();
		entrada.close();
		
		if (Arrays.binarySearch(hundred, num) >= 0) {
			System.out.println("El numero introducido SI se encuentra en el vector");
		}else System.out.println("El numero introducido NO se encuentra en el vector");
		
		for (int n : hundred) {
			System.out.println(n);
		}
		
		Hacer un programa en el que se declare una matriz de dimensiones 5 x 8 (5 filas y 8 columnas)
		de datos de tipo entero. Asignarle a los elementos de la matriz valores generados al azar y
		comprendidos entre 20 y 40. Recorrer a continuación la matriz y escribir en pantalla el valor de
		sus elementos.Calcular cuál es el elemento mas pequeño y mayor de la tabla.
		Escribir también la tabla para comprobar los resultados. La salida tiene que tener el formato:
		Elemento menor: XX Fila: XX Columna: XX
		Elemento mayor: XX Fila: XX Columna: XX
		
		int FILAS = 5;
		int COLUMNAS = 8;
		int matriz[][] = new int[FILAS][COLUMNAS];
		int posMenor[] = new int[2];
		int posMayor[] = new int[2];
		Random r = new Random();
		int mayor = 0, menor = 100;
		
		
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				int num = r.nextInt(20) + 20;
				matriz[i][j] = num;
			}
		}
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				System.out.print(matriz[i][j] + " ");
			}
			System.out.println();
		}
		
		
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				if (matriz[i][j] < menor) {
					menor = matriz[i][j];
					posMenor[0] = i;
					posMenor[1] = j;
				}
				if (matriz[i][j] > mayor) {
					mayor = matriz[i][j];
					posMayor[0] = i;
					posMayor[1] = j;
				}
			}
		}
		
		System.out.println("MENOR: " + menor + "\t" + "Fila: " + posMenor[0] + "\t" + "Columna: " + posMenor[1] + "\n" + "MAYOR: " + mayor + "\t" + "Fila: " + posMayor[0] + "\t" + "Columna: " + posMayor[1] + "\n");
		
		
		Hacer un programa que genere y escriba una matriz unitaria de orden 10. Una matriz unitaria
		de orden 10 es una matriz de 10x10 en la que todos los elementos valen 0, excepto los de la
		diagonal principal que valen 1. La diagonal principal es la que va de la esquina superior
		izquierda a la inferior derecha
		
		int unitaria[][] = new int[10][10];
		
		for (int i = 0; i < unitaria.length; i++) {
			for (int j = 0; j < unitaria[i].length; j++) {
				if (i == j) {
					unitaria[i][j] = 1;					
				} else {
					unitaria[i][j] = 0;
				}
			}
		}
		for (int i = 0; i < unitaria.length; i++) {
			for (int j = 0; j < unitaria[i].length; j++) {
				System.out.print(unitaria[i][j] + " ");
			}
			System.out.println();
		}
		Hacer un programa que averigüe si una matriz cuadrada de orden 4 es simétrica. Una matriz es
		simétrica cuando a[f][c]=a[c][f] para cualquier elemento de la matriz.
		
		int cuadrada[][] = new int[4][4];
		boolean flag = false;
		
		for (int i = 0; i < cuadrada.length; i++) {
			for (int j = 0; j < cuadrada[i].length; j++) {
				if (i == j) {
					cuadrada[i][j] = 1;					
				} else {
					cuadrada[i][j] = 0;
				}
				if (cuadrada[i][j] != cuadrada[j][i]) {
					flag = true;
				}
				System.out.print(cuadrada[i][j] + " ");
			}
			System.out.println();
		}
				
		if (flag == true) {
			System.out.println("La matriz no es simetrica");
		}else {
			System.out.println("La matriz es simetrica");
		}
		
		
		EJ 12-13
		Hacer un programa que asigne números a una matriz de orden 4x5 comprendidos entre 1 y 10.
		El programa tiene que escribir la suma de los elementos de cada fila y la suma de los números
		que son pares de cada columna con el formato siguiente:
		suma de los elementos de la fila 0 --> XX
		suma de los elementos de la fila 1 --> XX
		.................................................................
		suma de los elementos de la fila 3 --> XX
		-----------------------------------------
		suma de los elementos pares de la columna 0 --> XX
		suma de los elementos pares de la columna 1 --> XX
		.....................................................................................
		suma de los elementos pares de la columna 4 --> XX 
		
		int matriz[][] = new int[4][5];
		Random r = new Random();
		int sumaFila[] = new int[4];
		int sumaColumna[] = new int[5];
		
		//Asignamos valores a nuestra matriz
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				matriz[i][j] = r.nextInt(10) + 1;
				System.out.print(matriz[i][j] + "\t");
				
				switch (i) {							//Sumamos las filas
				case 0:
					sumaFila[i] += matriz[i][j];
					break;
				case 1:
					sumaFila[i] += matriz[i][j];
					break;
				case 2:
					sumaFila[i] += matriz[i][j];
					break;
				case 3:
					sumaFila[i] += matriz[i][j];
					break;			
				
				}
				if (matriz[i][j] % 2 == 0) {			//Sumamos los valores pares de las columnas. J almacena el valor de cada columna en su lugar correspondiente y los va sumando 
					sumaColumna[j] += matriz[i][j];					
				}
			}
			
			System.out.println();
		}
		
		//Imprimo los resultados
		for (int i = 0; i < sumaFila.length; i++) {
			System.out.println("Suma fila " + i + ": " + sumaFila[i]);
			
		}
		for (int i = 0; i < sumaColumna.length; i++) {
			System.out.println("Suma de elementos pares de la columna " + i + ": " + sumaColumna[i]);
		}
		 
		 
		EJ 14:
		Hacer un programa que genere e imprima un cuadrado latino de orden 10 (matriz 10x10). Un
		cuadradado latino de orden n es aquel en el que la primera fila tiene los no naturales del 1 a n,
		y cada una de las filas restantes de la matriz es igual a su fila superior desplazada una posicion
		hacia la derecha, entrando por la izquierda el número que se pierde en el desplazamiento. Por
		ejemplo, un cuadrado latino de orden 5 es:
		
		1	2	3	4	5		 
		5	1	2	3	4
		4	5	1	2	3
		3	4	5	1	2
		2	3	4	5	1
		
		
		int cuadradoLatino[][] = new int [10][10];
		int numero = 1, ultimoValor = -1;				//Numero contemplará valores del 1-10, al llegar al 10 empezará en 1.
		
		System.out.println();
		for (int i = 0; i < cuadradoLatino.length; i++) {
			for (int j = 0; j < cuadradoLatino[i].length; j++, numero++) {
				if ( i != 0 ) {							//Entramos cuando se ha impreso la primera fila
					if ( j == 0 ) {						//Comenzamos la fila con el ultimo valor de la anterior
						numero = ultimoValor;
						cuadradoLatino[i][j] = numero;
					}
					if (numero > cuadradoLatino.length) { 		//Si llegamos al 10 reseteamos el numero
						numero = 1;
						cuadradoLatino[i][j] = numero;
					}else								//Si no, seguimos imprimiendo valores
						cuadradoLatino[i][j] = numero;
				} else {								//Imprimimos la primera fila
					cuadradoLatino[i][j] = numero;					
				}
				ultimoValor = numero;					//Actualizamos el ultimo valor
				System.out.print(cuadradoLatino[i][j] + "\t");
			}
			System.out.println();
		}
		

		
	
	Realiza un ejercicio que haga lo siguiente:

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
	
	System.out.println("Introduce un numero para continuar");
	while (bucleActivo == 0) {
		System.out.println("*****************MENÚ CESTA*****************" + "\r" + "¿Qué deseas hacer?" +"\r" + "1- Añadir" + "\r" + "2- Buscar" + "\r" + "3- Eliminar" + "\r" + "4- Modificar" + "\r" + "5- Mostrar");
		opcion = entrada.nextInt();
		
		switch (opcion) {
		case 1:

			break;
		case 2:
			
			break;
		case 3:
			
			break;
		case 4:
			
			break;
		}
	}
	
		
		
	//FIN CLASE MAIN
	}

}

