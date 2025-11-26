package boletin1ej1;

public class HiloHora extends Thread{
	private String nombreEmpleado;
	private String dia;
	private double hora;
	private static final double HORA_INGRESO = 8.00;
	
	public HiloHora(String nombreEmpleado, String dia, double hora) {
		this.nombreEmpleado = nombreEmpleado;
		this.dia = dia;
		this.hora = hora;
	}
	
	@Override
	public void run() {
		String mensaje = "";
		if (hora > HORA_INGRESO) {
			mensaje = " tarde ";
		}else {
			mensaje = " temprano ";
		}
		System.out.println(nombreEmpleado + " llegó" + mensaje + "el día " + dia);
	}
}
