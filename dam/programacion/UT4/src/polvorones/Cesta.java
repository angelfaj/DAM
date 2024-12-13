package polvorones;

public class Cesta {
	//Atributos
	private static Polvoron cesta[][] = new Polvoron[2][3];
	private static final double VALORCESTA = 3.0;

	//Contructores
	
	//Metodos
	public static void addPolvoron(Polvoron polvoron) {
		boolean encontradoSabor = false, encontradoHueco = false;
		int fila = -1, columna = -1;
		
		for (int i = 0; i < cesta.length && !encontradoSabor; i++) {
			for (int j = 0; j < cesta[i].length && !encontradoSabor; j++) {		 
				if (cesta[i][j] == null && !encontradoHueco)  {
					fila = i;
					columna = j;
					encontradoHueco = true;
				}else if (cesta[i][j] != null) {
					Polvoron p = cesta[i][j];
					if (p.getSabor().equals(polvoron.getSabor())) {
						System.out.println("Ya existe un polvorón del mismo sabor en la cesta");
						encontradoSabor = true;
					}
				}
			}
		}
		if (encontradoHueco && !encontradoSabor) {
			cesta[fila][columna] = polvoron;
		}	
	}
	
	public static int[] searchPolvoron(Polvoron polvoron) {
		boolean flag = false;
		int posicion[] = {-1, -1};
		Polvoron p;
		
		for (int i = 0; i < cesta.length && !flag; i++) {
			for (int j = 0; j < cesta[i].length && !flag; j++) {
				if (cesta[i][j] != null) {
					p = cesta[i][j];
					if (p.getSabor().equals(polvoron.getSabor())) {
						posicion[0] = i;
						posicion[1] = j;
						flag = true;										//Estos bucle será mas apropiados con while ya que involucra una flag
					}
				}
			}
		}
		return posicion;
	}
	
	public static boolean deletePolvoron(Polvoron polvoron) {
		boolean flag = false;
		int pos[] = searchPolvoron(polvoron);
		
		if ((pos[0] > -1)) {
			cesta[pos[0]][pos[1]] = null;
			flag = true;
		}
	
		return flag;
	}
	
	public static boolean modifyPolvoron(Polvoron oldPol, Polvoron newPol) {
		boolean flag = false;
		int pos[] = searchPolvoron(oldPol);
		
		if ((pos[0] > -1)) {
			cesta[pos[0]][pos[1]] = newPol;
			flag = true;
		}
		
		return flag;
	}
	
	public static void showCesta() {
		System.out.println("\n" + "||||||||||||||||CESTA||||||||||||||||");
		for (int i = 0; i < cesta.length; i++) {
			for (int j = 0; j < cesta[i].length; j++) {
				if (cesta[i][j] == null) {
					cesta[i][j] = null;
					System.out.print(cesta[i][j] + "\t");
				} else {
					Polvoron p = cesta[i][j];
					System.out.print(p.getSabor() + "\t");					
				}
				}
			System.out.println();
			}
		System.out.println("|||||||||||||||||||||||||||||||||||||" + "\n");
	}
	
	public static double cestaPrice() {
		double total = 0;
		Polvoron p;
		
		for (int i = 0; i < cesta.length; i++) {
			for (int j = 0; j < cesta[i].length; j++) {
				if (cesta[i][j] != null) {
					p = cesta[i][j];
					total += p.getPrecio();
					}
				}
		}
		total += VALORCESTA;
		return total;
	}
	
	
}
