package formulariocliente;

import java.io.Serializable;

public class Cliente implements Serializable {
    private String nombre;
    private String correo;
    private boolean desayuno;

    public Cliente(String nombre, String correo, boolean desayuno) {
        this.nombre = nombre;
        this.correo = correo;
        this.desayuno = desayuno;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + "\nCorreo: " + correo + "\nDesayuno: " + (desayuno ? "Sí" : "No") + "\n";
    }
}
