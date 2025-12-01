package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import modelo.Cliente;
import util.HibernateUtil;

public class ClienteDAOImpl implements ClienteDAO{
	private SessionFactory factory;

	public ClienteDAOImpl() {
		// Hacemos una primera conexión para que la primera consulta no tarde en
		// realizarse
		factory = HibernateUtil.getSessionFactory();
	}
	@Override
	public Cliente buscarPorId(long id) {
		Session sess = factory.openSession(); // No consume recursos de BD hasta que no es necesario
		Cliente p = null;
		Transaction tx = null;
		try {
			tx = sess.beginTransaction();// inicio mi transaccion
			// busco empleado que conozco que existe
			p = sess.find(Cliente.class, id);

			tx.commit(); // Se hacen efectivos los cambios en BD
		} catch (RuntimeException e1) {
			if (tx != null)
				tx.rollback();
			throw e1; // o visualizamos mensaje de error
		} finally {
			sess.close();
		}
		return p;

	}

	@Override
	public void actualizar(Cliente p) {
		Session sess = factory.openSession(); // No consume recursos de BD hasta que no es necesario
		
		Transaction tx = null;
		try {
			tx = sess.beginTransaction();// inicio mi transaccion
			// inserto empleado
			sess.merge(p);
			
			tx.commit(); // Se hacen efectivos los cambios en BD
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e; // o visualizamos mensaje de error
		} finally {
			sess.close();
		}
	}

	@Override
	public void eliminar(Long id) {
		Session sess = factory.openSession(); // No consume recursos de BD hasta que no es necesario

		Transaction tx = null;
		try {
			tx = sess.beginTransaction();// inicio mi transaccion
			// borro empleado
			sess.remove(buscarPorId(id));

			tx.commit(); // Se hacen efectivos los cambios en BD
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e; // o visualizamos mensaje de error
		} finally {
			sess.close();
		}
	}

	@Override
	public void guardar(Cliente p) {
		Session sess = factory.openSession(); // No consume recursos de BD hasta que no es necesario

		Transaction tx = null;
		try {
			tx = sess.beginTransaction();// inicio mi transaccion
			// inserto empleado
			sess.persist(p);

			tx.commit(); // Se hacen efectivos los cambios en BD
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e; // o visualizamos mensaje de error
		} finally {
			sess.close();
		}
	}

}
