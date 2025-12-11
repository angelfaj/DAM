package dao;

import java.util.List;

import modelo.Customer;

public interface CustomerDAO {
	public Customer buscarPorId(Long id);

	public void actualizar(Customer c);

	public void eliminar(Long id);

	public void guardar(Customer c);
	
	public List<Customer> getAllCustomers();

	public List<Customer> getAllCustomersFromCountry(String country);
	
}
