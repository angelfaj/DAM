package com.example.rest_alumnos.controlador;
import com.example.rest_alumnos.util.Alumno;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController 				//Anotacion de spring para indicar el servicio rest
@RequestMapping("/alumnos")		//Ruta mediante la que se comunicara ip:puerto/alumnos
public class MiControlador {	//Esta clase genera un JSON
	
	@Autowired					//Inyectamos el objeto marcado con bean
	List<Alumno> alumnos;
	
	@Autowired
	HashMap<Integer, Alumno> alumnos_hash;
	
	@GetMapping("/get_alumnos")							//Indicamos que es una llamada get ip:puerto/alumnos/get_alumnos
	public List<Alumno> get_alumnos() {
		return alumnos;
	}
	
	@GetMapping("/get_alumnos_hash")							//Indicamos que es una llamada get ip:puerto/alumnos/get_alumnos
	public HashMap<Integer, Alumno> get_alumnos_hash() {
		return alumnos_hash;
	}
	
	@PostMapping("/add_alumno")
	public Integer add_alumno(@RequestBody Alumno alumno) {
		if (alumnos_hash.containsKey(alumno.getId_alumno())) {
			return 1;
		} else {
			alumnos_hash.put(alumno.getId_alumno(), alumno);
			alumnos.add(alumno);
			return 0;
		}
	}
}
