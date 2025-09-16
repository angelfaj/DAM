package controlador;

import modelo.ModeloHotel;
import vista.VistaHotel;

public class ControladorHotel {
	private ModeloHotel modelo;
	private VistaHotel vista;
	
	public ControladorHotel(ModeloHotel modelo, VistaHotel vista) {
		this.modelo = modelo;
		this.vista = vista;
		
		Oyente oyente = new Oyente(modelo, vista);	//Creamos el oyente 
		vista.getTextArea().addMouseListener(oyente);//Lo asociamos al textarea
	}
}
