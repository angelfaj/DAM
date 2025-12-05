package servicio;

import dao.DetalleLibroDAO;
import modelo.DetalleLibro;

public class DetalleLibroService {
	private final DetalleLibroDAO detalleLibroDAO;
	
	public DetalleLibroService(DetalleLibroDAO detalleLibroDAO) {
		this.detalleLibroDAO = detalleLibroDAO;
	}
	
	 public void registrarDetalleLibro(DetalleLibro dl) {
	     // Lógica de negocio: Validar longitud del nombre 
	     if (dl.getEditorial().length() < 2) {
	         throw new IllegalArgumentException("El nombre de la editorial debe tener al menos dos caracteres.");
	     }
	     detalleLibroDAO.guardar(dl);
	 }

	 public DetalleLibro obtenerdelleLibro(Long id) {
	     // Aquí no hay lógica de negocio compleja, solo delegamos
	     return detalleLibroDAO.buscarPorId(id);
	 }

	 public void modificarDetalleLibro(DetalleLibro dl) {
	     // Lógica de negocio: Asegurar que el ID exista antes de actualizar
	     if (detalleLibroDAO.buscarPorId(dl.getId()) == null) {
	          throw new IllegalArgumentException("El objeto a modificar no existe.");
	     }
	     detalleLibroDAO.actualizar(dl);
	 }

	 public void eliminarDetalleLibro(Long id) {
	     detalleLibroDAO.eliminar(id);
	 }
}
