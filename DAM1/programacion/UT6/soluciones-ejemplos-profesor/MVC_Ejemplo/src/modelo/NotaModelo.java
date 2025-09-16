package modelo;

import java.io.*;

public class NotaModelo {
    private static final String ARCHIVO_NOTAS = "notas.txt";

    // Método para guardar la nota en el archivo
    public void guardarNota(String contenido) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARCHIVO_NOTAS))) {
            writer.write(contenido);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para cargar la nota desde el archivo
    public String cargarNota() {
        StringBuilder contenido = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(ARCHIVO_NOTAS))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                contenido.append(linea).append("\n");
            }
        } catch (IOException e) {
            return "No se pudo cargar la nota.";
        }
        return contenido.toString();
    }
}
