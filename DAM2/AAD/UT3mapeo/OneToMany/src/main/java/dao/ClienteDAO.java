package dao;

import modelo.Cliente;

public interface ClienteDAO {
	public Cliente buscarPorId(long id);

	public void actualizar(Cliente c);

	public void eliminar(Cliente id);

	public void guardar(Cliente c);
}
