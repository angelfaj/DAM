package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import modelo.ModeloEditor;
import vista.VistaEditor;

public class ControladorEditor {

	private VistaEditor vista;
	private ModeloEditor modelo;
	
	public ControladorEditor(VistaEditor vista, ModeloEditor modelo) {
		this.vista = vista;
		this.modelo = modelo;
		
		this.vista.getBtnCargar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String text = ModeloEditor.uploadText();
					vista.setTxtField(text);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		this.vista.getBtnGuardar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					ModeloEditor.addText(vista.getTxtField().getText());
					vista.setTxtField("");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});

		this.vista.getBtnSobreescribir().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					ModeloEditor.rewriteText(vista.getTxtField().getText());
					vista.setTxtField("");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
			}
		});
	}
}
