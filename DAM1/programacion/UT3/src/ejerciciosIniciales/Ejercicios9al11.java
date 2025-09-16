package ejerciciosIniciales;

public class Ejercicios9al11 {
	
	//Ej9
	public static String printPosition(String...str) {
		String position = "El número de parámetros recibidos es: " + str.length;
		for(int i = 0; i < str.length; i++) {
			position += "\n" + "Posición " + i +": " + str[i];
		}
		
		return position;
	}
	
	//Ej10
	public static double suma;
	public static void sumParam(int...i) {
		for (int h = 0; h < i.length; h++) {
			suma += i[h];
		}
	}
	
	public static double getSuma() {
		return suma;
	}

	//Ej11
	public static void sumParam(int i1, int i2, double... ds) {
		suma=i1 + i2;
		for(int h = 0; h < ds.length; h++) {
			suma +=  ds[h];
		}
	}
}
