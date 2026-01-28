package com.example.examen;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/incidencias")
public class IncidenciaController {
	private static List<Incidencia> incidencias = new ArrayList<Incidencia>();
	private static long idContador = 1;
	
	@PostMapping
	public Incidencia guardar(@RequestBody Incidencia nueva) {
		nueva.setId(idContador++);
		incidencias.add(nueva);
		return nueva;
	}
	
	@GetMapping
	public List<Incidencia> listar(){
		return incidencias;
	}
	
	@PutMapping("/{id}")
	public Incidencia actualizar(@PathVariable Long id) { 
		for (Incidencia i:incidencias) {
			if(i.getId().equals(id)) {
				i.setResuelta(true);
				return i;
			}
		}
		return null;
	}
}
