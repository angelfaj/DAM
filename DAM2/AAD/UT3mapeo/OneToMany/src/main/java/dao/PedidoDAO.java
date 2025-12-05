package dao;

import modelo.Pedido;

public interface PedidoDAO {
	public Pedido buscarPorId(Long id);

	public void actualizar(Pedido p);

	public void eliminar(Long id);

	public void guardar(Pedido p);
}
