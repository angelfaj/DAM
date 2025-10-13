package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.ModeloCalculadora;
import vista.VistaCalculadora;

public class ControladorCalculadora {
	private VistaCalculadora vista;
	private ModeloCalculadora modelo;	//No es necesario ya que todos los metodos son estaticos
	
	public ControladorCalculadora(VistaCalculadora vista, ModeloCalculadora modelo) {
		super();
		this.vista = vista;
		this.modelo = modelo;
		
		this.vista.getBtnSum().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				vista.getTextFieldResult().setText("TOTAL: " + (ModeloCalculadora.sumar(Double.parseDouble(vista.getTextField_1().getText()), Double.parseDouble(vista.getTextField_2().getText()))));				
			}
		});
		
		this.vista.getBtnSubstract().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				vista.getTextFieldResult().setText("TOTAL: " + (ModeloCalculadora.restar(Double.parseDouble(vista.getTextField_1().getText()), Double.parseDouble(vista.getTextField_2().getText()))));
			}
		});
		
		this.vista.getBtnMultiply().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				vista.getTextFieldResult().setText("TOTAL: " + (ModeloCalculadora.multiplicar(Double.parseDouble(vista.getTextField_1().getText()), Double.parseDouble(vista.getTextField_2().getText()))));
			}
		});
		
		this.vista.getBtnDivide().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				vista.getTextFieldResult().setText("TOTAL: " + (ModeloCalculadora.dividir(Double.parseDouble(vista.getTextField_1().getText()), Double.parseDouble(vista.getTextField_2().getText()))));
			}
		});
	}
	
	
}
