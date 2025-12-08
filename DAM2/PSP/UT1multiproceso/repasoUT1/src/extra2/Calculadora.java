package extra2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Calculadora {

	public static void main(String[] args) {
		/*
		🧩 Ejercicio: Calculadora entre procesos
		📘 Descripción
		Vas a crear dos programas Java que se comuniquen entre sí:
		un lanzador (padre) y una calculadora (hijo).
		🧠 Objetivo
		El padre enviará operaciones aritméticas en texto al hijo, y el hijo devolverá el resultado numérico.
		La comunicación debe hacerse usando p.getOutputStream() y p.getInputStream().
		Cada línea tendrá una operación simple, por ejemplo: 5 + 6
		Si recibe "FIN", termina.
		Si recibe una operación válida, evalúa y escribe el resultado en la salida estándar.
		Si la operación es inválida, escribe "ERROR".
		*/
		
		try(BufferedReader buff = new BufferedReader(new InputStreamReader(System.in))) {
			String entrada;
			boolean continuar = true;
			while ((entrada = buff.readLine()) != null && continuar) {
				if (entrada.equals("FIN")) {
					continuar = false;
				}else {
					String[] operacion = entrada.split(" ");
					if (operacion.length != 3 ) {
						System.out.println("ERROR - El formato introducido es invalido");
					}else {
						int n1 = 0, n2 = 0;
						String operador = operacion[1];
						
						try {
							n1 = Integer.parseInt(operacion[0]);
							n2 = Integer.parseInt(operacion[2]);
						}catch (NumberFormatException e) {
							System.out.println("ERROR - El formato introducido es invalido");
						}
						
						double resultado = 0.0;
						switch (operador) {
						case "+":
							resultado = n1 + n2;
							break;
						case "-":
							resultado = n1 - n2;
							break;
						case "*":
							resultado = n1 * n2;
							break;
						case "/":
							resultado = n1 / n2;
							break;
						}
						System.out.println("Resultado: " + resultado);
					}
				}
			}
			System.exit(0);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
