package view;


import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JTable;

public class ReservaView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panelContacto;
	private JTextField textFieldNombre;
	private JTextField textFieldNumero;
	private JTextField textFieldNumeroPersonas;
	private JPanel panelTipoEvento;
	private SpinnerDateModel dateModel;
	private JSpinner spinnerFecha;
	private ButtonGroup btnGroup;
	private JRadioButton rdbtnBanquete, rdbtnJornada, rdbtnCongreso; 
	private JLabel lblCocina;
	private String[] opcionesCocina = {"Buffet libre", "Carta", "Pedir cita con el chef", "No precisa"};
	private JComboBox<String> comboBoxCocina;
	private JPanel panelReserva;
	private JLabel lblDas;
	private SpinnerNumberModel modelSpinerDias;
	private JSpinner spinnerDias;
	private JButton btnAceptar, btnCancelar; 
	private JCheckBox chckbxNecesitarnHabitacion;
	private JTextPane textPane;
	private Object valorInicialFecha;
	private Object valorInicialDias;
	private JTable table;
	private JButton btnVisualizar;
	
	public ReservaView() {
		setTitle("Reserva");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		getContentPane().setLayout(null);
		
		panelContacto = new JPanel();
		panelContacto.setBorder(new TitledBorder(null, "Datos de contacto", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelContacto.setBounds(28, 72, 394, 84);
		panelContacto.setLayout(null);
		contentPane.add(panelContacto);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(12, 23, 55, 15);
		panelContacto.add(lblNombre);
		
		JLabel lblTelfono = new JLabel("Teléfono");
		lblTelfono.setBounds(12, 50, 62, 15);
		panelContacto.add(lblTelfono);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(85, 21, 264, 19);
		panelContacto.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldNumero = new JTextField();
		textFieldNumero.setColumns(10);
		textFieldNumero.setBounds(85, 48, 133, 19);
		//Únicamente permitimos introducir numeros
		textFieldNumero.addKeyListener(new KeyAdapter() {
		    public void keyTyped(KeyEvent e) {
		        char c = e.getKeyChar();

		        // Solo permite dígitos
		        if (!Character.isDigit(c)) {
		            e.consume();
		        }
		    }
		});
		panelContacto.add(textFieldNumero);
		
		panelReserva = new JPanel();
		panelReserva.setLayout(null);
		panelReserva.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Datos de la reserva", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		panelReserva.setBounds(28, 179, 394, 268);
		contentPane.add(panelReserva);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(12, 23, 55, 15);
		panelReserva.add(lblFecha);
		
		JLabel lblNmeroDePersonas = new JLabel("Número de personas");
		lblNmeroDePersonas.setBounds(197, 23, 148, 15);
		panelReserva.add(lblNmeroDePersonas);
		
		textFieldNumeroPersonas = new JTextField();
		textFieldNumeroPersonas.setColumns(10);
		textFieldNumeroPersonas.setBounds(197, 44, 102, 19);
		//Únicamente permitimos introducir numeros
		textFieldNumeroPersonas.addKeyListener(new KeyAdapter() {
		    public void keyTyped(KeyEvent e) {
		        char c = e.getKeyChar();

		        // Solo permite dígitos
		        if (!Character.isDigit(c)) {
		            e.consume();
		        }
		    }
		});
		panelReserva.add(textFieldNumeroPersonas);
		
		LocalDate localTomorrow = LocalDate.now().plusDays(1);
		Date tomorrow = Date.from(localTomorrow.atStartOfDay(ZoneId.systemDefault()).toInstant());
		//Modelo para que la fecha minima sea el dia actual
		dateModel = new SpinnerDateModel(tomorrow, tomorrow, null, Calendar.DAY_OF_MONTH);
		spinnerFecha = new JSpinner(dateModel);
		spinnerFecha.setBounds(12, 44, 167, 19);
		panelReserva.add(spinnerFecha);

		//Establecemos formato de fecha
		JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(spinnerFecha, "dd/MM/yyyy");
		spinnerFecha.setEditor(dateEditor);
		
		valorInicialFecha = spinnerFecha.getValue();
		
		panelTipoEvento = new JPanel();
		panelTipoEvento.setLayout(null);
		panelTipoEvento.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Tipo de evento", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		panelTipoEvento.setBounds(12, 88, 133, 106);
		panelReserva.add(panelTipoEvento);
		
		rdbtnBanquete = new JRadioButton("Banquete");
		rdbtnBanquete.setBounds(8, 22, 94, 23);
		rdbtnBanquete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				desactivar();
			}
		});
		panelTipoEvento.add(rdbtnBanquete);
		
		rdbtnJornada = new JRadioButton("Jornada");
		rdbtnJornada.setBounds(8, 49, 94, 23);
		rdbtnJornada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				desactivar();
			}
		});
		panelTipoEvento.add(rdbtnJornada);
		
		rdbtnCongreso = new JRadioButton("Congreso");
		rdbtnCongreso.setBounds(8, 76, 93, 23);
		rdbtnCongreso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				activar();
			}
		});
		panelTipoEvento.add(rdbtnCongreso);
		
		btnGroup = new ButtonGroup();
		btnGroup.add(rdbtnBanquete);
		btnGroup.add(rdbtnCongreso);
		btnGroup.add(rdbtnJornada);
		
		lblCocina = new JLabel("Cocina");
		lblCocina.setBounds(163, 100, 47, 15);
		panelReserva.add(lblCocina);
		
		comboBoxCocina = new JComboBox<String>(opcionesCocina);
		comboBoxCocina.setBounds(221, 95, 148, 24);
		panelReserva.add(comboBoxCocina);
		
		lblDas = new JLabel("Días");
		lblDas.setBounds(163, 167, 31, 15);
		panelReserva.add(lblDas);
		
		modelSpinerDias =  new SpinnerNumberModel(0, 0, 100, 1);
		spinnerDias = new JSpinner(modelSpinerDias);
		spinnerDias.setBounds(221, 165, 55, 19);
		panelReserva.add(spinnerDias);
		valorInicialDias = spinnerDias.getValue();
		
		chckbxNecesitarnHabitacion = new JCheckBox("Necesitarán habitación");
		chckbxNecesitarnHabitacion.setBounds(12, 224, 190, 23);
		panelReserva.add(chckbxNecesitarnHabitacion);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comprobarCampos();
			}
		});
		btnAceptar.setBounds(86, 469, 117, 25);
		contentPane.add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarCampos();
			}
		});
		btnCancelar.setBounds(250, 469, 117, 25);
		contentPane.add(btnCancelar);
		
		JLabel lblReservasDelSaln = new JLabel("RESERVAS DEL SALÓN HAVANA");
		lblReservasDelSaln.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		lblReservasDelSaln.setBounds(28, 23, 361, 41);
		contentPane.add(lblReservasDelSaln);
		
		textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setBounds(28, 508, 394, 62);
		contentPane.add(textPane);
		
		JLabel lblVisualizarReservas = new JLabel("Visualizar reservas");
		lblVisualizarReservas.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		lblVisualizarReservas.setBounds(450, 23, 228, 41);
		contentPane.add(lblVisualizarReservas);
		
		btnVisualizar = new JButton("Visualizar");
		btnVisualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				visualizar();
			}
		});
		btnVisualizar.setBounds(694, 23, 117, 35);
		contentPane.add(btnVisualizar);
		
		table = new JTable();
		table.setBounds(450, 83, 363, 364);
		contentPane.add(table);
		
		desactivar();
		setVisible(true);
	}

    protected void visualizar() {
    	
	}

	protected void limpiarCampos() {
		textFieldNombre.setText("");
		textFieldNumero.setText("");
		textFieldNumeroPersonas.setText("");
		btnGroup.clearSelection();
		chckbxNecesitarnHabitacion.setSelected(false);
		spinnerDias.setValue(valorInicialDias);
		spinnerFecha.setValue(valorInicialFecha);
		comboBoxCocina.setSelectedIndex(0);
		desactivar();
    }

	protected void comprobarCampos() {
    	String motivoError = "";
		boolean error = false;
		
		//Variable para almacenar el contenido del formulario
		
		String nombre = textFieldNombre.getText();
		String telefono = textFieldNumero.getText();
		String fecha = (String) spinnerFecha.getValue();
		String nPersonas = textFieldNumeroPersonas.getText();
		String tipoEvento = "";
		String cocina = (String) comboBoxCocina.getSelectedItem();
		String habitacion = "";
		int nDias = (int) spinnerDias.getValue();
		
		
		
		//Comprobamos si ha introducido nombre
		if(nombre.isEmpty()) {
			motivoError += "Debes introducir un nombre. ";
			error = true;
		}
		
		//Comprobamos si ha introducido telefono
		if(telefono.isEmpty()) {
			motivoError += "Debes introducir un teléfono. ";
			error = true;
		}else if (!telefono.matches("\\d{9}")) {
			motivoError += "Debes introducir un teléfono VALIDO. ";
			error = true;
        }
		
		//Comprobamos si ha introducido numero de personas
		if(nPersonas.isEmpty()) {
			motivoError += "Debes indicar el número de asistentes. ";
			error = true;
		}
		
		//Comprobamos si ha seleccionado tipo de evento y si ha indicado los dias de ser un congreso
		if (!rdbtnBanquete.isSelected() && !rdbtnCongreso.isSelected() && !rdbtnJornada.isSelected()) {
			motivoError += "Debes seleccionar el tipo de evento. ";
			error = true;
		}else if (rdbtnBanquete.isSelected()) {
			tipoEvento = "Banquete";
		}else if (rdbtnJornada.isSelected()) {
			tipoEvento = "Jornada";
		}else if (rdbtnCongreso.isSelected() && Integer.parseInt(spinnerDias.getValue().toString()) <= 0) {
			motivoError += "Debes indicar el número de días. ";
			error = true;
		}else {
			tipoEvento = "Congreso";
		}
		
		if (chckbxNecesitarnHabitacion.isSelected()) {
			habitacion = "si";
		}else {
			habitacion = "no";
		}
		
		
		
        //Objetos necesarios para manipular el color del resultado mostrado en el textpane
		StyledDocument doc = textPane.getStyledDocument();
		SimpleAttributeSet color = new SimpleAttributeSet();
		
		if (error) {
			textPane.setText("ERROR <" + motivoError + ">");
			 StyleConstants.setForeground(color, Color.RED); // Cambia a color rojo
		}else {
			textPane.setText("ENVIADO CORRECTAMENTE");
			 StyleConstants.setForeground(color, Color.GREEN); // Cambia a color verde
		}
		doc.setCharacterAttributes(0, doc.getLength(), color, false);
		
	}

	public void desactivar() {
    	lblDas.setEnabled(false);
        spinnerDias.setEnabled(false);
        chckbxNecesitarnHabitacion.setEnabled(false);
    }
	
    public void activar() {
        if (rdbtnCongreso.isSelected()){
            if (!lblDas.isEnabled()){
            	lblDas.setEnabled(true);
            }
            if (!spinnerDias.isEnabled()){
            	spinnerDias.setEnabled(true);
            }
            if (!chckbxNecesitarnHabitacion.isEnabled()){
            	chckbxNecesitarnHabitacion.setEnabled(true);
            }
        }  
    }
}
