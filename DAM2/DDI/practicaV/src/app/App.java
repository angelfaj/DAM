package app;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
	private Integer[] euros = {0, 1, 2, 3, 4, 5};
	private Double[] centimos = {0.0, 0.10, 0.20, 0.30, 0.40, 0.50, 0.60, 0.70, 0.80, 0.90};
	private JComboBox<Double> comboBoxCents;
	private JComboBox<Integer> comboBoxEuros;
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
		
		comboBoxEuros = new JComboBox<Integer>(euros);
		comboBoxEuros.setBounds(94, 24, 91, 20);
		panelPrecio.add(comboBoxEuros);
		
		comboBoxCents = new JComboBox<Double>(centimos);
		comboBoxCents.setBounds(94, 66, 91, 20);
		panelPrecio.add(comboBoxCents);
		
		btnPagar = new JButton("Pagar");
		btnPagar.addActionListener(new ActionListener() {
			/*Se sabe que :
			Bebida A tiene un costo de 0 euros 80 centimos.
			Bebida B tiene un costo de 1 euros 20 centimos.
			Bebida C tiene un costo de 3 euros 10 centimos
			*/
			public void actionPerformed(ActionEvent e) {
				double cantidadIntroducida = ((Integer) comboBoxEuros.getSelectedItem()) + ((Double) comboBoxCents.getSelectedItem());
				double bebidaA = 0.80;
				double bebidaB = 1.20;
				double bebidaC = 3.10;
				String correcto = "Correcto, extrayendo bebida";
				String incorrectoFalta = "Incorrecto faltan ";
				String incorrectoSobra = "Incorrecto sobran ";
				//Para cambiar el color del texto
				StyledDocument doc = textPaneResul.getStyledDocument();
				SimpleAttributeSet color = new SimpleAttributeSet();
				
//				FALTA AÑADIR CANTIDAD RESTANTE/SOBRANTE
				if (rdbtnBebidaA.isSelected()) {
					if (cantidadIntroducida == bebidaA) {
						StyleConstants.setForeground(color, Color.GREEN); // Cambia a color verde
						textPaneResul.setText(correcto);
					}else if(cantidadIntroducida > bebidaA){
						StyleConstants.setForeground(color, Color.RED); // Cambia a color rojo
						textPaneResul.setText(incorrectoSobra + (cantidadIntroducida - bebidaA));
					}else {
						StyleConstants.setForeground(color, Color.RED); // Cambia a color rojo
						textPaneResul.setText(incorrectoFalta + (bebidaA - cantidadIntroducida));
					}
				}else if (rdbtnBebidaB.isSelected()) {
					if(cantidadIntroducida == bebidaB) {
						StyleConstants.setForeground(color, Color.GREEN); // Cambia a color verde
						textPaneResul.setText(correcto);
					}else if(cantidadIntroducida > bebidaB){
						StyleConstants.setForeground(color, Color.RED); // Cambia a color rojo
						textPaneResul.setText(incorrectoSobra + (cantidadIntroducida - bebidaB));
					}else {
						StyleConstants.setForeground(color, Color.RED); // Cambia a color rojo
						textPaneResul.setText(incorrectoFalta + (bebidaB - cantidadIntroducida));
					}
				}else if (rdbtnBebidaC.isSelected()) {
					if (cantidadIntroducida == bebidaC) {
						StyleConstants.setForeground(color, Color.GREEN); // Cambia a color verde
						textPaneResul.setText(correcto);
					}else if (cantidadIntroducida > bebidaC){
						StyleConstants.setForeground(color, Color.RED); // Cambia a color rojo
						textPaneResul.setText(incorrectoSobra + (cantidadIntroducida - bebidaC));
					}else {
						StyleConstants.setForeground(color, Color.RED); // Cambia a color rojo
						textPaneResul.setText(incorrectoFalta + (bebidaC - cantidadIntroducida));
					}
				}else {
					StyleConstants.setForeground(color, Color.RED); // Cambia a color rojo
					textPaneResul.setText("error desconocido");
				}
				doc.setCharacterAttributes(0, doc.getLength(), color, false);
			}
		});
		btnPagar.setBounds(27, 181, 117, 25);
		contentPane.add(btnPagar);
		
		textPaneResul = new JTextPane();
		textPaneResul.setBounds(176, 165, 260, 41);
		contentPane.add(textPaneResul);
		
		setVisible(true);
	}

	public static void main(String[] args) {
		App app = new App();
	}
}
