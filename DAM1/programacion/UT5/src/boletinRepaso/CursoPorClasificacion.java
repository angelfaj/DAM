package boletinRepaso;

import java.util.Comparator;

public class CursoPorClasificacion implements Comparator<Curso>{

	@Override
	public int compare(Curso o1, Curso o2) {
		return o1.getClasificacion().compareTo(o2.getClasificacion());
	}
	
}
