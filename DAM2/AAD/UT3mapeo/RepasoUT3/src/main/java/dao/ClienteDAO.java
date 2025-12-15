package dao;

import modelo.Cliente;

public interface ClienteDAO {
	void crearCliente(Cliente cliente);
	Cliente obtenerCliente(Long id);
	void modificarCliente(Cliente cliente);
	void eliminarCliente(Long id);
}
