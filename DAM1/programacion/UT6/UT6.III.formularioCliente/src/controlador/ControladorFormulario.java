package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import modelo.ModeloFormulario;
import vista.VistaFormulario;

public class ControladorFormulario  implements ActionListener{
	private ModeloFormulario modelo;
	private VistaFormulario vista;
	
	
	public ControladorFormulario(ModeloFormulario modelo, VistaFormulario vista) {
		super();
		this.modelo = modelo;
		this.vista = vista;
		
		this.vista.getBtnMostrarTodos().addActionListener(this);
		this.vista.getBtnEnviar().addActionListener(this);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == vista.getBtnEnviar()) {
			ModeloFormulario clientToShow = null;
			ModeloFormulario clientToSave = new ModeloFormulario(vista.getTextFieldName().getText(), vista.getTextFieldEmail().getText(), vista.getChckbxBreakfast().isSelected());
			
			try {
				clientToSave.saveClient();
				clientToShow = ModeloFormulario.showClient(vista.getTextFieldName().getText());
				vista.getTextArea().setText("Nombre: " + clientToShow.getNombre() + "\n" + "Email: " + clientToShow.getEmail() + "\n" + "Desayuno: " + clientToShow.getDesayuno());
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}  catch (IOException e1) {
				e1.printStackTrace();
			}
		}else if (e.getSource() == vista.getBtnMostrarTodos()) {
			String text = "";
			
			try {
				for (ModeloFormulario aux : ModeloFormulario.showAllClient()) {
					text += "Nombre: " + aux.getNombre() + "\n" + "Email: " + aux.getEmail() + "\n" + "Desayuno: " + aux.getDesayuno() + "\n";
				}
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			vista.getTextArea().setText(text);
		}
	}

}
