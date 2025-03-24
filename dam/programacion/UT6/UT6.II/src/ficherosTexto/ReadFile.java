package ficherosTexto;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public abstract class ReadFile {
	public static BufferedReader bufferedReader;
	public static int i;
	public static char caracter;
	public static String linea, cadena;
	
	public static void printContentByChar(FileReader fr) throws FileNotFoundException, IOException {
		while ((i = fr.read()) != -1) {
			caracter = (char) i;
			System.out.print(caracter);
		}
	}

	public static void printContentByCharConvertingSize(FileReader fr) throws FileNotFoundException, IOException {
		while ((i = fr.read()) != -1) {
			if (i == 10 || i == 32) {		//Ignoro los espacios y saltos de linea
				caracter = (char) i;	
			}
			else if (i < 97) {				//Convierto a minusculas
				caracter = (char) (i + 32);	
			}else {
				caracter = (char) (i - 32);	//Convierto a mayusculas
			}
			System.out.print(caracter);
		}
	}
	
	public static void printContentByCharWithOutSpaces(FileReader fr) throws FileNotFoundException, IOException {
		while ((i = fr.read()) != -1) {
			caracter = (char) i;
			if (caracter != ' ') {
				System.out.print(caracter);
			}
		}
	}

	public static void printContentByLine(FileReader fr) throws FileNotFoundException, IOException {
		bufferedReader = new BufferedReader(fr);
		
		while ((linea = bufferedReader.readLine()) != null) {
			System.out.println(linea);
		}
	}
	
	public static String readContent(FileReader fr) throws IOException {
		bufferedReader = new BufferedReader(fr);
		cadena = "";
		while ((linea = bufferedReader.readLine()) != null) {
			cadena += linea; 
		}
		return cadena;
	}
	
	
	public static File fileMerge(File file1, File file2) throws IOException {
		File combFile = new File(file1.getName() + "_" + file2.getName() + ".txt");
		
		if (combFile.exists()) {	//Lo borramos y creamos de cero en caso de que existiese
			combFile.delete();
			combFile.createNewFile();
		}
		
		return combFile;
		
	}
}
