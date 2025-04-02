package ficherosCombinacion;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) {
		/*6. Creación de un log de operaciones
		Registrar cada operación bancaria (retiro/deposito) en un archivo de texto
		(log.txt).
		Pautas:
		• Crear una clase CuentaBancaria con titular y saldo.
		• Permitir depósitos y retiros, actualizando la cuenta. Realiza varias
		operaciones sobre distintas cuentas para que se guarden estas
		operaciones en el log.
		• Guardar cada operación de la CuentaBancaria con fecha en log.txt. Utiliza
		LocalDateTime.now() para guardar la fecha actual cuando se produce la
		operación de depósito/retirada. Ejemplo fichero log.txt
		2025-03-28T18:45:41.458552400 - Ana Martín - Retiro - 10,00
		2025-03-28T18:53:57.605749300 - Pepe - Depósito - 100,00
		*/
		/*
		File logFile = new File("logFile.log");
		CuentaBancaria cuenta = null;
		
		try {
			cuenta = new CuentaBancaria("Vanesa", 230000.43, logFile);
			System.out.println("Añadimos 300");
			cuenta.addSaldo(300);
			System.out.println("Retiramos 10");
			cuenta.extractSaldo(10);
			System.out.println("\n" + "*********** Mostramos log ***********");
			CuentaBancaria.readLog();
		} catch (IOException e) {
			e.printStackTrace();
		}
		*/
		
		/*7. Comparación entre un archivo de texto y un binario
		Comparar clientes almacenados en clientes.txt y clientes.dat y guardar los que
		solo están en uno de los dos archivos en diferencias.txt.
		Pautas:
		• clientes.txt contiene id,nombre.
		• clientes.dat almacena una lista de objetos Cliente donde algunos
		coincidan en id con los de clientes.txt y otros no.
		• Comparar ambas fuentes y guardar las diferencias en un archivo de texto.
		Ejemplo fichero diferencias.txt:
		Clientes solo en texto:
		[101,Luis Sánchez, 102,María Herrera, 103,Pablo Morales]
		Clientes solo en binario:
		[102, 104]
		*/
		/*
		File txtF = new File("clientes.txt");
		File objF = new File("clientes.dat");
		File txtDiferencias = new File("diferencias.txt");
		
		Cliente c1 = new Cliente("Paco", 1);
		Cliente c2 = new Cliente("Laura", 2);
		Cliente c3 = new Cliente("Maria", 3);
		Cliente c4 = new Cliente("Ramon", 4);
				
		Cliente[] clientesTxt = {c1, c2, c3}; 
		Cliente[] clientesObj = {c2, c3, c4}; 


		for (int i = 0; i < clientesObj.length; i++) {	//Rellenamos los ficheros
			try {
				clientesTxt[i].writeClienteFile(txtF);
				clientesObj[i].writeClienteObject(objF);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		//Imprimimos el contenido
		try {
			System.out.println("**********Contenido fichero txt**********");
			Cliente.readFileTxt(txtF);
			System.out.println("=========================================" + "\n");
			System.out.println("**********Contenido fichero objetos**********");
			Cliente.readFileObject(objF);
			System.out.println("=========================================");
			//Comparamos
			Cliente.compareSavedData(txtF, objF, txtDiferencias);
			System.out.println("**********Contenido diferencias txt**********");
			Cliente.readFileTxt(txtDiferencias);
			System.out.println("=========================================" + "\n");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		*/
		
		/*8. Serialización de datos con clave-valor desde un texto
		Convertir un archivo de configuración de texto (config.txt) en un archivo binario
		(config.dat).
		Pautas:
		• config.txt tiene pares clave-valor en formato clave=valor.
		• Crear una clase Configuracion con un Map<String, String>.
		• Leer el archivo de texto, convertirlo en un mapa y guardarlo en config.dat.*/
		
		File configTxt= new File("configuracion.txt");
		File configBin = new File("configuracion.dat");
		
		Configuracion c1 = new Configuracion();
		
		try {
			c1.fillMapFromTxt(configTxt);
			System.out.println("Mapa con los vañores del txt");
			System.out.println(c1);
			System.out.println("Guardamos el contenido en un binario");
			c1.saveMapInBinFile(configBin);
			System.out.println("Contenido del binario");
			Configuracion.readFileObject(configBin);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
