package calculadora;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

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
	String operador ="", n1 = "", n2 = "";	//String que almacenaran los numeros, de esta forma podremos introducir numeros mayores de 9 sin pisar el contenido
	boolean cambiaTurno = false;
	
	public UI() {
		setTitle("Calculadora");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 453, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		setResizable(false);
		
		JButton btnNewButtonEqual = new JButton("=");
		btnNewButtonEqual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				switch (operador) {
				case "-":
					//Integer.parseInt(n1) + Integer.parseInt(n2)
					;
				case "+":
					
					;
				case "x":
						
						;
				case "/":
					
					;
				default:
					throw new IllegalArgumentException("Unexpected value: " + key);
				}
			}
		});
		btnNewButtonEqual.setBounds(234, 348, 86, 73);
		contentPane.add(btnNewButtonEqual);
		
		JButton btnNewButtonSum = new JButton("+");
		btnNewButtonSum.setBounds(332, 348, 86, 73);
		contentPane.add(btnNewButtonSum);
		
		JButton btnNewButtonCero = new JButton("0");
		btnNewButtonCero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!cambiaTurno) {
					n1 += "0";
				}else {
					n2 += "0";
				}
			}
		});
		btnNewButtonCero.setBounds(136, 348, 86, 73);
		contentPane.add(btnNewButtonCero);
		
		JButton btnNewButtondecimal = new JButton(".");
		btnNewButtondecimal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!cambiaTurno) {
					n1 += ".";
				}else {
					n2 += ".";
				}
			}
		});
		btnNewButtondecimal.setBounds(38, 348, 86, 73);
		contentPane.add(btnNewButtondecimal);
		
		JButton btnNewButtonOne = new JButton("1");
		btnNewButtonOne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!cambiaTurno) {
					n1 += "1";
				}else {
					n2 += "1";
				}
			}
		});
		btnNewButtonOne.setBounds(38, 263, 86, 73);
		contentPane.add(btnNewButtonOne);
		
		JButton btnNewButtonTwo = new JButton("2");
		btnNewButtonTwo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!cambiaTurno) {
					n1 += "2";
				}else {
					n2 += "2";
				}
			}
		});
		btnNewButtonTwo.setBounds(136, 263, 86, 73);
		contentPane.add(btnNewButtonTwo);
		
		JButton btnNewButtonTrhee = new JButton("3");
		btnNewButtonTrhee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!cambiaTurno) {
					n1 += "3";
				}else {
					n2 += "3";
				}
			}
		});
		btnNewButtonTrhee.setBounds(234, 263, 86, 73);
		contentPane.add(btnNewButtonTrhee);
		
		JButton btnNewButtonSustract = new JButton("-");
		btnNewButtonSustract.setBounds(332, 263, 86, 73);
		contentPane.add(btnNewButtonSustract);
		
		JButton btnNewButtonFour = new JButton("4");
		btnNewButtonFour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!cambiaTurno) {
					n1 += "4";
				}else {
					n2 += "4";
				}
			}
		});
		btnNewButtonFour.setBounds(38, 178, 86, 73);
		contentPane.add(btnNewButtonFour);
		
		JButton btnNewButtonFive = new JButton("5");
		btnNewButtonFive.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!cambiaTurno) {
					n1 += "5";
				}else {
					n2 += "5";
				}
			}
		});
		btnNewButtonFive.setBounds(136, 178, 86, 73);
		contentPane.add(btnNewButtonFive);
		
		JButton btnNewButtonSix = new JButton("6");
		btnNewButtonSix.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!cambiaTurno) {
					n1 += "6";
				}else {
					n2 += "6";
				}
			}
		});
		btnNewButtonSix.setBounds(234, 178, 86, 73);
		contentPane.add(btnNewButtonSix);
		
		JButton btnNewButtonMultiply = new JButton("x");
		btnNewButtonMultiply.setBounds(332, 178, 86, 73);
		contentPane.add(btnNewButtonMultiply);
		
		JButton btnNewButtonSeven = new JButton("7");
		btnNewButtonSeven.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!cambiaTurno) {
					n1 += "7";
				}else {
					n2 += "7";
				}
			}
		});
		btnNewButtonSeven.setBounds(38, 93, 86, 73);
		contentPane.add(btnNewButtonSeven);
		
		JButton btnNewButtonEight = new JButton("8");
		btnNewButtonEight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!cambiaTurno) {
					n1 += "8";
				}else {
					n2 += "8";
				}
			}
		});
		btnNewButtonEight.setBounds(136, 93, 86, 73);
		contentPane.add(btnNewButtonEight);
		
		JButton btnNewButtonNine = new JButton("9");
		btnNewButtonNine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!cambiaTurno) {
					n1 += "9";
				}else {
					n2 += "9";
				}
			}
		});
		btnNewButtonNine.setBounds(234, 93, 86, 73);
		contentPane.add(btnNewButtonNine);
		
		JButton btnNewButtonDivide = new JButton("/");
		btnNewButtonDivide.setBounds(332, 93, 86, 73);
		contentPane.add(btnNewButtonDivide);
		
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setBounds(38, 23, 380, 60);
		contentPane.add(textField);
		textField.setColumns(10);
	}
}
