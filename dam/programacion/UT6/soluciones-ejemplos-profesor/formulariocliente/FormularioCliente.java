package formulariocliente;

import javax.swing.*;
import java.awt.event.*;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class FormularioCliente extends JFrame implements ActionListener {

	private JTextField campoNombre, campoCorreo;
	private JCheckBox checkDesayuno;
	private JButton botonEnviar;
	private JTextArea resultado;

	private final String ARCHIVO = "formularios.dat";

	public FormularioCliente() {
		setTitle("Formulario Cliente");
		setSize(400, 300);
		setLayout(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JLabel label1 = new JLabel("Nombre:");
		label1.setBounds(20, 20, 100, 25);
		add(label1);

		campoNombre = new JTextField();
		campoNombre.setBounds(120, 20, 200, 25);
		add(campoNombre);

		JLabel label2 = new JLabel("Correo:");
		label2.setBounds(20, 60, 100, 25);
		add(label2);

		campoCorreo = new JTextField();
		campoCorreo.setBounds(120, 60, 200, 25);
		add(campoCorreo);

		checkDesayuno = new JCheckBox("Incluir desayuno");
		checkDesayuno.setBounds(120, 100, 150, 25);
		add(checkDesayuno);

		botonEnviar = new JButton("Enviar");
		botonEnviar.setBounds(120, 140, 100, 30);
		botonEnviar.addActionListener(this);
		add(botonEnviar);

		resultado = new JTextArea();
		resultado.setBounds(20, 180, 340, 60);
		resultado.setEditable(false);
		add(resultado);
	}

	public void actionPerformed(ActionEvent e) {
		String nombre = campoNombre.getText();
		String correo = campoCorreo.getText();
		boolean desayuno = checkDesayuno.isSelected();

		Cliente cliente = new Cliente(nombre, correo, desayuno);
		try {
			guardarCliente(cliente);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		try {
			ArrayList<Cliente> clientes = null;

			clientes = leerClientes();
			//Para concatenar o alterar textos es más eficiente StringBuilder que String ya que String no es mutable y StringBuilder sí. 
			//String crea objetos nuevos cada vez que lo variamos.
			StringBuilder texto = new StringBuilder();
			for (Cliente c : clientes) {
				texto.append(c.toString()).append("\n"); //añado (append) cada cliente con un salto de linea al final
			}
			
			String todoTexto=texto.toString();
			resultado.setText(todoTexto);//muestro en el textArea el String final que he compuesto
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	private void guardarCliente(Cliente cliente) throws IOException {
		try (FileOutputStream fos = new FileOutputStream(ARCHIVO, true);) {
			ObjectOutputStream oos;
			File f = new File(ARCHIVO);
			if (!f.exists())
				oos = new ObjectOutputStream(fos);
			else
				oos = new ObjectOutputStreamSinCabecera(fos);

			oos.writeObject(cliente);
		}
	}

	private ArrayList<Cliente> leerClientes() throws ClassNotFoundException, FileNotFoundException, IOException {
		ArrayList<Cliente> lista = new ArrayList<>();
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARCHIVO))) {
			while (true) {
				Cliente c = (Cliente) ois.readObject();
				lista.add(c);
			}
		} catch (EOFException eof) {
			// Fin del archivo.
			System.out.println("Fin del fichero");
		}
		return lista;
	}

	public static void main(String[] args) {
		new FormularioCliente().setVisible(true);
	}
}
