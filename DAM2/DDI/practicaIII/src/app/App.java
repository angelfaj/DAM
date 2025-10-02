package app;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class App extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnHacerEncuesta;

	public App() {
		setTitle("Introduccion a la encuesta");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnHacerEncuesta = new JButton("Hacer encuesta");
		btnHacerEncuesta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Encuesta();
				setVisible(false);
			}
		});
		btnHacerEncuesta.setBounds(159, 80, 145, 25);
		contentPane.add(btnHacerEncuesta);
		
		setVisible(true);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App frame = new App();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
