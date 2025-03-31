package ficherosCombinacion;

import java.io.File;
import java.io.IOException;

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
		
		
		/*8. Serialización de datos con clave-valor desde un texto
		Convertir un archivo de configuración de texto (config.txt) en un archivo binario
		(config.dat).
		Pautas:
		• config.txt tiene pares clave-valor en formato clave=valor.
		• Crear una clase Configuracion con un Map<String, String>.
		• Leer el archivo de texto, convertirlo en un mapa y guardarlo en config.dat.*/

	}

}
