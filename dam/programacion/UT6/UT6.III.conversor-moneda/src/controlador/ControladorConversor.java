package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import modelo.GestionMoneda;
import modelo.Operacion;
import vista.VistaConversor;

public class ControladorConversor implements ActionListener {
	private GestionMoneda modelo;
	private VistaConversor vista;
	
	public ControladorConversor(GestionMoneda modelo, VistaConversor vista) {
		this.modelo = modelo;
		this.vista = vista;
		iniciar();
	}
	
	private void iniciar() {
		vista.getBtnConvertir().addActionListener(this);
		try {
			vista.refreshTabla(modelo.getMatrizOperaciones());
		} catch (IOException e) {
			vista.showMessage(e.getMessage());
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String monedaOrigen = (String)vista.getComboBoxMonedaOrigen().getSelectedItem();
		String monedaDestino = (String)vista.getComboBoxMonedaDestino().getSelectedItem();
		double cantidad = Double.parseDouble(vista.getTextFieldCantidadOrigen().getText());
		
		Operacion aux = new Operacion(monedaOrigen, monedaDestino, cantidad, 0);
		aux.convertir();
		
		try {
			modelo.saveOperacionTxt(aux);
			vista.refreshTabla(modelo.getMatrizOperaciones());
		} catch (IOException e1) {
			vista.showMessage(e1.getMessage());
		}
		
	}
	
	
}
