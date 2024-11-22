package examen;

public class Biblioteca {
	//Atributos
	private static int limiteLibros = 3;
	
	//Dados los requisitos y al solo tener una biblioteca no necesitamos constructores. 
	//Volvemos todos sus métodos y atributos static para acceder a ellos mediante la clase.
	
	//Metodos
	public static void setMaximoLibrosPrestados(int maximo) {
		limiteLibros = maximo;
	}
	
	public static String consultarTotalLibrosPrestados() {
		return "Total de libros prestados actualmente: " + Libro.librosPrestados;
	}
	
	public static int getLimiteLibros() {			//Lo utilizaremos en nuestra clase Libro
		return limiteLibros;
	}
}
