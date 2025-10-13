package e1;

public class SumadorEnteros {

	public static void main(String[] args) {
		/*Ejercicio 1
		Crea un programa que reciba dos números enteros en el main() y sume todo el
		intervalo que hay entre ellos. El resultado muéstralo por pantalla.
		Después crea otro programa que ejecute el anterior y muestre el resultado por
		pantalla
		*/
		
		//Comprobamos que hemos recibido argument
		if(args.length < 1) {
			System.out.println("Debes introducir argumentos");
			System.exit(1);
		}else {
			int menor = Integer.parseInt(args[0]);
			int mayor = Integer.parseInt(args[1]);
			if (mayor < menor) {
				int aux = menor;
				menor = mayor; 
				mayor = aux;
			}
			System.out.println("Numeros introducidos:" + menor + ", " + mayor);
			int total = menor;
			while (menor < mayor) {
				menor++;
				total += menor;
			}
			System.out.println("Suma del intervalo: " + total);
			System.exit(0);
		}

	}

}
