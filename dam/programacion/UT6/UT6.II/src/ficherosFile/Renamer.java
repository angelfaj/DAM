package ficherosFile;
import java.io.File;

public abstract class Renamer {	
	public static File auxFile;
	public static File auxFile2;
	public static String auxVector[];
	
	public static void renameAll(File file, String names[]) {	//Renombra el directorio y todo su contenido
		auxFile = new File(names[0]);
		file.renameTo(auxFile);
		file = new File(auxFile.getPath());	//file ahora apuntara a la nueva ruta
		
		auxVector = file.list();	//Volcamos el contenido de file en el vector
		
		for (int i = 0; i < auxVector.length; i++) {	
			auxFile = new File(auxVector[i]);	//Aqui volcaremos cada objeto que contenga la carpeta padre: carpetaPadre/objeto 
			auxFile2 = new File(names[i + 1]); //Sumamos 1 para evitar que tomme el valor de la carpeta padre alojado en names[0]
			auxFile.renameTo(auxFile2);
			
			
		}
	}
}
