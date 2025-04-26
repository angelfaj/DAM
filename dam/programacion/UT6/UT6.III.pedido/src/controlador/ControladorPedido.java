package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo.GestionPedido;
import modelo.Pedido;
import vista.VistaPedido;

public class ControladorPedido implements ActionListener {
	private VistaPedido vista;
	private GestionPedido modelo;
	
	public ControladorPedido(VistaPedido vista, GestionPedido modelo) {
		super();
		this.vista = vista;
		this.modelo = modelo;
		
		iniciar();
	}
	
	public void iniciar() {
		vista.getBtnAniadirTxt().addActionListener(this);
		vista.getBtnAniadirObj().addActionListener(this);
		vista.getBtnBuscar().addActionListener(this);
		vista.getBtnMostrarTodo().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Pedido p = null;
		
		if (e.getSource() == vista.getBtnAniadirTxt()) {
			p = new Pedido(vista.getTextFieldPedido().getText(), getComidas());
			try {
				modelo.savePedidoTxt(p);
				JOptionPane.showMessageDialog(vista, "Pedido guardado correctamente");
			} catch (FileNotFoundException e1) {
				JOptionPane.showMessageDialog(vista, e1.getMessage());
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(vista, e1.getMessage());
			}
		}else if(e.getSource() == vista.getBtnAniadirObj()) {
			p = new Pedido(vista.getTextFieldPedido().getText(), getComidas());
			try {
				modelo.savePedidoBin(p);
				JOptionPane.showMessageDialog(vista, "Pedido guardado correctamente");
			} catch (FileNotFoundException e1) {
				JOptionPane.showMessageDialog(vista, e1.getMessage());
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(vista, e1.getMessage());
			}
		}else if(e.getSource() == vista.getBtnBuscar()) {
			try {
				vista.getTextArea().setText(modelo.searchPedidoTxt(vista.getTextFieldPedido().getText())); 
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(vista, e1.getMessage());
			}
		}else if(e.getSource() == vista.getBtnMostrarTodo()) {
			try {
				vista.getTextArea().setText(modelo.readAllPedidoBin());
			} catch (ClassNotFoundException e1) {
				JOptionPane.showMessageDialog(vista, e1.getMessage());
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(vista, e1.getMessage());
			}
		}
	}

	private ArrayList<String> getComidas() {
		ArrayList<String> comidas = new ArrayList<String>();
		
		if (vista.getChckbxCocaCola().isSelected()) {
			comidas.add("Coca Cola");
		}
		if (vista.getChckbxHamburguesa().isSelected()) {
			comidas.add("Hamburguesa");
		}
		if (vista.getChckbxHelado().isSelected()) {
			comidas.add("Helado");
		}
		if (vista.getChckbxPatatas().isSelected()) {
			comidas.add("Patatas");
		}
		
		return comidas;
	}
}
