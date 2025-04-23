package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.swing.JOptionPane;

import modelo.Modelo;
import vista.Ventana;

public class Controlador {
	private Ventana vista;
	private Modelo modelo;

	public Controlador(Ventana vista, Modelo modelo) {
		this.modelo = modelo;
		this.vista = vista;
		this.iniciar();
	}

	public void iniciar() {
        // Listener anónimo para el botón reset
		vista.getBotonReset().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	vista.getComboCiudades().setSelectedIndex(0);
                vista.getComentarios().setText("");
                vista.setVisible(true);

            }
        });
        
        
        // Listener anónimo para tecla ENTER en el área de texto
		vista.getComentarios().addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    e.consume(); // evitar salto de línea para no guardarlo
                    
                    String ciudad = (String) vista.getComboCiudades().getSelectedItem();
                    String texto = vista.getComentarios().getText();

                    // Mostrar en diálogo
                    JOptionPane.showMessageDialog(null,
                            "Ciudad seleccionada: " + ciudad + "\nComentarios:\n" + texto,
                            "Información",
                            JOptionPane.INFORMATION_MESSAGE);

                    // Guardar en archivo
                    try {
						modelo.guardarEnArchivo(ciudad, texto);
					} catch (IOException e1) {
						vista.muestraExcepcion(e1);
						e1.printStackTrace();
					}
                }
            }
        });
	}

}
