package modelo;

import java.io.Serializable;

public class Equipo implements Serializable{
	private static final long serialVersionUID = 1L;
	private String numeroSerie;
    private String marca;
    private int anioCompra;
    private String tipo;
    private boolean ssd;
    private boolean ram8GB;
    private boolean wifi;
    private transient boolean gpu;

    public Equipo(String numeroSerie, String marca, int anioCompra, String tipo, boolean ssd, boolean ram8GB, boolean wifi, boolean gpu) {
        this.numeroSerie = numeroSerie;
        this.marca = marca;
        this.anioCompra = anioCompra;
        this.tipo = tipo;
        this.ssd = ssd;
        this.ram8GB = ram8GB;
        this.wifi = wifi;
        this.gpu = gpu;
    }

    @Override
    public String toString() {
		String texto=numeroSerie + " - " + marca + " - " + anioCompra + " - " + tipo;
		if (ssd) 
			texto+=" [SSD]";
		if (ram8GB)
			texto+=" [RAM>8GB]";
		if (wifi)
			texto+=" [Wifi]";
		if (gpu)
			texto+=" [GPU]";
        return texto;
    }

	public String getNumeroSerie() {
		return numeroSerie;
	}

	public void setNumeroSerie(String numeroSerie) {
		this.numeroSerie = numeroSerie;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getAnioCompra() {
		return anioCompra;
	}

	public void setAnioCompra(int anioCompra) {
		this.anioCompra = anioCompra;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public boolean isSsd() {
		return ssd;
	}

	public void setSsd(boolean ssd) {
		this.ssd = ssd;
	}

	public boolean isRam8GB() {
		return ram8GB;
	}

	public void setRam8GB(boolean ram8gb) {
		ram8GB = ram8gb;
	}

	public boolean isWifi() {
		return wifi;
	}

	public void setWifi(boolean wifi) {
		this.wifi = wifi;
	}


}

