package examen;

public class TestBiblioteca {

	public static void main(String[] args) {
		//Creamos los libros con los que trabajaremos y establecemos un mensaje prioritario 
		Libro libro1 = new Libro("El Quijote", "Miguel Cervantes");
		Libro libro2 = new Libro("Apocalipsis", "Stephen King", 1500);
		Libro libro3 = new Libro("Drácula", "Bram Stocker");
		
		String mensajePrioritario = "se pudo realizar el préstamo prioritario para el libro: ";
		
		
		//Introducimos las páginas a posteriori
		System.out.println("Numero de páginas de " + libro3.getTitulo() + ": " + libro3.getNumeroPaginas());
		libro3.setNumeroPaginas(600);
		System.out.println("Numero de páginas de " + libro3.getTitulo() + ": " + libro3.getNumeroPaginas());
		
		//Cambiamos el límite de libros prestados
		System.out.println(libro1.prestarLibro());
		Biblioteca.setMaximoLibrosPrestados(1);
		System.out.println(Biblioteca.consultarTotalLibrosPrestados());
		
		System.out.println(libro2.prestarLibro());
		Biblioteca.setMaximoLibrosPrestados(2);
		
		//Probamos el mensaje prioritario
		System.out.println(libro3.prestarLibro(mensajePrioritario));
		System.out.println(libro2.prestarLibro(mensajePrioritario));
		System.out.println(Biblioteca.consultarTotalLibrosPrestados());
		
		//Probamos a devolver más libros de la cuenta
		libro1.devolverLibro();
		System.out.println(Biblioteca.consultarTotalLibrosPrestados());
		libro1.devolverLibro();
		libro1.devolverLibro();
		
	}

}
