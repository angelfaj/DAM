package agenda;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI frame = new UI();
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
	public UI() {
		setTitle("Agenda");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBounds(172, 17, 240, 158);
		contentPane.add(table);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(22, 31, 70, 15);
		contentPane.add(lblNombre);
		
		textField = new JTextField();
		textField.setBounds(22, 57, 114, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblTelfono = new JLabel("Teléfono:");
		lblTelfono.setBounds(22, 96, 70, 15);
		contentPane.add(lblTelfono);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(22, 122, 114, 19);
		contentPane.add(textField_1);
		
		JButton btnAadirContacto = new JButton("Añadir contacto");
		btnAadirContacto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnAadirContacto.setBounds(22, 187, 146, 25);
		contentPane.add(btnAadirContacto);
		
		JButton btnEditarContacto = new JButton("Editar contacto");
		btnEditarContacto.setBounds(270, 187, 142, 25);
		contentPane.add(btnEditarContacto);
		
		JButton btnEliminarContacto = new JButton("Eliminar contacto");
		btnEliminarContacto.setBounds(145, 228, 156, 25);
		contentPane.add(btnEliminarContacto);
		
		setResizable(false);
	}
}
