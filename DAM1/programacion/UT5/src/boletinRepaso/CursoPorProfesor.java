package boletinRepaso;

import java.util.Comparator;

public class CursoPorProfesor implements Comparator<Curso>{

	@Override
	public int compare(Curso o1, Curso o2) {
		return o1.getProfesor().compareTo(o2.getProfesor());
	}
	
	
}
