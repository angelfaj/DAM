package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import modelo.Customer;
import util.HibernateUtil;

public class CustomerDAOImpl implements CustomerDAO{
	private SessionFactory factory;
	
	public CustomerDAOImpl() {
		factory = HibernateUtil.getSessionFactory();
	}
	
	@Override
	public Customer buscarPorId(Long id) {
		Session sess = factory.openSession();
		Transaction tx = null;
		Customer c = null;
		
		try {
			tx = sess.beginTransaction();
			c = sess.find(Customer.class, id);
			tx.commit();
		}catch (RuntimeException e) {
			if (tx != null) tx.rollback();
			throw e;
		}finally {
			sess.close();
		}
		
		return c;
	}

	@Override
	public void actualizar(Customer c) {
		Session sess = factory.openSession();
		Transaction tx = null;
		
		try {
			tx = sess.beginTransaction();
			sess.merge(c);
			tx.commit();
		}catch (RuntimeException e) {
			if (tx != null) tx.rollback();
		}finally {
			sess.close();
		}
	}

	@Override
	public void eliminar(Long id) {
		Transaction tx = null;
		try (Session sess = factory.openSession()) {
			tx = sess.beginTransaction();
			sess.remove(buscarPorId(id));
			tx.commit();
		}catch (RuntimeException e) {
			if (tx != null) tx.rollback();
		}
	}

	@Override
	public void guardar(Customer c) {
		Transaction tx = null;
		try (Session sess = factory.openSession()) {
			tx = sess.beginTransaction();
			sess.persist(c);
			tx.commit();
		}catch (RuntimeException e) {
			if (tx != null) tx.rollback();
		}
	}

	@Override
	public List<Customer> getAllCustomers() {
		List<Customer> customersList = null;
		
		try(Session sess = factory.openSession()) {
			Query consulta = sess.createQuery("select c from Customer c", Customer.class);
			customersList = (List<Customer>) consulta.getResultList();
		}catch (RuntimeException e) {
			e.printStackTrace();
		}
		return customersList;
	}

	@Override
	public List<Customer> getAllCustomersFromCountry(String country) {
		List<Customer> customersList = null;
		
		try(Session sess = factory.openSession()) {
			Query consulta = sess.createQuery("select c from Customer c where c.country = :pais", Customer.class);
			consulta.setParameter("pais", country);
			customersList = (List<Customer>) consulta.getResultList();
		}catch (RuntimeException e) {
			e.printStackTrace();
		}
		return customersList;
	}

}
