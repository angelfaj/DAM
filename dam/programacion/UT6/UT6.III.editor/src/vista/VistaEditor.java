package vista;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VistaEditor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextArea textArea;
	private JButton btnGuardar, btnCargar;
	private JButton btnSobreescribir;
	
	public VistaEditor() {
		setTitle("Editor de texto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textArea = new JTextArea();
		textArea.setBounds(10, 10, 416, 203);
		contentPane.add(textArea);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(20, 223, 110, 30);
		contentPane.add(btnGuardar);
		
		btnCargar = new JButton("Cargar");
		btnCargar.setBounds(316, 223, 110, 30);
		contentPane.add(btnCargar);
		
		btnSobreescribir = new JButton("Sobreescribir");
		btnSobreescribir.setBounds(172, 223, 110, 30);
		contentPane.add(btnSobreescribir);

		//Siempre al final
		setVisible(true);
		setResizable(false);
	}
	
	public JButton getBtnGuardar() {
		return btnGuardar;
	}
	
	public JButton getBtnCargar() {
		return btnCargar;
	}

	public JButton getBtnSobreescribir() {
		return btnSobreescribir;
	}
	
	public JTextArea getTxtField() {
		return textArea;
	}
	
	public void setTxtField(String text) {
		textArea.setText(text);
	}
}
