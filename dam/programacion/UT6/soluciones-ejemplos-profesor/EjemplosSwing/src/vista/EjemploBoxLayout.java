package vista;

import java.awt.*;
import javax.swing.*;

public class EjemploBoxLayout extends JFrame {
	final Container container = getContentPane();
	final JPanel panel1 = new JPanel();
	final JPanel panel2 = new JPanel();

	public EjemploBoxLayout() {
//		container.setLayout(new BoxLayout(container, BoxLayout.X_AXIS));// Orientación horizontal
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));// Orientación vertical

		((JPanel) container).setBorder(BorderFactory.createTitledBorder("Demo BoxLayout Borde")); // Creamos un borde

		panel1.setBorder(BorderFactory.createTitledBorder("Panel1"));// Creamos un borde
//		panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));// Orientación vertical
		panel1.setLayout(new BoxLayout(panel1, BoxLayout.X_AXIS));// Orientación horizontal


		panel2.setBorder(BorderFactory.createTitledBorder("Panel2"));// Creamos un borde
//		panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));// Orientación vertical
		panel2.setLayout(new BoxLayout(panel2, BoxLayout.X_AXIS));// Orientación horizontal


		for (int i = 0; i < 3; i++) {
			panel1.add(new JButton("Botón número " + i));
			panel2.add(new JButton("Botón número " + i));
		}
		container.add(panel1);
		container.add(panel2);
		setSize(350, 300);//Tamaño del frame exterior (la ventana principal)
		setTitle("Demo BoxLayout");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setVisible(true);

	}

	public static void main(String[] args) {
//		try {
//			// Set System L&F
//			UIManager.setLookAndFeel(UIManaer.getSystemLookAndFeelClassName());
//		} catch (Exception e) {
//			// handle exception
//		}
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				new EjemploBoxLayout();
			}
		});
	}
}
