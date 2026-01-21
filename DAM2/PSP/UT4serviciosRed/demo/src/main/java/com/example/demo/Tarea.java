package com.example.demo;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Tarea {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private boolean hecha;
	
	// Constructores, Getters y Setters
	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }
	public String getTitulo() { return titulo; }
	public void setTitulo(String titulo) { this.titulo = titulo; }
	public boolean isHecha() { return hecha; }
	public void setHecha(boolean hecha) { this.hecha = hecha; }
}
