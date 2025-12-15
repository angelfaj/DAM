package dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.Session;

import modelo.Concesionario;
import util.HibernateUtil;

public class ConcesionarioDAOImpl implements ConcesionarioDAO {
	private SessionFactory sf;
	
	public ConcesionarioDAOImpl() {
		sf = HibernateUtil.getSessionFactory();
	}
	
	@Override
	public void save(Concesionario concesionario) {
		Transaction tx = null;
		
		try (Session sess = sf.openSession()) {
			tx = sess.beginTransaction();
			sess.persist(concesionario);
			tx.commit();
		}catch (RuntimeException e) {
			if (tx != null) tx.rollback();
		}
		
	}
	
	@Override
	public List<Object[]> obtenerDatosSedeTodosConcesionarios() {
		List<Object[]> datosSedes = null;
		
		try (Session sess = sf.openSession()) {
			datosSedes = sess.createQuery("SELECT c.nombre, c.sede.calle, c.sede.ciudad "
					+ "FROM Concesionario c", Object[].class).list();
		}catch (RuntimeException e) {
			e.printStackTrace();
		}
		return datosSedes;
	}

	@Override
	public Concesionario obtenerConcesionarioPorNombreYCiudad(String nombreConcesionario, String ciudad) {
		Concesionario concesionario = null;
		
		try (Session sess = sf.openSession()) {
			Query consulta = sess.createQuery("FROM Concesionario c "
					+ "WHERE c.nombre = :nombre AND c.sede.ciudad = :ciudad", Concesionario.class);
			consulta.setParameter("nombre", nombreConcesionario);
			consulta.setParameter("ciudad", ciudad);
			
			concesionario = (Concesionario) consulta.getSingleResult();
		}catch (RuntimeException e) {
			e.printStackTrace();
		}
		return concesionario;
	}

	@Override
	public Concesionario getById(Long idConcesionario) {
		Concesionario concesionario = null;
		
		try (Session sess = sf.openSession()) {
			concesionario = sess.find(Concesionario.class, idConcesionario);
		}catch (RuntimeException e) {
			e.printStackTrace();
		}
		
		return concesionario;
	}

	@Override
	public void update(Concesionario c) {
		Transaction tx = null;
		
		try (Session sess = sf.openSession()) {
			tx = sess.beginTransaction();
			sess.merge(c);
			tx.commit();
		}catch (RuntimeException e) {
			if (tx != null) tx.rollback();
		}
		
	}

	@Override
	public void delete(Concesionario c) {
		Transaction tx = null;
		
		try (Session sess = sf.openSession()) {
			tx = sess.beginTransaction();
			sess.remove(c);
			tx.commit();
		}catch (RuntimeException e) {
			if (tx != null) tx.rollback();
		}
		
	}

}
