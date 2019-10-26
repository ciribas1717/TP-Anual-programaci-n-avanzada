package edu.usal.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import edu.usal.dao.LineaAereaDAO;
import edu.usal.dao.factory.LineaAereaFactory;
import edu.usal.dto.LineaAereaDTO;
import edu.usal.view.LineaAereaView;

public class LineaAereaController implements ActionListener {

	private LineaAereaView lineaAereaView;
	private static LineaAereaDAO lineaAereaDAO;
	
	public LineaAereaController(LineaAereaView lineaAereaView) {
		this.lineaAereaView = lineaAereaView;
		lineaAereaDAO = LineaAereaFactory.getLineaAereaDAO("sql");
	}

	public LineaAereaView getLineaAereaView() {
		return lineaAereaView;
	}

	public void setLineaAereaView(LineaAereaView lineaAereaView) {
		this.lineaAereaView = lineaAereaView;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getActionCommand().equals("Baja")) {
			int a = getLineaAereaView().eliminarAerolinea();
			if (a != 0) {
				lineaAereaDAO.eliminarLineaAerea(new LineaAereaDTO(a));
				getLineaAereaView().actualizarTabla();
			}
		} else if (arg0.getActionCommand().equals("Modificación")) {
			getLineaAereaView().setIDAerolineaAModificar();
		} else if (arg0.getActionCommand().equals("Volver")) {
			this.getLineaAereaView().dispose();
		} else if (arg0.getActionCommand().equals("Modificación de línea aérea")) {
			lineaAereaDAO.modificarLineaAerea(getLineaAereaView().modificarAerolinea());
			getLineaAereaView().menuTabla();
		} else if (arg0.getActionCommand().equals("Alta")) {
			lineaAereaDAO.agregarLineaAerea(getLineaAereaView().agregarAerolinea());
		}
	}
	
	public static List <LineaAereaDTO> obtenerLineasAereas () {
		if (lineaAereaDAO == null) {
			lineaAereaDAO = LineaAereaFactory.getLineaAereaDAO("sql");
		}
		return lineaAereaDAO.obtenerLineasAereas();
	}
	
}
