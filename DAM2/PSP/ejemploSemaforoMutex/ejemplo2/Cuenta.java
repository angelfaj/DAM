package ejemplo2;

public class Cuenta {
	//Saldo de la cuenta
    static int cuenta=100;
    
    public void ingreso(int cantidad) {
    	System.out.println("Hay en la cuenta: "+cuenta);
    	cuenta+=cantidad;    	
    }
    
    public void retirada(int cantidad) {
    	System.out.println("Hay en la cuenta: "+cuenta);
    	cuenta-=cantidad;
    	
    }
}
