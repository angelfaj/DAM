package oneToMany;

import jakarta.persistence.*;

@Entity
@Table(name = "EMPLEADO")
public class Empleado {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_empleado")
	@SequenceGenerator(name = "seq_empleado", sequenceName = "SEQ_EMPLEADO", allocationSize = 1)
	private Long id;

	private String nombre;

	// EL DUEÑO: Usa @ManyToOne y @JoinColumn con la FK.
	// fetch = EAGER (carga inmediata, valor por defecto para N:1).
	// Cascade no debe ir en @ManyToOne, porque el hijo (Empleado) no debe
	// crear/borrar automáticamente el Departamento.
	/*
	 * EN EL LADO MANY (Empleado)
	 *  NO se pone cascade 
	 *  NO se pone orphanRemoval
	 * porque Empleado no debe controlar la vida de Departamento
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "DEPARTAMENTO_ID")
	private Departamento departamento;

	public Empleado() {
	}

	public Empleado(String nombre, Departamento d) {
		this.nombre = nombre;
		this.departamento = d;
	}

	// getters/setters

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

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	@Override
	public String toString() {
		return "Empleado [id=" + id + ", nombre=" + nombre + ", departamento=" + departamento + "]";
	}

}
