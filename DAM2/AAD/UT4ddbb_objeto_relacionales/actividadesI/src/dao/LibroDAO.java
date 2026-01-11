package dao;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;

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
}
