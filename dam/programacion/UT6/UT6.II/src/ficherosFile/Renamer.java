package ficherosFile;
import java.io.File;
import java.util.StringTokenizer;

public abstract class Renamer {	
	public static File auxFile;
	public static File auxFile2;
	public static String auxVector[];
	public static String auxVector2[];
	
	public static void renameAll(File parentFile, String names[]) {	//Renombra el directorio y todo su contenido
		auxFile = new File(names[0]);
		parentFile.renameTo(auxFile);
		parentFile = new File(auxFile.getPath());	//parentFile ahora apuntara a la nueva ruta
		auxVector = parentFile.list();	//Volcamos el contenido de file en el vector
		
		for (int i = 0; i < auxVector.length; i++) {	
			auxFile = new File(parentFile, auxVector[i]);	//Aqui volcaremos cada objeto que contenga la carpeta padre: carpetaPadre/objeto 
			auxFile2 = new File(parentFile, names[i + 1]); //Sumamos 1 para evitar que tomme el valor de la carpeta padre alojado en names[0]
			auxFile.renameTo(auxFile2);			//Lo renombramos 
			
			auxFile = new File(auxFile2.getPath());	// dir/dir
			System.out.println(auxFile.getPath());
			
			renameAllFile(auxFile);
			
			
		}
	}
	
	public static void renameAllFile(File lastFile) {
		auxVector2 = lastFile.list();	//Volcamos el contenido de cada dir dentro de auxVector2
		
		for (int j = 0; j < auxVector2.length; j++) {
			auxFile2 =new File(lastFile.getPath(), auxVector2[j]); //auxFile2 contendra los archivos con extension
			
			StringTokenizer tokenizer = new StringTokenizer(auxFile2.getName(), ".");
			File aux20 = new File(lastFile.getPath(), tokenizer.nextToken());
			auxFile2.renameTo(aux20);
			
		}
		
	}
	
	
	
}
