package Boletin2;

public class Ejercicio2 {

	public static void main(String[] args) {
		// valores
		int a=3;
		int b=6;
		int c=0;
		
		//Empezamos a operar
		c=a+b;
		System.out.println("Suma: c = a + b = " + c);
		
		c=a-b;
		System.out.println("Resta: c = a - b = " + c);
		
		c=a*b;
		System.out.println("Multiplicación: c = a * b = " + c);
		
		c=b/a;
		System.out.println("División: c = a / b = " + c);
		
		c=6%3;
		System.out.println("Módulo: c = 6 % 3 = " + c);
		
		a++;
		System.out.println("Incremento: a = a + 1 = " + a);
		
		b--;
		System.out.println("Decremento: b = b - 1 = " + b);
		
		a+=b;
		System.out.println("Suma: a = a + b = " + a);
		System.out.println("Suma: a = a + b = " + b);
		
		b-=a;
		System.out.println("Resta: b = b - a= " + a);
		System.out.println("Resta: b = b - a = " + b);
	}

}
