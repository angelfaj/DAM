package repasoEj3;

public class Main {

	public static void main(String[] args) {
		/*Ejercicio 3: Bandeja de mensajes
		• Clase Bandeja con un único mensaje.
		• Productor escribe un mensaje, consumidor lo lee.
		• No se puede escribir si ya hay un mensaje pendiente.
		• No se puede leer si la bandeja está vacía*/
		
		Bandeja bandeja = new Bandeja();
		Thread productor = new Thread(new HiloProductorConsumidor("productor", bandeja));
		Thread consumidor = new Thread(new HiloProductorConsumidor("consumidor", bandeja));

		productor.start();
		consumidor.start();
	}

}
