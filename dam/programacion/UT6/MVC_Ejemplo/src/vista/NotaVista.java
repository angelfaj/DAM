package vista;

import javax.swing.*;
import java.awt.*;

public class NotaVista extends JFrame {
    private JTextArea areaTexto;
    private JButton btnGuardar, btnCargar;

    public NotaVista() {
        setTitle("Gestor de Notas");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());

        areaTexto = new JTextArea();
        areaTexto.setFont(new Font("Monospaced", Font.PLAIN, 14));
        getContentPane().add(new JScrollPane(areaTexto), BorderLayout.CENTER);

        JPanel panelBotones = new JPanel();
        btnGuardar = new JButton("Guardar");
        btnCargar = new JButton("Cargar");
        
        panelBotones.add(btnGuardar);
        panelBotones.add(btnCargar);
        getContentPane().add(panelBotones, BorderLayout.SOUTH);
        
        setVisible(true);
    }

    public JTextArea getAreaTexto() {
        return areaTexto;
    }

    public JButton getBtnGuardar() {
        return btnGuardar;
    }

    public JButton getBtnCargar() {
        return btnCargar;
    }
}
