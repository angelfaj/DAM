package servicio;

import dao.DireccionDAOImpl;
import modelo.Direccion;

public class DireccionService {
	private DireccionDAOImpl dao;
	
	public DireccionService() {
		dao = new DireccionDAOImpl();
	}
	
	public void crearDireccion(Direccion dir) {
		dao.crearDireccion(dir);
	}
	
	public Direccion obtenerDireccion(Long id) {
		return dao.obtenerDireccion(id);
	}
	
	public void modificarDireccion(Direccion dir) {
		dao.modificarDireccion(dir);
	}
	
	public void eliminarDireccion(Long id) {
		dao.eliminarDireccion(id);
	}
}
