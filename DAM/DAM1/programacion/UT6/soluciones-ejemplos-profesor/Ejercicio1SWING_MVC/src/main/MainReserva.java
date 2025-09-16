package main;


import controlador.ControladorReserva;
import modelo.HabitacionModelo;
import vista.VentanaReserva;

public class MainReserva {
    public static void main(String[] args) {
        VentanaReserva vista = new VentanaReserva();
        HabitacionModelo modelo = new HabitacionModelo();
        ControladorReserva controlador = new ControladorReserva(vista, modelo);
        controlador.iniciar();//Otra forma de inicializar la UI en lugar del constructor
    }
}
