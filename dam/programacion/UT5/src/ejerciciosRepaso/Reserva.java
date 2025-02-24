package ejerciciosRepaso;

import java.util.Date;

public abstract class Reserva implements Reservable, Facturable{
	private int number;
	private String guestName;
	private Date check_inDate, check_outDate;
	private boolean reservation;
	
	public Reserva(int number, String guestName, Date check_inDate, Date check_outDate, boolean reservation) {
		this.number = number;
		this.guestName = guestName;
		this.check_inDate = check_inDate;
		this.check_outDate = check_outDate;
		this.reservation = reservation;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getGuestName() {
		return guestName;
	}

	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}

	public Date getCheck_inDate() {
		return check_inDate;
	}

	public void setCheck_inDate(Date check_inDate) {
		this.check_inDate = check_inDate;
	}

	public Date getCheck_outDate() {
		return check_outDate;
	}

	public void setCheck_outDate(Date check_outDate) {
		this.check_outDate = check_outDate;
	}

	public boolean isReservation() {
		return reservation;
	}

	public void setReservation(boolean reservation) {
		this.reservation = reservation;
	}
	
	@Override
	public void doBooking() {
		 setReservation(true);
		
	}

	@Override
	public void cancelBooking() {
		setReservation(false);
	}

	@Override
	public String toString() {
		return "[number=" + number + ", guestName=" + guestName + ", check_inDate=" + check_inDate
				+ ", check_outDate=" + check_outDate + ", reservation=" + reservation;
	}
	
	
}
