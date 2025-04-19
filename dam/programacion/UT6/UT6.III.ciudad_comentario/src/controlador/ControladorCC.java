package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JOptionPane;

import modelo.ModeloCC;
import vista.VistaCC;

public class ControladorCC {
	private VistaCC vista;
	private ModeloCC modelo;
	
	public ControladorCC(VistaCC vista, ModeloCC modelo) {
		super();
		this.vista = vista;
		this.modelo = modelo;
		
		this.vista.getBtnReset().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				vista.getComboBox().setSelectedIndex(0);
				vista.getTextArea().setText("");
			}
		});
		
		this.vista.getBtnMostrar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					vista.getTextArea().setText("");
					vista.getTextArea().setText(ModeloCC.readReservas());
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		this.vista.getTextArea().addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					ModeloCC aux = new ModeloCC(vista.getComboBox().getSelectedItem().toString(), vista.getTextArea().getText());
					try {
						aux.saveReserva();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(vista, "Ciudad seleccionada: " + aux.getCiudad() + "\n" + "Comentarios: " + aux.getComentario());
				}
			}
		}); 
		
		
	}
	
	
}
