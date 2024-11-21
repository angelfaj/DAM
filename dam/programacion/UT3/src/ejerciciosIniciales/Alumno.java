package ejerciciosIniciales;

public class Alumno {
	
	//Atributos
	public int matricula, notaA1, notaA2, notaA3;
	public static int aprobados;
	
	//Constructores
	public Alumno(int mat, int a1, int a2, int a3) {
		matricula = mat;
		notaA1 = a1;
		notaA2 = a2;
		notaA3 = a3;
	}
	
	//Metodos
	public void calculaAprobados(Alumno... a1) {
		int media;
		for (int i = 0; i < a1.length; i++) {
			media = (a1[i].notaA1 + a1[i].notaA2 + a1[i].notaA3) / 3 ;
			if (media >= 5) {
				aprobados++;
			}
		}
	}
	
	public int getAprobados() {
		return aprobados;
	}
	
//	public static void calculaMedia(Alumno... a1) {
//			for (int i = 0; i < a1.length; i++) {				
//				media += (a1[i].notaA1 + a1[i].notaA2 + a1[i].notaA3) / 3 ;
//			}
//	}
	
//	public static String getMedias() {
////		int comparador = 10;
////		for (int i = 0; i < media.length(); i++) {
////			media.indexOf(i);
////		}
//		return media;
//	}
	@Override
	public String toString() {
		return "Alumno [matricula=" + matricula + ", notaA1=" + notaA1 + ", notaA2=" + notaA2 + ", notaA3=" + notaA3
				+ "]";
	}

}
