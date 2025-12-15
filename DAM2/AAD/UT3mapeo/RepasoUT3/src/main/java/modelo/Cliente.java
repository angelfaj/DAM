package modelo;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name="CLIENTE")
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_cliente")
	@SequenceGenerator(name = "seq_cliente", sequenceName = "SEQ_CLIENTE", allocationSize = 1)
	private Long id;
	
	@Column(name = "NOMBRE")
	private String nombre;		
	
	@OneToOne(mappedBy = "cliente", fetch = FetchType.EAGER, orphanRemoval = true, cascade = CascadeType.ALL)
	private Direccion direccion;
	
	@OneToMany(mappedBy = "cliente", fetch = FetchType.EAGER, orphanRemoval = true, cascade = CascadeType.ALL)
	private List<Pedido> pedidosList = new ArrayList<Pedido>();
	
	public Cliente() {}

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

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public List<Pedido> getPedidosList() {
		return pedidosList;
	}

	public void setPedidosList(List<Pedido> pedidosList) {
		this.pedidosList = pedidosList;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + "]";
	}
	
	
}
