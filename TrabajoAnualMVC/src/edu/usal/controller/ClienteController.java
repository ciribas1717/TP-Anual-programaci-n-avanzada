package edu.usal.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import edu.usal.dao.ClienteDAO;
import edu.usal.dao.factory.ClienteFactory;
import edu.usal.dto.ClienteDTO;
import edu.usal.view.ClienteView;

public class ClienteController implements ActionListener, ItemListener {
	
	private ClienteView clienteView;
	private ClienteDAO clienteDAO;
	
	public ClienteController (ClienteView clienteView) {
		this.clienteView = clienteView;
		clienteDAO = ClienteFactory.getClienteDAO("sql");
	}
	

	public ClienteView getClienteView() {
		return clienteView;
	}


	public void setClienteView(ClienteView clienteView) {
		this.clienteView = clienteView;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Baja")) {
			int a = getClienteView().eliminarCliente();
			if (a != 0) {
				clienteDAO.eliminarCliente(new ClienteDTO(a));
				getClienteView().actualizarTabla();
			}
		} else if (e.getActionCommand().equals("Modificación")) {
			getClienteView().setIDClienteAModificar();
		} else if (e.getActionCommand().equals("Volver")) {
			this.getClienteView().dispose();
		} else if (e.getActionCommand().equals("Modificación de cliente")) {
			ClienteDTO clienteDTO = getClienteView().modificarCliente();
			if (clienteDTO != null) {
				clienteDAO.modificarCliente(clienteDTO);
				getClienteView().mostrarTabla();
			} else {
				clienteDTO = getClienteView().modificarCliente();
			}
		} else if (e.getActionCommand().equals("Alta")) {
			ClienteDTO clienteDTO = getClienteView().agregarCliente();
			if (clienteDTO != null) {
				clienteDAO.agregarCliente(clienteDTO);
			} else {
				clienteDTO = getClienteView().agregarCliente();
			}
		}
	}

	public List <ClienteDTO> obtenerClientes() {
		return clienteDAO.obtenerClientes();
	}


	@Override
	public void itemStateChanged(ItemEvent arg0) {
		if (arg0.getStateChange() == ItemEvent.SELECTED) {
			if (arg0.getItem().toString().equals("Argentina")) {
				getClienteView().mostrarComboProvincias();
			} else {
				getClienteView().ocultarComboProvincias();
			}
		}
	}
	
}
