package edu.usal.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.usal.view.ClienteView;
import edu.usal.view.LineaAereaView;
import edu.usal.view.MainView;
import edu.usal.view.VentaView;
import edu.usal.view.VueloView;

public class MainController implements ActionListener {

	private MainView mainView;
	
	public MainController (MainView mainView) {
		this.mainView = mainView;
	}

	public MainView getMainView() {
		return mainView;
	}

	public void setMainView(MainView mainView) {
		this.mainView = mainView;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getActionCommand().equals("Menú clientes")) {
			this.getMainView().cambiarTexto(1);
		} else if (arg0.getActionCommand().equals("Menú líneas aéreas")) {
			this.getMainView().cambiarTexto(2);
		} else if (arg0.getActionCommand().equals("Menú vuelos")) {
			this.getMainView().cambiarTexto(3);
		} else if (arg0.getActionCommand().equals("Menú ventas")) {
			this.getMainView().cambiarTexto(4);
		} else if (arg0.getActionCommand().equals("Volver")) {
			this.getMainView().cambiarTexto(5);
		} else if (arg0.getActionCommand().equals("Alta línea aérea")) {
			LineaAereaView.main(new String[] {"0"});
		} else if (arg0.getActionCommand().equals("Baja línea aérea")) {
			LineaAereaView.main(new String[] {"1"});
		} else if (arg0.getActionCommand().equals("Modificación línea aérea")) {
			LineaAereaView.main(new String[] {"2"});
		} else if (arg0.getActionCommand().equals("Consulta líneas aéreas")) {
			LineaAereaView.main(new String[] {"3"});
		} else if (arg0.getActionCommand().equals("Alta cliente")) {
			ClienteView.main(new String[] {"0"});
		} else if (arg0.getActionCommand().equals("Baja cliente")) {
			ClienteView.main(new String[] {"1"});
		} else if (arg0.getActionCommand().equals("Modificación cliente")) {
			ClienteView.main(new String[] {"2"});
		} else if (arg0.getActionCommand().equals("Consulta clientes")) {
			ClienteView.main(new String[] {"3"});
		} else if (arg0.getActionCommand().equals("Alta vuelo")) {
			VueloView.main(new String[] {"0"});
		} else if (arg0.getActionCommand().equals("Baja vuelo")) {
			VueloView.main(new String[] {"1"});
		} else if (arg0.getActionCommand().equals("Modificación vuelo")) {
			VueloView.main(new String[] {"2"});
		} else if (arg0.getActionCommand().equals("Consulta vuelos")) {
			VueloView.main(new String[] {"3"});
		} else if (arg0.getActionCommand().equals("Alta venta")) {
			VentaView.main(new String[] {"0"});
		} else if (arg0.getActionCommand().equals("Baja venta")) {
			VentaView.main(new String[] {"1"});
		} else if (arg0.getActionCommand().equals("Modificación venta")) {
			VentaView.main(new String[] {"2"});
		} else if (arg0.getActionCommand().equals("Consulta ventas")) {
			VentaView.main(new String[] {"3"});
		}
	}

}
