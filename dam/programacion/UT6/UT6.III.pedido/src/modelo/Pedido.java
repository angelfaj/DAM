package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Pedido implements Serializable{

	private static final long serialVersionUID = 1L;
	private String pedido;
	private ArrayList<String> comida;
	
	public Pedido() {}
	
	public Pedido(String pedido, ArrayList<String> comida) {
		this.pedido = pedido;
		this.comida = comida;
	}

	public String getPedido() {
		return pedido;
	}

	public void setPedido(String pedido) {
		this.pedido = pedido;
	}

	public StringBuilder getComida() {
		StringBuilder comidas = new StringBuilder();
		for (String s: comida) {
			comidas.append(s).append(", ");
		}
		comidas.delete(comidas.length() - 2, comidas.length());	//Borramos la coma y espacio final
		return comidas;
	}

	public void setComida(ArrayList<String> comida) {
		this.comida = comida;
	}

	@Override
	public String toString() {
		return pedido + " - " + getComida();
	}

	@Override
	public boolean equals(Object obj) {	//Seran iguales los pedidos con mismo nombre
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		return Objects.equals(pedido, other.pedido);
	}
	
}
