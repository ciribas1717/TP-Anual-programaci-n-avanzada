package edu.usal.dto;

import java.time.LocalDate;

public class PasaporteDTO {
	
	private int id;
	private String numeroPasaporte;
	private String autoridad;
	private LocalDate fecEmision;
	private LocalDate fecVencimiento;
	private PaisDTO pais;
	private ClienteDTO cliente;
	
	public PasaporteDTO (int id) {
		this.id = id;
	}

	public PasaporteDTO(int id, String numeroPasaporte, String autoridad, LocalDate fecEmision,
			LocalDate fecVencimiento, PaisDTO pais, ClienteDTO cliente) {
		super();
		this.id = id;
		this.numeroPasaporte = numeroPasaporte;
		this.autoridad = autoridad;
		this.fecEmision = fecEmision;
		this.fecVencimiento = fecVencimiento;
		this.pais = pais;
		this.cliente = cliente;
	}
	
	public PasaporteDTO(String numeroPasaporte, String autoridad, LocalDate fecEmision,
			LocalDate fecVencimiento, PaisDTO pais) {
		this.numeroPasaporte = numeroPasaporte;
		this.autoridad = autoridad;
		this.fecEmision = fecEmision;
		this.fecVencimiento = fecVencimiento;
		this.pais = pais;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumeroPasaporte() {
		return numeroPasaporte;
	}

	public void setNumeroPasaporte(String numeroPasaporte) {
		this.numeroPasaporte = numeroPasaporte;
	}

	public String getAutoridad() {
		return autoridad;
	}

	public void setAutoridad(String autoridad) {
		this.autoridad = autoridad;
	}

	public LocalDate getFecEmision() {
		return fecEmision;
	}

	public void setFecEmision(LocalDate fecEmision) {
		this.fecEmision = fecEmision;
	}

	public LocalDate getFecVencimiento() {
		return fecVencimiento;
	}

	public void setFecVencimiento(LocalDate fecVencimiento) {
		this.fecVencimiento = fecVencimiento;
	}

	public PaisDTO getPais() {
		return pais;
	}

	public void setPais(PaisDTO pais) {
		this.pais = pais;
	}

	public ClienteDTO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteDTO cliente) {
		this.cliente = cliente;
	}
}
