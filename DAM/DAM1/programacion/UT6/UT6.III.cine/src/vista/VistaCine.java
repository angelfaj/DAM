package vista;


import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JLabel;

public class VistaCine extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldEmail;
	private JRadioButton rdbtnSi, rdbtnNo;
	private ButtonGroup rdbtnGroup;
	private DefaultTableModel modeloTabla;
	private JTable table;
	private JButton btnNewEnviar;
	private JComboBox<String> comboBoxFilms;
	private static final String[] PELICULAS = {"La naranja mecánica", "El resplandor", "Solo en casa", "Acompañado en casa"};
	private static final String[] columnas = {"F1", "F2", "F3", "F4", "F5", "F6", "F7", "F8", "F9", "F10"};
	
	public VistaCine() {
		setTitle("Compra de butacas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setSize(151, 20);
		textFieldEmail.setLocation(21, 113);
		contentPane.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		
		rdbtnNo = new JRadioButton("No");
		rdbtnNo.setBounds(21, 169, 50, 23);
		contentPane.add(rdbtnNo);
		
		rdbtnSi = new JRadioButton("Si");
		rdbtnSi.setBounds(100, 169, 50, 23);
		contentPane.add(rdbtnSi);

		rdbtnGroup = new ButtonGroup();
		rdbtnGroup.add(rdbtnSi);
		rdbtnGroup.add(rdbtnNo);
		
		btnNewEnviar = new JButton("Enviar");
		btnNewEnviar.setBounds(180, 208, 89, 23);
		contentPane.add(btnNewEnviar);
		
		comboBoxFilms = new JComboBox<String>(PELICULAS);
		comboBoxFilms.setBounds(21, 54, 152, 28);
		contentPane.add(comboBoxFilms);
		
		modeloTabla = new DefaultTableModel(null, columnas);
		
		table = new JTable(modeloTabla);
		table.setBounds(251, 54, 151, 138);
		contentPane.add(table);
		
		JLabel lblNewLabel = new JLabel("Selecciona la película:");
		lblNewLabel.setBounds(21, 30, 151, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblIntroduceTuEmail = new JLabel("Introduce tu email:");
		lblIntroduceTuEmail.setBounds(21, 93, 151, 14);
		contentPane.add(lblIntroduceTuEmail);
		
		JLabel lblPersonaConMovilidad = new JLabel("Persona con movilidad reducida:");
		lblPersonaConMovilidad.setBounds(21, 148, 192, 14);
		contentPane.add(lblPersonaConMovilidad);
		
		JLabel lblSeleccionaLaButaca = new JLabel("Selecciona la butaca:");
		lblSeleccionaLaButaca.setBounds(251, 29, 151, 14);
		contentPane.add(lblSeleccionaLaButaca);
		
		
		setVisible(true);
		setResizable(false);
	}

	public void fillTable(String[][] datosMatriz) {
		modeloTabla.setRowCount(0); //Limpiamos la tabla
		
		for (String[] fila : datosMatriz) {
			modeloTabla.addRow(fila);
		}
	}
	
	public JTextField getTextFieldEmail() {
		return textFieldEmail;
	}

	public JRadioButton getRdbtnSi() {
		return rdbtnSi;
	}

	public JRadioButton getRdbtnNo() {
		return rdbtnNo;
	}

	public ButtonGroup getRdbtnGroup() {
		return rdbtnGroup;
	}

	public DefaultTableModel getModeloTabla() {
		return modeloTabla;
	}

	public JTable getTable() {
		return table;
	}

	public JButton getBtnNewEnviar() {
		return btnNewEnviar;
	}

	public JComboBox<String> getComboBoxFilms() {
		return comboBoxFilms;
	}
}
