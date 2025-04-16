package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import modelo.PersonaModelo;
import vista.UI;

public class ControladorPersona {		//El controlador gestiona las excepciones

	private UI vista;
	private PersonaModelo modelo;
	
	public ControladorPersona(UI vista, PersonaModelo modelo) {
		this.vista = vista;
		this.modelo = modelo;
		cargarTabla();
		
		this.vista.getBtnAniadir().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PersonaModelo persona = new PersonaModelo(vista.getTxtNombre().getText(), vista.getTxtNumero().getText());
				try {							//Seria mas adecuado mostrar un error al usuario en la ui
					persona.addPersona();
					vista.setTxtFieldNombre("");
					vista.setTxtFieldNumero("");
					cargarTabla();
				} catch (IOException e1) {	
					e1.printStackTrace();
				}
			}
		});
		
		this.vista.getBtnEditar().addActionListener(new ActionListener() {	//Carga los valores en los campos para poder editarlos
			@Override
			public void actionPerformed(ActionEvent e) {
				PersonaModelo oldPersona = vista.getSelectectPersona();
				vista.setTxtFieldNombre(oldPersona.getNombre());
				vista.setTxtFieldNumero(oldPersona.getNumero());
				try {
					oldPersona.deletePersona();
					cargarTabla();
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		this.vista.getBtnEliminar().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PersonaModelo oldPersona = vista.getSelectectPersona();
				try {
					oldPersona.deletePersona();
					vista.setTxtFieldNombre("");
					vista.setTxtFieldNumero("");
					cargarTabla();
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
	}
	
	public void cargarTabla() {
		try {
			vista.mostrarTabla(PersonaModelo.getPersonaMatriz());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
