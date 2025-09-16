package estructurasDinamicas;


public class Carta implements Comparable<Object>{
	//Atributos
	private static String[] n = {"as", "dos", "tres", "cuatro", "cinco",
	"seis", "siete", "sota", "caballo", "rey"};
	private static String[] p = {"bastos", "copas", "espadas", "oros"};
	private Integer numero;		//Al guardarlo como Integer nos guarda su posicion e el array; as-0 uno-1....
	private String palo;
	
	//Constructores
	public Carta() {
	this.numero = (int)(Math.random()*10);
	this.palo = p[(int)(Math.random()*4)];
	}

	//Metodos
	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getPalo() {
		return palo;
	}

	public void setPalo(String palo) {
		this.palo = palo;
	}
	
	@Override
	public String toString() {
		return n[numero] + " de " + this.getPalo();
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null) {
			return false;
		}
		if (o.getClass() == this.getClass()) {
			Carta c = (Carta) o;
			if (this.getPalo() == c.getPalo() && this.getNumero() == c.getNumero()) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public int compareTo(Object o) {
		Carta c = (Carta) o;
		if (this.getPalo().equals(c.getPalo())) {
			return this.getNumero().compareTo(c.getNumero());
		} else {
			return this.getPalo().compareTo(c.getPalo());
		}
	}
	
}
