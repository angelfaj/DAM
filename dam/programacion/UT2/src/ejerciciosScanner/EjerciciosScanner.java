package ejerciciosScanner;

import java.util.Scanner;


public class EjerciciosScanner {

	public static void main(String[] args) {
		//11,10,7,8
		
		/*Ejercicio 11:Escribe un programa que solicite la conversión de KB a MB.1MB son
		1024KB.
		Scanner entrada = new Scanner(System.in);
		float $valor, $resultado;
		final float $KILOBITES = 1024;
		
		System.out.println("Introduce el valor en KB que deseas convertir a MB: ");
		$valor = entrada.nextFloat();
		
		$resultado = $valor / $KILOBITES;
		System.out.println("Son "+$resultado+" MB");
		entrada.close();*/
		
		/*Ejercicio 10:Escribe un programa que solicite la conversión de MB a KB.1MB son
		1024KB.
		Scanner entrada = new Scanner(System.in);
		float $valor, $resultado;
		final float $KILOBITES = 1024;
		
		System.out.println("Introduce el valor en MB que deseas convertir a KB: ");
		$valor = entrada.nextFloat();
		
		$resultado = $valor * $KILOBITES;
		System.out.println("Son "+$resultado+" KB");
		entrada.close(); //Cerramos el scanner*/
		
		/*Ejercicio 7:Calcular una factura a partir de introducir la base imponible. Pide por
		teclado la base imponible y aplícale el 21% de IVA. Muestra el resultado con 2
		decimales.
		double $baseImponible, $total = 0, $ivaSum;
		final double IVA = 0.21;
		
		
		Scanner entrada = new Scanner(System.in);
		System.out.printf("\nFactura: "+"\nIntroduce la base imponible: ");
		$baseImponible = entrada.nextDouble();
		$ivaSum = $baseImponible * IVA; 
		$total = $baseImponible + $ivaSum;
		System.out.printf("El total de tu factura es: %.2f",$total);
		entrada.close();*/
		
		
		/*Ejercicio 8:Escribe un programa que calcule el salario semanal de un empleado
		en base a las horas trabajadas, a razón de 12 euros la hora. Pide por teclado el
		número de horas que ha trabajado esa semana y muestra el salario semanal con 2
		decimales.*/
		
		double $horas, $salario;
		final double PRECIOHORA = 12;
		
		Scanner entrada = new Scanner(System.in);
		System.out.println("Introduce el número de horas trabajadas esta semana: ");
		$horas = entrada.nextDouble();
		$salario = $horas * PRECIOHORA;
		System.out.println("Tu salario semanal equivale a: "+$salario);
		entrada.close();
	}

}
