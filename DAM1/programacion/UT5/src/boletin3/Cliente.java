package boletin3;

public class Cliente extends Persona{
	protected int idCliente;
	
	public Cliente(String dni) {
		super(dni);
	}
	
	public Cliente(String nombre, String apellidos, String dni, int edad, int idCliente) {
		super(nombre,apellidos, dni, edad);
	}

	public int getIdCliente() {
		return idCliente;
	}

	@Override
	public String toString() {
		return super.toString() + "Cliente [idCliente=" + idCliente + "]";
	}
	
	
	
}
