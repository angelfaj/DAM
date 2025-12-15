package modelo;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "CONCESIONARIO")
public class Concesionario {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_concesionario")
	@SequenceGenerator(name = "seq_concesionario", sequenceName = "SEQ_CONCESIONARIO", allocationSize = 1)
	private Long id;
	
	@Column(name = "NOMBRE")
	private String nombre;
	
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	@JoinColumn(name = "SEDE_ID")
	private Sede sede;
	
	@OneToMany(mappedBy = "concesionario", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	private List<Coche> coches = new ArrayList<Coche>();

	public Concesionario() {}
	
	public Concesionario(String nombre) {
		this.nombre = nombre;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Sede getSede() {
		return sede;
	}

	public void setSede(Sede sede) {
		this.sede = sede;
		sede.setConcesionario(this);
	}

	public List<Coche> getCoches() {
		return coches;
	}

	public void setCoches(List<Coche> coche) {
		this.coches = coche;
	}
	
	public void addCoche(Coche coche) {
		coches.add(coche);
		coche.setConcesionario(this);
	}
	
	
	@Override
	public String toString() {
		return "Concesionario [id=" + id + ", nombre=" + nombre + ", sede=" + sede + ", coche=" + coches + "]";
	}

}
