package app;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainGestor {

	public static void main(String[] args) {
		//Directorio de trabajo
		File bin = new File("bin");
		
		//Comando y argumentos a ejecutar
		ProcessBuilder pbLanzamiento1 = new ProcessBuilder("java", "app.ProcesoClasificador", "42");
		ProcessBuilder pbLanzamiento2 = new ProcessBuilder("java", "app.ProcesoClasificador", "23");
		ProcessBuilder pbLanzamiento3 = new ProcessBuilder("java", "app.ProcesoClasificador", "Hola");
		
		//Asignamos el directorio de trabajo
		pbLanzamiento1.directory(bin);
		pbLanzamiento2.directory(bin);
		pbLanzamiento3.directory(bin);
		
		Process p1 = null, p2 = null, p3 = null;
		
		try {
			//Primer lanzamiento
			lanzarProceso(pbLanzamiento1, p1);
			//Segundo lanzamiento
			lanzarProceso(pbLanzamiento2, p2);
			//Tercer lanzamiento
			lanzarProceso(pbLanzamiento3, p3);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	private static void lanzarProceso(ProcessBuilder pb, Process p) throws IOException, InterruptedException {
		//Inicializamos el proceso para crear los bufer reader
		p = pb.start();
		
		//Aprovechamos el autoclosable de try
		//Capturamos la salida del proceso hijo y su flujo de errores
		try (BufferedReader bfSalida = new BufferedReader(new InputStreamReader(p.getInputStream()));
				BufferedReader bfError = new BufferedReader(new InputStreamReader(p.getErrorStream()))){
			
			//Imprimimos salida
			String salida;
			while((salida = bfSalida.readLine()) != null) {
				System.out.println("SALIDA HIJO: " + salida);
			}
			
			//Imprimimos errores
			String errores;
			while((errores = bfError.readLine()) != null) {
				System.out.println("ERROR HIJO: " + errores);
			}
			int exitCode1 = p.waitFor();
			//Breakpoint en la siguiente linea para comprobar el valor de retorno del proceso hijo 
			System.out.println("Código de salida del primer lanzamiento: " + exitCode1);
		}
	}
}
