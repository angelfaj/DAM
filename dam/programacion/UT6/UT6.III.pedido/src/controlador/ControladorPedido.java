package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.GestionPedido;
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
		Falta
	}
}
