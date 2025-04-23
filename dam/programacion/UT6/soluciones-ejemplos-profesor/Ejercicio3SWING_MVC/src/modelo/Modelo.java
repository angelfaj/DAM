package modelo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

public class Modelo {

    //Método para guardar en archivo de texto plano
    public void guardarEnArchivo(String ciudad, String texto) throws IOException{
        try (FileWriter fw = new FileWriter("reservas.txt", true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {

            out.println("Ciudad: " + ciudad);
            out.println("Comentarios: " + texto);
            out.println("------------");

        } catch (IOException ex) {
        }
    }
}
