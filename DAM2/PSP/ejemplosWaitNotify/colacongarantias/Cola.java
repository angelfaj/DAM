package colacongarantias;

import java.util.ArrayList;
import java.util.List;

public class Cola {

    private List<Integer> lista;
    private int limite;

    public Cola(int limite) {
        this.limite = limite;
        lista = new ArrayList<Integer>();
    }

    // Método llamado por el PRODUCTOR para meter datos
    public synchronized void encolar(int valor) {

        // Mientras la cola esté llena, el productor debe ESPERAR
        while (lista.size() == limite) {
            try {
                System.out.println("Productor espera → Cola llena");
                wait(); // El productor se duerme aquí
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Ahora hay espacio, me han despertado → se añade el valor
        lista.add(valor);
        System.out.println("Productor produce: " + valor);

        // Se avisa al consumidor de que ya hay datos disponibles
        notify();
    }

    // Método llamado por el CONSUMIDOR para sacar datos
    public synchronized int desencolar() {

        // Mientras la cola esté vacía, el consumidor debe ESPERAR
        while (lista.size() == 0) {
            try {
                System.out.println("Consumidor espera → Cola vacía");
                wait(); // El consumidor se duerme aquí
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Ahora sí hay datos, me han despertado → se saca el primero (FIFO)
        int valor = lista.remove(0);
        System.out.println("Consumidor consume: " + valor);

        // Se avisa al productor de que puede producir más
        notify();

        return valor;
    }
}
