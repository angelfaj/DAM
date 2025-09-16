package controlador;

import modelo.*;
import vista.*;

import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

public class Controlador {
	private GestorAnimales modelo;
	private VentanaPrincipal vista;

	public Controlador(GestorAnimales modelo, VentanaPrincipal vista) {
		this.modelo = modelo;
		this.vista = vista;

		vista.getBtnGuardarTxt().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (modelo.guardarComoTexto("animales.txt", guardar()))
						vista.mostrarMensaje("Animal guardado en fichero de texto correctamente");
					// JOptionPane.showMessageDialog(vista, "Animal guardado en fichero de texto
					// correctamente");
					else
						JOptionPane.showMessageDialog(vista, "El animal no se ha guardado en el fichero de texto");

				} catch (IOException ex) {
					JOptionPane.showMessageDialog(vista, "Error guardando TXT.");
				}
			}
		});

		vista.getBtnGuardarObj().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (modelo.guardarComoObjeto("animales.dat", guardar()))
						JOptionPane.showMessageDialog(vista, "Animal guardado en fichero de objetos correctamente");
					else
						JOptionPane.showMessageDialog(vista, "El animal no se ha guardado en el fichero de objetos");
				} catch (IOException ex) {
					JOptionPane.showMessageDialog(vista, "Error guardando OBJ.");
				}
			}
		});

		vista.getBtnCargarTxt().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String texto = modelo.cargarDesdeTexto("animales.txt");
					vista.getAreaAnimales().setText(texto);
//					vista.getAreaAnimales().append(texto);//con append no se borra,se añade a lo que tuviera
				} catch (IOException ex) {
					JOptionPane.showMessageDialog(vista, "Error leyendo TXT.");
				}
			}
		});

		vista.getBtnCargarObj().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ArrayList<Animal> lista = modelo.cargarDesdeObjeto("animales.dat");
					vista.getAreaAnimales().setText("");// limpio el area
					for (Animal a : lista) {
						vista.getAreaAnimales().append(a.toString() + "\n");
					}
				} catch (ClassNotFoundException ex) {
					JOptionPane.showMessageDialog(vista, "Error leyendo OBJ." + ex.getMessage());
				} catch (IOException ex) {
					JOptionPane.showMessageDialog(vista, "Error leyendo OBJ." + ex.getMessage());
				}
			}
		});

	}

	// Método que recupera la información de la interfaz y retorna un animal con
	// dicha información
	public Animal guardar() {
		Animal a = new Animal();
		String nombre = vista.getTxtNombre().getText();
		String especie = (String) vista.getComboEspecie().getSelectedItem();

		String sexo = "";
		if (vista.getRbtnMacho().isSelected()) {
			sexo = "Macho";
		} else if (vista.getRbtnHembra().isSelected()) {
			sexo = "Hembra";
		}

		try {
			int edad = Integer.parseInt(vista.getTxtEdad().getText());
			double peso = Double.parseDouble(vista.getTxtPeso().getText());
			a = new Animal(nombre, especie, edad, peso, sexo);
		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(vista, "Edad o peso no válidos.", "Error", JOptionPane.ERROR_MESSAGE);
		} finally {
			return a;
		}
	}
}
