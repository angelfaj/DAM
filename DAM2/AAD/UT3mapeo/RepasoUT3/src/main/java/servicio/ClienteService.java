package servicio;

import dao.ClienteDAOImpl;
import modelo.Cliente;

public class ClienteService {
	private ClienteDAOImpl dao;
	
	public ClienteService() {
		dao = new ClienteDAOImpl();
	}
	
	public void crearCliente(Cliente cliente) {
		dao.crearCliente(cliente);
	}
	
	public Cliente obtenerCliente(Long id) {
		return dao.obtenerCliente(id);
	}
	
	public void modificarCliente(Cliente cliente) {
		dao.modificarCliente(cliente);
	}
	
	public void eliminarCliente(Long id) {
		dao.eliminarCliente(id);
	}
	
	public void obtenerTodosLosClientes() {
		dao.obtenerTodosLosClientes();
	}
	
	public void getClienteYDireccion(Long id) {
		dao.getClienteYDireccion(id);
	}
	
	public void getClientesEmpiezanPor(String regex) {
		dao.getClientesEmpiezanPor(regex);
	}
}
