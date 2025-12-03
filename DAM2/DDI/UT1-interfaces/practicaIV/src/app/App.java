package app;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class App extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btn4, btn3, btn2, btn1;
	private JPanel panelAscensor;
	private static JLabel lblNPiso;
	private static JLabel lblDirPiso;
	
	public App() {
		setTitle("Ascensor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btn4 = new JButton("4");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accionAscensor(btn4);
				lblNPiso.setText(btn4.getText());
			}
		});
		btn4.setBounds(23, 0, 70, 52);
		contentPane.add(btn4);
		
		btn3 = new JButton("3");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accionAscensor(btn3);
				lblNPiso.setText(btn3.getText());
			}
		});
		btn3.setBounds(23, 64, 70, 52);
		contentPane.add(btn3);
		
		btn2 = new JButton("2");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accionAscensor(btn2);
				lblNPiso.setText(btn2.getText());
			}
		});
		btn2.setBounds(23, 128, 70, 52);
		contentPane.add(btn2);
		
		btn1 = new JButton("1");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accionAscensor(btn1);
				lblNPiso.setText(btn1.getText());
			}
		});
		btn1.setBounds(23, 192, 70, 52);
		contentPane.add(btn1);
		
		panelAscensor = new JPanel();
		panelAscensor.setBorder(new TitledBorder(null, "Informaci\u00F3n de planta", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelAscensor.setBounds(162, 0, 255, 117);
		panelAscensor.setLayout(null);
		contentPane.add(panelAscensor);
		
		JLabel lblPiso = new JLabel("Piso:");
		lblPiso.setBounds(12, 33, 35, 15);
		panelAscensor.add(lblPiso);
		
		JLabel lblDireccin = new JLabel("Dirección:");
		lblDireccin.setBounds(12, 90, 70, 15);
		panelAscensor.add(lblDireccin);
		
		lblNPiso = new JLabel("");
		lblNPiso.setBounds(122, 33, 70, 15);
		panelAscensor.add(lblNPiso);
		
		lblDirPiso = new JLabel("");
		lblDirPiso.setBounds(122, 90, 121, 15);
		panelAscensor.add(lblDirPiso);
		
		setVisible(true);
	}

	private static void accionAscensor(JButton btn) {
		try {
			if (lblNPiso.getText().isEmpty()) {
				lblDirPiso.setText("Planta actual");
			}else if (lblNPiso.getText().equals(btn.getText())) {
				lblDirPiso.setText("Planta actual");
			}else if (Integer.parseInt(lblNPiso.getText()) > Integer.parseInt(btn.getText())) {
				lblDirPiso.setText("Bajando");
			}else {
				lblDirPiso.setText("Subiendo");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		App app = new App();
	}
}
