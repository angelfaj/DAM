package dao;

import modelo.Direccion;

public interface DireccionDAO {
	public Direccion buscarPorId(long id);

	public void actualizar(Direccion d);

	public void eliminar(Direccion id);

	public void guardar(Direccion d);
}
