package edu.usal.dto;

public class DireccionDTO {

	private int idDireccion;
	private String calle;
	private String altura;
	private String ciudad;
	private String codPostal;
	private PaisDTO pais;
	private ProvinciaDTO provincia;
	private ClienteDTO cliente;
	
	public DireccionDTO (int idDireccion) {
		this.idDireccion = idDireccion;
	}

	public DireccionDTO(int idDireccion, String calle, String altura, String ciudad, String codPostal, PaisDTO pais,
			ProvinciaDTO provincia, ClienteDTO cliente) {
		super();
		this.idDireccion = idDireccion;
		this.calle = calle;
		this.altura = altura;
		this.ciudad = ciudad;
		this.codPostal = codPostal;
		this.pais = pais;
		this.provincia = provincia;
		this.cliente = cliente;
	}
	
	public DireccionDTO(String calle, String altura, String ciudad, String codPostal, PaisDTO pais,
			ProvinciaDTO provincia, ClienteDTO cliente) {
		this.calle = calle;
		this.altura = altura;
		this.ciudad = ciudad;
		this.codPostal = codPostal;
		this.pais = pais;
		this.provincia = provincia;
		this.cliente = cliente;
	}
	
	public DireccionDTO(String calle, String altura, String ciudad, String codPostal, PaisDTO pais,
			ProvinciaDTO provincia) {
		this.calle = calle;
		this.altura = altura;
		this.ciudad = ciudad;
		this.codPostal = codPostal;
		this.pais = pais;
		this.provincia = provincia;
	}

	public int getIdDireccion() {
		return idDireccion;
	}

	public void setIdDireccion(int idDireccion) {
		this.idDireccion = idDireccion;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getAltura() {
		return altura;
	}

	public void setAltura(String altura) {
		this.altura = altura;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getCodPostal() {
		return codPostal;
	}

	public void setCodPostal(String codPostal) {
		this.codPostal = codPostal;
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

	public ClienteDTO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteDTO cliente) {
		this.cliente = cliente;
	}
}
