package servicio;

//En el servicio se realizan validaciones de negocio no se mezclan con la interfaz.
//Si se quiere hacer varias operaciones DAO en una misma transacción, se hace aquí un método y la app sólo llama al método.

import dao.ClienteDAO;
import modelo.Cliente;

public class ClienteService {

 private final ClienteDAO clienteDAO;

 public ClienteService(ClienteDAO clienteDAO) {
     this.clienteDAO = clienteDAO;
 }

 public void registrarCliente(Cliente p) {
     // Lógica de negocio: Validar que el precio no sea negativo
     if (p.getNombre().length() < 2) {
         throw new IllegalArgumentException("El precio del producto no puede ser negativo.");
     }
     clienteDAO.guardar(p);
 }

 public Cliente obtenerCliente(Long id) {
     // Aquí no hay lógica de negocio compleja, solo delegamos
     return clienteDAO.buscarPorId(id);
 }

 public void modificarCliente(Cliente p) {
     // Lógica de negocio: Asegurar que el ID exista antes de actualizar
     if (clienteDAO.buscarPorId(p.getId()) == null) {
          throw new IllegalArgumentException("El producto a modificar no existe.");
     }
     clienteDAO.actualizar(p);
 }

 public void eliminarCliente(Long id) {
     clienteDAO.eliminar(id);
 }
}
