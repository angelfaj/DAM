package ejerciciosIniciales;

public class Calcula {
	
	//Metodos
	public static int mayor(int... num) {
		int mayor = 0;
		int nuevoNum;
		for (int i = 0; i < num.length; i++) {
			nuevoNum = num[i];
			if (nuevoNum > mayor) {
				mayor = nuevoNum;
			}
		}
		return mayor;
	}
	
	public static float mayor(float... num) {
		float mayor = 0;
		float nuevoNum;
		for (int i = 0; i < num.length; i++) {
			nuevoNum = num[i];
			if (nuevoNum > mayor) {
				mayor = nuevoNum;
			}
		}
		return mayor;
	}
	
	public static int menor(int... num) {
		int menor = 10000000;
		int nuevoNum;
		for (int i = 0; i < num.length; i++) {
			nuevoNum = num[i];
			if (nuevoNum < menor) {
				menor = nuevoNum;
			}
		}
		return menor;
	}
	
	public static float menor(float... num) {
		float menor = 1000000;
		float nuevoNum;
		for (int i = 0; i < num.length; i++) {
			nuevoNum = num[i];
			if (nuevoNum < menor) {
				menor = nuevoNum;
			}
		}
		return menor;
	}
	
	public static String mayor(String... st) {
		String cadenaMayor = "";
		String nuevaCadena;
		for (int i = 0; i < st.length; i++) {
			nuevaCadena = st[i];
			if (nuevaCadena.compareToIgnoreCase(cadenaMayor) > 0) {
				cadenaMayor = nuevaCadena;
			}
		}
		return cadenaMayor;
	}
	
}
