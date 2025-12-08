package extra1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConversorMayusculas {

	public static void main(String[] args) {
		/*Crea dos programas Java:
		Programa hijo (EcoMayusculas.java)
		Debe leer líneas de texto desde la entrada estándar (System.in).
		Por cada línea recibida, devolver la misma línea en mayúsculas.
		Terminar cuando reciba la palabra "FIN".
		Programa padre (LanzadorEco.java)
		Debe lanzar el programa hijo con ProcessBuilder.
		Usar p.getOutputStream() para enviarle varias líneas de texto.
		Leer la respuesta del hijo con p.getInputStream() y mostrarla en consola.
		Enviar "FIN" al final para que el hijo termine.
		*/
		
		try (BufferedReader buf = new BufferedReader(new InputStreamReader(System.in))) {
			String line;
			boolean continuar = true;
			while ((line = buf.readLine()) != null && continuar) {
				if (line.equals("FIN")) {
					continuar = false;
				}else {
					System.out.println(line.toUpperCase());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
