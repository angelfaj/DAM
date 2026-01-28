package com.example.examen;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Incidencia {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; // Autogenerado en el controlador
	private String descripcion;
	private int prioridad;
	private boolean resuelta;

	// Constructores
	public Incidencia() {
	}

	public Incidencia(Long id, String descripcion, int prioridad) {
		this.id = id;
		this.descripcion = descripcion;
		this.prioridad = prioridad;
		this.resuelta = false; // Por defecto false
	}

	// Getters y Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(int prioridad) {
		this.prioridad = prioridad;
	}

	public boolean isResuelta() {
		return resuelta;
	}

	public void setResuelta(boolean resuelta) {
		this.resuelta = resuelta;
	}
}