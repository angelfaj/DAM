package controlador;

import modelo.HabitacionModelo;
import vista.VentanaReserva;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ControladorReserva implements MouseListener {
    private VentanaReserva vista;
    private HabitacionModelo modelo;

    public ControladorReserva(VentanaReserva vista, HabitacionModelo modelo) {
        this.vista = vista;
        this.modelo = modelo;
    }

    public void iniciar() {
        vista.getSimple().addMouseListener(this);
        vista.getDoble().addMouseListener(this);
        vista.getSuite().addMouseListener(this);
        vista.setVisible(true);
    }

    public void mouseClicked(MouseEvent e) {
        JRadioButton fuente = (JRadioButton) e.getSource();
        String tipoSeleccionado = fuente.getText();
        String descripcion = modelo.obtenerDescripcion(tipoSeleccionado);
        vista.mostrarDescripcion(descripcion);
    }

    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
}
