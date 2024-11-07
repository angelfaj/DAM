package ejerciciosIniciales;

public class Billete {
	//Atributos
	public String nombre;
	public String nif;
	public String clase;
	public int asiento;
	public boolean catering;
	public boolean baño;
	public int maletas;
	
	//Constructores
	public Billete(String nom, String dni) {
		nombre = nom;
		nif = dni;
	}
	
	public Billete(String nom, String dni, String clas) {
		this(nom, dni);
		clase = clas;
	}
	
	//Metodos
	public void facturar(int as) {
		asiento = as;	
	}
	
	public String getNombre() {
		return nombre;		
	}
	
	public String getNif() {
		return nif;		
	}
	
	public String getClase() {
		return clase;		
	}
	
	public String getAsiento() {
		return clase;		
	}
}
