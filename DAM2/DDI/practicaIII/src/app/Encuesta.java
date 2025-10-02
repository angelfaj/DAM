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
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.JCheckBox;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JSlider;

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
	private String[] opcionesDeporte = {"Ténis", "Fútbol", "Natación", "Escalada", "Alpinismo", "Pádel", "Entrenamiento de pesas"};
	private JList listDeportes;
	private JCheckBox chckbxpracticaAlgnDeporte;
	private JPanel panelCual;
	private JSeparator separator;
	private JScrollPane scrollDeporte;
	
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
		panelSexo.setBounds(23, 97, 394, 49);
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
		
		chckbxpracticaAlgnDeporte = new JCheckBox("¿Practica algún deporte?");
		chckbxpracticaAlgnDeporte.setBounds(23, 158, 201, 23);
		contentPane.add(chckbxpracticaAlgnDeporte);
		
		panelCual = new JPanel();
		panelCual.setLayout(null);
		panelCual.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "\u00BFCu\u00E1l?", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		panelCual.setBounds(238, 162, 179, 96);
		contentPane.add(panelCual);
		
		listDeportes = new JList<String>(opcionesDeporte);
		scrollDeporte = new JScrollPane(listDeportes);
		scrollDeporte.setBounds(12, 29, 155, 60);
		panelCual.add(scrollDeporte);
		
		separator = new JSeparator();
		separator.setForeground(new Color(153, 193, 241));
		separator.setBounds(12, 270, 405, 15);
		contentPane.add(separator);
		
		JLabel lblMarqueDel = new JLabel("Marque del 1 al 10 su grado de afición a:");
		lblMarqueDel.setBounds(84, 281, 287, 15);
		contentPane.add(lblMarqueDel);
		
		JLabel lblCompras = new JLabel("Compras:");
		lblCompras.setBounds(23, 328, 67, 15);
		contentPane.add(lblCompras);
		
		JLabel lblVerTv = new JLabel("Ver TV:");
		lblVerTv.setBounds(23, 453, 50, 15);
		contentPane.add(lblVerTv);
		
		JLabel lblIrAlCine = new JLabel("Ir al cine:");
		lblIrAlCine.setBounds(23, 595, 65, 15);
		contentPane.add(lblIrAlCine);
		
		JSlider sliderCompras = new JSlider();
		sliderCompras.setPaintTicks(true);
		sliderCompras.setPaintLabels(true);
		sliderCompras.setMinorTickSpacing(1);
		sliderCompras.setMajorTickSpacing(1);
		sliderCompras.setValue(5);
		sliderCompras.setMaximum(10);
		sliderCompras.setMinimum(1);
		sliderCompras.setBounds(134, 328, 200, 51);
		contentPane.add(sliderCompras);
		
		JSlider sliderTv = new JSlider();
		sliderTv.setPaintTicks(true);
		sliderTv.setPaintLabels(true);
		sliderTv.setMinorTickSpacing(1);
		sliderTv.setMajorTickSpacing(1);
		sliderTv.setValue(5);
		sliderTv.setMinimum(1);
		sliderTv.setMaximum(10);
		sliderTv.setBounds(134, 453, 200, 37);
		contentPane.add(sliderTv);
		
		JSlider sliderCine = new JSlider();
		sliderCine.setMinorTickSpacing(1);
		sliderCine.setMajorTickSpacing(1);
		sliderCine.setPaintTicks(true);
		sliderCine.setPaintLabels(true);
		sliderCine.setValue(5);
		sliderCine.setMinimum(1);
		sliderCine.setMaximum(10);
		sliderCine.setBounds(134, 583, 200, 37);
		contentPane.add(sliderCine);
		
		setVisible(true);
	}
}
