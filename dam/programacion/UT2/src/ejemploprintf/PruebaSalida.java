package ejemploprintf;

public class PruebaSalida {

	public static void main(String[] args) {
		//Prueba del funcionamiento de printf
		//%f = decimal
		//%d = entero
		//%s = string 
		
		//Mostrar el número 12.3698 de tipo double con dos decimales
		System.out.printf("%.2f %n", 12.3698);
		
		//Mostrar la cadena "Total:" con un ancho de 10 caracteres y alineada a la izquierda:
		System.out.printf("%-10s", "Total:");
		
		//Mostrar 4.56 con un ancho de 40 caracteres y dos decimales
		System.out.printf("%d", 456);
		
		
		//IMPORTANTE: al concatenar con + se convierte todo en un uńico argumento
		String miTexto="Hola que tal";
		double n=12.4;
		int x=56;
		System.out.printf("Mi decimal es: %.2f"+"Mi entero es: %d"+"Mi cadena es: %s",n,x,miTexto);
		
	}

}
