package oneToMany;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "departamento")

public class Departamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_dep")
	@SequenceGenerator(name = "seq_dep", sequenceName = "SEQ_DEPARTAMENTO", allocationSize = 1)
	private Long id;
	
	private String nombre;

	// LADO INVERSO: Usa mappedBy para reflejar la relación gestionada por Empleado.
	// fetch = LAZY (para colecciones grandes, valor por defecto para 1:N).
	/*EN EL LADO ONE (Departamento)
		cascade = ALL -> guarda, borra o actualiza empleados automáticamente
		orphanRemoval = true -> si quitas empleados de la colección, se BORRAN*/
	@OneToMany(mappedBy = "departamento", cascade = CascadeType.ALL, 
			orphanRemoval = true, fetch = FetchType.LAZY)
	private List<Empleado> empleados = new ArrayList<>();

    public Departamento() {}

    public Departamento(String nombre) {
        this.nombre = nombre;
    }

    //getters y setters

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}

	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Departamento [nombre=" + nombre + ", empleados=" + empleados + "]";
	}
    
    
    
}