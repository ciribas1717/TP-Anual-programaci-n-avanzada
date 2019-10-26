package edu.usal.dto;

public class LineaAereaDTO {

	private int id;
	private String nombre;
	private AlianzaDTO alianza;
	
	public LineaAereaDTO (int id) {
		this.id = id;
	}

	public LineaAereaDTO(int id, String nombre, AlianzaDTO alianza) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.alianza = alianza;
	}
	
	public LineaAereaDTO(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}
	
	public LineaAereaDTO(String nombre, AlianzaDTO alianza) {
		this.nombre = nombre;
		this.alianza = alianza;
	}
	
	public LineaAereaDTO(String nombre) {
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public AlianzaDTO getAlianza() {
		return alianza;
	}

	public void setAlianza(AlianzaDTO alianza) {
		this.alianza = alianza;
	}	
}
