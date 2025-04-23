package modelo;

import java.io.*;

public class HabitacionModelo {

    public String obtenerDescripcion(String tipoHabitacion) {
        try (BufferedReader br = new BufferedReader(new FileReader("descripciones.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(":", 2);
                if (partes.length == 2 && partes[0].trim().equalsIgnoreCase(tipoHabitacion)) {
                    return partes[1].trim();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Descripción no disponible.";
    }
}
