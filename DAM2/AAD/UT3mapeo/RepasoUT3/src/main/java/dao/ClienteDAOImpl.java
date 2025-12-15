package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


import com.sun.jdi.LongType;

import jakarta.persistence.Query;
import modelo.Cliente;
import util.HibernateUtil;

public class ClienteDAOImpl implements ClienteDAO {
	private SessionFactory sf;
	
	public ClienteDAOImpl() {
		sf = HibernateUtil.getSessionFactory();
	}
	
	@Override
	public void crearCliente(Cliente cliente) {
		Transaction tx = null;
		
		try(Session sess = sf.openSession()) {
			tx = sess.beginTransaction();
			sess.persist(cliente);
			tx.commit();
		}catch (RuntimeException e) {
			if (tx != null) tx.rollback();
		}
	}

	@Override
	public Cliente obtenerCliente(Long id) {
		Transaction tx = null;
		Cliente cliente = null;
		
		try(Session sess = sf.openSession()) {
			tx = sess.beginTransaction();
			cliente = sess.find(Cliente.class, id);
			tx.commit();
		}catch (RuntimeException e) {
			if (tx != null) tx.rollback();
		}
		return cliente;
	}

	@Override
	public void modificarCliente(Cliente cliente) {
		Transaction tx = null;
		
		try(Session sess = sf.openSession()) {
			tx = sess.beginTransaction();
			sess.merge(cliente);
			tx.commit();
		}catch (RuntimeException e) {
			if (tx != null) tx.rollback();
		}
	}

	@Override
	public void eliminarCliente(Long id) {
		Transaction tx = null;
		
		try(Session sess = sf.openSession()) {
			tx = sess.beginTransaction();
			sess.remove(obtenerCliente(id));
			tx.commit();
		}catch (RuntimeException e) {
			if (tx != null) tx.rollback();
		}
	}

	public void obtenerTodosLosClientes() {
		
		try(Session sess = sf.openSession()){
			Query selectAll = sess.createQuery("SELECT c FROM Cliente c", Cliente.class);
			List<Cliente> clientes = (List<Cliente>) selectAll.getResultList();
			
			for (Cliente c:clientes) {
				System.out.println(c);
			}
		}catch (RuntimeException e) {
			e.printStackTrace();
		}
	}
	
	public void getClienteYDireccion(Long id) {
		try(Session sess = sf.openSession()) {
			Query consultaNombreYDireccion = sess.createQuery("SELECT c.nombre, c.direccion FROM Cliente c LEFT JOIN c.direccion d"
					+ " WHERE c.id = :id", Object[].class);
			consultaNombreYDireccion.setParameter("id", id);
			List<Object[]> clientes = (List<Object[]>) consultaNombreYDireccion.getResultList();
			
			
			for (Object[] c : clientes) {
				System.out.println("Nombre-" + c[0] + ":Direccion:" + c[1]);
			}
		}
	}
	
	public void getClientesEmpiezanPor(String regex) {
		try(Session sess = sf.openSession()) {
			Query consulta = sess.createQuery("FROM Cliente c WHERE c.nombre LIKE ?1", Cliente.class);
			consulta.setParameter(1, regex);
			List<Cliente> clientes = (List<Cliente>) consulta.getResultList();
			
			for (Cliente c:clientes) {
				System.out.println(c);
			}
		}
	}
}




