package dao;

import modelo.DetalleLibro;

public interface DetalleLibroDAO {
	public DetalleLibro buscarPorId(long id);

	public void actualizar(DetalleLibro p);

	public void eliminar(Long id);

	public void guardar(DetalleLibro p);
}
