package edu.usal.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import edu.usal.dao.ClienteDAO;
import edu.usal.dto.AlianzaDTO;
import edu.usal.dto.ClienteDTO;
import edu.usal.dto.DireccionDTO;
import edu.usal.dto.LineaAereaDTO;
import edu.usal.dto.PaisDTO;
import edu.usal.dto.PasajeroFrecuenteDTO;
import edu.usal.dto.PasaporteDTO;
import edu.usal.dto.ProvinciaDTO;
import edu.usal.dto.TelefonoDTO;
import edu.usal.util.ConexionBD;

public class ClienteDAOImpl implements ClienteDAO {

	@Override
	public void agregarCliente(ClienteDTO a) {
		Connection con = ConexionBD.getConexion();
		try {
			con.setAutoCommit(false);
			String query = "{call CLIENTEABM (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
			CallableStatement cs = con.prepareCall(query);
			cs.setString(1, "ALTA");
			cs.setString(2, a.getNombre());
			cs.setString(3, a.getApellido());
			cs.setString(4, a.getdNI());
			cs.setString(5, a.getPasaporte().getNumeroPasaporte());
			cs.setString(6, a.getPasaporte().getAutoridad());
			cs.setObject(7, a.getPasaporte().getFecEmision());
			cs.setObject(8, a.getPasaporte().getFecVencimiento());
			cs.setString(9, a.getPasaporte().getPais().getNombre());
			cs.setString(10, a.getCuit_cuil());
			cs.setObject(11, a.getFecNac());
			cs.setString(12, a.getEmail());
			cs.setString(13, a.getTelefono().getNumPersonal());
			cs.setString(14, a.getTelefono().getNumCelular());
			cs.setString(15, a.getTelefono().getNumLaboral());
			cs.setString(16, a.getPasajeroFrecuente().getAlianza().getNombre());
			cs.setString(17, a.getPasajeroFrecuente().getNumeroPasajeroFrecuente());
			cs.setString(18, a.getPasajeroFrecuente().getCategoria());
			cs.setString(19, a.getPasajeroFrecuente().getAerolinea().getNombre());
			cs.setString(20, a.getDireccion().getCalle());
			cs.setString(21, a.getDireccion().getAltura());
			cs.setString(22, a.getDireccion().getCiudad());
			cs.setString(23, a.getDireccion().getCodPostal());
			cs.setString(24, a.getDireccion().getPais().getNombre());
			cs.setString(25, a.getDireccion().getProvincia().getNombre());
			cs.setInt(26, 0);
			cs.execute();
			cs.close();
			con.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
	}

	@Override
	public boolean eliminarCliente(ClienteDTO a) {
		Connection con = ConexionBD.getConexion();
		try {
			con.setAutoCommit(false);
			String query = "{call CLIENTEABM (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
			CallableStatement cs = con.prepareCall(query);
			cs.setString(1, "BAJA");
			cs.setString(2, "");
			cs.setString(3, "");
			cs.setString(4, "");
			cs.setString(5, "");
			cs.setString(6, "");
			cs.setObject(7, null);
			cs.setObject(8, null);
			cs.setString(9, "");
			cs.setString(10, "");
			cs.setObject(11, null);
			cs.setString(12, "");
			cs.setString(13, "");
			cs.setString(14, "");
			cs.setString(15, "");
			cs.setString(16, "");
			cs.setString(17, "");
			cs.setString(18, "");
			cs.setString(19, "");
			cs.setString(20, "");
			cs.setString(21, "");
			cs.setString(22, "");
			cs.setString(23, "");
			cs.setString(24, "");
			cs.setString(25, "");
			cs.setInt(26, a.getIdCliente());
			cs.execute();
			cs.close();
			con.commit();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public ClienteDTO obtenerCliente(ClienteDTO a) {
		Connection con = ConexionBD.getConexion();
		try {
			con.setAutoCommit(false);
			String query = "{call CLIENTEABM (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
			CallableStatement cs = con.prepareCall(query);
			cs.setString(1, "CONSULTA");
			cs.setString(2, a.getNombre());
			cs.setString(3, a.getApellido());
			cs.setString(4, a.getdNI());
			cs.setString(5, a.getPasaporte().getNumeroPasaporte());
			cs.setString(6, a.getPasaporte().getAutoridad());
			cs.setObject(7, a.getPasaporte().getFecEmision());
			cs.setObject(8, a.getPasaporte().getFecVencimiento());
			cs.setString(9, a.getPasaporte().getPais().getNombre());
			cs.setString(10, a.getCuit_cuil());
			cs.setObject(11, a.getFecNac());
			cs.setString(12, a.getEmail());
			cs.setString(13, a.getTelefono().getNumPersonal());
			cs.setString(14, a.getTelefono().getNumCelular());
			cs.setString(15, a.getTelefono().getNumLaboral());
			cs.setString(16, a.getPasajeroFrecuente().getAlianza().getNombre());
			cs.setString(17, a.getPasajeroFrecuente().getNumeroPasajeroFrecuente());
			cs.setString(18, a.getPasajeroFrecuente().getCategoria());
			cs.setString(19, a.getPasajeroFrecuente().getAerolinea().getNombre());
			cs.setString(20, a.getDireccion().getCalle());
			cs.setString(21, a.getDireccion().getAltura());
			cs.setString(22, a.getDireccion().getCiudad());
			cs.setString(23, a.getDireccion().getCodPostal());
			cs.setString(24, a.getDireccion().getPais().getNombre());
			cs.setString(25, a.getDireccion().getProvincia().getNombre());
			cs.setInt(26, a.getIdCliente());
			ResultSet rs = cs.executeQuery();
			ClienteDTO clienteDTO = new ClienteDTO (rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), new PasaporteDTO (rs.getInt(5), rs.getString(6), rs.getString(8), rs.getObject(9, LocalDate.class),
			rs.getObject(10, LocalDate.class), new PaisDTO (rs.getString(7)), new ClienteDTO(rs.getInt(1))), rs.getString(11), rs.getObject(12, LocalDate.class), rs.getString(13), new TelefonoDTO(rs.getInt(14), 
			rs.getString(15), rs.getString(16), rs.getString(17), new ClienteDTO(rs.getInt(1))), new PasajeroFrecuenteDTO(rs.getInt(18), new AlianzaDTO (rs.getString(19)), rs.getString(22), rs.getString(23), new ClienteDTO (rs.getInt(1)), 
			new LineaAereaDTO (rs.getInt(20), rs.getString(21))), new DireccionDTO (rs.getInt(24), rs.getString(25), rs.getString(26), rs.getString(27), rs.getString(30), new PaisDTO (rs.getString(28)), new ProvinciaDTO (rs.getString(29)), new ClienteDTO (rs.getInt(1))));
			cs.close();
			con.commit();
			return clienteDTO;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public void modificarCliente(ClienteDTO a) {
		Connection con = ConexionBD.getConexion();
		try {
			con.setAutoCommit(false);
			String query = "{call CLIENTEABM (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
			CallableStatement cs = con.prepareCall(query);
			cs.setString(1, "MODIFICACIÓN");
			cs.setString(2, a.getNombre());
			cs.setString(3, a.getApellido());
			cs.setString(4, a.getdNI());
			cs.setString(5, a.getPasaporte().getNumeroPasaporte());
			cs.setString(6, a.getPasaporte().getAutoridad());
			cs.setObject(7, a.getPasaporte().getFecEmision());
			cs.setObject(8, a.getPasaporte().getFecVencimiento());
			cs.setString(9, a.getPasaporte().getPais().getNombre());
			cs.setString(10, a.getCuit_cuil());
			cs.setObject(11, a.getFecNac());
			cs.setString(12, a.getEmail());
			cs.setString(13, a.getTelefono().getNumPersonal());
			cs.setString(14, a.getTelefono().getNumCelular());
			cs.setString(15, a.getTelefono().getNumLaboral());
			cs.setString(16, a.getPasajeroFrecuente().getAlianza().getNombre());
			cs.setString(17, a.getPasajeroFrecuente().getNumeroPasajeroFrecuente());
			cs.setString(18, a.getPasajeroFrecuente().getCategoria());
			cs.setString(19, a.getPasajeroFrecuente().getAerolinea().getNombre());
			cs.setString(20, a.getDireccion().getCalle());
			cs.setString(21, a.getDireccion().getAltura());
			cs.setString(22, a.getDireccion().getCiudad());
			cs.setString(23, a.getDireccion().getCodPostal());
			cs.setString(24, a.getDireccion().getPais().getNombre());
			cs.setString(25, a.getDireccion().getProvincia().getNombre());
			cs.setInt(26, a.getIdCliente());
			cs.execute();
			cs.close();
			con.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<ClienteDTO> obtenerClientes() {
		List <ClienteDTO> lista = new ArrayList <ClienteDTO>();
		Connection con = ConexionBD.getConexion();
		try {
			con.setAutoCommit(false);
			String query = "{call CLIENTEABM (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
			CallableStatement cs = con.prepareCall(query);
			cs.setString(1, "CONSULTATOTAL");
			cs.setString(2, "");
			cs.setString(3, "");
			cs.setString(4, "");
			cs.setString(5, "");
			cs.setString(6, "");
			cs.setObject(7, null);
			cs.setObject(8, null);
			cs.setString(9, "");
			cs.setString(10, "");
			cs.setObject(11, null);
			cs.setString(12, "");
			cs.setString(13, "");
			cs.setString(14, "");
			cs.setString(15, "");
			cs.setString(16, "");
			cs.setString(17, "");
			cs.setString(18, "");
			cs.setString(19, "");
			cs.setString(20, "");
			cs.setString(21, "");
			cs.setString(22, "");
			cs.setString(23, "");
			cs.setString(24, "");
			cs.setString(25, "");
			cs.setInt(26, 0);
			ResultSet rs = cs.executeQuery();
			while (rs.next()) {
				lista.add(new ClienteDTO (rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), new PasaporteDTO (rs.getInt(5), rs.getString(6), rs.getString(8), rs.getObject(9, LocalDate.class),
			rs.getObject(10, LocalDate.class), new PaisDTO (rs.getString(7)), new ClienteDTO(rs.getInt(1))), rs.getString(11), rs.getObject(12, LocalDate.class), rs.getString(13), new TelefonoDTO(rs.getInt(14), 
			rs.getString(15), rs.getString(16), rs.getString(17), new ClienteDTO(rs.getInt(1))), new PasajeroFrecuenteDTO(rs.getInt(18), new AlianzaDTO (rs.getString(19)), rs.getString(22), rs.getString(23), new ClienteDTO (rs.getInt(1)), 
			new LineaAereaDTO (rs.getInt(20), rs.getString(21))), new DireccionDTO (rs.getInt(24), rs.getString(25), rs.getString(26), rs.getString(27), rs.getString(30), new PaisDTO (rs.getString(28)), new ProvinciaDTO (rs.getString(29)), new ClienteDTO (rs.getInt(1)))));
			}
			cs.close();
			con.commit();
			return lista;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

}
