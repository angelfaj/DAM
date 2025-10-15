package extra1;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Scanner;

public class LanzadorConversorMayusculas {

	public static void main(String[] args) {
	    File bin = new File("bin");
	    ProcessBuilder pb = new ProcessBuilder("java", "extra1.ConversorMayusculas");
	    pb.directory(bin);

	    try {
	        Process p = pb.start();

	        try (OutputStream os = p.getOutputStream();
	             InputStream is = p.getInputStream();
	             Scanner sc = new Scanner(System.in)) {

	            BufferedReader br = new BufferedReader(new InputStreamReader(is));

	            boolean continuar = true;
	            while (continuar) {
	                System.out.print("Introduce una cadena (FIN para finalizar): ");
	                String entrada = sc.nextLine();

	                os.write((entrada + "\n").getBytes());
	                os.flush();

	                if (entrada.equals("FIN")) {
	                    continuar = false;
	                    break;
	                }

	                // Lee la respuesta de una línea
	                String respuesta = br.readLine(); //Aqui no debemos hacer un bucle de lectura con while != null ya que readLine() devuelve null solo cuando el hijo termina y este no terminara hasta que introduzacamos FIN, por lo tanto nuestro proceso padre se quedaria esperando eternamente
	                System.out.println("Respuesta del hijo: " + respuesta);
	            }
	        }

	        int exit = p.waitFor();
	        System.out.println("Código de salida: " + exit);

	    } catch (IOException | InterruptedException e) {
	        e.printStackTrace();
	    }
	}


}
