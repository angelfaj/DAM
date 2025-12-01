package modelo;

import jakarta.persistence.*;

@Entity
@Table(name="CLIENTE")
public class Cliente {
	@Id
	@SequenceGenerator(name="cliente_seq", sequenceName="CLIENTE_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "cliente_seq")
	@Column(name="ID")
	private long id;
	
	@Column(name="NOMBRE")
	private String nombre;

	@Column(name="EMAIL")
	private String email;
	
	@Column(name="TELEFONO")
	private String telefono;


	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", email=" + email + ", telefono=" + telefono + "]";
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

}
