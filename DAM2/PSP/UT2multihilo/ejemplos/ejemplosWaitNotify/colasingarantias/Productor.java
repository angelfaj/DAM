package colasingarantias;

public class Productor implements Runnable {

    private Cola cola;

    public Productor(Cola c) {
        this.cola = c;
    }

    public void run() {
        int numero = 1;
        while (true) {
            boolean encolado = cola.encolar(numero);

            if (encolado) {
                System.out.println("Productor produce: " + numero);
                numero++;
            } else {
                System.out.println("Productor: cola llena, se pierde el dato " + numero);
            }

            try {
                Thread.sleep(200); // PRODUCTOR RÁPIDO → CAMBIA este valor para pruebas
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
