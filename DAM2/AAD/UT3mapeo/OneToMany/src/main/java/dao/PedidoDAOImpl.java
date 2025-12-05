package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import modelo.Pedido;

public class PedidoDAOImpl implements PedidoDAO{
	private SessionFactory factory;
	
	@Override
	public Pedido buscarPorId(Long id) {
		Session sess = factory.openSession();
		Transaction tx = null;
		Pedido p = null;
		
		try {
			tx = sess.beginTransaction();
			p = sess.find(Pedido.class, id);
			tx.commit();
		}catch (RuntimeException e) {
			if (tx != null) tx.rollback();
			throw e;
		}finally {
			sess.close();
		}
		
		return p;
	}

	@Override
	public void actualizar(Pedido p) {
		Session sess = factory.openSession();
		Transaction tx = null;
		
		try {
			tx = sess.beginTransaction();
			sess.merge(p);
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
	public void guardar(Pedido p) {
		Transaction tx = null;
		try (Session sess = factory.openSession()) {
			tx = sess.beginTransaction();
			sess.persist(p);
			tx.commit();
		}catch (RuntimeException e) {
			if (tx != null) tx.rollback();
		}
	}

}