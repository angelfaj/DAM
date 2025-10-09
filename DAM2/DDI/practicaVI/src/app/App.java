package app;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JSpinner;
import javax.swing.JTextPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class App extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panelCompuertas;
	private JLabel lblFlujoCompuerta1;
	private JLabel lblFlujoCompuerta2;
	private JLabel lblFlujoCompuerta3;
	private SpinnerNumberModel modelSpiner1 = new SpinnerNumberModel(0, 0, 100, 1);
	private SpinnerNumberModel modelSpiner2 = new SpinnerNumberModel(0, 0, 100, 1);
	private SpinnerNumberModel modelSpiner3 = new SpinnerNumberModel(0, 0, 100, 1);
	private JSpinner spinnerC1;
	private JSpinner spinnerC2;
	private JSpinner spinnerC3;
	private JTextPane textPaneResultado;
	private JButton btnActualizarCaudal;
	
	public App() {
		setTitle("Medidor de caudal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panelCompuertas = new JPanel();
		panelCompuertas.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Compuertas", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		panelCompuertas.setBounds(38, 12, 386, 151);
		panelCompuertas.setLayout(null);
		contentPane.add(panelCompuertas);
		
		lblFlujoCompuerta1 = new JLabel("Flujo compuerta 1:");
		lblFlujoCompuerta1.setBounds(12, 28, 131, 15);
		panelCompuertas.add(lblFlujoCompuerta1);
		
		lblFlujoCompuerta2 = new JLabel("Flujo compuerta 2:");
		lblFlujoCompuerta2.setBounds(12, 68, 131, 15);
		panelCompuertas.add(lblFlujoCompuerta2);
		
		lblFlujoCompuerta3 = new JLabel("Flujo compuerta 3:");
		lblFlujoCompuerta3.setBounds(12, 109, 131, 15);
		panelCompuertas.add(lblFlujoCompuerta3);
		
		spinnerC1 = new JSpinner(modelSpiner1);
		spinnerC1.setBounds(188, 27, 101, 17);
		panelCompuertas.add(spinnerC1);
		
		spinnerC2 = new JSpinner(modelSpiner2);
		spinnerC2.setBounds(188, 66, 101, 17);
		panelCompuertas.add(spinnerC2);
		
		spinnerC3 = new JSpinner(modelSpiner3);
		spinnerC3.setBounds(188, 107, 101, 17);
		panelCompuertas.add(spinnerC3);
		
		textPaneResultado = new JTextPane();
		textPaneResultado.setBounds(214, 191, 206, 44);
		contentPane.add(textPaneResultado);
		
		btnActualizarCaudal = new JButton("Actualizar caudal");
		btnActualizarCaudal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int caudal = (int) spinnerC1.getValue() + (int) spinnerC2.getValue() + (int) spinnerC3.getValue(); 
				
				if (0 < caudal && caudal <= 100) {
					textPaneResultado.setText(caudal + " mts³/s caudal bajo.");
				}else if (101 <= caudal && caudal <= 200) {
					textPaneResultado.setText(caudal + " mts³/s caudal medio.");
				}else if (200 < caudal) {
					textPaneResultado.setText(caudal + " mts³/s caudal alto.");
				}
			}
		});
		btnActualizarCaudal.setBounds(38, 198, 156, 25);
		contentPane.add(btnActualizarCaudal);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		App app = new App();
	}
}
