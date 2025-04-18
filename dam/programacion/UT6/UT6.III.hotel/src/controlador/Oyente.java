package controlador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import modelo.ModeloHotel;
import vista.VistaHotel;

public class Oyente implements MouseListener{	//La clase main debe limitarse a inicializar y poner en marcha la app por eso el oyente dentro edel paquete controlador
	private VistaHotel vista;
	private ModeloHotel modelo;
	
	public Oyente(ModeloHotel modelo, VistaHotel vista) {
		this.vista = vista;
		this.modelo = modelo;
	}
	

	@Override
	public void mouseEntered(MouseEvent e) {		//Segun el radiobuton seleccionado escribira un texto u otro en le jtexarea
		try {
			if (vista.getRdbtnSimple().isSelected()) {
				vista.getTextArea().setText(modelo.readFicheroPattern(0));
			}else if (vista.getRdbtnDoble().isSelected()) {
				vista.getTextArea().setText(modelo.readFicheroPattern(1));
			}else if (vista.getRdbtnSuite().isSelected()) {
				vista.getTextArea().setText(modelo.readFicheroPattern(2));
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {}
	
	@Override
	public void mousePressed(MouseEvent e) {}
	
	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

}
