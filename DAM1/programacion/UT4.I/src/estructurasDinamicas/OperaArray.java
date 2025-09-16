package estructurasDinamicas;
import java.util.ArrayList;
import java.util.Scanner;

public class OperaArray {
	//Atributos
	private ArrayList<Integer> listaEnteros;
	
	//Constructores
	public OperaArray () {
		listaEnteros = new ArrayList<Integer>();
	}
	
	//Metodos
	public void fillArray() {
		Scanner entrada = new Scanner(System.in);
		boolean continuar = true;
		int numero = 1, i = 0;
		
		while (continuar & (numero > 0)) {
			System.out.println("Introduce un numero (un numero < 0 para terminar el programa)");
			numero = entrada.nextInt();
			if (numero <= 0) {
				continuar = false;
			} else {
				listaEnteros.add(i, numero);
			}
			i++;
		}
		entrada.close();
		
	}
	
	public void verifyArray() {
		int i = 0, j = 0;
		
		while (i < listaEnteros.size()) {		//Busqueda de repes
			int comparador = listaEnteros.get(i);
			
			while (j < listaEnteros.size()) {
				if (comparador == listaEnteros.get(j) & j != i & listaEnteros.get(j) != 0 ) {
					listaEnteros.set(j, 0);
				}
				j++;
			}
			j = 0;
			i++;
		}
	}
	
	@Override
	public String toString() {
		String resul = "[";
		for (int i:listaEnteros) { 
			resul+= " " + i + ",";
		}
		resul += "]";
		return resul;
	}
	
	
	
	

}
