package vista;


import javax.swing.*;
import java.awt.*;

public class VentanaReserva extends JFrame {
	
    private JRadioButton simple, doble, suite;
    private JTextArea descripcion;
    private ButtonGroup grupo;

    public VentanaReserva() {
    	setTitle("Reserva de Habitación");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        setResizable(false);

        JLabel label = new JLabel("Tipo de habitación:");
        label.setBounds(20, 20, 150, 25);
        getContentPane().add(label);

        simple = new JRadioButton("Simple");
        doble = new JRadioButton("Doble");
        suite = new JRadioButton("Suite");

        simple.setBounds(20, 50, 100, 25);
        doble.setBounds(20, 80, 100, 25);
        suite.setBounds(20, 110, 100, 25);

        grupo = new ButtonGroup();
        grupo.add(simple);
        grupo.add(doble);
        grupo.add(suite);

        getContentPane().add(simple);
        getContentPane().add(doble);
        getContentPane().add(suite);

        descripcion = new JTextArea();
        descripcion.setText("Pincha aquí para ver descripción de la habitación seleccionada");
        descripcion.setLineWrap(true);
        descripcion.setBounds(150, 50, 200, 100);
        descripcion.setEditable(false);
        getContentPane().add(descripcion);
    }

    public void mostrarDescripcion(String descripcion) {
    	this.descripcion.setText(descripcion);
    }

	public JRadioButton getSimple() {
		return simple;
	}

	public void setSimple(JRadioButton simple) {
		this.simple = simple;
	}

	public JRadioButton getDoble() {
		return doble;
	}

	public void setDoble(JRadioButton doble) {
		this.doble = doble;
	}

	public JRadioButton getSuite() {
		return suite;
	}

	public void setSuite(JRadioButton suite) {
		this.suite = suite;
	}

	public JTextArea getDescripcionArea() {
		return descripcion;
	}

	public void setDescripcionArea(JTextArea descripcionArea) {
		this.descripcion = descripcionArea;
	}

	public ButtonGroup getGrupo() {
		return grupo;
	}

	public void setGrupo(ButtonGroup grupo) {
		this.grupo = grupo;
	}
    
    
}
