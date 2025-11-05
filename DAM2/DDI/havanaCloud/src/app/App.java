package app;

import controller.EventoController;
import model.EventoModel;
import view.MenuView;

public class App {

	
	public static void main(String[] args) {
		MenuView app = new MenuView();
		EventoModel evento = new EventoModel();
		
		EventoController controller = new EventoController(app, evento);
	}
}
