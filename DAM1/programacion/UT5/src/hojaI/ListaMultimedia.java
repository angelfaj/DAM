package hojaI;

import java.util.ArrayList;

public class ListaMultimedia {
	protected ArrayList<Multimedia> listaMultimedia;
	protected int objetosAlmacenados;
	protected int topeLista;
	
	public ListaMultimedia(int i) {
		listaMultimedia = new ArrayList<Multimedia>();
		topeLista = i;
	}
	
	
	public boolean add(Multimedia m) {
		if (objetosAlmacenados == topeLista) {
			return false;			
		} else {
			listaMultimedia.add(m);
			objetosAlmacenados++;
			return true;
		}
	}
	
	public Multimedia get(int posicion) {
		Multimedia aux = null;
		if (listaMultimedia.size() < topeLista) {
			aux = listaMultimedia.get(posicion);
		}
		return aux;	
	}
	
	public int size() {
		return objetosAlmacenados;
	}


	@Override
	public String toString() {
		return "ListaMultimedia [listaMultimedia=" + listaMultimedia + "]";
	}


	
	
	
	
	
	
}
