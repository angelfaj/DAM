package vista;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;


public class EjemploJDialog extends JFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EjemploJDialog frame = new EjemploJDialog();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	// el constuctor
		public EjemploJDialog() {
			super("Ejemplo ventana con dialog enfrente!");
			setTitle("Ejemplo ventana con dialog enfrente!");
			setSize(300,200);
			setVisible(true);
//			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//			JDialog cuadroDialogo= new JDialog(this, true); //Crea un dialog modal
			JDialog cuadroDialogo = new JDialog(this, false); // Crea un dialog no modal
			cuadroDialogo.setSize(100,100);
			cuadroDialogo.setVisible(true);
		}

}
