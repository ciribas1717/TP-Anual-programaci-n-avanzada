package edu.usal.dto;

import java.time.LocalDateTime;

public class VueloDTO {
	
	private int id;
	private String numeroVuelo;
	private int cantAsientos;
	private LocalDateTime fecSalida;
	private LocalDateTime fecLlegada;
	private int tiempoVuelo;
	private AeropuertoDTO aeropuertoSalida;
	private AeropuertoDTO aeropuertoLlegada;
	private LineaAereaDTO aerolinea;
	
	public VueloDTO (int id) {
		this.id = id;
	}
	
	public VueloDTO(String numeroVuelo) {
		this.numeroVuelo = numeroVuelo;
	}

	public VueloDTO(int id, String numeroVuelo, int cantAsientos, LocalDateTime fecSalida, LocalDateTime fecLlegada,
			int tiempoVuelo, AeropuertoDTO aeropuertoSalida, AeropuertoDTO aeropuertoLlegada, LineaAereaDTO aerolinea) {
		this.id = id;
		this.numeroVuelo = numeroVuelo;
		this.cantAsientos = cantAsientos;
		this.fecSalida = fecSalida;
		this.fecLlegada = fecLlegada;
		this.tiempoVuelo = tiempoVuelo;
		this.aeropuertoSalida = aeropuertoSalida;
		this.aeropuertoLlegada = aeropuertoLlegada;
		this.aerolinea = aerolinea;
	}
	
	public VueloDTO(int id, String numeroVuelo, int cantAsientos, LocalDateTime fecSalida, LocalDateTime fecLlegada,
			int tiempoVuelo, AeropuertoDTO aeropuertoSalida, AeropuertoDTO aeropuertoLlegada) {
		this.id = id;
		this.numeroVuelo = numeroVuelo;
		this.cantAsientos = cantAsientos;
		this.fecSalida = fecSalida;
		this.fecLlegada = fecLlegada;
		this.tiempoVuelo = tiempoVuelo;
		this.aeropuertoSalida = aeropuertoSalida;
		this.aeropuertoLlegada = aeropuertoLlegada;
	}
	
	public VueloDTO(String numeroVuelo, int cantAsientos, LocalDateTime fecSalida, LocalDateTime fecLlegada,
			int tiempoVuelo, AeropuertoDTO aeropuertoSalida, AeropuertoDTO aeropuertoLlegada, LineaAereaDTO aerolinea) {
		this.numeroVuelo = numeroVuelo;
		this.cantAsientos = cantAsientos;
		this.fecSalida = fecSalida;
		this.fecLlegada = fecLlegada;
		this.tiempoVuelo = tiempoVuelo;
		this.aeropuertoSalida = aeropuertoSalida;
		this.aeropuertoLlegada = aeropuertoLlegada;
		this.aerolinea = aerolinea;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumeroVuelo() {
		return numeroVuelo;
	}

	public void setNumeroVuelo(String numeroVuelo) {
		this.numeroVuelo = numeroVuelo;
	}

	public int getCantAsientos() {
		return cantAsientos;
	}

	public void setCantAsientos(int cantAsientos) {
		this.cantAsientos = cantAsientos;
	}

	public LocalDateTime getFecSalida() {
		return fecSalida;
	}

	public void setFecSalida(LocalDateTime fecSalida) {
		this.fecSalida = fecSalida;
	}

	public LocalDateTime getFecLlegada() {
		return fecLlegada;
	}

	public void setFecLlegada(LocalDateTime fecLlegada) {
		this.fecLlegada = fecLlegada;
	}

	public int getTiempoVuelo() {
		return tiempoVuelo;
	}

	public void setTiempoVuelo(int tiempoVuelo) {
		this.tiempoVuelo = tiempoVuelo;
	}

	public AeropuertoDTO getAeropuertoSalida() {
		return aeropuertoSalida;
	}

	public void setAeropuertoSalida(AeropuertoDTO aeropuertoSalida) {
		this.aeropuertoSalida = aeropuertoSalida;
	}

	public AeropuertoDTO getAeropuertoLlegada() {
		return aeropuertoLlegada;
	}

	public void setAeropuertoLlegada(AeropuertoDTO aeropuertoLlegada) {
		this.aeropuertoLlegada = aeropuertoLlegada;
	}

	public LineaAereaDTO getAerolinea() {
		return aerolinea;
	}

	public void setAerolinea(LineaAereaDTO aerolinea) {
		this.aerolinea = aerolinea;
	}
}
