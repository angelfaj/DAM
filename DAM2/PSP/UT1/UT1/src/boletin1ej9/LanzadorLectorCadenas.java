package boletin1ej9;

import java.io.File;
import java.io.IOException;

public class LanzadorLectorCadenas {

	public static void main(String[] args) {

		File errorFile = new File("errorE09.txt");
		File salidaFile = new File("salidaE09.txt");
		File bin = new File("bin");
		
		ProcessBuilder pb = new ProcessBuilder("java", "boletin1ej9.LectorCadenas");
		pb.directory(bin);
		pb.redirectError(ProcessBuilder.Redirect.appendTo(errorFile));
		pb.redirectOutput(ProcessBuilder.Redirect.appendTo(salidaFile));
		
		try {
			Process p = pb.start();
			int exitCode = p.waitFor();
			System.out.println("Codigo de salida " + exitCode);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
