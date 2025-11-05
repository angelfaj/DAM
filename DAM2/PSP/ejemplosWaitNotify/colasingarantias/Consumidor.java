package colasingarantias;

public class Consumidor implements Runnable {

    private Cola cola; 

    public Consumidor(Cola c) {
        this.cola = c;
    }

    public void run() {
        while (true) {
            int dato = cola.desencolar();

            if (dato != -1) {
                System.out.println("Consumidor consume: " + dato);
            } else {
                System.out.println("Consumidor: cola vacía, no hay nada que consumir");
            }

            try {
                Thread.sleep(500); // CONSUMIDOR MÁS LENTO → CAMBIA este valor para pruebas
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
