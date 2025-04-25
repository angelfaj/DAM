package app;

import controlador.ControladorPedido;
import modelo.GestionPedido;
import vista.VistaPedido;

public class Main {

	public static void main(String[] args) {
		
		GestionPedido modelo = new GestionPedido();
		VistaPedido vista = new VistaPedido();
		
		new ControladorPedido(vista, modelo);
		
	}
}
