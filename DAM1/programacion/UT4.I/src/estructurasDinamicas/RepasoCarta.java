package estructurasDinamicas;

import java.util.Objects;

public class RepasoCarta implements Comparable<Object> {
	//Atributos
	private static String[] n = {"as", "dos", "tres", "cuatro", "cinco",
	"seis", "siete", "sota", "caballo", "rey"};
	private static String[] p = {"bastos", "copas", "espadas", "oros"};
	private Integer numero;
	private String palo;
	
	//Constructores
	public RepasoCarta() {
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
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RepasoCarta other = (RepasoCarta) obj;
		return Objects.equals(numero, other.numero) && Objects.equals(palo, other.palo);
	}

	@Override 
	public int compareTo(Object o) {
		RepasoCarta c = (RepasoCarta) o;
		if (this.getPalo().equals(c.getPalo())) {
			return this.numero.compareTo(c.numero);
		}else {
			return this.palo.compareTo(c.palo);
			}
		}




}
