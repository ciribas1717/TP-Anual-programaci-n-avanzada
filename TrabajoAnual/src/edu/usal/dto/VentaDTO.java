package edu.usal.dto;

import java.time.LocalDateTime;

public class VentaDTO {

	private int id;
	private LocalDateTime fecVenta;
	private FormaDePago formaDePago;
	private ClienteDTO cliente;
	private VueloDTO vuelo;
	private LineaAereaDTO aerolinea;
	
	public VentaDTO (int id) {
		this.id = id;
	}

	public VentaDTO(int id, LocalDateTime fecVenta, FormaDePago formaDePago, ClienteDTO cliente, VueloDTO vuelo,
			LineaAereaDTO aerolinea) {
		super();
		this.id = id;
		this.fecVenta = fecVenta;
		this.formaDePago = formaDePago;
		this.cliente = cliente;
		this.vuelo = vuelo;
		this.aerolinea = aerolinea;
	}
	
	public VentaDTO(LocalDateTime fecVenta, FormaDePago formaDePago, ClienteDTO cliente, VueloDTO vuelo,
			LineaAereaDTO aerolinea) {
		this.fecVenta = fecVenta;
		this.formaDePago = formaDePago;
		this.cliente = cliente;
		this.vuelo = vuelo;
		this.aerolinea = aerolinea;
	}
	
	public VentaDTO(FormaDePago formaDePago, ClienteDTO cliente, VueloDTO vuelo,
			LineaAereaDTO aerolinea) {
		this.formaDePago = formaDePago;
		this.cliente = cliente;
		this.vuelo = vuelo;
		this.aerolinea = aerolinea;
	}
	
	public VentaDTO(int id, FormaDePago formaDePago, ClienteDTO cliente, VueloDTO vuelo,
			LineaAereaDTO aerolinea) {
		super();
		this.id = id;
		this.formaDePago = formaDePago;
		this.cliente = cliente;
		this.vuelo = vuelo;
		this.aerolinea = aerolinea;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getFecVenta() {
		return fecVenta;
	}

	public void setFecVenta(LocalDateTime fecVenta) {
		this.fecVenta = fecVenta;
	}

	public FormaDePago getFormaDePago() {
		return formaDePago;
	}

	public void setFormaDePago(FormaDePago formaDePago) {
		this.formaDePago = formaDePago;
	}

	public ClienteDTO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteDTO cliente) {
		this.cliente = cliente;
	}

	public VueloDTO getVuelo() {
		return vuelo;
	}

	public void setVuelo(VueloDTO vuelo) {
		this.vuelo = vuelo;
	}

	public LineaAereaDTO getAerolinea() {
		return aerolinea;
	}

	public void setAerolinea(LineaAereaDTO aerolinea) {
		this.aerolinea = aerolinea;
	}
}
