package boletin5ej1;

public class Cliente implements Runnable{
	private String nombre;
	private TiendaRopaCompartida tienda;
	
	public Cliente (String nombre, TiendaRopaCompartida tienda) {
		this.nombre = nombre;
		this.tienda = tienda;
	}

	@Override
	public void run() {
		tienda.accederProbador(this.nombre);
	}
	
	
}
