package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JOptionPane;

import modelo.Animal;
import vista.VistaAnimal;

public class ControladorAnimal {
	private Animal modelo;
	private VistaAnimal vista;
	
	public ControladorAnimal(Animal modelo, VistaAnimal vista) {
		this.modelo = modelo;
		this.vista = vista;
		
		iniciar();
	}
	
	public void iniciar() {
		//Guardar en fichero txt
		vista.getBtnGuardarTxt().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String nombre = vista.getTextFieldNombre().getText();
				int edad = Integer.parseInt(vista.getTextFieldEdad().getText());
				double peso = Double.parseDouble(vista.getTextFieldPeso().getText());
				String especie = (String) vista.getComboBoxEspecie().getSelectedItem();
				String sexo = "";
				
				if (vista.getRdbtnHembra().isSelected()) {
					sexo = "Hembra";
				}else if (vista.getRdbtnMacho().isSelected()) {
					sexo = "Macho";
				}
				
				modelo = new Animal(nombre, especie, edad, peso, sexo);
				try {
					modelo.saveAnimalTxt();
					JOptionPane.showMessageDialog(vista, "Animal guardado en el fichero de texto correctamente.");
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(vista, "Ocurrió un error al guardar los datos");
				}

				
			}
		});
		
		//Guardar en fichero de datos
		vista.getBtnGuardarObj().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String nombre = vista.getTextFieldNombre().getText();
				int edad = Integer.parseInt(vista.getTextFieldEdad().getText());
				double peso = Double.parseDouble(vista.getTextFieldPeso().getText());
				String especie = (String) vista.getComboBoxEspecie().getSelectedItem();
				String sexo = "";
				
				if (vista.getRdbtnHembra().isSelected()) {
					sexo = "Hembra";
				}else if (vista.getRdbtnMacho().isSelected()) {
					sexo = "Macho";
				}
				
				modelo = new Animal(nombre, especie, edad, peso, sexo);
				try {
					modelo.saveAnimalDat();
					JOptionPane.showMessageDialog(vista, "Animal guardado en el fichero de datos correctamente.");
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(vista, e1.getMessage());
				}
				
				
			}
		});

		//Cargar txt
		vista.getBtnCargarTxt().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					vista.getTextArea().setText(modelo.showAnimalesTxt());
				} catch (FileNotFoundException e1) {
					JOptionPane.showMessageDialog(vista, e1.getMessage());
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(vista, e1.getMessage());
				} 
			}
		});
		
		//Cargar obj
		vista.getBtnCargarObj().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					vista.getTextArea().setText(modelo.showAnimalesDat());
				} catch (FileNotFoundException e1) {
					JOptionPane.showMessageDialog(vista, e1.getMessage());
				} catch (ClassNotFoundException e1) {
					JOptionPane.showMessageDialog(vista, e1.getMessage());
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(vista, e1.getMessage());
				}
				
			}
		});
		
	}
	
}
