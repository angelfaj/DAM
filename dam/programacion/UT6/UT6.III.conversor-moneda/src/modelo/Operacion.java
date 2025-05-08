package modelo;

import java.io.Serializable;

public class Operacion implements Serializable{
	private static final long serialVersionUID = 1L;
	private String monedaOrigen;
	private String monedaDestino;
	private double cantidad;
	private double cantidadConvertida;
	private static final double DOLLARVALUE = 1.12;
	
	public Operacion() {}
	
	public Operacion(String monedaOrigen, String monedaDestino, double cantidadOrigen, double cantidadDestino) {
		this.monedaOrigen = monedaOrigen;
		this.monedaDestino = monedaDestino;
		this.cantidad = cantidadOrigen;
		this.cantidadConvertida = 0;		//Evitamos que corrompan las operaciones en caso de introducir una cantidad en el destino
	}

	public String getMonedaOrigen() {
		return monedaOrigen;
	}

	public void setMonedaOrigen(String monedaOrigen) {
		this.monedaOrigen = monedaOrigen;
	}

	public String getMonedaDestino() {
		return monedaDestino;
	}

	public void setMonedaDestino(String monedaDestino) {
		this.monedaDestino = monedaDestino;
	}

	public double getCantidadOrigen() {
		return cantidad;
	}

	public void setCantidadOrigen(double cantidad) {
		this.cantidad = cantidad;
	}

	public double getCantidadConvertida() {
		return cantidadConvertida;
	}

	public void setCantidadConvertida(double cantidad) {
		this.cantidadConvertida = cantidad;
	}

	@Override
	public String toString() {
		return cantidad + " " + monedaOrigen + " - " + cantidadConvertida + monedaDestino;
	}
	
	public String convertir() {	
		if (monedaOrigen.equalsIgnoreCase("Euro") && monedaDestino.equalsIgnoreCase("Dolar")) {
			setCantidadConvertida(cantidad*DOLLARVALUE);
		}else if (monedaOrigen.equalsIgnoreCase("Dolar") && monedaDestino.equalsIgnoreCase("Euro")) {
			setCantidadConvertida(cantidad/DOLLARVALUE);
		}else {
			setCantidadConvertida(cantidad);
		}
		return this.toString();
	}
	
}
