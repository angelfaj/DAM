package dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;

import model.Autor;
import model.Libro;

public class InsertarDatosBiblioteca{
    public static void main(String[] args) {
        ODB odb = ODBFactory.open("biblioteca.db");

      

        // 📌 Insertar Libros
        List<Autor> listaAutores1 = new ArrayList<>();
        List<Autor> listaAutores2 = new ArrayList<>();
        List<Autor> listaAutores3 = new ArrayList<>();
        List<Autor> listaAutores4 = new ArrayList<>();

        Libro libro1 = new Libro("Java Avanzado", 2020, "Pearson", 450, listaAutores1);
        Libro libro2 = new Libro("Python para Todos", 2019, "O'Reilly", 350, listaAutores2);
        Libro libro3 = new Libro("C++ Moderno", 2021, "McGraw-Hill", 500, listaAutores3);
        Libro libro4 = new Libro("Historias Cortas", 2015, "Anaya", 25, listaAutores4); // Menos de 30 páginas
        odb.store(libro1);
        odb.store(libro2);
        odb.store(libro3);
        odb.store(libro4);

        // 📌 Insertar Autores
        List<Libro> listaLibros1 = new ArrayList<>();
        List<Libro> listaLibros2 = new ArrayList<>();
        List<Libro> listaLibros3 = new ArrayList<>();
        List<Libro> listaLibros4 = new ArrayList<>();

        Autor autor1 = new Autor("Carlos", "Pérez", "Española", 45, listaLibros1);
        Autor autor2 = new Autor("María", "Sánchez", "Argentina", 38, listaLibros2); // Apellido con "S"
        Autor autor3 = new Autor("Juan", "Rodríguez", "Mexicana", 50, listaLibros3);
        Autor autor4 = new Autor("Ana", "López", "Española", 42, listaLibros4);
        odb.store(autor1);
        odb.store(autor2);
        odb.store(autor3);
        odb.store(autor4);

        // 📌 Relacionar autores con libros
        libro1.getAutores().add(autor1);
        libro2.getAutores().add(autor2);
        libro3.getAutores().add(autor3);
        libro4.getAutores().add(autor4);
        odb.store(libro1);
        odb.store(libro2);
        odb.store(libro3);
        odb.store(libro4);

        // 📌 Relacionar libros con autores
        autor1.getLibros().add(libro1);
        autor2.getLibros().add(libro2);
        autor3.getLibros().add(libro3);
        autor4.getLibros().add(libro4);
        odb.store(autor1);
        odb.store(autor2);
        odb.store(autor3);
        odb.store(autor4);

        odb.close();
        System.out.println("✅ Datos insertados correctamente.");
    }
}
