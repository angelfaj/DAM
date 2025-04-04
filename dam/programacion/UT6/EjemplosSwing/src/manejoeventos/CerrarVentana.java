package manejoeventos;

/**
 * @author victor
 */

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/** Demonstrate simple use of Button */
public class CerrarVentana extends JFrame {

	public CerrarVentana() {
		setLayout(new FlowLayout());
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new CerrarVentanaAdapter());

		setSize(300, 200);

	}

	/** Named Inner class that closes a Window. */
	class CerrarVentanaAdapter extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			
			int opc = JOptionPane.showConfirmDialog(null, "Está seguro de cerrar la Ventana", 
					"Título Diálogo", 
					JOptionPane.YES_NO_OPTION);
			if (opc == 0) {
				System.exit(0);
			}
		}
	}

	public static void main(String[] unuxed) {

		SwingUtilities.invokeLater(() -> new CerrarVentana().setVisible(true));
	}
}
