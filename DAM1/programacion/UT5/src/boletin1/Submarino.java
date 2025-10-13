package boletin1;

public class Submarino extends Acuatico{
	//Atributo
	private int profundidadMaxima;
	
	public Submarino(String matricula, String modelo, int eslora, int profundidadMaxima) {
		super(matricula, modelo, eslora);
		this.profundidadMaxima = profundidadMaxima;
	}

	public int getProfundidadMaxima() {
		return profundidadMaxima;
	}

	public void setProfundidadMaxima(int profundidadMaxima) {
		this.profundidadMaxima = profundidadMaxima;
	}

	@Override
	public String toString() {
		return "Submarino " + super.toString() + ", profundidadMaxima=" + profundidadMaxima + "]";
	}
	
	
	
}
