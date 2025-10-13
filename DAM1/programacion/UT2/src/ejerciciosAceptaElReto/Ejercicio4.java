package ejerciciosAceptaElReto;
import java.util.Scanner;

public class Ejercicio4 {

	public static void main(String[] args) {
		/*A mí no me asusta el fin del mundo; me asusta el fin de mes, porque no siempre consigo que mis ingresos lleguen conmigo. Los gastos se acumulan, y no sé qué más hacer para estirar mi triste sueldo.
		Creo que el primer paso para mejorar mi situación es hacer una estimación de lo bien o lo mal que me va a ir un mes, en función de los ingresos y los gastos previstos. Sé cuánto dinero tengo en el banco al principio, y sé cuánto va a variar. ¿Me ayudas a saber si llegaré a fin de mes con dinero en el banco?La entrada comienza con un número que indica cuántos casos de prueba vendrán a continuación. Cada caso contiene dos números, −10.000 ≤ s,c ≤ 10.000 indicando, respectivamente, el saldo en mi cuenta bancaria el primer día del mes, y el cambio estimado (ingresos menos gastos) durante el mes.Para cada caso de prueba, se escribirá "SI" si llego a fin de mes con saldo mayor o igual que cero, y "NO" en otro caso.*/
		
		Scanner entrada = new Scanner (System.in);
		int numeroCasos, caso, parteUno, parteDos;
		String resultado = "";
		
		System.out.printf("\nPor favor introduce el número de casos: ");
		numeroCasos = entrada.nextInt();
		
		for (int i = 0; i < numeroCasos; i++) {
			System.out.printf("\nCaso: ");
			parteUno = entrada.nextInt();
			parteDos = entrada.nextInt();
			
			caso = parteUno + parteDos;
		
			if (caso >= 0 ) {
				resultado += "\n" + "SI";
			} else {
				resultado += "\n" + "NO";
			}
			parteUno = 0;
			parteDos = 0;
		}
		entrada.close();
		System.out.println(resultado);
		
	}

}
