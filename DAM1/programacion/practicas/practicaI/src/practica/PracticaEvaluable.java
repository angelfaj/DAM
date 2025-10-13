package practica;
import java.util.Scanner;

public class PracticaEvaluable {

	public static void main(String[] args) {
		//Distancia a recorrer 5km, si numero positvo  +1km si numero negativo -2km (max 2 veces) si 0 = no se mueve 
		//max 10 intentos, debe regstrar y mostrar los movimientos de mario. Al final de los 10 intentos se indicara si mario ha llegado o no
		
		Scanner entrada = new Scanner(System.in);
		
		final int TRY = 10;								//Creamos la variable que almacenará el límite de intentos, como no se modificará la creamos con final
		int numero, avanza = 0, retrocesos = 0; 		//Numero recogerá la entrada, avanza hara la suma de KM recorridos y retrocesos contabilizará los retrocesos.
		String recorrido = "";							//Recorrido almacenará los movimientos de Mario.
		
		System.out.println("Mario necesita recorrer 5 km para rescatar a la princesa." + "\n" + "Introduce hasta 10 números. Si el número es positivo, Mario avanza 1 km. Si es negativo, retrocede 2 km (máximo 2 veces de retroceso).");
		
		for (int i = 1; i <= TRY && avanza != 5; i++) {						//Bucle principal que se ejecutará siempre que no se superen los 10 intentos y Mario no recorra los 5Km
			System.out.print("Introduce un número (intento " + i + " de " + TRY + "): ");
			numero = entrada.nextInt();
			
			if ((numero < 0) && (retrocesos < 2)) {							//Ifs anidados para sumar, restar y mostrar por pantalla los datos necesarios 
				recorrido += "-2km" + "\t";
				avanza += -2;
				retrocesos += 1;
				System.out.println("Mario retrocede 2 km. Ha retrocido. Ahora está en " + avanza + " km de 5km.");
			} else if (numero > 0) {
				recorrido += "+1km" + "\t";
				avanza += 1;
				System.out.println("Mario avanza 1 km. Ha recorrido " + avanza + " km de 5km.");
			}else if (numero == 0) {
				recorrido += "+0km" + "\t";
			}
			else if (retrocesos == 2) {
				i--;
				System.out.println("Mario ya ha retrocedido el máximo de 2 veces. No puede retroceder más. Introduce un nuevo número. Mario está en " + avanza + " km de 5km.");
			}			
		}
		
		if (avanza == 5) {													//Ifs anidados para mostrar la frase indicada en función de si ha llegado o ha superado los intentos
			System.out.println("¡Mario ha llegado a la princesa! Ha recorrido 5 km.");
		} else if (avanza != 5)  {
			System.out.println("Mario no ha podido rescatar a la princesa. Ha recorrido " + avanza + " km de 5km.");
		}
		
		System.out.print("Los pasos de Mario han sido: " + recorrido);		
		entrada.close();
	}

}
