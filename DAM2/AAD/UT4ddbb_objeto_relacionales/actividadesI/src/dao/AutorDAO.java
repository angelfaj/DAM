package dao;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;

import model.Autor;

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
}
