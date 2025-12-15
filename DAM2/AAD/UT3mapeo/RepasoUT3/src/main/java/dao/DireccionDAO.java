package dao;

import modelo.Direccion;

public interface DireccionDAO {
	void crearDireccion(Direccion dir);
	Direccion obtenerDireccion(Long id);
	void modificarDireccion(Direccion dir);
	void eliminarDireccion(Long id);
}
