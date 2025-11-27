package modelo;

import jakarta.persistence.*;

@Entity
@Table(name="EMPLEADO")
public class Producto {
	private long id;
	private String nombre;
	private String descripcion;
	private double precio;
}
