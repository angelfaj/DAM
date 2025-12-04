package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import modelo.Libro;
import util.HibernateUtil;

public class LibroDAOImpl implements LibroDAO{
	private SessionFactory factory;

	public LibroDAOImpl() {
		//Primera conexion para q la consulta no tarde en realizarse
		factory = HibernateUtil.getSessionFactory();
	}
	
	@Override
	public Libro buscarPorId(long id) {
		Session sess = factory.openSession();
		Libro libro = null;
		Transaction tx = null;
		
		try {
			tx = sess.beginTransaction();
			libro = sess.find(Libro.class, id);
			tx.commit();
		}catch (RuntimeException e) {
			if (tx != null) tx.rollback();
			throw e;
		}finally {
			sess.close();
		}
		
		return libro;
	}

	@Override
	public void actualizar(Libro libro) {
		Session sess = factory.openSession();
		Transaction tx = null;
		
		try {
			tx = sess.beginTransaction();
			sess.merge(libro);
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
		}finally {
			sess.close();
		}
		
	}

	@Override
	public void guardar(Libro libro) {
		Session sess = factory.openSession();
		Transaction tx = null;
		
		try {
			tx = sess.beginTransaction();
			sess.persist(libro);
			tx.commit();
		}catch (RuntimeException e) {
			if (tx != null) tx.rollback();
		}finally {
			sess.close();
		}
		
	}

}
