package edu.usal.dao;

import java.util.List;

import edu.usal.dto.VueloDTO;

public interface VueloDAO {

	public void agregarVuelo (VueloDTO a);
	public boolean eliminarVuelo (VueloDTO a);
	public VueloDTO obtenerVuelo (VueloDTO a);
	public void modificarVuelo (VueloDTO a);
	public List <VueloDTO> obtenerVuelos ();
	
}
