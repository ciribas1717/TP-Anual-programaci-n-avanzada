package edu.usal.dto;

public class TelefonoDTO {
	
	private int id;
	private String numPersonal;
	private String numCelular;
	private String numLaboral;
	private ClienteDTO cliente;
	
	public TelefonoDTO (int id) {
		this.id = id;
	}

	public TelefonoDTO(int id, String numPersonal, String numCelular, String numLaboral, ClienteDTO cliente) {
		super();
		this.id = id;
		this.numPersonal = numPersonal;
		this.numCelular = numCelular;
		this.numLaboral = numLaboral;
		this.cliente = cliente;
	}
	
	public TelefonoDTO(String numPersonal, String numCelular, String numLaboral) {
		this.numPersonal = numPersonal;
		this.numCelular = numCelular;
		this.numLaboral = numLaboral;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumPersonal() {
		return numPersonal;
	}

	public void setNumPersonal(String numPersonal) {
		this.numPersonal = numPersonal;
	}

	public String getNumCelular() {
		return numCelular;
	}

	public void setNumCelular(String numCelular) {
		this.numCelular = numCelular;
	}

	public String getNumLaboral() {
		return numLaboral;
	}

	public void setNumLaboral(String numLaboral) {
		this.numLaboral = numLaboral;
	}

	public ClienteDTO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteDTO cliente) {
		this.cliente = cliente;
	}
}
