package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class VistaPedido extends JFrame {

	private JPanel contentPane;
	private JPanel pedidoPane;
	private JPanel goodsPane;
	private JTextField textFieldPedido;
	private JTextArea textArea;
	private JCheckBox chckbxHamburguesa, chckbxPatatas, chckbxCocaCola, chckbxHelado;
	private JButton btnAniadirTxt, btnBuscar, btnMostrarTodo,btnAniadirObj;
	
	public VistaPedido() {
		setTitle("Gestor de pedidos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 462, 309);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		pedidoPane = new JPanel();
		pedidoPane.setBounds(23, 10, 285, 32);
		contentPane.add(pedidoPane);
		pedidoPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre pedido:");
		lblNombre.setBounds(12, 7, 139, 15);
		pedidoPane.add(lblNombre);
		
		textFieldPedido = new JTextField();
		textFieldPedido.setBounds(159, 5, 114, 19);
		pedidoPane.add(textFieldPedido);
		textFieldPedido.setColumns(10);
		
		goodsPane = new JPanel();
		goodsPane.setBounds(23, 44, 397, 32);
		contentPane.add(goodsPane);
		goodsPane.setLayout(null);
		
		chckbxHamburguesa = new JCheckBox("Hamburguesa");
		chckbxHamburguesa.setBounds(8, 5, 124, 23);
		goodsPane.add(chckbxHamburguesa);
		
		chckbxPatatas = new JCheckBox("Patatas");
		chckbxPatatas.setBounds(134, 5, 81, 23);
		goodsPane.add(chckbxPatatas);
		
		chckbxCocaCola = new JCheckBox("Coca cola");
		chckbxCocaCola.setBounds(220, 5, 92, 23);
		goodsPane.add(chckbxCocaCola);
		
		chckbxHelado = new JCheckBox("Helado");
		chckbxHelado.setBounds(317, 5, 75, 23);
		goodsPane.add(chckbxHelado);
		
		btnAniadirTxt = new JButton("AñadirTXT");
		btnAniadirTxt.setBounds(20, 109, 117, 25);
		contentPane.add(btnAniadirTxt);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(320, 10, 100, 25);
		contentPane.add(btnBuscar);
		
		btnMostrarTodo = new JButton("Mostrar todo");
		btnMostrarTodo.setBounds(279, 109, 141, 25);
		contentPane.add(btnMostrarTodo);
		
		textArea = new JTextArea();
		textArea.setBounds(12, 146, 414, 107);
		contentPane.add(textArea);
		
		btnAniadirObj = new JButton("AñadirOBJ");
		btnAniadirObj.setBounds(149, 109, 117, 25);
		contentPane.add(btnAniadirObj);
		
		setResizable(false);
		setVisible(true);
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public JPanel getPedidoPane() {
		return pedidoPane;
	}

	public JPanel getGoodsPane() {
		return goodsPane;
	}

	public JTextField getTextFieldPedido() {
		return textFieldPedido;
	}

	public JTextArea getTextArea() {
		return textArea;
	}

	public JCheckBox getChckbxHamburguesa() {
		return chckbxHamburguesa;
	}

	public JCheckBox getChckbxPatatas() {
		return chckbxPatatas;
	}

	public JCheckBox getChckbxCocaCola() {
		return chckbxCocaCola;
	}

	public JCheckBox getChckbxHelado() {
		return chckbxHelado;
	}

	public JButton getBtnAniadirTxt() {
		return btnAniadirTxt;
	}

	public JButton getBtnBuscar() {
		return btnBuscar;
	}

	public JButton getBtnMostrarTodo() {
		return btnMostrarTodo;
	}

	public JButton getBtnAniadirObj() {
		return btnAniadirObj;
	}
	
	
	
}
