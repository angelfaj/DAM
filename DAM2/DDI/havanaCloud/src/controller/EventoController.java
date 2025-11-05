package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import model.EventoModel;
import view.MenuView;
import view.ReservaView;

public class EventoController {
	private MenuView menuView;
	private ReservaView reservaView;
	private EventoModel eventoModel;

	public EventoController(MenuView menuView, ReservaView reservaView, EventoModel eventoModel) {
		this.menuView = menuView;
		this.reservaView = reservaView;
		this.eventoModel = eventoModel;
		
		addListeners();
	}

	public void addListeners() {
		menuView.getBtnRealizarUnaReserva().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new ReservaView();
				menuView.setVisible(false);
			}
		});
		
		//Únicamente permitimos introducir numeros
		reservaView.getTextFieldNumero().addKeyListener(new KeyAdapter() {
		    public void keyTyped(KeyEvent e) {
		        char c = e.getKeyChar();

		        // Solo permite dígitos
		        if (!Character.isDigit(c)) {
		            e.consume();
		        }
		    }
		});
		
		//Únicamente permitimos introducir numeros
		reservaView.getTextFieldNumeroPersonas().addKeyListener(new KeyAdapter() {
		    public void keyTyped(KeyEvent e) {
		        char c = e.getKeyChar();

		        // Solo permite dígitos
		        if (!Character.isDigit(c)) {
		            e.consume();
		        }
		    }
		});
		
		reservaView.getRdbtnBanquete().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reservaView.desactivar();
			}
		});
		
		reservaView.getRdbtnJornada().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reservaView.desactivar();
			}
		});
		
		reservaView.getRdbtnCongreso().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reservaView.activar();
			}
		});
		
		reservaView.getBtnAceptar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				reservaView.comprobarCampos();
			}
		});
		
		reservaView.getBtnCancelar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reservaView.limpiarCampos();
			}
		});
		
		reservaView.getBtnVisualizar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					reservaView.mostrarTabla(eventoModel.getEventoMatriz());
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
		});
		
	}
	
}
