package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import modelo.Direccion;
import util.HibernateUtil;

public class DireccionDAOImpl implements DireccionDAO{
	private SessionFactory sf;
	
	public DireccionDAOImpl() {
		sf = HibernateUtil.getSessionFactory();
	}
	
	@Override
	public void crearDireccion(Direccion dir) {
		Transaction tx = null;
		
		try(Session sess = sf.openSession()) {
			tx = sess.beginTransaction();
			sess.persist(dir);
			tx.commit();
		}catch (RuntimeException e) {
			if (tx != null) tx.rollback();
		}
	}

	@Override
	public Direccion obtenerDireccion(Long id) {
		Transaction tx = null;
		Direccion dir = null;
		try(Session sess = sf.openSession()) {
			tx = sess.beginTransaction();
			dir = sess.find(Direccion.class, id);
			tx.commit();
		}catch (RuntimeException e) {
			if (tx != null) tx.rollback();
		}
		return dir;
	}

	@Override
	public void modificarDireccion(Direccion dir) {
		Transaction tx = null;
		
		try(Session sess = sf.openSession()) {
			tx = sess.beginTransaction();
			sess.merge(dir);
			tx.commit();
		}catch (RuntimeException e) {
			if (tx != null) tx.rollback();
		}
		
	}

	@Override
	public void eliminarDireccion(Long id) {
		Transaction tx = null;
		
		try(Session sess = sf.openSession()) {
			tx = sess.beginTransaction();
			sess.remove(obtenerDireccion(id));
			tx.commit();
		}catch (RuntimeException e) {
			if (tx != null) tx.rollback();
		}
		
	}

}
