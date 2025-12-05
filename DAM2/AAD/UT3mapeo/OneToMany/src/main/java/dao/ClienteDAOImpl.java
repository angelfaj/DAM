package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import modelo.Cliente;

public class ClienteDAOImpl implements ClienteDAO{
	private SessionFactory factory;
	
	@Override
	public Cliente buscarPorId(Long id) {
		Session sess = factory.openSession();
		Transaction tx = null;
		Cliente c = null;
		
		try {
			tx = sess.beginTransaction();
			c = sess.find(Cliente.class, id);
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
	public void actualizar(Cliente c) {
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
	public void guardar(Cliente c) {
		Transaction tx = null;
		try (Session sess = factory.openSession()) {
			tx = sess.beginTransaction();
			sess.persist(c);
			tx.commit();
		}catch (RuntimeException e) {
			if (tx != null) tx.rollback();
		}
	}

}
