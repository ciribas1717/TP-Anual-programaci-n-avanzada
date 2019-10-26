package edu.usal.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import edu.usal.dao.VentaDAO;
import edu.usal.dto.AeropuertoDTO;
import edu.usal.dto.AlianzaDTO;
import edu.usal.dto.ClienteDTO;
import edu.usal.dto.FormaDePago;
import edu.usal.dto.LineaAereaDTO;
import edu.usal.dto.PaisDTO;
import edu.usal.dto.ProvinciaDTO;
import edu.usal.dto.VentaDTO;
import edu.usal.dto.VueloDTO;
import edu.usal.util.ConexionBD;

public class VentaDAOImpl implements VentaDAO {

	@Override
	public void agregarVenta(VentaDTO a) {
		Connection con = ConexionBD.getConexion();
		try {
			String query = "{call VENTAABM (?, ?, ?, ?, ?, ?, ?)}";
			con.setAutoCommit(false);
			CallableStatement cs = con.prepareCall(query);
			cs.setString(1, "ALTA");
			cs.setObject(2, a.getFecVenta());
			cs.setString(3, a.getFormaDePago().toString());
			cs.setString(4, a.getCliente().getdNI());
			cs.setString(5, a.getVuelo().getNumeroVuelo());
			cs.setString(6, a.getAerolinea().getNombre());
			cs.setInt(7, 0);
			cs.execute();
			cs.close();
			con.commit();
		} catch (SQLException e) {
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
	public boolean eliminarVenta(VentaDTO a) {
		Connection con = ConexionBD.getConexion();
		try {
			String query = "{call VENTAABM (?, ?, ?, ?, ?, ?, ?)}";
			con.setAutoCommit(false);
			CallableStatement cs = con.prepareCall(query);
			cs.setString(1, "BAJA");
			cs.setObject(2, null);
			cs.setString(3, "");
			cs.setString(4, "");
			cs.setString(5, "");
			cs.setString(6, "");
			cs.setInt(7, a.getId());
			cs.execute();
			cs.close();
			con.commit();
			return true;
		} catch (SQLException e) {
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
	public VentaDTO obtenerVenta(VentaDTO a) {
		Connection con = ConexionBD.getConexion();
		try {
			String query = "{call VENTAABM (?, ?, ?, ?, ?, ?, ?)}";
			con.setAutoCommit(false);
			CallableStatement cs = con.prepareCall(query);
			cs.setString(1, "CONSULTA");
			cs.setObject(2, a.getFecVenta());
			cs.setString(3, a.getFormaDePago().toString());
			cs.setString(4, a.getCliente().getdNI());
			cs.setString(5, a.getVuelo().getNumeroVuelo());
			cs.setString(6, a.getAerolinea().getNombre());
			cs.setInt(7, a.getId());
			VentaDTO ventaDTO = null;
			ResultSet rs = cs.executeQuery();
			if (rs.next()) {
				ventaDTO = new VentaDTO (rs.getInt(1), rs.getObject(2, LocalDateTime.class), FormaDePago.valueOf(rs.getString(3)),
						new ClienteDTO (rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getObject(9, LocalDate.class), rs.getString(10))
						, new VueloDTO (rs.getInt(11), rs.getString(12), rs.getInt(13), rs.getObject(14, LocalDateTime.class), rs.getObject(15, LocalDateTime.class), 
						rs.getInt(16), new AeropuertoDTO(rs.getInt(17), rs.getString(18), new PaisDTO (rs.getString(20)), new ProvinciaDTO (rs.getString(21)), rs.getString(19)),
						new AeropuertoDTO (rs.getInt(22), rs.getString(23), new PaisDTO (rs.getString(25)), new ProvinciaDTO (rs.getString(26)), rs.getString(24))), 
						new LineaAereaDTO (rs.getInt(27), rs.getString(28), new AlianzaDTO (rs.getString(29))));
			}
			cs.close();
			con.commit();
			return ventaDTO;
		} catch (SQLException e) {
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
	public void modificarVenta(VentaDTO a) {
		Connection con = ConexionBD.getConexion();
		try {
			String query = "{call VENTAABM (?, ?, ?, ?, ?, ?, ?)}";
			con.setAutoCommit(false);
			CallableStatement cs = con.prepareCall(query);
			cs.setString(1, "MODIFICACIÓN");
			cs.setObject(2, a.getFecVenta());
			cs.setString(3, a.getFormaDePago().toString());
			cs.setString(4, a.getCliente().getdNI());
			cs.setString(5, a.getVuelo().getNumeroVuelo());
			cs.setString(6, a.getAerolinea().getNombre());
			cs.setInt(7, a.getId());
			cs.execute();
			cs.close();
			con.commit();
		} catch (SQLException e) {
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
	public List<VentaDTO> obtenerVentas() {
		Connection con = ConexionBD.getConexion();
		List <VentaDTO> lista = new ArrayList <VentaDTO>();
		try {
			String query = "{call VENTAABM (?, ?, ?, ?, ?, ?, ?)}";
			con.setAutoCommit(false);
			CallableStatement cs = con.prepareCall(query);
			cs.setString(1, "CONSULTATOTAL");
			cs.setObject(2, null);
			cs.setString(3, "");
			cs.setString(4, "");
			cs.setString(5, "");
			cs.setString(6, "");
			cs.setInt(7, 0);
			ResultSet rs = cs.executeQuery();
			while (rs.next()) {
				lista.add(new VentaDTO (rs.getInt(1), rs.getObject(2, LocalDateTime.class), FormaDePago.valueOf(rs.getString(3)),
						new ClienteDTO (rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getObject(9, LocalDate.class), rs.getString(10))
						, new VueloDTO (rs.getInt(11), rs.getString(12), rs.getInt(13), rs.getObject(14, LocalDateTime.class), rs.getObject(15, LocalDateTime.class), 
						rs.getInt(16), new AeropuertoDTO(rs.getInt(17), rs.getString(18), new PaisDTO (rs.getString(20)), new ProvinciaDTO (rs.getString(21)), rs.getString(19)),
						new AeropuertoDTO (rs.getInt(22), rs.getString(23), new PaisDTO (rs.getString(25)), new ProvinciaDTO (rs.getString(26)), rs.getString(24))), 
						new LineaAereaDTO (rs.getInt(27), rs.getString(28), new AlianzaDTO (rs.getString(29)))));
			}
			cs.close();
			con.commit();
			return lista;
		} catch (SQLException e) {
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
