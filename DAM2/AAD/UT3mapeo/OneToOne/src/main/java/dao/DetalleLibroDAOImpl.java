package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import modelo.DetalleLibro;
import util.HibernateUtil;

public class DetalleLibroDAOImpl implements DetalleLibroDAO{
	private SessionFactory factory;
	
	public DetalleLibroDAOImpl() {
		factory = HibernateUtil.getSessionFactory();
	}
	
	@Override
	public DetalleLibro buscarPorId(long id) {
		Session sess = factory.openSession();
		Transaction tx = null;
		DetalleLibro dl = null;
		
		try {
			tx = sess.beginTransaction();
			dl = sess.find(DetalleLibro.class, id);
			tx.commit();
		}catch (RuntimeException e) {
			if (tx != null) tx.rollback();
			throw e;
		}finally {
			sess.close();
		}
		return dl;
	}

	@Override
	public void actualizar(DetalleLibro dl) {
		Session sess = factory.openSession();
		Transaction tx = null;
		
		try {
			tx = sess.beginTransaction();
			sess.merge(dl);
			tx.commit();
		}catch (RuntimeException e) {
			if (tx != null) tx.rollback();
			throw e;
		}finally {
			sess.close();
		}
		
	}

	@Override
	public void eliminar(Long id) {
		Session sess = factory.openSession();
		Transaction tx = null;
		
		try {
			tx = sess.beginTransaction();
			sess.remove(buscarPorId(id));
			tx.commit();
		}catch (RuntimeException e) {
			if (tx != null) tx.rollback();
			throw e;
		}finally {
			sess.close();
		}
	}

	@Override
	public void guardar(DetalleLibro dl) {
		Session sess = factory.openSession();
		Transaction tx = null;
		
		try {
			tx = sess.beginTransaction();
			sess.persist(dl);
			tx.commit();
		}catch (RuntimeException e) {
			if (tx != null) tx.rollback();
			throw e;
		}finally {
			sess.close();
		}
	}

}
