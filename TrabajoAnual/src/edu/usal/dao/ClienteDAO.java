package edu.usal.dao;

import java.util.List;

import edu.usal.dto.ClienteDTO;

public interface ClienteDAO {

	public void agregarCliente (ClienteDTO a);
	public boolean eliminarCliente (ClienteDTO a);
	public ClienteDTO obtenerCliente (ClienteDTO a);
	public void modificarCliente (ClienteDTO a);
	public List <ClienteDTO> obtenerClientes ();
	
}