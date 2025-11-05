package colacongarantias;

public class Consumidor implements Runnable {

    private Cola cola;

    public Consumidor(Cola c) {
        this.cola = c;
    }

    public void run() {
        while (true) {
            cola.desencolar();

            try {
                Thread.sleep(500); // Ajusta velocidad del consumidor
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
