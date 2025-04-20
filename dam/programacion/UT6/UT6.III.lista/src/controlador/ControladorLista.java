package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import modelo.ModeloLista;
import vista.VistaLista;

public class ControladorLista implements ActionListener{
	private ModeloLista modelo;
	private VistaLista vista;
	
	public ControladorLista(ModeloLista modelo, VistaLista vista) {
		this.modelo = modelo;
		this.vista = vista;
		
		this.vista.getBtnAdd().addActionListener(this);
		this.vista.getBtnEliminar().addActionListener(this);
		this.vista.getBtnEliminarTodo().addActionListener(this);
		
		refreshLista();
	}
	
	public void refreshLista() {
		try {
			vista.getTextArea().setText(ModeloLista.getAllTareas());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == vista.getBtnAdd()) {
			modelo = new ModeloLista(vista.getList().getSelectedValue());
			try {
				modelo.saveTarea();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			refreshLista();
		}else if (e.getSource() == vista.getBtnEliminar()) {
			modelo = new ModeloLista(vista.getList().getSelectedValue());
			try {
				modelo.deleteTarea();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			refreshLista();
		}else if (e.getSource() == vista.getBtnEliminarTodo()) {
			modelo.deleteAll();
			refreshLista();
		}
	}
}
