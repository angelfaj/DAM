package boletin4ej1;

public class HiloResta implements Runnable{
	private int n1, n2;
	private Cuenta cuenta;
	
	public HiloResta (int n1, int n2, Cuenta cuenta) {
		this.n1 = n1;
		this.n2 = n2;
		this.cuenta = cuenta;
	}
	
	@Override
	public void run() {
		synchronized (cuenta) {
			cuenta.disminuyeCuenta(n1);
			cuenta.disminuyeCuenta(n2);
			System.out.println("HiloResta acaba de restar: " + cuenta.muestraCuenta());
		}
	}

}
