package model;

import java.util.Date;

public class Jugador {
	private int id_emp;
	private String apellido;
	private String oficio;
	private Date fecha_alta;
	private float salario;
	private float comision;
	private Jugador jefe;
	private Departamento departamento;
	
	public Jugador() {}
	
	public Jugador(int id_emp, String apellido) {
		this.id_emp = id_emp;
		this.apellido = apellido;
	}

	public Jugador(int id_emp, String apellido, String oficio, Date fecha_alta, float salario, float comision, Jugador jefe, Departamento departamento) {
		this(id_emp, apellido);
		this.oficio = oficio;
		this.fecha_alta = fecha_alta;
		this.salario = salario;
		this.comision = comision;
		this.jefe = jefe;
		this.departamento = departamento;
	}

	public int getId_emp() {
		return id_emp;
	}

	public void setId_emp(int id_emp) {
		this.id_emp = id_emp;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getOficio() {
		return oficio;
	}

	public void setOficio(String oficio) {
		this.oficio = oficio;
	}

	public Date getFecha_alta() {
		return fecha_alta;
	}

	public void setFecha_alta(Date fecha_alta) {
		this.fecha_alta = fecha_alta;
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}

	public float getComision() {
		return comision;
	}

	public void setComision(float comision) {
		this.comision = comision;
	}

	public Jugador getJefe() {
		return jefe;
	}

	public void setJefe(Jugador jefe) {
		this.jefe = jefe;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	@Override
	public String toString() {
		String j, d;
		if (this.jefe == null) {
			j = "No asignado";
		}else {
			j = jefe.getApellido();
		}
		if (this.departamento == null) {
			d = "No asignado";
		}else {
			d = departamento.getNombre();
		}
		return "Empleado:" + id_emp + ":" + apellido + ":" + oficio + ":"
				+ fecha_alta + ":" + salario + ":" + comision + ":" + j + ":"
				+ d;
	}
}
