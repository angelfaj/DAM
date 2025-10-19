package ejercicioCompleto;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
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
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		//Crea un programa en Java que gestione un inventario de productos, donde cada producto tenga un identificador, un nombre, un precio y una cantidad en stock. El programa debe permitir trabajar con los datos del inventario utilizando ficheros de texto, ficheros binarios, ficheros de objetos y ficheros de acceso aleatorio, almacenando y recuperando la información según el tipo de fichero correspondiente.
		Scanner sc = new Scanner(System.in);
		boolean continuar = true;
		File inventarioTxt = new File("inventario.txt");
		File inventarioDat = new File("inventario.dat");
		File inventarioObj = new File("inventarioObj.dat");
		File inventarioRaf = new File("inventarioRaf.raf");
		
		ArrayList<Producto> productList = new ArrayList<Producto>();
		
		do {
			showMenu();
			int op = sc.nextInt();
			sc.nextLine();
			
			switch (op) {
			case 1 -> {
				// Guardar en fichero de texto (.txt)
				try {
					saveInTxt(productList, inventarioTxt);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Guardado en txt");
			}
			case 2 -> {
				// Cargar desde fichero de texto (.txt)
				System.out.println("Contenido del fichero: " + inventarioTxt.getAbsolutePath());
				try {
					printFromTxt(inventarioTxt);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			case 3 -> {
				// Guardar en fichero binario
				try {
					saveInBinFile(productList, inventarioDat);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Guardado en binario");
				
			}
			case 4 -> {
				// Cargar desde fichero binario
				System.out.println("Contenido del fichero: " + inventarioDat.getAbsolutePath());
				try {
					printFromBinFile(inventarioDat);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			case 5 -> {
				// Guardar en fichero de objetos
				try {
					saveInObjFile(productList, inventarioObj);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Guardado en fichero de objetos");
			}
			case 6 -> {
				// Cargar desde fichero de objetos
				System.out.println("Contenido del fichero: " + inventarioObj.getAbsolutePath());
				try {
					printFromObjFile(inventarioObj);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			case 7 -> {
				// Guardar en fichero de acceso aleatorio
				try {
					saveInRafFile(productList, inventarioRaf);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Guardado en fichero raf");
			}
			case 8 -> {
				// Cargar desde fichero de acceso aleatorio
				System.out.println("Contenido del fichero: " + inventarioRaf.getAbsolutePath());
				try {
					printFromRafFile(inventarioRaf);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			case 9 -> {
				// Modificar producto
				System.out.println("Introduce el id del producto: ");
				int id = sc.nextInt();
				sc.nextLine();
				try {
					modifyProduct(id, inventarioRaf, sc);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			case 10 -> {
				// Añadir productos
				productList.clear();
				productList.add(new Producto(1, "Jabon", 3.45, 67));
				productList.add(new Producto(2, "PC", 345, 7));
				productList.add(new Producto(3, "Libreta", 1.45, 644));
				productList.add(new Producto(4, "Soporte", 35.99, 34));
				productList.add(new Producto(5, "Raton", 4.45, 62));
				productList.add(new Producto(6, "Taladro", 75.34, 6));
				productList.add(new Producto(7, "Tijeras", 2.45, 7));
			}
			case 11 -> {
				// Eliminar producto
			}
			case 12 -> {
				// Salir
				continuar = false;
				System.out.println("Saliendo del programa...");
			}
			default -> {
				System.out.println("Opción no válida. Intente de nuevo.");
			}
			}
		}while(continuar);
		sc.close();

	}
	//Metodos para la gestion de los archivos//
	private static void saveInTxt(ArrayList<Producto> productList, File txt) throws IOException {
		try(FileWriter writer = new FileWriter(txt)) {
			for (Producto p: productList) {
				writer.write(p.toString() + "\n");
			}
		}
	}

	private static void printFromTxt(File txt) throws IOException {
		try(FileReader fr = new FileReader(txt)) {
			int c;
			while ((c = fr.read()) != -1) {
				System.out.print((char) c);
			}
		}
	}

	private static void saveInBinFile(ArrayList<Producto> productList, File inventarioDat) throws IOException {
		try(FileOutputStream fo = new FileOutputStream(inventarioDat, true); DataOutputStream datos = new DataOutputStream(fo)) {
			for (Producto p: productList) {
				datos.writeInt(p.getId());
				datos.writeUTF(p.getName());
				datos.writeDouble(p.getPrice());
				datos.writeInt(p.getStock());
			}
		}
	}
	
	private static void printFromBinFile(File inventarioDat) throws IOException {
		try(FileInputStream fi = new FileInputStream(inventarioDat); DataInputStream datos = new DataInputStream(fi)) {
			while (true) {
				int id = datos.readInt();
				String name = datos.readUTF();
				double price = datos.readDouble();
				int stock = datos.readInt();
				System.out.println(id + ":" + name + ":" + price + ":" + stock);
			}
		}catch (EOFException e) {}
	}
	
	private static void saveInObjFile(ArrayList<Producto> productList, File inventarioObj) throws IOException {
		FileOutputStream fo;
		ObjectOutputStream datos;
		
		if (!inventarioObj.exists()) {
			fo = new FileOutputStream(inventarioObj);
			datos = new ObjectOutputStream(fo);
		}else {
			fo = new FileOutputStream(inventarioObj, true);
			datos = new MiObjectOutputStream(fo);
		}
		
		for (Producto p:productList) {
			datos.writeObject(p);
		}
		
		datos.close();
	}
	
	private static void printFromObjFile(File inventarioObj) throws IOException, ClassNotFoundException {
		try(FileInputStream fi = new FileInputStream(inventarioObj);ObjectInputStream datos = new ObjectInputStream(fi)) {
			while (true) {
				Producto p = (Producto) datos.readObject();
				System.out.println(p);
			}
		}catch (EOFException e) {}
	}
	
	private static void saveInRafFile(ArrayList<Producto> productList, File inventarioRaf) throws IOException {
		try(RandomAccessFile raf = new RandomAccessFile(inventarioRaf, "rw")) {
			//Colocamos el puntero al final
			raf.seek(raf.length());
			for (Producto p:productList) {
				raf.writeInt(p.getId());
				StringBuilder sb = new StringBuilder();
				sb.append(p.getName());
				sb.setLength(10);
				raf.writeChars(sb.toString());
				raf.writeDouble(p.getPrice());
				raf.writeInt(p.getStock());
			}
		}
	}
	
	private static void printFromRafFile(File inventarioRaf) throws IOException, ClassNotFoundException {
		try(RandomAccessFile raf = new RandomAccessFile(inventarioRaf, "r")) {
			char[] name = new char[10];
			while (raf.getFilePointer() < raf.length()) {
				int id = raf.readInt();
				for (int i = 0; i < name.length; i++) {
					name[i] = raf.readChar();
				}
				String nameS = new String(name);
				double price = raf.readDouble();
				int stock = raf.readInt();
				//De no realizar trim() no se muestran los valores price y stock
				System.out.println(id + ":" + nameS.trim() + ":" + price + ":" + stock);
			}
		}
	}
	
	private static void modifyProduct(int id, File inventarioRaf, Scanner sc) throws FileNotFoundException, IOException {
		//int + string + double + int
		int registerSize = 4 + 20 + 8 + 4;
		int position = (id - 1) * registerSize;
		
		try(RandomAccessFile raf = new RandomAccessFile(inventarioRaf, "rw")) {
			raf.seek(position);
			//Leemos y mostramos la linea a modificar
			int id2 = raf.readInt();
			char[] name = new char[10];
			for (int i = 0; i < name.length; i++) {
				name[i] = raf.readChar();
			}
			String nameS = new String(name);
			double price = raf.readDouble();
			int stock = raf.readInt();
			//De no realizar trim() no se muestran los valores price y stock
			System.out.println("Producto a modificar: " + id2 + ":" + nameS.trim() + ":" + price + ":" + stock);
			
			//Solicitamos datos
			System.out.println("Introduce el nuevo precio: ");
			price = sc.nextDouble();
			System.out.println("Introduce el nuevo stock: ");
			stock = sc.nextInt();
			
			//Guardamos
			raf.seek(position);
			raf.skipBytes(24); //Saltamos id y nombre
			raf.writeDouble(price);
			raf.writeInt(stock);
		}
	}
	
	private static void showMenu() {
		System.out.println("""
				=== GESTIÓN DE INVENTARIO ===
				  1. Guardar en fichero de texto (.txt)
				  2. Cargar desde fichero de texto (.txt)
				  3. Guardar en fichero binario (.dat)
				  4. Cargar desde fichero binario (.dat)
				  5. Guardar en fichero de objetos (.dat)
				  6. Cargar desde fichero de objetos (.dat)
				  7. Guardar en fichero de acceso aleatorio (.raf/dat)
				  8. Cargar desde fichero de acceso aleatorio (.raf/dat)
				  9. Modificar producto
				  10. Llenar lista de productos (PRIMER PASO)
				  11. Eliminar producto
				  12. Salir
				Seleccione una opción: """);

	}
}
