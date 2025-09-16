package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;

public class VistaFondo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnVerde, btnBlanco, btnNegro;
	private JLabel lblPulsa;

	public VistaFondo() {
		setTitle("Cambio de fondo");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		contentPane.setLayout(null);
		
		lblPulsa = new JLabel("Pulsa cualquier boton:");
		lblPulsa.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPulsa.setForeground(new Color(0, 0, 0));
		lblPulsa.setBounds(51, 89, 138, 14);
		contentPane.add(lblPulsa);
		
		btnBlanco = new JButton("Blanco");
		btnBlanco.setBackground(new Color(255, 255, 255));
		btnBlanco.setBounds(51, 123, 89, 23);
		contentPane.add(btnBlanco);
		
		btnNegro = new JButton("Negro");
		btnNegro.setForeground(new Color(255, 255, 255));
		btnNegro.setBackground(new Color(0, 0, 0));
		btnNegro.setBounds(173, 123, 89, 23);
		contentPane.add(btnNegro);
		
		btnVerde = new JButton("Verde");
		btnVerde.setForeground(new Color(255, 255, 255));
		btnVerde.setBackground(new Color(0, 102, 0));
		btnVerde.setBounds(293, 123, 89, 23);
		contentPane.add(btnVerde);
		
		setResizable(false);
		setVisible(true);
	}

	public JButton getBtnVerde() {
		return btnVerde;
	}

	public JButton getBtnBlanco() {
		return btnBlanco;
	}

	public JButton getBtnNegro() {
		return btnNegro;
	}
	
	public JLabel getLblPulsa() {
		return lblPulsa;
	}

}
