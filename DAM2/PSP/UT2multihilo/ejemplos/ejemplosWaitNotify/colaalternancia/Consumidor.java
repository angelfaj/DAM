package colaalternancia;

public class Consumidor implements Runnable {

    private Cola cola;

    public Consumidor(Cola c) {
        this.cola = c;
    }

    public void run() {
        while (true) {
            cola.consumir();

            try {
                Thread.sleep(600); // solo para visualizar alternancia
            } catch (InterruptedException e) {}
        }
    }
}
