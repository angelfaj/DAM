package extra;

public class Equipo {
	//Atributos
	private String nombre;
	private int ip[] = new int[4];
	
	//Constructores
	public Equipo() {
		
	}
	
	public Equipo(String nombre) {
		this.nombre = nombre;
	}
	
	public Equipo(String nombre, int ip[]) {
		this(nombre);
		for (int i = 0; i < ip.length; i++) {
			this.ip[i] = ip[i];
		}
	}

	//Metodos
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getIp() {
		String ip = "";
		for (int i:this.ip) {
			ip += i + ".";
		}
		return ip;
	}

	public void setIp(int[] ip) {
		for (int i = 0; i < ip.length; i++) {
			this.ip[i] = ip[i];
		}
	}
	
	@Override
	public String toString() {
		return "[ " + this.getNombre() + ":" + this.getIp() + " ]";
	}
	
}
