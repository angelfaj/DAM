package ejerciciosArraysI;
import java.util.Arrays;
import java.util.Scanner;

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
		b) (opcional) Los nombres y apellidos no pueden estar repetidos.*/
		
		//Creamos los vectores
		String nombre[] = {"Lucia", "Patricia", "Laura", "Maria", "Andrea", "Diana", "Veronica", "Raquel", "Carla", "Marta"};
		String apellido1[] = {"Gómez", "Pérez", "Martínez", "López", "Sánchez", "Rodríguez", "Fernández", "García", "Martín", "Jiménez"};
		String apellido2[] = {"Torres", "Vázquez", "Ramírez", "Moreno", "Muñoz", "Hernández", "Díaz", "Álvarez", "Ruiz", "Domínguez"};
		
		String nombresApellidos[] = new String [30];	
		
		//Recogemos los tres vectores en uno solo
		System.arraycopy(nombre, 0, nombresApellidos, 0, 10);
		System.arraycopy(apellido1, 0, nombresApellidos, 10, 10);
		System.arraycopy(apellido2, 0, nombresApellidos, 20, 10);
			
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
			
			
	}

}
