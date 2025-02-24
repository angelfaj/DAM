package ejerciciosRepaso;

import java.util.Date;

public class Estandar extends Reserva{
	private int beds;
	
	public Estandar(int number, String guestName, Date check_inDate, Date check_outDate, boolean reservation, int beds) {
		super(number, guestName, check_inDate, check_outDate, reservation);
		this.beds = beds;
	}

	public int getBeds() {
		return beds;
	}

	public void setBeds(int beds) {
		this.beds = beds;
	}

	@Override
	public String toString() {
		return "Habitación estandar " + super.toString() + ", beds=" + beds + "]";
	}

	@Override
	public String getInvoice() {
		String factura = "";
		int total = 500*beds;
		factura += "******INVOICE******" + "\n" + "Base rate: 500" + "\n" + "Beds: " + beds + "\n" + "TOTAL: " + total;  
		return factura;
	}

	
	
	
}
