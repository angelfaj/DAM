package ejercicio15;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		/*Para calcular la nota media de un alumno se le pide sus 4 notas y se guarda cada una de ellas
		en un array. Después se tiene que mostrar la información de cada nota e indicar la media del
		alumno. Para ello utiliza for each. 
		*/
		
		Scanner entrada = new Scanner(System.in);
		double notas[] = new double[4];
		boolean continuar = true;
		int opcion, j;
		Alumno lista[] = new Alumno[4];
		
		
		while (continuar) {
			System.out.print("\n" + "****************MENÚ****************" + "\n" + "1. Introducir alumnos" + "\n" + "2. Mostrar alumnos" + "\n" +"3. Introducir notas" + "\n" + "4. Consultar notas" + "\n" + "5. Consultar media" + "\n" + "6. Terminar programa" + "\n" + "Introduce un numero a continuación: ");
			opcion = entrada.nextInt();
			
			switch (opcion) {
			case 1:															//Introducir alumnos
				String nombre;
				for (int i = 0; i < lista.length; i++) {
					System.out.println("Introduce el nombre del alumno " + i + " :");
					nombre = entrada.next();
					lista[i] = new Alumno(nombre);
				}
			break;
			case 2:															//Mostrar alumnos
				for (int i = 0; i < lista.length; i++) {
					System.out.print("\n" + i + ". " + lista[i].getNombre() + "\t");
				}
			break;
			case 3:															//Introducir notas
				System.out.println("Introduce el numero de alumno al que modificarle las notas: ");
				j = entrada.nextInt();
				for (int i = 0; i < notas.length; i ++) {
					System.out.println("Introduce la nota " + (i + 1) + ":");
					notas[i] = entrada.nextDouble();
				}
				lista[j].setNotas(notas);
				break;
			case 4:															//Consultar notas
				System.out.println("Introduce el numero de alumno al que modificarle las notas: ");
				j = entrada.nextInt();
				for (int i = 0; i < notas.length; i ++) {
					System.out.println("La nota " + i + " es: " + lista[j].getNotas());
				}															
				break;
			case 5:															//Consultar media
				System.out.println("Introduce el numero de alumno: ");
				j = entrada.nextInt();
				System.out.println("La media del alumno es: " + lista[j].getMedia());															
				break;
			case 6:															//Terminar
				System.out.println("Adios!");
				continuar = false;
				break;
			}
		}
		
		entrada.close();

	}
}
