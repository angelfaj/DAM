package vista;

import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

public class VistaHotel extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JRadioButton rdbtnSimple, rdbtnDoble, rdbtnSuite;
	private ButtonGroup grupo;
	private JTextArea textArea;

	
	public VistaHotel() {
		setTitle("Reserva de habitacion");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTipoHabitacion = new JLabel("Tipo de habitación:");
		lblTipoHabitacion.setBounds(22, 40, 146, 31);
		contentPane.add(lblTipoHabitacion);
		
		rdbtnSimple = new JRadioButton("Simple");
		rdbtnSimple.setBounds(22, 77, 103, 21);
		contentPane.add(rdbtnSimple);
		
		rdbtnDoble = new JRadioButton("Doble");
		rdbtnDoble.setBounds(22, 118, 103, 21);
		contentPane.add(rdbtnDoble);
		
		rdbtnSuite = new JRadioButton("Suite");
		rdbtnSuite.setBounds(22, 162, 103, 21);
		contentPane.add(rdbtnSuite);
		
		grupo = new ButtonGroup();
		grupo.add(rdbtnDoble);
		grupo.add(rdbtnSuite);
		grupo.add(rdbtnSimple);
		
		textArea = new JTextArea();
		textArea.setBounds(171, 75, 181, 108);
		textArea.setLineWrap(true);				//Activamos el ajuste de linea
		textArea.setWrapStyleWord(true);		//Evita que el salto de linea se haga entre medias palabras
		contentPane.add(textArea);
		
		
		setVisible(true);
		setResizable(false);
	}


	public JRadioButton getRdbtnSimple() {
		return rdbtnSimple;
	}

	public JRadioButton getRdbtnDoble() {
		return rdbtnDoble;
	}

	public JRadioButton getRdbtnSuite() {
		return rdbtnSuite;
	}

	public JTextArea getTextArea() {
		return textArea;
	}


	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}
	
	
	
	
}
