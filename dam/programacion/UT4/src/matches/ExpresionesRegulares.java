package matches;

public class ExpresionesRegulares {

	public static void main(String[] args) {
		/*
		Ejercicio 1: Verificar si una cadena contiene solo dígitos
		Descripción: Escribe un método que verifique si una cadena contiene solo números.
		
		Ejercicio 2: Validar una dirección de correo electrónico
		Descripción: Verifica si una cadena tiene el formato de un correo electrónico.
		
		Ejercicio 3: Comprobar si una cadena contiene solo letras mayúsculas
		Descripción: Escribe un método para verificar si una cadena tiene solo letras en
		mayúscula.
		
		Ejercicio 4: Validar un número de teléfono (10 dígitos)
		Descripción: Verifica si un número tiene exactamente 10 dígitos.
		
		Ejercicio 5: Verificar si una cadena es una fecha válida en formato DD/MM/YYYY
		Descripción: Asegúrate de que la cadena represente una fecha válida.
		
		Ejercicio 6: Verificar si una cadena contiene solo letras y espacios
		Descripción: Permite solo letras y espacios.
		
		Ejercicio 7: Validar una dirección IPv4
		Descripción: Verifica si una cadena es una dirección IPv4 válida.
		
		Ejercicio 8: Verificar si una cadena es un código postal válido
		Descripción: Los códigos postales deben ser de 5 dígitos.
		
		Ejercicio 9: Validar un identificador alfanumérico
		Descripción: Debe contener letras y números, pero no caracteres especiales.
		
		Ejercicio 10: Validar un nombre de usuarioDescripción: Un nombre de usuario debe tener entre 3 y 15 caracteres, y solo
		contener letras, números o guiones bajos.
		
		Ejercicio 11: Verificar si una cadena contiene solo caracteres hexadecimales
		Descripción: Asegúrate de que contenga caracteres del 0 al 9 o de la A a la F.
		
		Ejercicio 12: Verificar si una cadena empieza con una vocal
		Descripción: Comprueba si la cadena comienza con una vocal.
		
		Ejercicio 13: Validar un número en formato decimal
		Descripción: Verifica si una cadena representa un número decimal.
		
		Ejercicio 14: Verificar si una cadena contiene una palabra específica
		Descripción: Comprueba si la palabra "Java" está en la cadena.
		
		Ejercicio 15: Validar un color hexadecimal
		Descripción: Los colores hexadecimales comienzan con # y tienen 6 caracteres
		hexadecimales.
		
		Ejercicio 16: Validar una matrícula de coche
		Descripción: Las matrículas tienen 4 números del 0 al 9 seguidos de guión ‘-‘ y
		después 3 letras en mayúsculas.
		 */
		
		String cadena = "1234-ABC";; 
		//Ej 1
		System.out.println("Ejercicio 1: " + cadena.matches("\\d{1,}"));

		//Ej 2
		System.out.println("Ejercicio 2: " + cadena.matches("[a-z | A-Z | 0-9]*[@][a-z | A-Z | 0-9]*[.][a-z | A-Z]*")); //Las expresiones regulares se evaluan caracter a caracter, por tanto [a-z] daria true solo si la cadena es un unico caracter, para evaluar una cadena con mas caracteres seria necesario el *
	
		//Ej 3
		System.out.println("Ejercicio 3: " + cadena.matches("[A-Z]+"));
		
		//Ej 4
		System.out.println("Ejercicio 4: " + cadena.matches("\\d{10}"));
		
		//Ej 5
		System.out.println("Ejercicio 5: " + cadena.matches("[0-3]?[0-9][/][0-1]?[0-9][/]\\d{4}"));		//En las fechas seria mas adecuado utilizar 3[0-1] que significa que el 3 solo puede utilizarse seguido de un 0 o un 1
		
		//Ej 6
		System.out.println("Ejercicio 6: " + cadena.matches("[a-z | A-Z | \\s]*"));
		
		//Ej 7
		System.out.println("Ejercicio 7: " + cadena.matches("\\d{1,4}[.]\\d{1,4}[.]\\d{1,4}[.]\\d{1,4}"));
		
		//Ej 8
		System.out.println("Ejercicio 8: " + cadena.matches("\\d{5}"));
		
		//Ej 9
		System.out.println("Ejercicio 9: " + cadena.matches("\\w*"));
		
		//Ej 10
		System.out.println("Ejercicio 10: " + cadena.matches("\\w{3,15}"));
		
		//Ej 11
		System.out.println("Ejercicio 11: " + cadena.matches("[0-9 | A-F]*"));
		
		//Ej 12
		System.out.println("Ejercicio 12: " + cadena.matches("[a | e | i | o | u].*"));
		
		//Ej 13
		System.out.println("Ejercicio 13: " + cadena.matches("[0-9]*"));
		
		//Ej 14
		System.out.println("Ejercicio 14: " + cadena.matches(".*[Java].*"));
		
		//Ej 15
		System.out.println("Ejercicio 15: " + cadena.matches("[#][0-9 | A-F]{6}"));
		
		//Ej 16
		System.out.println("Ejercicio 16: " + cadena.matches("[0-9]{4}[-][A-Z]{3}"));
	
	}

}
