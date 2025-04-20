package app;

import java.io.IOException;

import javax.swing.ViewportLayout;

import controlador.ControladorLista;
import modelo.ModeloLista;
import vista.VistaLista;

public class Main {

	public static void main(String[] args) {
		ModeloLista modelo = new ModeloLista();
		VistaLista vista = new VistaLista();
		
		ControladorLista controlador = new ControladorLista(modelo, vista);
	
	
	}
}
