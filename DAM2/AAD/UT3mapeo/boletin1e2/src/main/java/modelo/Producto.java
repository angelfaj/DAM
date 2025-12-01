package modelo;

import java.math.BigDecimal;

import jakarta.persistence.*;

@Entity
@Table(name="PRODUCTO")
public class Producto {
	@Id
	@SequenceGenerator(name="producto_seq", sequenceName="PRODUCTO_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "producto_seq")
	@Column(name="ID")
	private long id;
	
	@Column(name="NOMBRE")
	private String nombre;

	@Column(name="DESCRIPCION")
	private String descripcion;
	
	@Column(name="PRECIO")
	private BigDecimal precio;

	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", precio=" + precio
				+ "]";
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal bigDecimal) {
		this.precio = bigDecimal;
	}
	
	
}
