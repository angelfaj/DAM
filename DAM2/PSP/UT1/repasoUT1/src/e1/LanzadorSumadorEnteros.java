package e1;

import java.io.File;
import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;

public class LanzadorSumadorEnteros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File dirTrabajo = new File("bin");
		File errores = new File("errores.txt");
		
		ProcessBuilder pb = new ProcessBuilder("java", "e1.SumadorEnteros", "4", "9");
		pb.directory(dirTrabajo);
		pb.redirectError(errores);
		pb.redirectOutput(Redirect.INHERIT);
		
		Process p = null;
		try {
			p = pb.start();
			int erroCode = p.waitFor();
			System.out.println("Codigo de error " + erroCode);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
