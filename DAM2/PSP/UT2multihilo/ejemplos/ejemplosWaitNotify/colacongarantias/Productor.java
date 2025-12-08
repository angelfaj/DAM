package colacongarantias;

public class Productor implements Runnable {

    private Cola cola;

    public Productor(Cola c) {
        this.cola = c;
    }

    public void run() {
        int numero = 1;

        while (true) {
            cola.encolar(numero);
            numero++;

            try {
                Thread.sleep(200); // Ajusta velocidad del productor
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
