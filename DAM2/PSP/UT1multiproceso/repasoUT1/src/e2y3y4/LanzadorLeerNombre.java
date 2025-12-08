package e2y3y4;

import java.io.File;
import java.lang.ProcessBuilder.Redirect;

public class LanzadorLeerNombre {

	public static void main(String[] args) {
		File dir = new File("bin");
		File errores = new File("errores.txt");
		
		ProcessBuilder pb = new ProcessBuilder("java", "e2y3y4.LeerNombre", "Bravo");
		pb.directory(dir);
		pb.redirectError(errores);
		pb.redirectOutput(Redirect.INHERIT);
		
		//Una ejecucion
		Process p = null;
		try {
			p = pb.start();
			int error = p.waitFor();
			System.out.println("Codigo de error: " + error);
		}catch (Exception e) {
			e.printStackTrace();
		}
		//Probando cosas
		String[] nombres = {"Ana", "Carlos", "María", "Juan", "Lucía", "Pedro", "Sofía", "Miguel", "Elena", "Diego"};

		try {
			for (int i = 0; i < nombres.length; i++) {
				pb.command("java", "e2y3y4.LeerNombre", nombres[i]);
				p = pb.start();
				int error = p.waitFor();
				System.out.println("Codigo de error: " + error);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
