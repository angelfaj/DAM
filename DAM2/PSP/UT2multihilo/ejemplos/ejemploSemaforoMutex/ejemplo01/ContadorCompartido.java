package ejemplo01;

public class ContadorCompartido {

	private int n = 0;

	public int getN() {
		return n;

	}

	public void setN(String id, int n) {

		this.n = n;

		System.out.println(id + ": " + n);

	}

}