package hojaI;

public class Universidad {
	private static Persona universidad[] = new Persona[8];
	
	public void addPersona(Persona p) {
		Profesor pro = new Profesor();
		Estudiante es = new Estudiante();
		Personal per = new Personal();
		
		if (p.getClass().equals(pro.getClass())) {
			pro =(Profesor) p;
		}else if (p.getClass().equals(es.getClass())) {
			es =(Estudiante) p;
		}else if (p.getClass().equals(per.getClass())) {
			per =(Personal) p;
		}
		
		uni
	}
	
}
