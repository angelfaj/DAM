package explicaSemaforoImpre;

public class Empleado extends Thread {
    private CentroImpresion centro;
    private String nombre;

    public Empleado(CentroImpresion centro, String nombre) {
        this.centro = centro;
        this.nombre = nombre;
    }

    public void run() {
        centro.imprimir(nombre);
    }
}