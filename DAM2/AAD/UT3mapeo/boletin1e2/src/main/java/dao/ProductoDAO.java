package dao;

import modelo.Producto;

public interface ProductoDAO {

	public Producto buscarPorId(long id);

	public void actualizar(Producto p);

	public void eliminar(Long id);

	public void guardar(Producto p);

}
