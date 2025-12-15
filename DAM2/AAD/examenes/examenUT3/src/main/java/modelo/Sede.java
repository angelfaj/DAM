package modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "SEDE")
public class Sede {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_sede")
	@SequenceGenerator(name = "seq_sede", sequenceName = "SEQ_SEDE", allocationSize = 1)
	private Long id;
	
	@Column(name = "CALLE")
	private String calle;
	
	@Column(name = "CIUDAD")
	private String ciudad;
	
	@OneToOne(mappedBy = "sede", fetch = FetchType.EAGER)
	private Concesionario concesionario;

	public Sede() {}
	
	public Sede(String calle, String ciudad) {
		this.calle = calle;
		this.ciudad = ciudad;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public Concesionario getConcesionario() {
		return concesionario;
	}

	public void setConcesionario(Concesionario concesionario) {
		this.concesionario = concesionario;
	}

	@Override
	public String toString() {
		return "Sede [id=" + id + ", calle=" + calle + ", ciudad=" + ciudad + ", concesionario=" + concesionario + "]";
	}
	
	
}
