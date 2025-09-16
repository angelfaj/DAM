package com.example.rest_peliculas.util;

public class Pelicula {
	//Atributos
	private int id_pelicula, anio;
	private String titulo, autor, genero;
	
	
	//Constructores
	public Pelicula() {
		
	}
	
	public Pelicula(int id_pelicula, int anio, String titulo, String autor, String genero) {
		this.id_pelicula = id_pelicula;
		this.anio = anio;
		this.titulo = titulo;
		this.autor = autor;
		this.genero = genero;
	}


	//Metodos
	public int getId_pelicula() {
		return id_pelicula;
	}


	public void setId_pelicula(int id_pelicula) {
		this.id_pelicula = id_pelicula;
	}


	public int getAnio() {
		return anio;
	}


	public void setAnio(int anio) {
		this.anio = anio;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getAutor() {
		return autor;
	}


	public void setAutor(String autor) {
		this.autor = autor;
	}


	public String getGenero() {
		return genero;
	}


	public void setGenero(String genero) {
		this.genero = genero;
	}



	
	
	
	
}
 