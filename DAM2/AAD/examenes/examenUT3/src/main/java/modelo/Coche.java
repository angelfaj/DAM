package modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "COCHE")
public class Coche {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_coche")
	@SequenceGenerator(name = "seq_coche", sequenceName = "SEQ_COCHE", allocationSize = 1)
	private Long id;
	
	@Column(name = "MODELO")
	private String modelo;
	
	@Column(name = "MATRICULA")
	private String matricula;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CONCESIONARIO_ID")
	private Concesionario concesionario;

	public Coche() {}
	
	public Coche(String modelo, String matricula) {
		this.modelo = modelo;
		this.matricula = matricula;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Concesionario getConcesionario() {
		return concesionario;
	}

	public void setConcesionario(Concesionario concesionario) {
		this.concesionario = concesionario;
	}

	@Override
	public String toString() {
		return "Coche [id=" + id + ", modelo=" + modelo + ", matricula=" + matricula + ", concesionario="
				+ concesionario + "]";
	}
	
	
}
