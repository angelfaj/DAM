package main;


import controlador.Controlador;
import modelo.Modelo;
import vista.Ventana;

public class MainOpiniones {
    public static void main(String[] args) {
    	Ventana vista = new Ventana();
    	Modelo modelo = new Modelo();
    	Controlador controlador = new Controlador(vista, modelo);
    	vista.setVisible(true);
    	
    }
}
