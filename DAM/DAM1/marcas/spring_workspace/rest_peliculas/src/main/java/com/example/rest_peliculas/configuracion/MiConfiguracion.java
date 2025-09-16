package com.example.rest_peliculas.configuracion;
import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.rest_peliculas.util.Pelicula;

@Configuration					//Esta anotacion de spring conseguimos que se ejecute el metodo al arrancar el proyecto
public class MiConfiguracion {
	
	@Bean						//Esta anotacion de spring hace que el objeto este disponible en cualquier parte del proyecto
	public ArrayList<Pelicula> get_peliculas() {
		ArrayList<Pelicula> peliculas = new ArrayList<Pelicula>();
		
		Pelicula p1 = new Pelicula(1, 1995, "Seven", "Andrew Kevin", "Cine negro");
		Pelicula p2 = new Pelicula(2, 2010, "Inception", "Christopher Nolan", "Ciencia ficcion");
		Pelicula p3 = new Pelicula(3, 2004, "Troya", "David Benioff", "Epico");
		peliculas.add(p3);
		peliculas.add(p2);
		peliculas.add(p1);
		
		return peliculas;
	}
	
	@Bean						//Esta anotacion de spring hace que el objeto este disponible en cualquier parte del proyecto
	public HashMap<Integer, Pelicula> get_alumnos_hash() {
		HashMap<Integer, Pelicula> peliculas = new HashMap<Integer, Pelicula>();
		Pelicula p1 = new Pelicula(1, 1995, "Seven", "Andrew Kevin", "Cine negro");
		Pelicula p2 = new Pelicula(2, 2010, "Inception", "Christopher Nolan", "Ciencia ficcion");
		Pelicula p3 = new Pelicula(3, 2004, "Troya", "David Benioff", "Epico");
		peliculas.put(1, p1);
		peliculas.put(2, p2);
		peliculas.put(3, p3);
		
		return peliculas;
	}
	
}
