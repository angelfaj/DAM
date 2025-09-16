package com.example.rest_alumnos.configuracion;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.example.rest_alumnos.util.Alumno;


@Configuration					//Esta anotacion de spring conseguimos que se ejecute el metodo al arrancar el proyecto
public class MiConfiguracion {
	
	@Bean						//Esta anotacion de spring hace que el objeto este disponible en cualquier parte del proyecto
	public List<Alumno> get_alumnos() {
		List<Alumno> alumnos = new ArrayList<Alumno>();
		Alumno a1 = new Alumno(1, "ana", "marcas", 5.6);
		alumnos.add(a1);
		Alumno a2 = new Alumno(2, "paco", "bbdd", 6.5);
		alumnos.add(a2);
		Alumno a3 = new Alumno(3, "manuel", "marcas", 5.6);
		alumnos.add(a3);
		Alumno a4 = new Alumno(4, "maria", "programacion", 9.6);
		alumnos.add(a4);
		Alumno a5 = new Alumno(5, "leire", "sistemas", 3.1);
		alumnos.add(a5);
		
		return alumnos;
	}
	
	@Bean						//Esta anotacion de spring hace que el objeto este disponible en cualquier parte del proyecto
	public HashMap<Integer, Alumno> get_alumnos_hash() {
		HashMap<Integer, Alumno> alumnos = new HashMap<Integer, Alumno>();
		Alumno a1 = new Alumno(1, "ana", "marcas", 5.6);
		alumnos.put(1, a1);
		Alumno a2 = new Alumno(2, "paco", "bbdd", 6.5);
		alumnos.put(2, a2);
		Alumno a3 = new Alumno(3, "manuel", "marcas", 5.6);
		alumnos.put(3, a3);
		Alumno a4 = new Alumno(4, "maria", "programacion", 9.6);
		alumnos.put(4, a4);
		Alumno a5 = new Alumno(5, "leire", "sistemas", 3.1);
		alumnos.put(5, a5);
		
		return alumnos;
	}
}
