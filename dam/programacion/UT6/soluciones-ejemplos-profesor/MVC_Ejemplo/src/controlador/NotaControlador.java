package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modelo.NotaModelo;
import vista.NotaVista;

public class NotaControlador {
    private NotaVista vista;
    private NotaModelo modelo;

    public NotaControlador(NotaVista vista, NotaModelo modelo) {
        this.vista = vista;
        this.modelo = modelo;

        // Agregar acción para guardar
        this.vista.getBtnGuardar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String texto = vista.getAreaTexto().getText();
                modelo.guardarNota(texto);
                JOptionPane.showMessageDialog(vista, "Nota guardada correctamente.");
            }
        });

        // Agregar acción para cargar
        this.vista.getBtnCargar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String texto = modelo.cargarNota();
                vista.getAreaTexto().setText(texto);
            }
        });
    }
}
