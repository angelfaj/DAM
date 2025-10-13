package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class EjemploJFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EjemploJFrame frame = new EjemploJFrame();
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
//	public EjemploJFrame() {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 450, 300);
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//
//		setContentPane(contentPane);
//	}
	
	// el constructor
		public EjemploJFrame() {
			super("Hola!!!"); // Pone un título a la ventana
			//o this.setTitle("Hola!!!");
//			setSize(300, 200);// método heredado que le da un tamaño a la ventana
			setBounds(100, 100, 450, 300);
//			setState(JFrame.ICONIFIED);//Se abre la aplicación pero minimizada
			setState(JFrame.NORMAL);
			setResizable(false); //¿Se puede cambiar el tamaño?
			//Anulamos ahora la posición que decíamos en setBounds para que salga centrado
//			setLocationRelativeTo(null); //¿La posición es relativa a? Para ubicar la ventana en el centro de la pantalla es null
			setVisible(true);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Para finalizar el programa al salir (ver que se queda el botón rojo de ejecución encendido)
		}

}
