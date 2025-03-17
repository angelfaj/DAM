package excepciones;

import java.util.Scanner;

import pimienta.MickyHerramienta;

public class Main {

	public static void main(String[] args) {
		/*
		Ejercicio 1
		Escribe	código para generar y capturar una excepción ArrayIndexOutOfBoundsException.
		
		
		int matriz[][] = new int[2][3];
		
		for (int i = 0; i < matriz.length; i ++) {
			for (int j = 0; j < matriz[i].length; j++) {
				matriz[i][j] = j;
			}
		}
		
		try {
			System.out.println(matriz[1][4]);
		}catch (ArrayIndexOutOfBoundsException a) {
			System.out.println(a);
		}
		
		
		
		Ejercicio 2
		Supongamos la siguiente clase:
		public class Ejemplo1 {
		public static void main(String[] args) {
		final int NUM = 5;
		int[] enteros = new int[NUM];
		int posicion = 0;
		Scanner teclado = new Scanner(System.in);
		int cont = 0;
		int divisor = 0;
		while (cont < NUM) {
		System.out.println("Introduce una posición del array:");
		posicion = Integer.parseInt(teclado.nextLine());
		System.out.println("Introduce un divisor:");
		divisor = Integer.parseInt(teclado.nextLine());
		enteros[posicion] = 100 / divisor;
		cont++;
		}
		System.out.println("El contenido del array de enteros es:");
		for (int valor : enteros) {
		System.out.println(valor);
		}
		}
		}
		Ejecuta el programa introduciendo:
		● La posición = 6 ¿Qué sucede?
		● El divisor=letra ¿Qué sucede?
		● El divisor=0 ¿Qué sucede?
		capturar
		unaModifica el código para que el programa capture las excepciones que se
		indican y muestre los correspondientes mensajes:
		● IndexOutOfBoundsException (array fuera de rango)
		● NumberFormatException (valor no entero)
		● ArithmeticException (division por 0)
		
		
		final int NUM = 5;
		int[] enteros = new int[NUM];
		int posicion = 0;
		Scanner teclado = new Scanner(System.in);
		int cont = 0;
		int divisor = 0;
		
		while (cont < NUM) {
			System.out.println("Introduce una posición del array:");
			posicion = Integer.parseInt(teclado.nextLine());
			System.out.println("Introduce un divisor:");
			try {
				divisor = Integer.parseInt(teclado.nextLine());
				enteros[posicion] = 100 / divisor;
			}catch (NumberFormatException e) {
				System.out.println("Valor no entero");
			}catch (IndexOutOfBoundsException e) {
				System.out.println("Array fuera de rango");
			}catch (ArithmeticException e) {
				System.out.println("Division por cero");
			}
			cont++;
		}
		System.out.println("El contenido del array de enteros es:");
		for (int valor : enteros) {
			System.out.println(valor);
		}
		
		teclado.close();

		Ejercicio 3
		Haz uso de la modularidad para modificar el ejercicio anterior, de forma
		que haya un método que muestre el contenido del array y otro que rellene
		el array y desde el main se llame a ambos.
		Dentro del método rellenaArray se lanzarán las excepciones de
		IndexOutOfBoundsException y ArithmeticException, las cuales serán
		capturadas en el método main. En el método se capturará la excepción
		NumberFormatException.
		
		final int NUM = 5;
		int vector[] = new int [NUM];
		try {
			Ejercicio3.fillVector(vector, NUM);
		}catch (IndexOutOfBoundsException e) {
			System.out.println("Array fuera de rango");
		}catch (ArithmeticException e) {
			System.out.println("Division por cero");
		}
		
		/*Ejercicio 4
		Intenta adivinar la salida por pantalla que produciría el siguiente
		programa:
			class Ejercicio4 {
				
			
					public static int devuelveNumero(int num) {
						try {
							if (num % 2 == 0) {
								throw new Exception("Lanzando excepción");
							}
							return 1;
						} catch (Exception ex) {
							return 2;
						} finally {
							return 3;
						}
					}
			}
			System.out.println(devuelveNumero(1));
			//FIN ENUNCIADO
		
		System.out.println("Ya que no se genera ninguna excepcion debería devolver 1, sin embargo devuelve 3 porque finally pasa a la pila de memoria y debido a su naturaleza se ejecuta siempre, por otro lado como un metodo no puede devolver dos return el que se encuentra dentro de finally sobreescribe al anterior");
	
		/*
		Ejercicio 5
		Indica qué se mostrará por pantalla cuando se ejecute cada una de estas
		clases (una vez lo hayas pensado bien ejecuta su código en Eclipse para
		comprobarlo):
			a. 
				class Uno{
						private static int metodo() {
							int valor = 0;
							try {
								valor += 1;
								valor += Integer.parseInt("42");
								valor += 1;
							}catch (NumberFormatException e) {
								valor += Integer.parseInt("42");
							}finally {
								valor += 1;
								System.out.println("Valor al final de finally: " + valor);
							}
							valor += 1;
							System.out.println("Valor antes del return: " + valor);
							return valor;
						}				
					}
				 
					try {
						System.out.println(metodo());
					}catch(Exception e) {
						System.err.println("Excepcion en metodo()");
						e.printStackTrace();
					}
					
			b.
				class Dos{
				    private static int metodo(){
				        int valor=0;
				        try{
				            valor = valor +1;
				            valor = valor + Integer.parseInt("W");
				            valor = valor + 1;
				            System.out.println("Valor al final del try : " + valor);
				        }catch(NumberFormatException e){
				            valor = valor + Integer.parseInt("42");
				            System.out.println("Valor al final del catch : " + valor);
				        }finally{
				            valor = valor + 1;
				            System.out.println("Valor al final de finally : " + valor);
				        }
				        valor = valor + 1;
				        System.out.println("Valor antes del return : " + valor);
				        return valor;
				    }
				
				    public static void main(String[] args){
				        try{
				            System.out.println(metodo());
				        }catch(Exception e){
				            System.err.println("Excepcion en metodo()");
				            e.printStackTrace();
				        }
				    }
				}

			c. 
				class Tres{
				    private static int metodo(){
				        int valor=0;
				        try{
				            valor = valor +1;
				            valor = valor + Integer.parseInt("W");
				            valor = valor + 1;
				            System.out.println("Valor al final del try : " + valor);
				        }catch(NumberFormatException e){
				            valor = valor + Integer.parseInt("W");
				            System.out.println("Valor al final del catch : " + valor);
				        }finally{
				            valor = valor + 1;
				            System.out.println("Valor al final de finally : " + valor);
				        }
				        valor = valor + 1;
				        System.out.println("Valor antes del return : " + valor);
				        return valor;
				    }
				
				    public static void main(String[] args){
				        try{
				            System.out.println(metodo());
				        }catch(Exception e){
				            System.err.println("Excepcion en metodo()");
				            e.printStackTrace();
				        }
				    }
				}

			d.
				class Cuatro{
				    private static int metodo(){
				        int valor=0;
				        try{
				            valor = valor +1;
				            valor = valor + Integer.parseInt("W");
				            valor = valor + 1;
				            System.out.println("Valor al final del try : " + valor);
				            throw new IOException();
				        }catch(IOException e){
				            valor = valor + Integer.parseInt("42");
				            System.out.println("Valor al final del catch : " + valor);
				        }finally{
				            valor = valor + 1;
				            System.out.println("Valor al final de finally : " + valor);
				        }
				        valor = valor + 1;
				        System.out.println("Valor antes del return : " + valor);
				        return valor;
				    }
				
				    public static void main(String[] args){
				        try{
				            System.out.println(metodo());
				        }catch(Exception e){
				            System.err.println("Excepcion en metodo()");
				            e.printStackTrace();
				        }
				    }
				}
			Fin del enunciado
		
		System.out.println("A devolverá 46 sin generar ninguna excepcion. B devolverá");

		
		Ejercicio 7
		Crea tu propia clase de excepción utilizando la palabra clave extends.
		Dicha clase tendrá como atributo un String. Escribe un constructor para
		dicha clase que tome un argumento String. Escribe un método que
		muestre la cadena de caracteres almacenada. Crea una
		cláusula try-catch para probar la nueva excepción. 
		
		
		try {
			throw new NuevaExcepcion("El cielo esta enladrillado quien lo desenladrillara el desenladrillador que lo desenladrille buen desenladrillador sera.");
		}catch (NuevaExcepcion n) {
			System.out.println(n);
		}
		
		
		
		Ejercicio 8
		Crea una clase Alumno con los atributos: nombre, edad y nota. Y el
		siguiente constructor, que deberá lanzar una excepción propia cuando la
		edad sea inferior a 0 (EdadNoValidaException con su propio mensaje de
		error).
		public Alumno(String nombre, int edad) ...
		La clase tendrá los siguientes métodos:
		●
		●
		●
		●
		public float getNota()
		public void setNota(float nota)
		public String getNombre()
		public int getEdad()
		El método setNota, no deberá asignar notas inferiores a 0 o superiores a
		10, y se protegerá lanzando una excepción cuando la nota sea errónea
		(NotaNoValidaException, con su propio mensaje de error).
		Crea una clase con un método main que lea desde teclado un array de 5
		alumnos con sus notas y posteriormente muestre la información de cada
		uno de ellos. Se deberán capturar todas las excepciones que se pudieran
		generar y mostrar los mensajes correspondientes a cada tipo de
		excepción.
		
		
		Alumno aula[] = new Alumno[5];
		
		try{
			aula[0] = new Alumno("MARIA", 30);
			aula[1] = new Alumno("RAMON", 31);
			aula[2] = new Alumno("PAULA", 24);
			aula[3] = new Alumno("MARTA", 20);
			aula[4] = new Alumno("PACO", 36);
			aula[0].setEdad(-1);
		} catch (EdadNoValidaException e) {
			System.out.println(e);
		}
		
		try {
			aula[1].setNota(-3);
		}catch (NotaNoValidaException n) {
			System.out.println(n);
		}
		
		
		6.
		Implementa una clase Gato con los atributos nombre y edad, un constructor
		con parámetros, los getters y setters, además de un método imprimir() para mostrar
		los datos de un gato. El nombre de un gato debe tener al menos 3 caracteres y la edad
		no puede ser negativa. Por ello, tanto en el constructor como en los setters, deberás
		comprobar que los valores sean válidos y lanzar una ‘Exception’ si no lo son. Luego, haz
		una clase principal con main para hacer pruebas: instancia varios objetos Gato y utiliza
		sus setters, probando distintos valores (algunos válidos y otros incorrectos). Maneja las
		excepciones.
		7.
		Crea una copia del programa anterior y modifica el main para hacer lo
		siguiente:
		 Crea un Array de 5 gatos. Luego, utilizando un bucle, pide al usuario que
		introduzca los datos de 5 gatos: utiliza un Scanner para pedir los datos, instancia
		el objeto y guárdalo en el array. Por último, imprime la información de los gatos.
		 Maneja las posibles excepciones de modo que en el array sólo almacenemos
		objetos Gato válidos y el bucle se repita hasta crear y almacenar correctamente
		5 gatos.*/
		
		
		Gato vectorGatos[] = new Gato[5];
		boolean vectorCorrecto = false;
		Scanner entrada = new Scanner(System.in);
		int edad, i = 0;
		String nombre;
		
		do {
			System.out.println("Introduce el nombre del gato " + i + ": ");
			nombre = entrada.nextLine();
			System.out.println("Introduce la edad del gato " + i + ": ");
			edad = entrada.nextInt();
			entrada.nextLine();
			
			try {
				vectorGatos[i] = new Gato(nombre, edad);	//Si el nomb
				vectorGatos[i].imprimir();
				i++;
			} catch (NombreGatoException n) {
				System.out.println(n);
			}catch (EdadNoValidaException e) {
				System.out.println(e);
			}
			
			if (i == vectorGatos.length) {
				vectorCorrecto = true;
			}
		}while(!vectorCorrecto);
		
		entrada.close();
		
		
		
		
	//Fin main
	}
}
