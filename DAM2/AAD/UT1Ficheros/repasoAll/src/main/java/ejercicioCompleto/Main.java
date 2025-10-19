package ejercicioCompleto;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		//Crea un programa en Java que gestione un inventario de productos, donde cada producto tenga un identificador, un nombre, un precio y una cantidad en stock. El programa debe permitir trabajar con los datos del inventario utilizando ficheros de texto, ficheros binarios, ficheros de objetos y ficheros de acceso aleatorio, almacenando y recuperando la información según el tipo de fichero correspondiente.
		Scanner sc = new Scanner(System.in);
		boolean continuar = true;
		File inventarioTxt = new File("inventario.txt");
		File inventarioDat = new File("inventario.dat");
		
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
			}
			case 6 -> {
				// Cargar desde fichero de objetos
			}
			case 7 -> {
				// Guardar en fichero de acceso aleatorio
			}
			case 8 -> {
				// Cargar desde fichero de acceso aleatorio
			}
			case 9 -> {
				// Mostrar inventario
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
	
	private static void modifyProduct() {

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
				  9. Mostrar inventario
				  10. Llenar lista de productos (PRIMER PASO)
				  11. Eliminar producto
				  12. Salir
				Seleccione una opción: """);

	}
}
