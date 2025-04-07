package fondo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class UI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI frame = new UI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UI() {
		setTitle("Cambio de fondo");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		contentPane.setLayout(null);
		
		JLabel lblPulsa = new JLabel("Pulsa cualquier boton:");
		lblPulsa.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPulsa.setForeground(new Color(0, 0, 0));
		lblPulsa.setBounds(51, 89, 138, 14);
		contentPane.add(lblPulsa);
		
		JButton btnBlanco = new JButton("Blanco");
		btnBlanco.setBackground(new Color(255, 255, 255));
		btnBlanco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setBackground(new Color(255, 255, 255));
				lblPulsa.setForeground(new Color(0, 0, 0));
			}
		});
		btnBlanco.setBounds(51, 123, 89, 23);
		contentPane.add(btnBlanco);
		
		JButton btnNegro = new JButton("Negro");
		btnNegro.setForeground(new Color(255, 255, 255));
		btnNegro.setBackground(new Color(0, 0, 0));
		btnNegro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setBackground(new Color(0, 0, 0));
				lblPulsa.setForeground(new Color(255, 255, 255));
			}
		});
		btnNegro.setBounds(173, 123, 89, 23);
		contentPane.add(btnNegro);
		
		JButton btnVerde = new JButton("Verde");
		btnVerde.setForeground(new Color(255, 255, 255));
		btnVerde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setBackground(new Color(0, 102, 0));
				lblPulsa.setForeground(new Color(255, 255, 255));
			}
		});
		btnVerde.setBackground(new Color(0, 102, 0));
		btnVerde.setBounds(293, 123, 89, 23);
		contentPane.add(btnVerde);
		
		setResizable(false);
	}

}
