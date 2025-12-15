package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import modelo.Pedido;
import util.HibernateUtil;

public class PedidoDAOImpl implements PedidoDAO{
	private SessionFactory sf;
	
	public PedidoDAOImpl() {
		sf = HibernateUtil.getSessionFactory();
	}
	
	@Override
	public void crearPedido(Pedido pedido) {
		Transaction tx = null;
		
		try(Session sess = sf.openSession()) {
			tx = sess.beginTransaction();
			sess.persist(pedido);
			tx.commit();
		}catch (RuntimeException e) {
			if (tx != null) tx.rollback();
		}
		
	}

	@Override
	public Pedido obtenerPedido(Long id) {
		Pedido pedido = null;
		Transaction tx = null;
		
		try(Session sess = sf.openSession()) {
			tx = sess.beginTransaction();
			pedido = sess.find(Pedido.class, id);
			tx.commit();
		}catch (RuntimeException e) {
			if (tx != null) tx.rollback();
		}
		
		return pedido;
	}

	@Override
	public void modificarPedido(Pedido pedido) {
		Transaction tx = null;
		
		try(Session sess = sf.openSession()) {
			tx = sess.beginTransaction();
			sess.merge(pedido);
			tx.commit();
		}catch (RuntimeException e) {
			if (tx != null) tx.rollback();
		}
		
	}

	@Override
	public void eliminarPedido(Long id) {
		Transaction tx = null;
		
		try(Session sess = sf.openSession()) {
			tx = sess.beginTransaction();
			sess.remove(obtenerPedido(id));
			tx.commit();
		}catch (RuntimeException e) {
			if (tx != null) tx.rollback();
		}
		
	}

}
