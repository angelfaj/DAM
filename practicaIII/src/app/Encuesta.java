package app;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;
import javax.swing.JCheckBox;

public class Encuesta extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldProfesion;
	private JComboBox<String> comboBox;
	private String[] opcionesEdad = {"Menor de 18", "Entre 18 y 30", "Entre 31 y 50", "Entre 51 y 65", "Más de 65"};
	private JPanel panelSexo;
	private ButtonGroup rdbtnGroup;		//Necesario para evitar la seleccion multiple de radiobuton
	private JRadioButton rdbtnHombre;
	private JRadioButton rdbtnMujer;
	private JSpinner spinner;
	
	public Encuesta() {
		setTitle("Encuesta");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblProfesin = new JLabel("Profesión:");
		lblProfesin.setBounds(23, 14, 73, 15);
		contentPane.add(lblProfesin);
		
		JLabel lblNHermanos = new JLabel("Nº Hermanos:");
		lblNHermanos.setBounds(23, 53, 98, 15);
		contentPane.add(lblNHermanos);
		
		JLabel lblEdad = new JLabel("Edad:");
		lblEdad.setBounds(226, 51, 40, 15);
		contentPane.add(lblEdad);
		
		textFieldProfesion = new JTextField();
		textFieldProfesion.setBounds(114, 12, 303, 19);
		contentPane.add(textFieldProfesion);
		textFieldProfesion.setColumns(10);
		
		spinner = new JSpinner();
		spinner.setBounds(134, 51, 40, 20);
		contentPane.add(spinner);
		
		comboBox = new JComboBox<String>(opcionesEdad);
		comboBox.setBounds(270, 46, 147, 24);
		contentPane.add(comboBox);
		
		panelSexo = new JPanel();
		panelSexo.setBorder(new TitledBorder(null, "Sexo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelSexo.setBounds(23, 97, 344, 49);
		contentPane.add(panelSexo);
		panelSexo.setLayout(null);
		
		rdbtnHombre = new JRadioButton("Hombre");
		rdbtnHombre.setBounds(85, 18, 80, 23);
		panelSexo.add(rdbtnHombre);
		
		rdbtnMujer = new JRadioButton("Mujer");
		rdbtnMujer.setBounds(245, 18, 65, 23);
		panelSexo.add(rdbtnMujer);
		
		rdbtnGroup = new ButtonGroup();
		rdbtnGroup.add(rdbtnHombre);
		rdbtnGroup.add(rdbtnMujer);
		
		JCheckBox chckbxpracticaAlgnDeporte = new JCheckBox("¿Practica algún deporte?");
		chckbxpracticaAlgnDeporte.setBounds(23, 170, 201, 23);
		contentPane.add(chckbxpracticaAlgnDeporte);
		
		setVisible(true);
	}
}
