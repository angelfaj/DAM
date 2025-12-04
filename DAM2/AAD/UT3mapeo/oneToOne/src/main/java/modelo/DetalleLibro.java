package modelo;

import jakarta.persistence.*;

@Entity
@Table(name="DETALLE_LIBRO")
public class DetalleLibro {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_detalle_libro")
	@SequenceGenerator(name = "seq_detalle_libro", sequenceName = "SEQ_DETALLE_LIBRO", allocationSize = 1)
	private Long id;
	
	@Column(name = "SINOPSIS_LARGA")
	private String sinopsis;
	
	@Column(name = "EDITORIAL")
	private String editorial;

	//DetalleLibro es el dueño de la relación. El atributo libro representa la foreign key.
	//Fetch lazy evita traer todos los atributos de libro cuando hacemos una consulta sobre detalleLibro.
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "LIBRO_ID", unique = true, nullable = false)
	private Libro libro;
	
	public DetalleLibro() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSinopsis() {
		return sinopsis;
	}

	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	@Override
	public String toString() {
		return "DetalleLibro [id=" + id + ", sinopsis=" + sinopsis + ", editorial=" + editorial + ", libro_id="
				+ libro + "]";
	}
	
}
