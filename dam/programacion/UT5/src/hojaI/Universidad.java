package hojaI;

public class Universidad {
	private static Persona universidad[] = new Persona[8];
	
	public static void fillUniversidad(Persona p) {
		Profesor pro = new Profesor();
		Estudiante es = new Estudiante();
		Personal per = new Personal();
		
		if (p.getClass().equals(pro.getClass())) {
			pro =(Profesor) p;
			if (universidad[0] == null) {
				universidad[0] = pro;
			}else if (universidad[1] == null) {
				universidad[1] = pro;
			}else if (universidad[6] == null) {
				universidad[6] = pro;
			}else {
				System.out.println("Ya hay 3 profesores en la universidad");
			}
		}else if (p.getClass().equals(es.getClass())) {
			es =(Estudiante) p;
			if (universidad[2] == null) {
				universidad[2] = es;
			}else if (universidad[3] == null) {
				universidad[3] = es;
			}else if (universidad[7] == null) {
				universidad[7] = es;
			}else {
				System.out.println("Ya hay 3 estudiantes en la universidad");
			}
		}else if (p.getClass().equals(per.getClass())) {
			per =(Personal) p;
			if (universidad[4] == null) {
				universidad[4] = per;
			}else if (universidad[5] == null) {
				universidad[5] = per;
			}else {
				System.out.println("Ya hay 3 de personal en la universidad");
			}
		}	
	}
	
	
	public static boolean cambiarCurso(String dni, String nuevoCurso) {
		Estudiante es = new Estudiante();
		boolean encontrado = false;
		int i = -1;
		do {
			i++;
			if (universidad[i] != null) {
				if (universidad[i].getClass().equals(es.getClass())) {	//Tambien se puede hacer con if (universidad[i] instanceof Estudiante) 
					es =(Estudiante) universidad[i];
					if (es.getDni().equals(dni)) {
						es.setCurso(nuevoCurso);
						encontrado = true;
					}
				}				
			}
		}while (!encontrado && (i < universidad.length));
		return encontrado;
	}
	
	public static boolean cambiarDepartamento(String dni, Departamento departamento) {
		Profesor pro = new Profesor();
		boolean encontrado = false;
		int i = -1;
		do {
			i++;
			if (universidad[i] != null) {
				if (universidad[i].getClass().equals(pro.getClass())) {
					pro = (Profesor) universidad[i];
					if (pro.getDni().equals(dni)) {
						pro.setDepartamento(departamento);
						encontrado = true;
					}				
				}			
			}
		}while (!encontrado && (i < universidad.length));
		return encontrado;
	}
	
	public static boolean cambiarSeccion(String dni, Seccion seccion) {
		Personal per = new Personal();
		boolean encontrado = false;
		int i = -1;
		do {
			i++;
			if (universidad[i] != null) {
				if (universidad[i].getClass().equals(per.getClass())) {
					per =(Personal) universidad[i];
					if (per.getDni().equals(dni)) {
						per.setSeccion(seccion);
						encontrado = true;
					}				
				}
			}
		}while (!encontrado && (i < universidad.length));
		return encontrado;
	}
	


	public static void listarProfesoresDepartamento(Departamento departamento) {
		Profesor aux = new Profesor();
		for (Persona p:universidad) {
			if (p.getClass().equals(aux.getClass())) {
				aux = (Profesor) p;
				if (aux.getDepartamento().equals(departamento)) {
					System.out.println(p);					
				}
			}
		}
	}
	
	public static void listarEmpleado() {
		Empleado aux = new Empleado();
		for (Persona p:universidad) {
//			if (p.getClass().equals(aux.getClass())) {
//				System.out.println((Empleado)p);
			if (p instanceof Empleado) {
				System.out.println(p);
			}
		}
	}
	
	public static void showUni() {
		for (Persona p:universidad) {
			System.out.println(p);
		}
	}
	
	
	
	
	
}
