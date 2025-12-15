package dao;

import modelo.Pedido;

public interface PedidoDAO {
	void crearPedido(Pedido pedido);
	Pedido obtenerPedido(Long id);
	void modificarPedido(Pedido pedido);
	void eliminarPedido(Long id);
}
