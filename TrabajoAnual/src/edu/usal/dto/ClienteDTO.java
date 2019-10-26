package edu.usal.dto;

import java.time.LocalDate;

public class ClienteDTO {
	
	private int idCliente;
	private String nombre;
	private String apellido;
	private String dNI;
	private PasaporteDTO pasaporte;
	private String cuit_cuil;
	private LocalDate fecNac;
	private String email;
	private TelefonoDTO telefono;
	private PasajeroFrecuenteDTO pasajeroFrecuente;
	private DireccionDTO direccion;
	
	public ClienteDTO (int idCliente) {
		this.idCliente = idCliente;
	}
	
	public ClienteDTO(String dNI) {
		this.dNI = dNI;
	}

	public ClienteDTO(int idCliente, String nombre, String apellido, String dNI, PasaporteDTO pasaporte,
			String cuit_cuil, LocalDate fecNac, String email, TelefonoDTO telefono,
			PasajeroFrecuenteDTO pasajeroFrecuente, DireccionDTO direccion) {
		super();
		this.idCliente = idCliente;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dNI = dNI;
		this.pasaporte = pasaporte;
		this.cuit_cuil = cuit_cuil;
		this.fecNac = fecNac;
		this.email = email;
		this.telefono = telefono;
		this.pasajeroFrecuente = pasajeroFrecuente;
		this.direccion = direccion;
	}
	
	public ClienteDTO(String nombre, String apellido, String dNI, PasaporteDTO pasaporte,
			String cuit_cuil, LocalDate fecNac, String email, TelefonoDTO telefono,
			PasajeroFrecuenteDTO pasajeroFrecuente, DireccionDTO direccion) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dNI = dNI;
		this.pasaporte = pasaporte;
		this.cuit_cuil = cuit_cuil;
		this.fecNac = fecNac;
		this.email = email;
		this.telefono = telefono;
		this.pasajeroFrecuente = pasajeroFrecuente;
		this.direccion = direccion;
	}
	
	public ClienteDTO(int idCliente, String nombre, String apellido, String dNI, String cuit_cuil, LocalDate fecNac, String email) {
		super();
		this.idCliente = idCliente;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dNI = dNI;
		this.cuit_cuil = cuit_cuil;
		this.fecNac = fecNac;
		this.email = email;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getdNI() {
		return dNI;
	}

	public void setdNI(String dNI) {
		this.dNI = dNI;
	}

	public PasaporteDTO getPasaporte() {
		return pasaporte;
	}

	public void setPasaporte(PasaporteDTO pasaporte) {
		this.pasaporte = pasaporte;
	}

	public String getCuit_cuil() {
		return cuit_cuil;
	}

	public void setCuit_cuil(String cuit_cuil) {
		this.cuit_cuil = cuit_cuil;
	}

	public LocalDate getFecNac() {
		return fecNac;
	}

	public void setFecNac(LocalDate fecNac) {
		this.fecNac = fecNac;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public TelefonoDTO getTelefono() {
		return telefono;
	}

	public void setTelefono(TelefonoDTO telefono) {
		this.telefono = telefono;
	}

	public PasajeroFrecuenteDTO getPasajeroFrecuente() {
		return pasajeroFrecuente;
	}

	public void setPasajeroFrecuente(PasajeroFrecuenteDTO pasajeroFrecuente) {
		this.pasajeroFrecuente = pasajeroFrecuente;
	}

	public DireccionDTO getDireccion() {
		return direccion;
	}

	public void setDireccion(DireccionDTO direccion) {
		this.direccion = direccion;
	}
}
