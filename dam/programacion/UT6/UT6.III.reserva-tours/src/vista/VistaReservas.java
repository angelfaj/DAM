package vista;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;

public class VistaReservas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane, dataPane, actionPane, paymentPane;
	private JButton btnCancelar, btnReservar, btnModificar;
	private JTextField textFieldNombre;
	private ButtonGroup grupoRdbtn;
	private JRadioButton rdbtnEfectivo, rdbtnTarjeta;
	private JComboBox<String> comboBox;
	private final static String[] TOURS = {"", "Free Tour", "Leyendas nocturnas", "Leyendas vivientes", "Tour express"};
	private JCheckBox chckbxCastellano, chckbxIngles; 
	private JTextArea textArea;
	
	public VistaReservas() {
		setTitle("Reserva de tours");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		dataPane = new JPanel();
		dataPane.setBounds(10, 11, 414, 130);
		dataPane.setLayout(null);
		contentPane.add(dataPane);

		paymentPane = new JPanel();
		paymentPane.setBounds(224, 83, 184, 36);
		paymentPane.setLayout(null);
		dataPane.add(paymentPane);
		
		rdbtnTarjeta = new JRadioButton("Tarjeta");
		rdbtnTarjeta.setBounds(6, 7, 75, 23);
		paymentPane.add(rdbtnTarjeta);
		
		rdbtnEfectivo = new JRadioButton("Efectivo");
		rdbtnEfectivo.setBounds(103, 7, 75, 23);
		paymentPane.add(rdbtnEfectivo);
		
		grupoRdbtn = new ButtonGroup();
		grupoRdbtn.add(rdbtnEfectivo);
		grupoRdbtn.add(rdbtnTarjeta);
		
		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setBounds(20, 11, 184, 14);
		dataPane.add(lblNewLabel);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(20, 25, 184, 20);
		dataPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblServicio = new JLabel("Servicio:");
		lblServicio.setBounds(20, 73, 184, 14);
		dataPane.add(lblServicio);
		
		comboBox = new JComboBox<String>(TOURS);
		comboBox.setBounds(20, 89, 184, 22);
		dataPane.add(comboBox);
		
		chckbxCastellano = new JCheckBox("Castellano");
		chckbxCastellano.setBounds(221, 25, 82, 23);
		dataPane.add(chckbxCastellano);
		
		chckbxIngles = new JCheckBox("Inglés");
		chckbxIngles.setBounds(326, 25, 82, 23);
		dataPane.add(chckbxIngles);
		
		JLabel lblNewLabel_1 = new JLabel("Forma de pago");
		lblNewLabel_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(237, 73, 114, 14);
		dataPane.add(lblNewLabel_1);

		actionPane = new JPanel();
		actionPane.setBounds(10, 156, 414, 44);
		actionPane.setLayout(null);
		contentPane.add(actionPane);
		
		btnReservar = new JButton("Reservar");
		btnReservar.setBounds(10, 11, 118, 23);
		actionPane.add(btnReservar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(286, 11, 118, 23);
		actionPane.add(btnModificar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(147, 11, 118, 23);
		actionPane.add(btnCancelar);
		
		textArea = new JTextArea("Pulsa un boton para ver resultados");
		textArea.setBackground(new Color(255, 128, 128));
		textArea.setBounds(10, 212, 414, 38);
		contentPane.add(textArea);
		
		setVisible(true);
		setResizable(false);
	}
	
	public void printLog(String text) {		//Log del textarea
		getTextArea().setText(text);
		JOptionPane.showMessageDialog(this, text);
	}

	public boolean camposRellenos() {		//True si estan todos los campos rellenos
		if (getTextFieldNombre().getText().length() <= 0) {
			return false;
		}
		if (getComboBox().getSelectedItem().equals("")) {
			return false;
		}
		if (!getChckbxCastellano().isSelected() && !getChckbxIngles().isSelected()) {
			return false;
		}
		if (!getRdbtnEfectivo().isSelected() && !getRdbtnTarjeta().isSelected()) {
			return false;
		}
		return true;
	}
	
	public void limpiarCampos() {		//Limpia el formulario
		getTextFieldNombre().setText("");
		getComboBox().setSelectedIndex(0);
		getChckbxCastellano().setSelected(false);
		getChckbxIngles().setSelected(false);
		getGrupoRdbtn().clearSelection();
	}
	
	public JPanel getContentPane() {
		return contentPane;
	}

	public JPanel getDataPane() {
		return dataPane;
	}

	public JPanel getActionPane() {
		return actionPane;
	}

	public JPanel getPaymentPane() {
		return paymentPane;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public JButton getBtnReservar() {
		return btnReservar;
	}

	public JButton getBtnModificar() {
		return btnModificar;
	}

	public JTextField getTextFieldNombre() {
		return textFieldNombre;
	}

	public ButtonGroup getGrupoRdbtn() {
		return grupoRdbtn;
	}

	public JRadioButton getRdbtnEfectivo() {
		return rdbtnEfectivo;
	}

	public JRadioButton getRdbtnTarjeta() {
		return rdbtnTarjeta;
	}

	public JComboBox<String> getComboBox() {
		return comboBox;
	}

	public JCheckBox getChckbxCastellano() {
		return chckbxCastellano;
	}

	public JCheckBox getChckbxIngles() {
		return chckbxIngles;
	}

	public JTextArea getTextArea() {
		return textArea;
	}
	
}
