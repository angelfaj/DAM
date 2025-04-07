package listaTareas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.AbstractListModel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class UI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

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
	File listaTareasTxt = new File("listaTareas.txt");
	
	public UI() {
		setTitle("Lista de tareas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		
		JLabel lblTareas = new JLabel("Tareas: ");
		lblTareas.setBounds(36, 70, 92, 14);
		contentPane.add(lblTareas);
		
		String[] listaTareas = {"Recoger el salón", "Lavar los platos", "Poner la lavadora", "Tender la ropa", "Recoger la ropa", "Hacer la compra", "Fregar la cocina", "Pasar el aspirador"};
		JList list = new JList(listaTareas);		//Importante crear asi las listas evitando el metodo x defecto de windowbuilder

		list.setBounds(36, 95, 120, 128);
		contentPane.add(list);
		
		JButton btnAdd = new JButton("Añadir");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!listaTareasTxt.exists()) {
					try {
						listaTareasTxt.createNewFile();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
				try (FileWriter writer = new FileWriter(listaTareasTxt, true)) {
					writer.write(listaTareas[list.getSelectedIndex()] + "\n");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnAdd.setForeground(new Color(255, 255, 255));
		btnAdd.setBackground(new Color(0, 204, 0));
		btnAdd.setBounds(191, 200, 89, 23);
		contentPane.add(btnAdd);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try (FileReader reader = new FileReader(listaTareasTxt); BufferedReader br = new BufferedReader(reader)) {
					String nuevaLista = "", linea = "";
					
					while ((linea = br.readLine()) != null ) {
						if (!linea.equals(listaTareas[list.getSelectedIndex()])) {		//Copio el resto de valores, borro el txt, creo uno nuevo y pego los valores.
							nuevaLista += linea + "\n";
						}
					}
					
					try (FileWriter writer = new FileWriter(listaTareasTxt)) {	//Si lo instanciamos en el try superior se guardará el contenido del fichero antiguo y no borrara correctamente
						writer.write(nuevaLista);					
					}
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnEliminar.setForeground(new Color(255, 255, 255));
		btnEliminar.setBackground(new Color(204, 0, 0));
		btnEliminar.setBounds(320, 200, 89, 23);
		contentPane.add(btnEliminar);

		
	}
}
