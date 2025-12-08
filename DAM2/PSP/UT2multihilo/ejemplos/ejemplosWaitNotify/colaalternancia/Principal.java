package colaalternancia;

public class Principal {
    public static void main(String[] args) {

        Cola c = new Cola();

        Thread productor = new Thread(new Productor(c));
        Thread consumidor = new Thread(new Consumidor(c));

        productor.start();
        consumidor.start();
    }
}
