package ejerciciosWhile;
import java.util.Scanner;

public class Ejercicio7 {

	public static void main(String[] args) {
		/*Realiza un programa que pinte una pirámide por pantalla. La altura se debe pedir por teclado.
		El carácter con el que se pinta la pirámide también se debe pedir por teclado.*/
	
		
		Scanner entrada = new Scanner(System.in);
		
		int altura, contadorFilas, contadorEspaciosMin, contadorEspaciosMax, contadorColorMin, contadorColorMax;
		String color;
		
		System.out.printf("Por favor introduce la altura de la pirámide: ");
		altura = entrada.nextInt();
		contadorEspaciosMax = altura - 1;
		
		System.out.printf("\nPor favor introduce el simbolo para rellenar: ");
		color = entrada.next();
		entrada.close();
		
		contadorFilas = 0;
		contadorColorMax = 1;
		System.out.println();
		
		while (contadorFilas != altura) {									//Este while se asegura de imprimir la altura solicitada
			contadorEspaciosMin = 0;
			while (contadorEspaciosMin != contadorEspaciosMax) {			//Este while imprime los espacios necesarios x cada linea
				System.out.printf(" ");
				contadorEspaciosMin++;
			}
			contadorColorMin = 0;
			while (contadorColorMin != contadorColorMax) {					//Este while imprime los signos necesarios x cada linea
				System.out.printf(color);
				contadorColorMin++;
			}
			System.out.printf("\n");
			contadorEspaciosMax--;
			contadorColorMax += 2;
			contadorFilas++;
		}
	}
}
//GG EZ