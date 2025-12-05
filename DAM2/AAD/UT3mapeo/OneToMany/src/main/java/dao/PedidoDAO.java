package dao;

import modelo.Pedido;

public interface PedidoDAO {
	public Pedido buscarPorId(long id);

	public void actualizar(Pedido p);

	public void eliminar(Pedido id);

	public void guardar(Pedido p);
}
