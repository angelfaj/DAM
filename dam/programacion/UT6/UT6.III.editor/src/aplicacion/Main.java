package aplicacion;

import controlador.ControladorEditor;
import modelo.ModeloEditor;
import vista.VistaEditor;

public class Main {

	public static void main(String[] args) {
		ModeloEditor modelo = new ModeloEditor();
		VistaEditor vista = new VistaEditor();
		ControladorEditor controlador = new ControladorEditor(vista, modelo);
	}

}
