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
		
		/*Ejercicio 5: El Detective del Hash: Accede a la web de CyberChef
		mencionada en los apuntes. Genera el hash SHA-256 de "Hola Mundo" y
		luego de "hola mundo" (en minúsculas). Observa la diferencia y explica
		cómo esta "sensibilidad extrema" ayuda a detectar si un archivo ha sido
		modificado por un atacante .*/
		
		//..
		
		/*Ejercicio 6: La Firma Inversa: La firma digital se define como "el mundo
		al revés" de la criptografía asimétrica. Escribe los 3 pasos para firmar un
		PDF y explica por qué el receptor necesita la clave pública del emisor
		para verificar que el documento es auténtico .*/
		
		// 1. Se genera un hash del PDF
		// 2. Se firma el hash con la clave privada.
		// 3. Se envia mensjae y firma.
		
		//Es necesaria la clave publica porque es la que permite descifrar la clave privada y viceversa.
		
		/*Ejercicio 7: El Guardián del Keystore: Imagina que programas una app
		que guarda tarjetas de crédito. Explica por qué es un error crítico dejar la
		clave de cifrado en una variable String dentro del código y describe cómo
		el archivo .jks (Keystore) soluciona este problema de seguridad.*/
		
		//Guardar la clave en el propio codigo la dejaria expuesta a cualquier atacante o usuario
		//El keystore es un baul seguro de claves que permite almacenar contraseñas de forma segura 
		
		/*Ejercicio 8: Análisis de la "Radiografía" SSL: Observa el comando
		openssl s_client del segundo PDF. Si al ejecutarlo ves un depth=0 con una
		fecha de NotAfter pasada, ¿qué le ocurriría al usuario que intenta entrar
		en esa web? . Identifica en el ejemplo cuál es el algoritmo simétrico que
		se usará para la transferencia masiva de datos una vez hecho el
		handshake .*/
		
		//Si el certificado esta caducado el navegador nos informara de que la conexion no es segura
		//Tras el handshake se utilizara el cifrado simetrico AES256
		
	}

}
