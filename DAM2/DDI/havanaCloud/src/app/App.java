package app;

import controller.EventoController;
import model.EventoModel;
import view.MenuView;
import view.ReservaView;

public class App {

	
	public static void main(String[] args) {
		MenuView menuView = new MenuView();
		ReservaView reservaView = new ReservaView();
		EventoModel eventoModel = new EventoModel();
		
		EventoController controller = new EventoController(menuView, reservaView, eventoModel);
	}
}
