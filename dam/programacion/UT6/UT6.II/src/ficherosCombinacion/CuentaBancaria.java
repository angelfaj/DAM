package ficherosCombinacion;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class CuentaBancaria {
	private String titular;
	private double saldo;
	private static File logFile;
	
	public CuentaBancaria(String titular, double saldo, File f) throws IOException {
		super();
		this.titular = titular;
		this.saldo = saldo;
		if (!f.exists()) {
			f.createNewFile();
		}
		logFile = f;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	@Override
	public String toString() {
		return "CuentaBancaria [titular=" + titular + ", saldo=" + saldo + "]";
	}
	
	public void addSaldo(double cantidad) throws IOException {
		this.saldo += cantidad;
		writeLog('d', cantidad);
	}
	
	public void extractSaldo(double cantidad) throws IOException {
		this.saldo -= cantidad;
		writeLog('r', cantidad);
	}
	
	public void writeLog(char act, double cantidad) throws IOException {
		String accion = "", message = "";
		if (act == 'd') {
			accion = "Depósito";
		}else if (act == 'r') {
			accion = "Retiro";
		}
		message = LocalDateTime.now() + " - " + this.getTitular() + " - " + accion + " - " + cantidad + "\n";  
		try(FileWriter writer = new FileWriter(logFile, true)) {
			writer.write(message);
		}
	}
	
	public static void readLog() throws FileNotFoundException, IOException {
		String linea = "";
		try(FileReader fr = new FileReader(logFile); BufferedReader bf = new BufferedReader(fr)) {
			while ((linea = bf.readLine()) != null) {
				System.out.println(linea);
			}
		}
	}
	
}
