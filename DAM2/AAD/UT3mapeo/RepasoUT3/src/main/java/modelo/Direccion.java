package modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "DIRECCION")
public class Direccion {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_direccion")
	@SequenceGenerator(name = "seq_direccion", sequenceName = "SEQ_DIRECCION", allocationSize = 1)
	private Long id;
	
	@Column(name = "CALLE")
	private String calle;

	@Column(name = "CIUDAD")
	private String ciudad;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = " CLIENTE_ID")
	private Cliente cliente;
	
	public Direccion() {}

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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Direccion [id=" + id + ", calle=" + calle + ", ciudad=" + ciudad + ", cliente=" + cliente + "]";
	}
	
	
}
