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
		Aula a1 = new Aula();
		Equipo e = new Equipo();
		
		while (continuar) {
			System.out.print("\n" + "*****************MENU*****************" + "\n" + "1. Generar equipo" + "\n" + "2. Añadir equipo al aula" + "\n" + "3. Buscar un equipo en el aula" + "\n" + "4. Eliminar equipo del aula" + "\n" + "5. Modificar equipo en el aula" + "\n" + "6. Mostrar aula" + "\n" + "7. Terminar programa" + "\n" + "Opcion: ");
			op = entrada.nextInt();
			int ip[] = new int [4];
			String pcName = "";
			
			
			switch (op) {
			case 1:								//Crear equipo e ip			
				String ipCompleta;
				boolean bucle = true;
				
				while (bucle) {
					ipCompleta = "";
					entrada.nextLine();
					System.out.println("Introduce el nombre del equipo: ");
					pcName = entrada.nextLine();
					System.out.println("Introduce su ip x partes de izq a dch(ej. 192 + enter, 168 + enter, 56 + enter, 1 + enter: ");
					for (int i = 0; i < ip.length; i++) {
						System.out.println("Octeto " + (i + 1) + ": ");
						ip[i] = entrada.nextInt();								
						ipCompleta += ip[i] + ".";
					}
					System.out.println("El nombre del equipo es: " + pcName + " y su ip es: " + ipCompleta + "\n" + "Es correcto?(1-si, 0-no): ");
					int correcto = entrada.nextInt();
					if (correcto == 1) {
						bucle = false;
					}
				}
				e.setIp(ip);
				e.setNombre(pcName);
				
				break;
			case 2:								//Añadir equipo al aula
				a1.addPc(e);
				System.out.println("Equipo " + e.getNombre() + " añadido");
				break;
			case 3:								//Buscar equipo en el aula
				
				break;
			case 4:								//Eliminar equipo del aula
				
				break;
			case 5:								//Modificar equipo del aula
				
				break;
			case 6:								//Mostrar aula
				
				break;
			case 7:								//Fin del programa
				System.out.println("Adio!");
				continuar = false;
			}
		}
		entrada.close();
	
	}

}
