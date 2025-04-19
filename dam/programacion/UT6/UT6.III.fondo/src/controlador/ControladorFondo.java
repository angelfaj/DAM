package controlador;

import vista.VistaFondo;

public class ControladorFondo {
	private VistaFondo vista;
	
	public ControladorFondo(VistaFondo vista) {
		this.vista = vista;
		
		Oyente oyente = new Oyente(vista);
		
		this.vista.getBtnBlanco().addActionListener(oyente);
		this.vista.getBtnVerde().addActionListener(oyente);
		this.vista.getBtnNegro().addActionListener(oyente);
	}
}
