package hojaI;

public class Main {

	public static void main(String[] args) {
		/*Ejercicio 1
		Escribe una clase Multimedia para almacenar información de los objetos
		de tipo multimedia (películas, discos, mp3,mp4...). Esta clase contiene
		título, autor, formato, y duración como atributos. El formato puede ser uno
		de los siguientes: wav, mp3, midi, avi, mov, mpg, cdAudio y dvd. El valor de
		todos los atributos se pasa por parámetro en el momento de crear el
		objeto. Esta clase tiene además, un método para devolver cada uno de los
		atributos y un método toString() que devuelve la información del objeto.
		Por último, un método equals() que recibe un objeto de tipo Multimedia y
		devuelve true en caso de que el título y el autor sean iguales y false en
		caso contrario.
		Escribe una clase Película que herede de la clase Multimedia anterior. La
		clase Película tiene, además de los atributos heredados, un actor principal
		y una actriz principal. Se permite que uno de los dos sea nulo, pero no los
		dos. La clase debe tener dos métodos para obtener los nuevos atributos y
		debe sobreescribir el método toString() para reflejar la nueva información.
		
		Pelicula p = new Pelicula ("Alicia en el pais de las maravillas", "Eminem", Formato.MP3, 12.5, "Elton John", "Madonna");
		
		System.out.println(p);
		
		
		
		
		
		Ejercicio 2
		Escribe una clase ListaMultimedia para almacenar objetos de tipo
		multimedia. La clase debe tener un atributo, que sea un array de objetos
		Multimedia y un entero para contar cuantos objetos hay almacenados.
		Además, tiene los siguientes métodos:
		● El constructor recibe un entero por parámetro indicando el número
		máximo de objetos que va a almacenar.
		● int size(): devuelve el número de objetos que hay en la lista.
		● boolean add(Multimedia m): añade el objeto a la lista y
		devuelve true, en caso de que la lista esté llena, devuelve false.
		● Multimedia get(int position): devuelve el objeto situado en la
		posición especificada.
		● String toString(): devuelve la información de los objetos que están
		en la lista.
		Escribe una aplicación dónde:
		● Se cree un objeto de tipo ListaMultimedia de tamaño 10.
		● Se creen tres películas y se añadan a la lista.
		● Se muestre la lista por pantalla. 
		
		ListaMultimedia listaA = new ListaMultimedia(10);
		Pelicula a = new Pelicula ("Alicia en el pais de las maravillas", "Eminem", Formato.MP3, 12.5, "Elton John", "Madonna");
		Pelicula b = new Pelicula ("Terminator", "Juan Carlos I", Formato.MP3, 12.5, "Paquirrin", "Jordi Hurtado");
		Pelicula c = new Pelicula ("Alguien volo sobre el nido del cuco", "Los chunguitos", Formato.MP3, 12.5, "Papa Noel", "Leticia Sabater");
		
		listaA.add(a);
		listaA.add(b);
		listaA.add(c);
		
		System.out.println(listaA);
		
		
		Ejercicio 3
		Escribe una clase Disco, que herede de la clase Multimedia. La clase Disco
		tiene, aparte de los elementos heredados, un atributo para almacenar el
		género al que pertenece. Los géneros posibles son: rock, pop, soul, funky,
		flamenco, clasica, blues, tecno, opera, punk, jazz, hiphop. La clase debe
		tener un método para obtener el nuevo atributo y debe sobreescribir el
		método toString() para que devuelva toda la información.
		Escribe una aplicación donde:
		● Se cree un objeto de tipo ListaMultimedia de tamaño máximo 20.
		● Se creen tres discos y se añadan a la lista.
		● Se muestre la lista por pantalla.● Se cree un objeto de tipo Disco, introduciendo el título y el autor de
		uno de los elementos de la lista. Para el resto de los argumentos se
		utilizan valores no significativos.*/
		
		ListaMultimedia listaB = new ListaMultimedia(20);
		Disco a = new Disco ("Alicia en el pais de las maravillas", "Eminem", Formato.MP3, 12.5, Genero.FUNKY);
		Disco b = new Disco ("Terminator", "Juan Carlos I", Formato.MP3, 12.5, Genero.TECHNO);
		Disco c = new Disco ("Alguien volo sobre el nido del cuco", "Los chunguitos", Formato.MP3, 12.5, Genero.CLASICA);
		
		listaB.add(a);
		listaB.add(b);
		listaB.add(c);
		
		System.out.println(listaB);
		
		Disco d = new Disco (listaB.get(0).getTitulo(), listaB.get(0).getAutor(), Formato.MP3, 12.5, Genero.CLASICA);
		listaB.add(d);
		
		
		
		
 	}

}
