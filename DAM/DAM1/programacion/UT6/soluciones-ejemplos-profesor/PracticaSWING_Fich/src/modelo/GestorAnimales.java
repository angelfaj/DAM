package modelo;

import java.io.*;
import java.util.ArrayList;

public class GestorAnimales {

	public boolean guardarComoTexto(String ruta, Animal animal) throws IOException {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta, true));) {
			if (animal != null) {
				bw.write(animal.toString());
				bw.newLine();
				return true;
			} else
				return false;

		}

	}

	public boolean guardarComoObjeto(String ruta, Animal animal) throws IOException {
		try (FileOutputStream fos = new FileOutputStream(ruta, true);) {

			ObjectOutputStream oos;
			File f = new File(ruta);
			if (f.length() == 0)
				oos = new ObjectOutputStream(fos);
			else
				oos = new ObjectOutputStreamSinCabecera(fos);

			if (animal != null) {
				oos.writeObject(animal);
				return true;
			} else
				return false;
		}
	}

	public ArrayList<Animal> cargarDesdeObjeto(String ruta) throws IOException, ClassNotFoundException {
		ArrayList<Animal> lista = new ArrayList<>();
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ruta));) {
			while (true) {
				Animal a = (Animal) ois.readObject();
				lista.add(a);
			}

		} catch (EOFException e) {
			System.out.println("Final lectura fichero");
		} finally {
			return lista;

		}

	}

	public String cargarDesdeTexto(String ruta) throws IOException {
		StringBuilder sb = new StringBuilder();
		try(BufferedReader br = new BufferedReader(new FileReader(ruta));){
			String linea;
			while ((linea = br.readLine()) != null) {
				sb.append(linea).append("\n");
			}
		}
		return sb.toString();
	}
}
