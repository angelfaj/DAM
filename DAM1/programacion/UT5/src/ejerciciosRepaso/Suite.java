package ejerciciosRepaso;

import java.util.Date;

public class Suite extends Reserva{
	private int meters;
	
	public Suite(int number, String guestName, Date check_inDate, Date check_outDate, boolean reservation, int meters) {
		super(number, guestName, check_inDate, check_outDate, reservation);
		this.meters = meters;
	}

	@Override
	public String toString() {
		return "Suite " + super.toString() + ", meters=" + meters + "]";
	}

	@Override
	public String getInvoice() {
		String factura = "";
		int total = 500*meters;
		factura += "******INVOICE******" + "\n" + "Base rate: 500" + "\n" + "Meters: " + meters + "\n" + "TOTAL: " + total;  
		return factura;
	}
	
	
}
