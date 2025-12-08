package boletin1ej2;

public class HiloNumeros extends Thread{
	
	
	@Override
	public void run() {
		for (int i = 1; i <= 20; i++) {
			System.out.print(i + " ");
			try {
				HiloNumeros.sleep(1500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
