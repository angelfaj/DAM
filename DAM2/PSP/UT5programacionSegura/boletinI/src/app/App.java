package app;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		/*Ejercicio 1: El Validador Robusto: Modifica el ejemplo de la página 1 .
		Crea un pequeño programa que pida una "Matrícula" (4 números y 3
		letras). Si el usuario introduce más caracteres de los permitidos o
		símbolos extraños, el programa debe lanzar un mensaje de error
		personalizado en lugar de fallar, evitando un posible desbordamiento o
		error lógico .*/
		
//		Scanner sc = new Scanner(System.in);
//		String regex = "^\\d{4}[A-Z]{3}$";
//		
//		System.out.print("Introduce una matricula: ");
//		if (sc.hasNext(regex)) {
//			String matricula = sc.next(regex);
//			System.out.println("Matricula valida");
//		}else {
//			System.out.println("Matricula no valida");
//		}
//		
//		sc.close();
		
		/*Ejercicio 2: Role Play (RBAC): Basándote en la analogía del Chef y el
		Camarero , dibuja un esquema rápido o escribe el pseudocódigo de un
		CallbackHandler que solicite no solo el usuario, sino también un "Código
		de Rol" (ADMIN o USER). Si el rol es USER, intenta invocar un método
		ficticio borrarBaseDeDatos() y explica por qué JAAS debería impedirlo
		basándose en sus Principals .*/

		
		/*Ejercicio 3: Elección de Algoritmo: Se te pide proteger:
		A) Una película de 2GB y
		B) Un mensaje de WhatsApp de 10 palabras.
		Indica qué tipo de criptografía usarías para cada uno (Simétrica o
		Asimétrica) y justifica por qué, mencionando la velocidad de AES y el
		problema de la distribución de claves .*/
		
		// A)Para una pelicula de 2GB elegiria cifrado simétrico, ya que es menos probable que tengas que compartirla y el usuario ya conoce la clave
		// B)Para mensajería es mas adecuada la criptografía asimetrica ya que garantiza que solo el receptor pueda recibir el mensaje.
		
		
		/*Ejercicio 4: El Candado de la Clave Pública: Explica paso a paso
		(usando el diagrama de la página 5 como referencia) qué claves
		intervienen si "Juan" quiere enviar un mensaje secreto a "María" . ¿Qué
		clave usa Juan para cifrar? ¿Qué pasaría si Juan pierde su propia clave
		privada en este proceso?*/ 
		
		// Juan utilizará la clave pública de María para cifrar el mensaje. Si Juan perdiese su clave privada no podría recibir mensajes cifrados de María.
	}

}
