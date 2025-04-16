package aplicación;

import controlador.NotaControlador;
import modelo.NotaModelo;
import vista.NotaVista;

/*Estructura del Código (MVC)
Modelo (NotaModelo.java) → Maneja la lectura y escritura de notas en un archivo de texto.

Vista (NotaVista.java) → Es la interfaz gráfica con un JTextArea y botones para guardar/cargar notas.

Controlador (NotaControlador.java) → Maneja la lógica de eventos, conecta la vista con el modelo.

Main (Main.java) → Inicia la aplicación.*/

public class Main {
    public static void main(String[] args) {
        NotaVista vista = new NotaVista();
        NotaModelo modelo = new NotaModelo();
        new NotaControlador(vista, modelo);
    }
}
