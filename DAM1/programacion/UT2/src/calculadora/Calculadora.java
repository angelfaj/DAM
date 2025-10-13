package calculadora;
import java.util.Scanner;

public class Calculadora {

	public static void main(String[] args) {
		/*Hacer una calculadora que sume, reste, multiplique y divida*/
		
		Scanner entrada = new Scanner(System.in);
		int valor = 0, acumulador= 0;
		String operador = "";
		
		
		
		while (!operador.equals("#")) {
			System.out.printf("\nValor: ");
			valor = entrada.nextInt();
			entrada.nextLine();
			
			System.out.printf("\nOperador: ");
			operador = entrada.nextLine();
			
						
			switch (operador) {
				case "+":
					acumulador += valor;
					break;
				case "-":
					acumulador -= valor;
					break;
				case "*":
					acumulador *= valor;
					break;
				case "/":
					acumulador /= valor;
					break;
				case "#":
					break;
			}
		}
		System.out.println("Total: " + acumulador);
		
		
	}

}
