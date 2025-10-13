package Boletin3;

public class AnexoI {

	public static void main(String[] args) {
		//Convertir al resto de tipos
		/*
		boolean       
		byte
		short
		char
		int
		long
		float
		double
		String
		*/
		
		
		//EJEMPLO SINTAXIS; De char a byte
//		byte miByte;
//		char miChar=5;
//		miByte=(byte)miChar;
		
		
		//Declaración de variables
		byte miByte;
		short miShort;
		char miChar;
		int miInt;
		long miLong;
		float miFloat;
		double miDouble;
		
		//SHORT
		//De short a byte
		miShort=12;
		miByte=(byte)miShort;
		
		//CHAR
		//De char a int
		miChar=10;
		miInt=miChar;
		//De char a short
		miShort=(short)miChar;
		//De char a byte
		miByte=(byte)miChar;
		
		//INT
		//De int a byte
		miInt=5;
		miByte=(byte)miInt;
		//De int a char
		miChar=(char)miInt;
		//De int a short
		miShort=(short)miInt;
		
		//LONG
		//De long a char
		miLong=6;
		miChar=(char)miLong;
		//De long a int
		miInt=(int)miLong;
		//De long a short
		miShort=(short)miLong;
		//De long a byte
		miByte=(byte)miLong;
		
		//FLOAT
		//De float a long
		miFloat=4;
		miLong=(long)miFloat;
		//De float a int
		miInt=(int)miFloat;
		//De float a char
		miChar=(char)miFloat;
		//De float a short
		miShort=(short)miFloat;
		//De float a byte
		miByte=(byte)miFloat;
		
		//DOUBLE
		//De double a float
		miDouble=2;
		miFloat=(float)miDouble;
		//De double a long
		miLong=(long)miDouble;
		//De double a int
		miInt=(int)miDouble;
		//De double a char
		miChar=(char)miDouble;
		//De double a short
		miShort=(short)miDouble;
		//De double a byte
		miByte=(byte)miDouble;		
		
		
		
		//prueba
		miFloat=miChar;
		System.out.println("quó");
		
			
		
	}

}
