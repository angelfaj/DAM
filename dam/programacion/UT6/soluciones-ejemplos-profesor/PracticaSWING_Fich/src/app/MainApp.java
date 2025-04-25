package app;
import modelo.*;
import vista.*;
import controlador.*;

public class MainApp {
    public static void main(String[] args) {
        GestorAnimales modelo = new GestorAnimales();
        VentanaPrincipal vista = new VentanaPrincipal();
        Controlador controlador = new Controlador(modelo, vista);
        vista.setVisible(true);
    }
}
