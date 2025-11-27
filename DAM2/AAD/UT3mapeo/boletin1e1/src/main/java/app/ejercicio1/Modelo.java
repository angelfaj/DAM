package app.ejercicio1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;



/**
 * En esta clase se interacciona con el modelo de datos de la aplicación Se
 * utiliza la clase HibernateUtil para crear las sesiones de conexión con
 * Hibernate
 */
public class Modelo {
	private SessionFactory factory;

	public Modelo() {
		// Hacemos una primera conexión para que la primera consulta no tarde en
		// realizarse
		factory = HibernateUtil.getSessionFactory();
	}
	
	// insertamos un empleado
		public void inserta(Empleado emp) {
			Session sess = factory.openSession(); // No consume recursos de BD hasta que no es necesario

			Transaction tx = null;
			try {
				tx = sess.beginTransaction();// inicio mi transaccion
				// inserto empleado
				sess.persist(emp);

				tx.commit(); // Se hacen efectivos los cambios en BD
			} catch (RuntimeException e) {
				if (tx != null)
					tx.rollback();
				throw e; // o visualizamos mensaje de error
			} finally {
				sess.close();
			}

		}

		public void actualiza(Empleado emp) {
			Session sess = factory.openSession(); // No consume recursos de BD hasta que no es necesario
			
			Transaction tx = null;
			try {
				tx = sess.beginTransaction();// inicio mi transaccion
				// inserto empleado
				sess.merge(emp);
				
				tx.commit(); // Se hacen efectivos los cambios en BD
			} catch (RuntimeException e) {
				if (tx != null)
					tx.rollback();
				throw e; // o visualizamos mensaje de error
			} finally {
				sess.close();
			}
			
		}
		
		// buscamos un empleado
		public Empleado buscar(int id) {
			Session sess = factory.openSession(); // No consume recursos de BD hasta que no es necesario
			Empleado e = null;
			Transaction tx = null;
			try {
				tx = sess.beginTransaction();// inicio mi transaccion
				// busco empleado que conozco que existe
				e = sess.find(Empleado.class, id);

				tx.commit(); // Se hacen efectivos los cambios en BD
			} catch (RuntimeException e1) {
				if (tx != null)
					tx.rollback();
				throw e1; // o visualizamos mensaje de error
			} finally {
				sess.close();
			}
			return e;

		}
		
		
		// borramos un empleado
		public void borrar(Empleado dep) {
			Session sess = factory.openSession(); // No consume recursos de BD hasta que no es necesario

			Transaction tx = null;
			try {
				tx = sess.beginTransaction();// inicio mi transaccion
				// borro empleado
				sess.remove(dep);

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
