package extra;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		/*
		 Matriz de 5 filas y 6 columnas, que contenga PCs simulando una clase, cada Pc tendra una IP asociada, una IP estara cmpuesta por un vector de tamaño 4 simulando los bytes de la misma.
		 Deberá contener los metodos:
		 	alta (ultimo hueco libre), baja, modificacion y consulta
		 */
		Scanner entrada = new Scanner(System.in);
		int op;
		boolean continuar = true;
		
		while (continuar) {
			System.out.print("\n" + "*****************MENU*****************" + "\n" + "1. Generar equipo" + "\n" + "2. Añadir equipo al aula" + "\n" + "3. Eliminar equipo del aula" + "\n" + "4. Modificar equipos en el aula" + "\n" + "5. Buscar un equipo en el aula" + "\n" + "6. Mostrar aula" + "\n" + "7. Terminar programa");
			op = entrada.nextInt();
			
			switch (op) {
			case 1:											//Generar 1 equipo.  o Varios de forma aleatoria 
				
				break;
			case 2:
				
				break;
			case 3:
				
				break;
			case 4:
				
				break;
			case 5:
				
				break;
			case 6:
				
				break;
			case 7:
				System.out.println("Adio!");
				continuar = false;
			}
		}
		entrada.close();
	
	}

}
