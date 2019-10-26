package edu.usal.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import edu.usal.dao.VueloDAO;
import edu.usal.dao.factory.VueloFactory;
import edu.usal.dto.VueloDTO;
import edu.usal.view.VueloView;

public class VueloController implements ActionListener {
	
	private VueloView vueloView;
	private VueloDAO vueloDAO;
	
	public VueloController (VueloView vueloView) {
		this.vueloView = vueloView;
		vueloDAO = VueloFactory.getVueloDAO("sql");
	}
	
	

	public VueloView getVueloView() {
		return vueloView;
	}



	public void setVueloView(VueloView vueloView) {
		this.vueloView = vueloView;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Baja")) {
			int a = getVueloView().eliminarVuelo();
			if (a != 0) {
				vueloDAO.eliminarVuelo(new VueloDTO(a));
				getVueloView().actualizarTabla();
			}
		} else if (e.getActionCommand().equals("Modificación")) {
			getVueloView().setIDVueloAModificar();
		} else if (e.getActionCommand().equals("Volver")) {
			this.getVueloView().dispose();
		} else if (e.getActionCommand().equals("Modificación de vuelo")) {
			VueloDTO vueloDTO = getVueloView().modificarVuelo();
			if (vueloDTO != null) {
				vueloDAO.modificarVuelo(vueloDTO);
				getVueloView().mostrarTabla();
			} else {
				vueloDTO = getVueloView().modificarVuelo();
				getVueloView().setVerificar(0);
			}
		} else if (e.getActionCommand().equals("Alta")) {
			VueloDTO vueloDTO = getVueloView().agregarVuelo();
			if (vueloDTO != null) {
				vueloDAO.agregarVuelo(vueloDTO);
			} else {
				vueloDTO = getVueloView().agregarVuelo();
				getVueloView().setVerificar(0);
			}
		}
	}
	
	public List <VueloDTO> obtenerVuelos () {
		return vueloDAO.obtenerVuelos();
	}

}
