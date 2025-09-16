package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class VistaCalculadora extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textFieldResult;
	private JButton btnSum, btnSubstract, btnMultiply, btnDivide;


	public VistaCalculadora() {
		setTitle("Calculadora");							//Titulos de la ventana	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);				//Permite mover donde queramos los componentes con el mouse 
		
		textField_1 = new JTextField();
		textField_1.setBounds(39, 106, 169, 55);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(225, 106, 169, 55);
		contentPane.add(textField_2);
		
		textFieldResult = new JTextField();
		textFieldResult.setFont(new Font("Tahoma", Font.BOLD, 16));
		textFieldResult.setForeground(new Color(0, 0, 0));
		textFieldResult.setText("TOTAL:");
		textFieldResult.setEnabled(false);
		textFieldResult.setColumns(10);
		textFieldResult.setBounds(39, 43, 355, 55);
		contentPane.add(textFieldResult);
		
		btnSum = new JButton("+");
		btnSum.setForeground(new Color(255, 255, 255));
		btnSum.setBackground(new Color(255, 102, 51));
		btnSum.setBounds(39, 172, 87, 55);
		contentPane.add(btnSum);
		
		btnSubstract = new JButton("-");
		btnSubstract.setForeground(new Color(255, 255, 255));
		btnSubstract.setBackground(new Color(255, 102, 51));
		btnSubstract.setBounds(128, 172, 87, 55);
		contentPane.add(btnSubstract);
		
		btnMultiply = new JButton("x");
		btnMultiply.setForeground(new Color(255, 255, 255));
		btnMultiply.setBackground(new Color(255, 102, 51));
		btnMultiply.setBounds(218, 172, 87, 55);
		contentPane.add(btnMultiply);
		
		btnDivide = new JButton("/");
		btnDivide.setForeground(new Color(255, 255, 255));
		btnDivide.setBackground(new Color(255, 102, 51));
		btnDivide.setBounds(307, 172, 87, 55);
		contentPane.add(btnDivide);
		
		setResizable(false);						//Bloqueamos el tamño
		setVisible(true);
		
	}


	public JTextField getTextField_1() {
		return textField_1;
	}


	public JTextField getTextField_2() {
		return textField_2;
	}


	public JTextField getTextFieldResult() {
		return textFieldResult;
	}


	public JButton getBtnSum() {
		return btnSum;
	}


	public JButton getBtnSubstract() {
		return btnSubstract;
	}


	public JButton getBtnMultiply() {
		return btnMultiply;
	}


	public JButton getBtnDivide() {
		return btnDivide;
	}
}
