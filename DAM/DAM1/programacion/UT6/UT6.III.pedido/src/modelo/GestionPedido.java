package modelo;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class GestionPedido {
	private static final File PEDIDOTXT = new File("pedido.txt");
	private static final File PEDIDOBIN = new File("pedido.bin");
	
	public GestionPedido() {
		super();
	}
	
	public void savePedidoTxt(Pedido p) throws IOException {
		FileWriter writer = null;
		
		if (!PEDIDOTXT.exists()) {
			writer = new FileWriter(PEDIDOTXT);
		}else 
			writer = new FileWriter(PEDIDOTXT, true);
		
		writer.write(p + "\n");
		writer.close();
	}
	
	public void savePedidoBin(Pedido p) throws FileNotFoundException, IOException {
		FileOutputStream fo = null;
		ObjectOutputStream datos = null;
		
		if (!PEDIDOBIN.exists()) {
			fo = new FileOutputStream(PEDIDOBIN);
			datos = new ObjectOutputStream(fo);
		}else {
			fo = new FileOutputStream(PEDIDOBIN, true);
			datos = new MiObjectOutputStream(fo);
		}
		
		datos.writeObject(p);
		datos.close();
	}
	
	public String readAllPedidoBin() throws ClassNotFoundException, IOException {
		String pedidos = "";
		
		try (FileInputStream fi = new FileInputStream(PEDIDOBIN); ObjectInputStream datos = new ObjectInputStream(fi)) {
			while (true) {
				Pedido p = (Pedido) datos.readObject();
				pedidos += p + "\n";
			}
		}catch (EOFException e) {}
		
		return pedidos;
	}
	
	public String readAllPedidoTxt() throws IOException {
		String pedidos = "", linea = "";
		
		try (FileReader reader = new FileReader(PEDIDOTXT); BufferedReader buffer = new BufferedReader(reader)) {
			while ((linea = buffer.readLine()) != null) {
				pedidos += linea + "\n";
			}
		}
		return pedidos;
	}
	
	public String searchPedidoBin(Pedido p) throws ClassNotFoundException, IOException {
		try(FileInputStream fi = new FileInputStream(PEDIDOBIN); ObjectInputStream datos = new ObjectInputStream(fi)) {
			while (true) {
				Pedido aux = (Pedido) datos.readObject();
				if (aux.equals(p)) {
					return aux.toString();
				}
			}
		}catch (EOFException e) {}
		
		return "";
	}
	
	public String searchPedidoTxt(String pedido) throws IOException {
		String linea = "";
		
		try(FileReader reader = new FileReader(PEDIDOTXT); BufferedReader buffer = new BufferedReader(reader)) {
			while ((linea = buffer.readLine()) != null) {
				if (linea.split(" - ")[0].equalsIgnoreCase(pedido)) {
					return linea;
				}
			}
		}
		return "";
	}
	

}
