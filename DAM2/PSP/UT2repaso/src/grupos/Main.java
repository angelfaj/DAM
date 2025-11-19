package grupos;

public class Main {

	public static void main(String[] args) {
		/*Enunciado 1: “Saludadores en equipo”
		Imagina que tienes un grupo de personas que quieren saludar al mismo tiempo.
		Cada una lo hará por separado, pero todas pertenecen al mismo equipo. Crea
		un programa donde cada saludo se haga desde un hilo diferente, y todos estén
		agrupados bajo un mismo nombre de equipo.
		Objetivo oculto: Crear varios hilos con nombres personalizados dentro de un
		ThreadGroup, y mostrar su información con Thread.toString().*/

//		ThreadGroup saludadores = new ThreadGroup("Saludadores");
//		Thread marcelo = new Thread(saludadores, new HiloSaludadores("Marcelo"));
//		Thread marianela = new Thread(saludadores, new HiloSaludadores("Marianela"));
//		Thread macarena = new Thread(saludadores, new HiloSaludadores("Macarena"));
//
//		marcelo.start();
//		marianela.start();
//		macarena.start();
//		
//		//Info extra
//		System.out.println(marcelo.toString());
//		System.out.println(marianela.toString());
//		System.out.println(macarena.toString());
//		System.out.println("Hilos activos: " + saludadores.activeCount());

		/*Enunciado 3: “Apagar todos los relojes”
		Tienes varios relojes que hacen “tic tac” cada segundo. Después de un rato,
		decides apagar todos a la vez. Crea un programa donde cada reloj sea un hilo
		que imprime “tic tac” cada segundo, y luego interrumpe todos los relojes juntos
		usando el grupo.
		Objetivo oculto: Uso de sleep(), interrupt(), y control grupal con ThreadGroup.*/
	
		ThreadGroup relojes = new ThreadGroup("relojes");
		Thread r1 = new Thread(relojes, new HiloTicTac());
		Thread r2 = new Thread(relojes, new HiloTicTac());
		Thread r3 = new Thread(relojes, new HiloTicTac());
		Thread r4 = new Thread(relojes, new HiloTicTac());
		
		r1.start();
		r2.start();
		r3.start();
		r4.start();

		try {
			Thread.sleep(5500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		relojes.interrupt();

		try {	
			//Espera necesaria para que los hilos mueran
			Thread.sleep(3500);
			System.out.println("Hilos activos tras interrupcion: " + relojes.activeCount());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
