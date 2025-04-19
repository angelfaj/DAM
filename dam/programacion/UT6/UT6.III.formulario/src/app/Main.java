package app;

import controlador.ControladorFormulario;
import modelo.ModeloFormulario;
import vista.VistaFormulario;

public class Main {

	public static void main(String[] args) {
		ModeloFormulario modelo = new ModeloFormulario();
		VistaFormulario vista = new VistaFormulario();
		ControladorFormulario controlador = new ControladorFormulario(vista, modelo);
	}

}
