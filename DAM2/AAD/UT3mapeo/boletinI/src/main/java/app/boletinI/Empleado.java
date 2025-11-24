package app.boletinI;

import jakarta.persistence.*;

@Entity
@Table(name="EMPLEADO")
public class Empleado {
	@Id
	@SequenceGenerator(name= "empleado_seq", sequenceName = "EMPLEADO_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "empleado_seq")
	@Column(name="ID")
	private int id;
	
	@Column(name="NOMBRE")
	private String nombre;
	
	@Column(name="DEPARTAMENTO")
	private String departamento;
	
	@Column(name="SALARIO")
	private double salario;
	
	public Empleado() {}
	
	public Empleado(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}
	
	public Empleado(int id, String nombre, String departamento, double salario) {
		this(id, nombre);
		this.departamento = departamento;
		this.salario = salario;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
	
}
