package edu.usal.dto;

public class PasajeroFrecuenteDTO {

	private int id;
	private AlianzaDTO alianza;
	private String numeroPasajeroFrecuente;
	private String categoria;
	private ClienteDTO cliente;
	private LineaAereaDTO aerolinea;
	
	public PasajeroFrecuenteDTO (int id) {
		this.id = id;
	}

	public PasajeroFrecuenteDTO(int id, AlianzaDTO alianza, String numeroPasajeroFrecuente, String categoria, ClienteDTO cliente,
			LineaAereaDTO aerolinea) {
		super();
		this.id = id;
		this.alianza = alianza;
		this.numeroPasajeroFrecuente = numeroPasajeroFrecuente;
		this.categoria = categoria;
		this.cliente = cliente;
		this.aerolinea = aerolinea;
	}
	
	public PasajeroFrecuenteDTO(int id, AlianzaDTO alianza, String numeroPasajeroFrecuente, String categoria, LineaAereaDTO aerolinea) {
		super();
		this.id = id;
		this.alianza = alianza;
		this.numeroPasajeroFrecuente = numeroPasajeroFrecuente;
		this.categoria = categoria;
		this.aerolinea = aerolinea;
	}
	
	public PasajeroFrecuenteDTO(AlianzaDTO alianza, String numeroPasajeroFrecuente, String categoria, LineaAereaDTO aerolinea) {
		this.alianza = alianza;
		this.numeroPasajeroFrecuente = numeroPasajeroFrecuente;
		this.categoria = categoria;
		this.aerolinea = aerolinea;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public AlianzaDTO getAlianza() {
		return alianza;
	}

	public void setAlianza(AlianzaDTO alianza) {
		this.alianza = alianza;
	}

	public String getNumeroPasajeroFrecuente() {
		return numeroPasajeroFrecuente;
	}

	public void setNumeroPasajeroFrecuente(String numeroPasajeroFrecuente) {
		this.numeroPasajeroFrecuente = numeroPasajeroFrecuente;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public ClienteDTO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteDTO cliente) {
		this.cliente = cliente;
	}

	public LineaAereaDTO getAerolinea() {
		return aerolinea;
	}

	public void setAerolinea(LineaAereaDTO aerolinea) {
		this.aerolinea = aerolinea;
	}	
	
}
