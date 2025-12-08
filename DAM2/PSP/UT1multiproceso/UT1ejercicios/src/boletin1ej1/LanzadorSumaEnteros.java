package boletin1ej1;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class LanzadorSumaEnteros {

	public static void main(String[] args) {
		File directorio = new File("bin");
		ProcessBuilder pb = new ProcessBuilder("java", "boletin1ej1.SumaEnteros", "5", "1");
		
		pb.directory(directorio);
		
		System.out.println("Dir de de trabajo " + pb.directory().getAbsolutePath());
		try {
			Process p = pb.start();
			InputStream is = p.getInputStream();
			int c;
			while ((c = is.read()) != -1) {
				System.out.print((char) c);
			}
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
