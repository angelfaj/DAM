package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import modelo.Direccion;
import util.HibernateUtil;

public class DireccionDAOImpl implements DireccionDAO{
	private SessionFactory factory;
		
	public DireccionDAOImpl() {
		factory = HibernateUtil.getSessionFactory();
	}

	@Override
	public Direccion buscarPorId(Long id) {
		Session sess = factory.openSession();
		Transaction tx = null;
		Direccion d = null;
		
		try {
			tx = sess.beginTransaction();
			d = sess.find(Direccion.class, id);
			tx.commit();
		}catch (RuntimeException e) {
			if (tx != null) tx.rollback();
			throw e;
		}finally {
			sess.close();
		}
		
		return d;
	}

	@Override
	public void actualizar(Direccion d) {
		Session sess = factory.openSession();
		Transaction tx = null;
		
		try {
			tx = sess.beginTransaction();
			sess.merge(d);
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
	public void guardar(Direccion d) {
		Transaction tx = null;
		try (Session sess = factory.openSession()) {
			tx = sess.beginTransaction();
			sess.persist(d);
			tx.commit();
		}catch (RuntimeException e) {
			if (tx != null) tx.rollback();
		}
	}

}
