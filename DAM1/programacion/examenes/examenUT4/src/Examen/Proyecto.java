package Examen;

import java.util.Objects;

public class Proyecto implements Comparable<Object> {
    private int id;
    private String nombre;
    private String fechaInicio;
    private String fechaFin;
    private String estado;
    private double presupuesto;

    public Proyecto(int id, String nombre, String fechaInicio, String fechaFin, String estado, double presupuesto) {
        this.id = id;
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado = estado;
        this.presupuesto = presupuesto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public void setPresupuesto(double presupuesto) {
		this.presupuesto = presupuesto;
	}

	public String getNombre() {
        return nombre;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public String getEstado() {
        return estado;
    }

    public double getPresupuesto() {
        return presupuesto;
    }

  
	@Override
    public String toString() {
        return "ID: " + id + ", Nombre: " + nombre + ", Fecha Inicio: " + fechaInicio + ", Fecha Fin: " + fechaFin + ", Estado: " + estado + ", Presupuesto: " + presupuesto;
    }

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Proyecto other = (Proyecto) obj;
		return id == other.id;
	}
	
	@Override 
	public int compareTo(Object o) {
		Proyecto aux = (Proyecto) o;
		return this.getNombre().compareTo(aux.getNombre());
	}
	
}



