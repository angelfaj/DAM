package dao;

import modelo.Direccion;

public interface DireccionDAO {
	public Direccion buscarPorId(Long id);

	public void actualizar(Direccion d);

	public void eliminar(Long id);

	public void guardar(Direccion d);
}
