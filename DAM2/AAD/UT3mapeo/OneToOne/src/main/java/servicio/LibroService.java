package servicio;

import dao.LibroDAO;
import modelo.Libro;

public class LibroService {
private final LibroDAO libroDAO;
	
	public LibroService(LibroDAO libroDAO) {
		this.libroDAO = libroDAO;
	}
	
	 public void registrarLibro(Libro l) {
	     // Lógica de negocio: Validar longitud del nombre 
	     if (l.getTitulo().length() < 2) {
	         throw new IllegalArgumentException("El nombre del libro debe tener al menos dos caracteres.");
	     }
	    libroDAO.guardar(l);
	 }

	 public Libro obtenerLibro(Long id) {
	     // Aquí no hay lógica de negocio compleja, solo delegamos
	     return libroDAO.buscarPorId(id);
	 }

	 public void modificarLibro(Libro l) {
	     // Lógica de negocio: Asegurar que el ID exista antes de actualizar
	     if (libroDAO.buscarPorId(l.getId()) == null) {
	          throw new IllegalArgumentException("El objeto a modificar no existe.");
	     }
	     libroDAO.actualizar(l);
	 }

	 public void eliminarLibro(Long id) {
	     libroDAO.eliminar(id);
	 }
}
