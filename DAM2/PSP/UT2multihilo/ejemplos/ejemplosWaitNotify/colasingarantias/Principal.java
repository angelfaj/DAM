package colasingarantias;

public class Principal {
    public static void main(String[] args) {

        Cola c = new Cola(5); // Cola pequeña para que se note el problema

        //compartimos cola (objeto) y estaremos añadiendo y quitando elementos en su lista a la vez
        Productor p = new Productor(c);
        Consumidor co = new Consumidor(c);

        new Thread(p).start();
        new Thread(co).start();
    }
}
