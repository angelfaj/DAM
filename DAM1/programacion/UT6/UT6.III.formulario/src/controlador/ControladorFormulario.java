package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import modelo.ModeloFormulario;
import vista.VistaFormulario;

public class ControladorFormulario implements ActionListener{
	private VistaFormulario vista;
	private ModeloFormulario modelo;
	
	public ControladorFormulario(VistaFormulario vista, ModeloFormulario modelo) {
		this.vista = vista;
		this.modelo = modelo;
		
		this.vista.getBtnEnviar().addActionListener(this);
		this.vista.getBtnMostrarTodos().addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == vista.getBtnEnviar()) {
			vista.getTextAreadDatos().setText("");
			ModeloFormulario aux = new ModeloFormulario(vista.getTextFieldNombre().getText(), Integer.parseInt(vista.getTextFieldEdad().getText()));
			
			try {
				aux.saveData();
				aux = ModeloFormulario.showData(vista.getTextFieldNombre().getText());
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			vista.getTextAreadDatos().setText("Nombre: " + aux.getNombre() + ", edad: " + aux.getEdad());
		}else if (e.getSource() == vista.getBtnMostrarTodos()) {
			vista.getTextAreadDatos().setText("");
			
			ArrayList<ModeloFormulario> lista = null;
			String listaTxt = "";
			
			try {
				lista = ModeloFormulario.showAllData();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
			for (ModeloFormulario m : lista) {
				listaTxt += "Nombre: " + m.getNombre() + ", edad: " + m.getEdad() + "\n";
			}
			vista.getTextAreadDatos().setText(listaTxt);
		}
	}
	
}
