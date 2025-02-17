package boletin1;

public abstract class Mascota {
	//Atributos
	private String nombre, fechaNacimiento;
	private int edad;
	private Estado estado;
	
	//Constructores
	public Mascota() {}
	
	public Mascota(String nombre, String fechaNacimiento, int edad, Estado estado) {
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.edad = edad;
		this.estado = estado;
	}

	//Metodos
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	
	
	@Override
	public String toString() {
		return "[nombre=" + nombre + ", fechaNacimiento=" + fechaNacimiento + ", edad=" + edad + ", estado="
				+ estado;
	}

	public void cumpleanios() {
		this.edad++;
	}
	
	public void morir() {
		this.estado = Estado.MUERTO;
	}

	public abstract void muestra();
	

	public abstract void habla();

	
}
