package modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "LIBRO")
public class Libro {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_libro")
	@SequenceGenerator(name = "seq_libro", sequenceName = "SEQ_LIBRO", allocationSize = 1)
	private Long id;
	
	@Column
	private String titulo;

	@Column
	private String autor;
	
	@OneToOne(mappedBy = "libro", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private DetalleLibro detalleLibro;
	
	public DetalleLibro getDetalleLibro() {
		return detalleLibro;
	}

	public void setDetalleLibro(DetalleLibro detalleLibro) {
		this.detalleLibro = detalleLibro;
	}

	public Libro() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "Libro [id=" + id + ", titulo=" + titulo + ", autor=" + autor + ", detalleLibro=" + detalleLibro.getId() + "]";
	}

}
