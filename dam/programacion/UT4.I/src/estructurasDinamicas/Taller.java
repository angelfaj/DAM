package estructurasDinamicas;
import java.util.ArrayList;
import java.util.Collections;

public class Taller {
	//Atributos
	private static ArrayList<Coche> taller = new ArrayList<Coche>();
	
	//Metodos
	public static void showMenu() {
		System.out.println("*********************** MENÚ TALLER ***********************" + "\n" + "1. Entrada nueva reparacion" + "\n" + "2. Salida de coche" + "\n" + "3. Listado vehiculos" + "\n" + "4. Ordenar por marca y en su defecto por matricula" + "\n" + "5. Ordenar por matricula" + "\n" + "6. Salir del programa");
	}
	
	public static void carIn(Coche c) {
		taller.add(c);
	}
	
	public static void carOut(Coche c) {
		c.setReparado(true);
		taller.remove(c);
	}
	
	public static void sortMarcaTaller() {
		Collections.sort(taller);
	}
	
	public static void sortMatriculaTaller() {
//		Collections.sort(taller);
	}
	
	public static String show() {
		String mensaje = "[ ";
		for (Coche c:taller) {
			mensaje += c.getMarca() + ":" + c.getMatricula() + ":" + c.getPropietario() + ":" + "reparado=" + c.isReparado() + " - ";
		}
		mensaje += " ]";
		return mensaje;
	}
	
	public static Coche findCoche(String propietario) {
		Coche c = null;
		boolean encontrado = false;
		int i = -1;
		while (!encontrado && i < taller.size()) {
			i++;
			if (taller.get(i).getPropietario().equalsIgnoreCase(propietario)) {
				encontrado = true;
				c = taller.get(i);
			}
		}
		return c;
	}

}
