package app;

import java.io.File;
import java.io.IOException;

public class MainRedireccionamiento {

	public static void main(String[] args) {
		// Debe lanzar un ls y redireccionar salida y errores a sus respectivos archivos
		
		//Creamos los archivos donde redireccionaremos los flujos
		File salidaEstandarFile = new File("listado_inicial.log");
		File salidaErrorFile = new File("log_errores.err");
		
		//Establecemos el comando a ejecutar
		ProcessBuilder pb = new ProcessBuilder("ls");
		//Redirigimos salidas, to -> sobreescribre. appendTo -> añade
		pb.redirectOutput(ProcessBuilder.Redirect.to(salidaEstandarFile));
		pb.redirectError(ProcessBuilder.Redirect.appendTo(salidaErrorFile));
		
		//Declaramos el proceso
		Process p;
		
		try {
			//Lanzamos el proceso y lo guardamos en nuestra variable process
			p = pb.start();
			
			//Capturamos el código de salida para imprimirlo después
			int exitCode = p.waitFor();
			//Breakpoint en la siguiente linea para comprobar el valor de retorno del proceso hijo
			System.out.println("Proceso finalizado, código de salida: " + exitCode);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
