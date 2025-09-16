package vista;

import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class Ventana extends JFrame {

    private JComboBox<String> comboCiudades;
    private JTextArea comentarios;
    private JButton botonReset;

    public Ventana() {
        setTitle("Ciudad y Comentarios");
        setSize(400, 300);
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


        JLabel label = new JLabel("Ciudad:");
        label.setBounds(20, 20, 100, 25);
        add(label);

        comboCiudades = new JComboBox<>(new String[]{"Madrid", "Barcelona", "Sevilla", "Valencia"});
        comboCiudades.setBounds(100, 20, 200, 25);
        add(comboCiudades);


        JLabel label2 = new JLabel("Comentarios:");
        label2.setBounds(20, 60, 200, 25);
        add(label2);

        comentarios = new JTextArea();
        comentarios.setBounds(20, 90, 340, 100);
        comentarios.setLineWrap(true);
        comentarios.setWrapStyleWord(true);
        add(comentarios);

        botonReset = new JButton("Resetear");
        botonReset.setBounds(140, 200, 100, 30);
        add(botonReset);
        
       

    }

	public JComboBox<String> getComboCiudades() {
		return comboCiudades;
	}

	public void setComboCiudades(JComboBox<String> comboCiudades) {
		this.comboCiudades = comboCiudades;
	}

	public JTextArea getComentarios() {
		return comentarios;
	}

	public void setComentarios(JTextArea comentarios) {
		this.comentarios = comentarios;
	}

	public JButton getBotonReset() {
		return botonReset;
	}

	public void setBotonReset(JButton botonReset) {
		this.botonReset = botonReset;
	}

	public void muestraExcepcion(IOException e1) {
      JOptionPane.showMessageDialog(this, "Error al guardar en archivo."+e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		
	}




}

