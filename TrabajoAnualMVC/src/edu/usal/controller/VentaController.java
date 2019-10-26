package edu.usal.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import edu.usal.dao.VentaDAO;
import edu.usal.dao.factory.VentaFactory;
import edu.usal.dto.VentaDTO;
import edu.usal.view.VentaView;

public class VentaController implements ItemListener, ActionListener {

	private VentaView ventaView;
	private VentaDAO ventaDAO;
	
	public VentaController (VentaView ventaView) {
		this.ventaView = ventaView;
		ventaDAO = VentaFactory.getVentaDAO("sql");
	}

	public VentaView getVentaView() {
		return ventaView;
	}

	public void setVentaView(VentaView ventaView) {
		this.ventaView = ventaView;
	}

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		if (arg0.getStateChange() == ItemEvent.SELECTED) {
			if (arg0.getItem().toString().equals("Tarjeta de crédito")) {
				getVentaView().mostrarFormaPago();
			} else {
				getVentaView().ocultarFormaPago();
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getActionCommand().equals("Baja")) {
			int a = getVentaView().eliminarVenta();
			if (a != 0) {
				ventaDAO.eliminarVenta(new VentaDTO(a));
				getVentaView().actualizarTabla();
			}
		} else if (arg0.getActionCommand().equals("Modificación")) {
			getVentaView().setIDVentaAModificar();
		} else if (arg0.getActionCommand().equals("Volver")) {
			this.getVentaView().dispose();
		} else if (arg0.getActionCommand().equals("Modificación de venta")) {
			VentaDTO ventaDTO = getVentaView().modificarVenta();
			if (ventaDTO != null) {
				ventaDAO.modificarVenta(ventaDTO);
				getVentaView().mostrarTabla();
			} else {
				ventaDTO = getVentaView().modificarVenta();
				getVentaView().setVerificar(0);
			}
		} else if (arg0.getActionCommand().equals("Alta")) {
			VentaDTO ventaDTO = getVentaView().agregarVenta();
			if (ventaDTO != null) {
				ventaDAO.agregarVenta(ventaDTO);
			} else {
				ventaDTO = getVentaView().agregarVenta();
				getVentaView().setVerificar(0);
			}
		}
	}
	
	public List <VentaDTO> obtenerVentas() {
		return ventaDAO.obtenerVentas();
	}

}
