package ficherosTexto;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.StringTokenizer;

public abstract class Counter {
	public static int contarLineas(File f) {
		int nLines = 0;
		try (FileReader fr = new FileReader(f); BufferedReader bf = new BufferedReader(fr);){
			while ((bf.readLine()) != null) {
				nLines++;
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return nLines;
	}
	
	public static int contarCaracteres(File f) {
		int nChar = 0;
		try (FileReader fr = new FileReader(f)){
			while ((fr.read()) != -1) {
				nChar++;
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return nChar;
	}
	
	public static int contarPalabras(File f) {
		int nWords = 0;
		String line = "";
		
		try (FileReader fr = new FileReader(f); BufferedReader bf = new BufferedReader(fr);){
			while ((line = bf.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(line, " ");
				while(st.hasMoreElements()) {
					st.nextToken();
					nWords++;
				}
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return nWords;
	}
	
	public static String cadenaMax(File f) {
		String largest = "", aux = "", line;
		try (FileReader fr = new FileReader(f); BufferedReader bf = new BufferedReader(fr);){
			while ((line = bf.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(line, " ");
				while(st.hasMoreElements()) {
					aux = st.nextToken();
					if (aux.length() > largest.length()) {
						largest = aux;
					}
				}
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return largest;
	}
	
	public static int cuentaPalabra(File f, String word) {
		int nWord = 0;
		
		return nWord;
	}
	
	
	
	
}
