package boletin1;

import java.util.ArrayList;

public class Empresa {
	//Atributos
	private String nombre, cif, direccion, telefono;
	private ArrayList<Trabajador> trabajadores;
	
	//Constructores
	public Empresa(String nombre, String cif, String direccion, String telefono) {
		this.nombre = nombre;
		this.cif = cif;
		this.direccion = direccion;
		this.telefono = telefono;
		trabajadores = new ArrayList<Trabajador>();
	}

	//Metodos
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public String getCif() {
		return cif;
	}

	public void showMoreTrabajadores() {
		for (Trabajador t: trabajadores) {
			System.out.println(t);
		}
	}

	public void addTrabajadore(Trabajador trabajador) {
		trabajadores.add(trabajador);
	}
	
	public void removeTrabajador(Trabajador trabajador) {
		if (trabajadores.contains(trabajador)) {
			trabajadores.remove(trabajador);
		}
	}
	
	public void showLessTrabajadores() {
		Empleado e;
		String infoExtra = "";
		
		for (Trabajador t:trabajadores) {
			if (t instanceof Empleado) {
				e = (Empleado) t;
				infoExtra =  ", salarioBrutoMensual:" + e.getSalarioBrutoMensual() + ", salarioNeto:" + e.calculaNeto();
			}
			System.out.println("DNI: " + t.getDni() + infoExtra);
			infoExtra = "";
		}
	}
	
	public double sumaTotalSueldosBrutos() {
		double sueldo = 0;
		Empleado e;
		for (Trabajador t:trabajadores) {
			if (t instanceof Empleado) {
				e = (Empleado) t;
				sueldo += e.getSalarioBrutoMensual();
			}
		}
		return sueldo;
	}
	
	public double sumaTotalSueldosNetos() {
		double sueldo = 0;
		Empleado e;
		for (Trabajador t:trabajadores) {
			if (t instanceof Empleado) {
				e = (Empleado) t;
				sueldo += e.calculaNeto();
			}
		}
		return sueldo;
	}
	
	
	
}
