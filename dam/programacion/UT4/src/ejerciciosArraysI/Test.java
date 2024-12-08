package ejerciciosArraysI;

import java.util.Arrays;

public class Test {
	//Atributos
	private int nPregunta;
	private String enunciado;
	private String opciones[] = new String[4];
	private char correcta;
	
	//Constructores
	public Test() {
		
	}
	
	public Test(int numero, String enunciado, String opciones[], char correcta) {
		nPregunta = numero;
		this.enunciado = enunciado;
		for (int i = 0; i < opciones.length; i++) {			//De esta forma creamos una copia, si los igualamos directamente ambos apuntaran a la misma celda de memoria!!!
			this.opciones[i] = opciones[i];
		}
		this.correcta = correcta;
	}
	

	//Metodos
	public int getnPregunta() {
		return nPregunta;
	}

	public void setnPregunta(int nPregunta) {
		this.nPregunta = nPregunta;
	}

	public String getEnunciado() {
		return enunciado;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}

	public String[] getOpciones() {
		return opciones;
	}

	public void setOpciones(String[] opciones) {
		this.opciones = opciones;
	}

	public char getCorrecta() {
		return correcta;
	}

	public void setCorrecta(char correcta) {
		this.correcta = correcta;
	}
	
	public void presenta() {
		String op1 = "", op2 = "", op3 = "", op4 = "";
		for (int i = 0; i < opciones.length; i++) {
			switch (i) {
			case 0:
				op1 = opciones[i];
				break;
			case 1:
				op2 = opciones[i];	
				break;
			case 2:
				op3 = opciones[i];	
				break;
			case 3:
				op4 = opciones[i];
				break;
			}
		}
		String presenta = this.getnPregunta() + " " + this.getEnunciado() + "\n" + "\tA. " + op1 + "\n" + "\tB. " + op2 + "\n" + "\tC. " + op3 + "\n" + "\tC. " + op4;
		System.out.println(presenta);
	}
	
	/*
	public String presenta(Test t[]) {					//la idea es que coja de forma aleatoria 5 objetos del array 
		int numeroTotalPreguntas = 5;					//posteriormente imprimir en orden dichos objetos
		Test p1, p2, p3, p4, p5;						//objetos temporales para almacenar las preguntas que incluire en el examen
		//Cambiar la linea superior por
		Test bateriaPreg[];
		for (int i = 0; i < 10; i++) {
			bateriaPreg[i] = new Test(); 
		}
		//y me ahorro crear cada objeto en el main, al estar dentro de un array no necesitan un nombre
		
		for (int i = 0; i < numeroTotalPreguntas; i++) {
			int r = (int)(Math.random()*5) + 1;
			
			switch (i) {
			case 0:
				p1 = t[r];
				break;
			case 1:
				p2 = t[r];	
				break;
			case 2:
				p3 = t[r];	
				break;
			case 3:
				p4 = t[r];
				break;
			case 4:
				p5 = t[r];
			}
			
		}
		return "";										//Aqui debo copiar el return del otro metodo
	}
*/

	@Override
	public String toString() {
		return "Test \n" + nPregunta + ". " + enunciado + "\n" + Arrays.toString(opciones)
				;
	}
	
	

}





























