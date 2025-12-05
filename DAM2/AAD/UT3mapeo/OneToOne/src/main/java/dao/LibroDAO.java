package dao;

import modelo.Libro;

public interface LibroDAO {
	public Libro buscarPorId(long id);

	public void actualizar(Libro p);

	public void eliminar(Long id);

	public void guardar(Libro p);

}
