package extra;

public class Aula {
	//Atributos
	private Equipo aula[][] = new Equipo[5][6];
		
	//Metodos 
	public void addPc(Equipo e) {					//alta (ultimo hueco libre)
		int lastI = 0, lastJ = 0;
		for (int i = 0; i < aula.length; i++) {
			for (int j = 0; j < aula[i].length; j++) {
				if (aula[i][j] == null) {
					lastI = i;
					lastJ = j;
				}
			}
		}
		aula[lastI][lastJ] = e;
	}
	
	public void removePc(Equipo e) {
		int posicion[] = selectPc(e);
		aula[posicion[0]][posicion[1]] = null;
	}
	
	public void modifyPc(Equipo e, Equipo f) {
		int posicion[] = selectPc(e);
		aula[posicion[0]][posicion[1]] = f;
	}
	
	public int[] selectPc(Equipo e) {
		boolean continuar = true;
		int i = 0, j = 0;
		int posicion [] = new int [2];
		while (i < aula.length & continuar) {
			while (j < aula[i].length & continuar) {
				if (aula[i][j] != null & aula[i][j] == e) {
					posicion[0] = i;
					posicion[1] = j;
					continuar = false;
				}
				j++;
			}
			i++;
		}
		return posicion;
	}
	
	public void showAula() {
		for (int i = 0; i < aula.length; i++) {
			for (int j = 0; j < aula[i].length; j++) {
				System.out.print(aula[i][j] + "\t");
			}
			System.out.println();
		}
	}
}
