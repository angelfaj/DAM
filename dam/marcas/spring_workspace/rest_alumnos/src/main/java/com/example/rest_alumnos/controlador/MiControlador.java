package com.example.rest_alumnos.controlador;
import com.example.rest_alumnos.util.Alumno;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController 				//Anotacion de spring para indicar el servicio rest
@RequestMapping("/alumnos")		//Ruta mediante la que se comunicara ip:puerto/alumnos
public class MiControlador {	//Esta clase genera un JSON
	
	@Autowired					//Inyectamos el objeto marcado con bean
	List<Alumno> alumnos;
	
	
	@GetMapping("/get_alumnos")							//Indicamos que es una llamada get ip:puerto/alumnos/get_alumnos
	public List<Alumno> get_alumnos() {
		return alumnos;
	}
}
