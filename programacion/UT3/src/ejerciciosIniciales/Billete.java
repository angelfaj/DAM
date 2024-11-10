package ejerciciosIniciales;

public class Billete {
	//Atributos
	public String nombre, nif, clase;
	public int asiento, maletas, totalBillete;
	public boolean catering, baño;
	
	//Constructores	
	public Billete(String nom, String dni) {
		nombre = nom;
		nif = dni;
	}
	
	public Billete(String nom, String dni, String clas) {
		nombre = nom;
		nif = dni;
		clase = clas;
		sumaClase();
	}
	
	//Metodos
	public void facturar(int as, int mal) {
		asiento = as;	
		maletas = mal;
		sumaMaletas();
	}
	
//	public void facturar(int as, int mal, boolean cat) {
//		facturar(as, mal);
//		catering = cat;
//		addExtras();
//	}
	
	public void facturar(int as, int mal, boolean cat, boolean aseo) {			//Se decide que catering y baño se contratan a la vez
		facturar(as, mal);
		catering = cat;
		baño = aseo;
		addExtras();
	}
	
	public void setClase(String clas) {
		clase = clas;
		sumaClase();
	}
	
	public void setMaletas(int mal) {
		maletas = mal;
		sumaMaletas();
	}
	
	public void sumaClase() {
		switch (clase) {
		case "turista":
			totalBillete += 200;
			break;
		case "business":
			totalBillete += 400;
			break;
		case "VIP":
			totalBillete += 600;
			break;
		}
	}
	
	public void addExtras() {
		if ((clase == "turista") && (catering == true) && (baño == true)) {
			totalBillete += 40; 
		} else if ((clase == "turista") && (catering == true)) {
			totalBillete += 20; 
		} else if ((clase == "turista") && (baño == true)) {
			totalBillete += 10; 
		}
	}
	
	public void sumaMaletas() {
		if ((clase == "turista") && (maletas > 1 )) {
			 totalBillete += (maletas - 1) * 50;
		 } else if ((clase == "business") && (maletas > 3 )) {
			 totalBillete += (maletas - 3) * 50;
		 }
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
	
	public int getTotal() {
		return totalBillete;		
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
