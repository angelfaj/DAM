package com.example.rest_peliculas.controlador;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rest_peliculas.util.Pelicula;

@CrossOrigin					//Esta anotacion permite la conexion con el front. De no ponerla nos saltaria error CORS
@RestController 				//Anotacion de spring para indicar el servicio rest
@RequestMapping("/peliculas")		//Ruta mediante la que se comunicara ip:puerto/peliculas
public class MiControlador {	//Esta clase genera un JSON
	
	@Autowired					//Inyectamos el objeto marcado con bean
	List<Pelicula> peliculas;
	
	@Autowired
	HashMap<Integer, Pelicula> peliculas_hash;
	
	@GetMapping("/get_peliculas")							//Indicamos que es una llamada get ip:puerto/peliculas/get_peliculas
	public List<Pelicula> get_peliculas() {
		return peliculas;
	}
	
	@GetMapping("/get_peliculas_hash")							//Indicamos que es una llamada get ip:puerto/peliculas/get_peliculas
	public HashMap<Integer, Pelicula> get_peliculas_hash() {
		return peliculas_hash;
	}
	
	@PostMapping("/add_pelicula")
	public Integer add_pelicula(@RequestBody Pelicula pelicula) {
		if (peliculas_hash.containsKey(pelicula.getId_pelicula())) {
			return 1;
		} else {
			peliculas_hash.put(pelicula.getId_pelicula(), pelicula);
			peliculas.add(pelicula);
			return 0;
		}
	}
}
