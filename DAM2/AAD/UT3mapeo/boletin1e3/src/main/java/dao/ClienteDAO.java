package dao;

import modelo.Cliente;

public interface ClienteDAO {

	public Cliente buscarPorId(long id);

	public void actualizar(Cliente p);

	public void eliminar(Long id);

	public void guardar(Cliente p);

}
