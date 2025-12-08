package boletin2ej1;

public class ThreadSaludadores extends Thread{

	public static void main(String[] args) {
		/*Enunciado 1: “Saludadores en equipo”
		Imagina que tienes un grupo de personas que quieren saludar al mismo tiempo.
		Cada una lo hará por separado, pero todas pertenecen al mismo equipo. Crea
		un programa donde cada saludo se haga desde un hilo diferente, y todos estén
		agrupados bajo un mismo nombre de equipo.
		Objetivo oculto: Crear varios hilos con nombres personalizados dentro de un
		ThreadGroup, y mostrar su información con Thread.toString().
		*/

		Thread.currentThread().setName("Main");
		
		ThreadGroup grupo = new ThreadGroup("Grupo saludadores");
		ThreadSaludadores ts = new ThreadSaludadores();
		
		Thread s1 = new Thread(grupo, ts, "Saludador 1");
		Thread s2 = new Thread(grupo, ts, "Saludador 2");
		Thread s3 = new Thread(grupo, ts, "Saludador 3");
		
		s1.start();
		s2.start();
		s3.start();
	}
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().toString() + " te saludo");
	}
}
