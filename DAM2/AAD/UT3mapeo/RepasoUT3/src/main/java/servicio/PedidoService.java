package servicio;

import dao.PedidoDAOImpl;
import modelo.Pedido;

public class PedidoService {
	private PedidoDAOImpl dao;
	
	public PedidoService() {
		dao = new PedidoDAOImpl();
	}
	public void crearPedido(Pedido pedido) {
		dao.crearPedido(pedido);
	}
	
	public Pedido obtenerPedido(Long id) {
		return dao.obtenerPedido(id);
	}
	
	public void modificarPedido(Pedido pedido) {
		dao.modificarPedido(pedido);
	}
	
	public void eliminarPedido(Long id) {
		dao.eliminarPedido(id);
	}
}
