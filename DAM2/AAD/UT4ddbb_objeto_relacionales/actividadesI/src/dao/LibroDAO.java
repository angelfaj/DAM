package dao;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.criteria.ICriterion;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

import model.Libro;

public class LibroDAO {
	public static void addLibro(Libro l) {
		ODB odb = ODBFactory.open("biblioteca.db");
		odb.store(l);	
		odb.close();
	}
	
	public static void getAllLibros() {
		ODB odb = ODBFactory.open("biblioteca.db");
		Objects<Libro> libros = null;
		
		libros = odb.getObjects(Libro.class);
		while(libros.hasNext()) {
			Libro l = libros.next();
			System.out.println(l);
		}
		odb.close();
	}
	
	public static void getLibrosMas30Pag() {
		ODB odb = ODBFactory.open("biblioteca.db");

		ICriterion critPags = Where.gt("paginas", 30);
		CriteriaQuery query = new CriteriaQuery(Libro.class, critPags);
		query.orderByAsc("paginas");
		
		Objects<Libro> librosPaginas = odb.getObjects(query);
		for (Libro e: librosPaginas) {
			System.out.println(e);
		}
		odb.close();
	}
	
	
}
