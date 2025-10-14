package app;


import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Reserva extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panelContacto;
	private JTextField textFieldNombre;
	private JTextField textFieldNumero;
	private JTextField textFieldNumeroPersonas;
	private JPanel panelTipoEvento;
	private JSpinner spinnerFecha;
	private ButtonGroup btnGroup;
	private JRadioButton rdbtnBanquete, rdbtnJornada, rdbtnCongreso; 
	private JLabel lblCocina;
	private String[] opcionesCocina = {"Buffet libre", "Carta", "Pedir cita con el chef", "No precisa"};
	private JComboBox<String> comboBox;
	private JPanel panelReserva;
	private JLabel lblDas;
	private JSpinner spinnerDias;
	private JButton btnAceptar, btnCancelar; 
	private JCheckBox chckbxNecesitarnHabitacion;
	
	public Reserva() {
		setTitle("Reserva");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		getContentPane().setLayout(null);
		
		panelContacto = new JPanel();
		panelContacto.setBorder(new TitledBorder(null, "Datos de contacto", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelContacto.setBounds(29, 12, 361, 84);
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
		panelContacto.add(textFieldNumero);
		
		panelReserva = new JPanel();
		panelReserva.setLayout(null);
		panelReserva.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Datos de la reserva", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		panelReserva.setBounds(29, 119, 394, 268);
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
		panelReserva.add(textFieldNumeroPersonas);
		
		spinnerFecha = new JSpinner();
		spinnerFecha.setBounds(12, 44, 167, 19);
		panelReserva.add(spinnerFecha);
		
		panelTipoEvento = new JPanel();
		panelTipoEvento.setLayout(null);
		panelTipoEvento.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Tipo de evento", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		panelTipoEvento.setBounds(12, 88, 133, 106);
		panelReserva.add(panelTipoEvento);
		
		rdbtnBanquete = new JRadioButton("Banquete");
		rdbtnBanquete.setBounds(8, 22, 94, 23);
		panelTipoEvento.add(rdbtnBanquete);
		
		rdbtnJornada = new JRadioButton("Jornada");
		rdbtnJornada.setBounds(8, 49, 94, 23);
		panelTipoEvento.add(rdbtnJornada);
		
		rdbtnCongreso = new JRadioButton("Congreso");
		rdbtnCongreso.setBounds(8, 76, 93, 23);
		panelTipoEvento.add(rdbtnCongreso);
		
		btnGroup.add(rdbtnBanquete);
		btnGroup.add(rdbtnCongreso);
		btnGroup.add(rdbtnJornada);
		
		lblCocina = new JLabel("Cocina");
		lblCocina.setBounds(163, 100, 47, 15);
		panelReserva.add(lblCocina);
		
		comboBox = new JComboBox<String>(opcionesCocina);
		comboBox.setBounds(221, 95, 148, 24);
		panelReserva.add(comboBox);
		
		lblDas = new JLabel("Días");
		lblDas.setBounds(163, 167, 31, 15);
		panelReserva.add(lblDas);
		
		spinnerDias = new JSpinner();
		spinnerDias.setBounds(221, 165, 55, 19);
		panelReserva.add(spinnerDias);
		
		chckbxNecesitarnHabitacion = new JCheckBox("Necesitarán habitación");
		chckbxNecesitarnHabitacion.setBounds(12, 224, 190, 23);
		panelReserva.add(chckbxNecesitarnHabitacion);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				faltan los listenersx
			}
		});
		btnAceptar.setBounds(87, 409, 117, 25);
		contentPane.add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnCancelar.setBounds(251, 409, 117, 25);
		contentPane.add(btnCancelar);
		
		setVisible(true);
	}



    public void desactivar() {
    	lblDas.setEnabled(false);
        spinnerDias.setEnabled(false);
        chckbxNecesitarnHabitacion.setEnabled(false);
    }
	
    public void activar() {
        if (rdbtnCongreso.isSelected()){
            if (lblDas.isEnabled() == false){
            	lblDas.setEnabled(true);
            }
            if (spinnerDias.isEnabled() == false){
            	spinnerDias.setEnabled(true);
            }
            if (chckbxNecesitarnHabitacion.isEnabled() == false){
            	chckbxNecesitarnHabitacion.setEnabled(true);
            }
        }  
    }


	
	public static void main(String[] args) {
		new Reserva();
	}
}
