package edu.usal.dto;

public class AeropuertoDTO {

	private int idAeropuerto;
	private String codigo;
	private PaisDTO pais;
	private ProvinciaDTO provincia;
	private String ciudad;
	
	public AeropuertoDTO (int idAeropuerto) {
		this.idAeropuerto = idAeropuerto;
	}
	
	public AeropuertoDTO(String codigo) {
		this.codigo = codigo;
	}
	
	public AeropuertoDTO(int idAeropuerto, String codigo, PaisDTO pais, ProvinciaDTO provincia, String ciudad) {
		super();
		this.idAeropuerto = idAeropuerto;
		this.codigo = codigo;
		this.pais = pais;
		this.provincia = provincia;
		this.ciudad = ciudad;
	}

	public int getIdAeropuerto() {
		return idAeropuerto;
	}

	public void setIdAeropuerto(int idAeropuerto) {
		this.idAeropuerto = idAeropuerto;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public PaisDTO getPais() {
		return pais;
	}

	public void setPais(PaisDTO pais) {
		this.pais = pais;
	}

	public ProvinciaDTO getProvincia() {
		return provincia;
	}

	public void setProvincia(ProvinciaDTO provincia) {
		this.provincia = provincia;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
}
