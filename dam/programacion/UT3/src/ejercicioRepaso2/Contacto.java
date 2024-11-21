package ejercicioRepaso2;

public class Contacto {
	//Atributos
	private String nombre, telefono;
	private Direccion dir;
	
	//Constructores
	public Contacto(String nombre, String telefono) {
		this.nombre = nombre;
		this.telefono = telefono;
	}
	
	public Contacto(String nombre, String telefono, Direccion direccion) {
		this(nombre, telefono);
		dir = direccion;
	}
	
	
	//Metodos
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Direccion getDireccion() {
		return dir;
	}

	public void setDireccion(Direccion direccion) {
		dir = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public boolean comprobarTelefono() {
		boolean esValido = false;
		if (this.getTelefono().length() == 9) {
			esValido = true;
		} else {
			this.setTelefono("999999999");
		}
		return esValido;
		
	}

	@Override
	public String toString() {
		return "Contacto [nombre=" + nombre + ", telefono=" + telefono + ", dir=" + dir + "]";
	}
	
	
}
