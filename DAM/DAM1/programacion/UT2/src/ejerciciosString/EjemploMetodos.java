package ejerciciosString;

public class EjemploMetodos {

	public static void main(String[] args) {
		// Utilizar cada metodo de string menos los que involucren arrays
		String conejo = "Los métodos (o funciones) son un tipo de instrucción que puede devolver (dar como resultado) un valor de un tipo de datos, y además pueden recibir varios valores para funcionar. Los valores que reciben los métodos se conocen como parámetros, y se escriben entre los paréntesis finales de la llamada al método método.";
		String mono = "";
		int rata = 69;
		char perro = 'p';

		System.out.println("lenght: " + conejo.length());
		System.out.println("charAt: " + conejo.charAt(10));
		System.out.println("equals: " + conejo.equals(mono));
		System.out.println("equalsIgnoreCase: " + conejo.equalsIgnoreCase(mono));
		System.out.println("contains: " + conejo.contains(mono));
		System.out.println("compareTo: " + conejo.compareTo(mono));
		System.out.println("substring: " + conejo.substring(4, 30));
		System.out.println("valueOf: " + String.valueOf(rata));
		System.out.println("replaceAll: " + conejo.replaceAll(mono, conejo));
		System.out.println("indexOf: " + conejo.indexOf(perro));
		System.out.println("startsWith: " + conejo.startsWith(mono));
		System.out.println("lastIndexOf: " + conejo.lastIndexOf(perro));
		System.out.println("endsWith: " + conejo.endsWith(mono));
		System.out.println("toLowerCase: " + conejo.toLowerCase());
		System.out.println("toUpperCase: " + conejo.toUpperCase());
	}

}
