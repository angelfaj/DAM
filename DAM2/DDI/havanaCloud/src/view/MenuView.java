package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnRealizarUnaReserva;


	public MenuView() {
		setTitle("Menú");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		getContentPane().setLayout(null);
		
		btnRealizarUnaReserva = new JButton("Realizar una reserva");
		btnRealizarUnaReserva.setBounds(143, 96, 181, 25);
		contentPane.add(btnRealizarUnaReserva);
		
		setVisible(true);
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public void setContentPane(JPanel contentPane) {
		this.contentPane = contentPane;
	}

	public JButton getBtnRealizarUnaReserva() {
		return btnRealizarUnaReserva;
	}

	public void setBtnRealizarUnaReserva(JButton btnRealizarUnaReserva) {
		this.btnRealizarUnaReserva = btnRealizarUnaReserva;
	}
}
