package edu.usal.dto;

public class PaisDTO {

	private int id;
	private String nombre;
	
	public PaisDTO (int id) {
		this.id = id;
	}
	
	public PaisDTO (String nombre) {
		this.nombre = nombre;
	}

	public PaisDTO(int id, String nombre) {
		super();
		this.id = id;
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
}
