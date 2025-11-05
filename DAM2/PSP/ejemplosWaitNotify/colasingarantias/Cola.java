package colasingarantias;

import java.util.ArrayList;
import java.util.List;

public class Cola {

	private List<Integer> lista; 
	private int limite;

	public Cola(int limite) {
		this.limite = limite;
		lista = new ArrayList<Integer>();
	}

	// Productor intenta añadir
	public synchronized boolean encolar(int valor) {
		if (lista.size() == limite) {
			// La cola está llena → se pierde el dato
			return false;
		}

		lista.add(valor); //añadimos al final de la lista
		return true;
	}

	// Consumidor intenta retirar
	public synchronized int desencolar() {
		if (lista.size() == 0) {
			// La cola está vacía
			return -1;
		}

		/* lista.remove(0):
		 * Devuelve el elemento que hay en la posición 0 (el primero de la lista).
		 * Lo elimina de la lista.
		 * Todos los elementos restantes se desplazan una posición hacia la izquierda.
		 */
		return lista.remove(0);
	}
}
