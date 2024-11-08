package ejerciciosIniciales;

public class Billete {
	//Atributos
	public String nombre, nif, clase;
	public int asiento, maletas;
	public boolean catering, baño;
	
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
	
	public void facturar(int as, boolean cat) {
		facturar(as);
		catering = cat;
	}
	
	public void facturar(int as, boolean cat, boolean aseo) {
		facturar(as, cat);
		baño = aseo;
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
	
	public int getAsiento() {
		return asiento;		
	}
	
	public int getMaletas() {
		return maletas;		
	}
	
	public boolean getCatering() {
		return catering;		
	}
	
	public boolean getBaño() {
		return baño;
	}
	
	@Override
	public String toString() {
		return "Billete [nombre=" + nombre + ", nif=" + nif + ", clase=" + clase + ", asiento=" + asiento + ", maletas="
				+ maletas + ", catering=" + catering + ", baño=" + baño + "]";
	}
	
}
