package boletin4ej1;

public class Cuenta {
	private static int cuenta = 0;
	
	public void aumentaCuenta(int n) {
		cuenta += n;
	}
	
	public void disminuyeCuenta(int n) {
		cuenta -= n;
	}
	
	public int muestraCuenta() {
		return cuenta;
	}
}
