package app;

import java.io.IOException;

import controlador.ControladorHotel;
import modelo.ModeloHotel;
import vista.VistaHotel;

public class Main {

	public static void main(String[] args) {
		ModeloHotel modelo = null;
		try {
			 modelo = new ModeloHotel();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		VistaHotel vista = new VistaHotel();
		new ControladorHotel(modelo, vista);
		
		
		
	}
}
