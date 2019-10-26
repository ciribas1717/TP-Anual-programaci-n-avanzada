package edu.usal.dao;

import java.util.List;

import edu.usal.dto.VentaDTO;

public interface VentaDAO {

	public void agregarVenta (VentaDTO a);
	public boolean eliminarVenta (VentaDTO a);
	public VentaDTO obtenerVenta (VentaDTO a);
	public void modificarVenta (VentaDTO a);
	public List <VentaDTO> obtenerVentas ();
	
}
