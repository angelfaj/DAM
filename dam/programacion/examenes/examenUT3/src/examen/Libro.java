package examen;

public class Libro {
	//Atributos
	private String titulo, autor;
	private int numeroPaginas;
	public static int librosPrestados;				//Aumentará o decrementará en función de los libros prestados. Será llamado en la clase Biblioteca. 
	
	//Constructores
	public Libro(String titulo, String autor ) {
		this.titulo = titulo;
		this.autor = autor;
	}
	
	public Libro(String titulo, String autor, int numeroPaginas) {
		this(titulo, autor);
		this.numeroPaginas = numeroPaginas;
	}

	//Metodos
	public String getTitulo() {
		return titulo;
	}

	public String getAutor() {
		return autor;
	}

	public int getNumeroPaginas() {
		return numeroPaginas;
	}

	public void setNumeroPaginas(int numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}
	
	public String prestarLibro() {
		if (librosPrestados < Biblioteca.getLimiteLibros()) {		//Condicional para prestar los libros solo cuando sea posible
			librosPrestados++;
			return "Libro prestado: " + this.getTitulo();			//Cortamos antes la ejecución si la condicion de prestar se da
		} 
		return "No se pudo prestar el libro: " + this.getTitulo() + ". Ya está prestado o se alcanzó el límite.";
	}
	
	public String prestarLibro(String mensajePrioridad) {			//Sobrecargamos el método para añadirle funcionalidad
		if (librosPrestados < Biblioteca.getLimiteLibros()) {		
			librosPrestados++;
			return "Si " + mensajePrioridad + this.getTitulo();		//Concatenamos nuestro mensaje prioritario
		}
		return "No " + mensajePrioridad + this.getTitulo();  
	}
	
	public void devolverLibro() {
		if (librosPrestados == 0) {									//Condicional que evita tener un numero de libro negativos
			System.out.println("No se puede devolver el libro ya que no hay ningún préstamo en curso");
		} else
		librosPrestados--;
	}
}
