package colaalternancia;

public class Cola {

    private int valor;          // único dato compartido
    private boolean disponible; // indica si hay valor pendiente de consumir. Inicialmente falso para que empiece a producir primero

    public synchronized void producir(int v) {

        // Si ya hay un valor pendiente → el productor debe esperar
        while (disponible) {
            try {
                wait(); // productor espera su turno
            } catch (InterruptedException e) {}
        }

        // Ahora SÍ puede producir
        valor = v;
        System.out.println("Productor produce: " + v);

        disponible = true; // marca que hay un dato listo
        notify(); // despierta al consumidor
    }

    public synchronized int consumir() {

        // Si no hay valor → consumidor espera
        while (!disponible) {
            try {
                wait(); // consumidor espera su turno
            } catch (InterruptedException e) {}
        }

        // Ahora SÍ puede consumir
        System.out.println("Consumidor consume: " + valor);

        disponible = false; // marca que la cola queda vacía
        notify(); // despierta al productor

        return valor;
    }
}
