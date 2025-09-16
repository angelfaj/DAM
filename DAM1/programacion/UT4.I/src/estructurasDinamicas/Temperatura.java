package estructurasDinamicas;
import java.util.ArrayList;

public class Temperatura {
	//Atributos
	private static ArrayList<Double> listaTemperaturas = new ArrayList<Double>();
	
	//Constructores
	
	
	//Metodos
	public static void addTemp(double d) {
		listaTemperaturas.add(d);
	}
	
	public static ArrayList<Double> getListaTemperaturas() {
		return listaTemperaturas;
	}

	public static double showAverage() {
		double average = 0;
		for (double d:listaTemperaturas) {
			average += d;
		}
		average /= listaTemperaturas.size();
		return average;
	}
	
	public static ArrayList<Double> showExtreme() {		//+40 y -20
		ArrayList<Double> extreme = new ArrayList<Double>();
		for (double i : listaTemperaturas) {
			if (i <= -20 | i >= 40) {
				extreme.add(i);
			}
		}
		return extreme;
	}
	
	
	public static int searchTemp(double d) {
		int pos = -1, i = 0;
		boolean continuar = true;
		
		while (i < listaTemperaturas.size() & continuar)
			if (listaTemperaturas.get(i) == d) {
				pos = i;
				continuar = false;
		}
		return pos;
	}
	
	public static void deleteTemp(double d) {
		int pos = searchTemp(d);
		if (pos >= 0) {
			listaTemperaturas.remove(pos);
		}
	}
	
	public static void showMenu() {
		System.out.println("*****************MENU TEMPERATURA*****************" + "\n" + "1. Añadir temperatura" + "\n" + "2. Mostrar temperatra media" + "\n" + "3. Mostrar temperaturas extremas" + "\n" + "4. Mostrar la lista de temperaturas" + "\n" + "5. Busca la temperatura y muestra su posición" + "\n" + "6. Borrar la temperatura" + "\n" + "7. Salir");
	}
}
