package edu.usal.dao;

import java.util.List;

import edu.usal.dto.LineaAereaDTO;

public interface LineaAereaDAO {

	public void agregarLineaAerea (LineaAereaDTO a);
	public boolean eliminarLineaAerea (LineaAereaDTO a);
	public LineaAereaDTO obtenerLineaAerea (LineaAereaDTO a);
	public void modificarLineaAerea (LineaAereaDTO a);
	public List <LineaAereaDTO> obtenerLineasAereas ();
	
}
