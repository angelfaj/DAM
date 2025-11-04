package boletin4ej1;

public class HiloSuma implements Runnable{
	private int n1, n2;
	private Cuenta cuenta;
	
	public HiloSuma (int n1, int n2, Cuenta cuenta) {
		this.n1 = n1;
		this.n2 = n2;
		this.cuenta = cuenta;
	}
	
	@Override
	public void run() {
		synchronized (cuenta) {
			cuenta.aumentaCuenta(n1);
			cuenta.aumentaCuenta(n2);
			System.out.println("HiloSuma acaba de sumar: " + cuenta.muestraCuenta());
		}
	}

}
