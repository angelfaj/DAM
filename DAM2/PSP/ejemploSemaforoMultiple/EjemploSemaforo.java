package explicaSemaforoImpre;

public class EjemploSemaforo {
    public static void main(String[] args) {
        CentroImpresion centro = new CentroImpresion();

        // Creamos 5 empleados que quieren imprimir y sólo hay dos impresoras en la empresa
        for (int i = 1; i <= 5; i++) {
            Empleado e = new Empleado(centro, "Empleado-" + i);
            e.start();
        }
    }
}