package controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.VistaFondo;

public class Oyente implements ActionListener {
	private VistaFondo vista;
	
	public Oyente(VistaFondo vista) {
		this.vista = vista;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == vista.getBtnBlanco()) {
			vista.getContentPane().setBackground(new Color(255, 255, 255));
			vista.getLblPulsa().setForeground(new Color(0, 0, 0));
		}else if (e.getSource() == vista.getBtnNegro()) {
			vista.getContentPane().setBackground(new Color(0, 0, 0));
			vista.getLblPulsa().setForeground(new Color(255, 255, 255));
		}else if (e.getSource() == vista.getBtnVerde()) {
			vista.getContentPane().setBackground(new Color(0, 102, 0));
			vista.getLblPulsa().setForeground(new Color(255, 255, 255));
		}
	}

}
