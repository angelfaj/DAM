package boletin1;

public class Barco extends Acuatico{
	private boolean motor;
	
	public Barco(String matricula, String modelo, int eslora, boolean motor) {
		super(matricula, modelo, eslora);
		this.motor = motor;
	}

	public boolean isMotor() {
		return motor;
	}

	public void setMotor(boolean motor) {
		this.motor = motor;
	}

	@Override
	public String toString() {
		return "Barco " + super.toString() + ", motor=" + motor + "]";
	}
	
	
}
