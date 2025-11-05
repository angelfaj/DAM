package colaalternancia;

public class Productor implements Runnable {

    private Cola cola;

    public Productor(Cola c) {
        this.cola = c;
    }

    public void run() {
        int numero = 1;
        while (true) {
            cola.producir(numero);
            numero++;

            try {
                Thread.sleep(300); // solo para ver más claro en pantalla
            } catch (InterruptedException e) {}
        }
    }
}
