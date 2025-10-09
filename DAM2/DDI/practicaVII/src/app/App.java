package app;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class App extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static String[] cuentas = {"Caja de ahorro", "Cuenta corriente"}; 
	private static Integer[] cantidades = {0, 50, 100, 150, 200, 250, 300, 350, 400, 450, 500};
	private JTextPane textPane;
	private JPanel panelDinero;
	private JComboBox<Integer> comboBoxDinero;
	private JComboBox<String> comboBoxCuenta;
	private JPanel panelResultado;
	private JButton btnExtraer;
	private int dineroAlmacenado = 3000;
	private int saldo = dineroAlmacenado;
	private int maxAhorro = 200;
	private int maxCorriente = 500;
	private JLabel lblSaldo;
	private JTextPane textSaldo;
	
	public App() {
		setTitle("Cajero");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panelDinero = new JPanel();
		panelDinero.setBounds(29, 12, 394, 154);
		panelDinero.setLayout(null);
		contentPane.add(panelDinero);
		
		JLabel lblDineroAExtraer = new JLabel("Dinero a extraer");
		lblDineroAExtraer.setBounds(12, 66, 116, 15);
		panelDinero.add(lblDineroAExtraer);
		
		JLabel lblTipoDeCuenta = new JLabel("Tipo de cuenta");
		lblTipoDeCuenta.setBounds(213, 66, 105, 15);
		panelDinero.add(lblTipoDeCuenta);
		
		comboBoxDinero = new JComboBox<Integer>(cantidades);
		comboBoxDinero.setBounds(12, 103, 116, 24);
		panelDinero.add(comboBoxDinero);
		
		comboBoxCuenta = new JComboBox<String>(cuentas);
		comboBoxCuenta.setBounds(213, 103, 148, 24);
		panelDinero.add(comboBoxCuenta);
		
		lblSaldo = new JLabel("Saldo cajero:");
		lblSaldo.setBounds(166, 22, 93, 15);
		panelDinero.add(lblSaldo);
		
		textSaldo = new JTextPane();
		textSaldo.setEditable(false);
		textSaldo.setBounds(277, 12, 105, 25);
		panelDinero.add(textSaldo);
		textSaldo.setText(saldo + "");
		
		panelResultado = new JPanel();
		panelResultado.setBounds(29, 178, 394, 46);
		panelResultado.setLayout(null);
		contentPane.add(panelResultado);
		
		btnExtraer = new JButton("Extraer");
		btnExtraer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int solicitado = (int) comboBoxDinero.getSelectedItem();
				String cuenta = (String) comboBoxCuenta.getSelectedItem();
				saldo -= solicitado;
				
				if (saldo >= 0) {
					if (cuenta.equals("Caja de ahorro")) {
						if (solicitado <= maxAhorro) {
							textPane.setText("Correcto");
							textSaldo.setText(saldo + "");
						}else {
							textPane.setText("Incorrecto");
						}
					}else if (cuenta.equals("Cuenta corriente")) {
						if (solicitado <= maxCorriente) {
							textPane.setText("Correcto");
							textSaldo.setText(saldo + "");
						}else {
							textPane.setText("Incorrecto");
						}
					}
				}else {
					textPane.setText("Fuera de servicio");
				}
			}
		});
		btnExtraer.setBounds(12, 12, 117, 25);
		panelResultado.add(btnExtraer);
		
		textPane = new JTextPane();
		textPane.setBounds(177, 12, 205, 25);
		panelResultado.add(textPane);
		
		setVisible(true);
	}

	public static void main(String[] args) {
		App app = new App();
	}
}
