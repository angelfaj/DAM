package vista;

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
import javax.swing.JTextArea;

public class VistaLista extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JList<String> list;
	private final String[] listaTareas = {"Recoger el salón", "Lavar los platos", "Poner la lavadora", "Tender la ropa", "Recoger la ropa", "Hacer la compra", "Fregar la cocina", "Pasar el aspirador"};
	private JButton btnAdd, btnEliminar, btnEliminarTodo;
	private JLabel lblTareas_1;
	private JTextArea textArea;
	private JScrollPane scroll, scrollList;

	public VistaLista() {
		setTitle("Lista de tareas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTareas = new JLabel("Tareas: ");
		lblTareas.setBounds(26, 33, 92, 14);
		contentPane.add(lblTareas);
		
		
		list = new JList<String>(listaTareas);		//Importante crear asi las listas evitando el metodo x defecto de windowbuilder

		scrollList = new JScrollPane(list);
		scrollList.setBounds(26, 58, 120, 128);
		contentPane.add(scrollList);
		
		btnAdd = new JButton("Añadir");
		btnAdd.setForeground(new Color(255, 255, 255));
		btnAdd.setBackground(new Color(0, 204, 0));
		btnAdd.setBounds(100, 200, 89, 23);
		contentPane.add(btnAdd);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setForeground(new Color(255, 255, 255));
		btnEliminar.setBackground(new Color(204, 0, 0));
		btnEliminar.setBounds(232, 200, 89, 23);
		contentPane.add(btnEliminar);
		
		lblTareas_1 = new JLabel("Lista:");
		lblTareas_1.setBounds(270, 34, 92, 14);
		contentPane.add(lblTareas_1);
		
		textArea = new JTextArea();
		textArea.setEnabled(false);
		scroll = new JScrollPane(textArea);
		scroll.setBounds(270, 58, 120, 128);
		contentPane.add(scroll);
		
		btnEliminarTodo = new JButton("Eliminar todo");
		btnEliminarTodo.setForeground(Color.WHITE);
		btnEliminarTodo.setBackground(new Color(204, 0, 0));
		btnEliminarTodo.setBounds(145, 233, 130, 23);
		contentPane.add(btnEliminarTodo);

		setVisible(true);
		setResizable(false);
	}

	public JTextArea getTextArea() {
		return textArea;
	}

	public JList<String> getList() {
		return list;
	}

	public String[] getListaTareas() {
		return listaTareas;
	}

	public JButton getBtnAdd() {
		return btnAdd;
	}

	public JButton getBtnEliminar() {
		return btnEliminar;
	}
	
	public JButton getBtnEliminarTodo() {
		return btnEliminarTodo;
	}
}
