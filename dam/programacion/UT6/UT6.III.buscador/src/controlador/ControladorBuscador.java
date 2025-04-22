package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import modelo.ModeloBuscador;
import vista.VistaBuscador;

public class ControladorBuscador implements ActionListener {
	private VistaBuscador vista;
	private ModeloBuscador modelo;
	
	public ControladorBuscador(VistaBuscador vista, ModeloBuscador modelo) {
		this.vista = vista;
		this.modelo = modelo;
		
		try {
			this.modelo.createAndFillTxt();
			this.vista.getTextAreaTexto().setText(this.modelo.getTxtContent());
		}catch (FileNotFoundException e0) {
			e0.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}

		this.vista.getBtnBuscar().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String patron = vista.getTextFieldWord().getText();
		
		String[][] results = new String[4][2];				//Llenamos la matriz que le pasaremos a la tabla
		results[1][0] = "Caracteres totales";
		results[2][0] = "Palabras totales";
		results[3][0] = "Lineas totales";
		try {
			results[1][1] = modelo.countChars() + "";
			results[2][1] = modelo.countWords() + "";
			results[3][1] = modelo.countLines() + "";

			if (patron.length() > 1) {						//Lamaremos a un metodo u otro en funcion de ser un string o char
				results[0][0] = "Cadena";
				results[0][1] = modelo.countOcurrences(patron) + "";
			}else {
				char c = patron.charAt(0);
				
				results[0][0] = "Caracter";
				results[0][1] = modelo.countOcurrences(c) + "";
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}catch (IOException e2) {
			e2.printStackTrace();
		}
		
		System.out.println("HOLA");
		vista.mostrarTabla(results);
	}
}
