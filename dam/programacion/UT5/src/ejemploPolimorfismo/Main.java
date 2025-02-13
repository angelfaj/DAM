package ejemploPolimorfismo;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Madre madre = new Madre();
		Hija1 h1 = new Hija1();
		Hija2 h2 = new Hija2();
		
		Madre madre2;
		
		madre2 = madre;
		madre2.llamame();
		
		madre2 = h1;
		h1.llamame();
		
		madre2 = h2;
		h2.llamame();
		madre2.llamame();
		
		
	}

}
