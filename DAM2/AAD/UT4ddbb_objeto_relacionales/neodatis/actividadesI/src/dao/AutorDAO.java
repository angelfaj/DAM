package dao;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.criteria.ICriterion;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

import model.Autor;
import model.Jugador;

public class AutorDAO {
	public static void addAutor(Autor a) {
		ODB odb = ODBFactory.open("biblioteca.db");
		odb.store(a);	
		odb.close();
	}
	
	public static void getAllAutores() {
		ODB odb = ODBFactory.open("biblioteca.db");
		Objects<Autor> autores = null;
		
		autores = odb.getObjects(Autor.class);
		while(autores.hasNext()) {
			Autor a = autores.next();
			System.out.println(a);
		}
		
		odb.close();
	}
	
	public static void getEspañoles() {
		ODB odb = ODBFactory.open("biblioteca.db");

		ICriterion critEspañol = Where.equal("nacionalidad", "Española");
		CriteriaQuery query = new CriteriaQuery(Autor.class, critEspañol);
		query.orderByAsc("nombre");
		
		Objects<Autor> españoles = odb.getObjects(query);
		for (Autor e: españoles) {
			System.out.println(e);
		}
		odb.close();
	}
	
	public static void getLibrosDeAutoresEmpiezanPorS() {
		ODB odb = ODBFactory.open("biblioteca.db");
		
		ICriterion critNombreS = Where.like("nombre", "S%");
		CriteriaQuery query = new CriteriaQuery(Autor.class, critNombreS);
		query.orderByAsc("nombre");
		
		Objects<Autor> nombreS = odb.getObjects(query);
		for (Autor s: nombreS) {
			System.out.println(s.getNombre() + "[ " + s.getLibros() + " ]");
		}
		odb.close();
	}
}
