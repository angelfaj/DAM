package Jaxb.PruebaUT1;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder = {"stock", "codigo", "nombre", "precio"})
public class Articulo implements Serializable{
	private static final long serialVersionUID = 1L;
	private String codigo;
    private String nombre;
    private int stock;
    private double precio;

    public Articulo() {}

    public Articulo(String codigo, String nombre, int stock, double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.stock = stock;
        this.precio = precio;
    }

    // --- Getters y Setters ---
    @XmlElement
    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    @XmlElement
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    @XmlAttribute
    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }

    @XmlElement
    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }

    @Override
    public String toString() {
        return "Articulo [codigo=" + codigo + ", nombre=" + nombre + ", stock=" + stock + ", precio=" + String.format("%.2f", precio) + "€]";
    }
}