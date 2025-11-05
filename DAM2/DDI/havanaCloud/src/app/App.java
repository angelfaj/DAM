package app;

import controller.EventoController;
import model.EventoModel;
import view.ReservaView;

public class App {

	
	public static void main(String[] args) {
		ReservaView reservaView = new ReservaView();
		EventoModel eventoModel = new EventoModel();
		
		EventoController controller = new EventoController(reservaView, eventoModel);
	}
}
