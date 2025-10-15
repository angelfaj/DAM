package app;

public class ProcesoClasificador {

    public static void main(String[] args) {
        
    	//Comprobamos si se han introducido argumentos
    	//En funcion del tipo de argumento introducido finalizamos el programa y devolvemos un codigo de salida
        if (args.length == 0) {
            System.out.println("ERROR: Falta argumento. Finalizando...");
            System.exit(1);
        }
        
        //Volcamos el argumento recibido en una cadena
        String argumento = args[0];
        int numero = 0;
        
        try {
        	//Intentamos castearlo a entero, si no es un entero arrojara la excepcion NumberFormatException 
            numero = Integer.parseInt(argumento);
            
            //Comprobamos si es par o impar
            if (numero % 2 == 0) {
                System.out.println("Número par clasificado: " + numero);
                System.exit(20);
            } else {
                System.out.println("Número impar clasificado: " + numero);
                System.exit(30);
            }
            //Controlamos la excepcion producida al introducirse una cadena e intentar parsearla a un entero
        } catch (NumberFormatException e) {
            System.out.println("ERROR: Argumento no numérico ('" + argumento + "'). Finalizando.");
            System.exit(10);
        }
    }
}
