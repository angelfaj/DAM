package colacongarantias;

public class Principal {
    public static void main(String[] args) {

        // Cola de capacidad limitada
        Cola c = new Cola(5);

        // Crear hilos
        Productor p = new Productor(c);
        Consumidor co = new Consumidor(c);

        new Thread(p, "Productor").start();
        new Thread(co, "Consumidor").start();
    }
}
