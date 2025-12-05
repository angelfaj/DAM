package dao;

import modelo.Cliente;

public interface ClienteDAO {
	public Cliente buscarPorId(Long id);

	public void actualizar(Cliente c);

	public void eliminar(Long id);

	public void guardar(Cliente c);
}
