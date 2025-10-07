package app;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextPane;

public class App extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panelBebida;
	private JPanel panelPrecio;
	private ButtonGroup rdbtnGroup;
	private JRadioButton rdbtnBebidaC, rdbtnBebidaB, rdbtnBebidaA;
	private JLabel lblEuros;
	private JLabel lblCntimos;
	private JButton btnPagar;
	private JComboBox comboBoxCents, comboBoxEuros;
	private JTextPane textPaneResul;
	
	public App() {
		setTitle("Expendedora");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panelBebida = new JPanel();
		panelBebida.setBorder(new TitledBorder(null, "Selecciona una bebida", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelBebida.setBounds(27, 12, 200, 133);
		contentPane.add(panelBebida);
		panelBebida.setLayout(null);
		
		rdbtnBebidaA = new JRadioButton("Bebida A");
		rdbtnBebidaA.setBounds(8, 24, 87, 23);
		panelBebida.add(rdbtnBebidaA);
		
		rdbtnBebidaB = new JRadioButton("Bebida B");
		rdbtnBebidaB.setBounds(8, 51, 87, 23);
		panelBebida.add(rdbtnBebidaB);
		
		rdbtnBebidaC = new JRadioButton("Bebida C");
		rdbtnBebidaC.setBounds(8, 78, 87, 23);
		panelBebida.add(rdbtnBebidaC);
		
		rdbtnGroup = new ButtonGroup();
		rdbtnGroup.add(rdbtnBebidaA);
		rdbtnGroup.add(rdbtnBebidaB);
		rdbtnGroup.add(rdbtnBebidaC);
		
		panelPrecio = new JPanel();
		panelPrecio.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Realiza el pago", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		panelPrecio.setBounds(239, 12, 197, 133);
		contentPane.add(panelPrecio);
		panelPrecio.setLayout(null);
		
		lblEuros = new JLabel("Euros");
		lblEuros.setBounds(12, 29, 40, 15);
		panelPrecio.add(lblEuros);
		
		lblCntimos = new JLabel("Céntimos");
		lblCntimos.setBounds(12, 71, 66, 15);
		panelPrecio.add(lblCntimos);
		
		comboBoxEuros = new JComboBox();
		comboBoxEuros.setBounds(94, 24, 91, 20);
		panelPrecio.add(comboBoxEuros);
		
		comboBoxCents = new JComboBox();
		comboBoxCents.setBounds(94, 66, 91, 20);
		panelPrecio.add(comboBoxCents);
		
		btnPagar = new JButton("Pagar");
		btnPagar.setBounds(27, 181, 117, 25);
		contentPane.add(btnPagar);
		
		textPaneResul = new JTextPane();
		textPaneResul.setBounds(176, 181, 260, 25);
		contentPane.add(textPaneResul);
		
		setVisible(true);
	}

	public static void main(String[] args) {
		App app = new App();
	}
}
