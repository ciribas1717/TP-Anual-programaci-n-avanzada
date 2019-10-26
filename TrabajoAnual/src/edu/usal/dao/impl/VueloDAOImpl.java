package edu.usal.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import edu.usal.dao.VueloDAO;
import edu.usal.dto.AeropuertoDTO;
import edu.usal.dto.AlianzaDTO;
import edu.usal.dto.LineaAereaDTO;
import edu.usal.dto.PaisDTO;
import edu.usal.dto.ProvinciaDTO;
import edu.usal.dto.VueloDTO;
import edu.usal.util.ConexionBD;

public class VueloDAOImpl implements VueloDAO {

	@Override
	public void agregarVuelo(VueloDTO a) {
		Connection con = ConexionBD.getConexion();
		try {
			String query = "{call VUELOABM (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
			con.setAutoCommit(false);
			CallableStatement cs = con.prepareCall(query);
			cs.setString(1, "ALTA");
			cs.setString(2, a.getNumeroVuelo());
			cs.setInt(3, a.getCantAsientos());
			cs.setObject(4, a.getFecSalida());
			cs.setObject(5, a.getFecLlegada());
			cs.setInt(6, a.getTiempoVuelo());
			cs.setString(7, a.getAeropuertoSalida().getCodigo());
			cs.setString(8, a.getAeropuertoLlegada().getCodigo());
			cs.setString(9, a.getAerolinea().getNombre());
			cs.setInt(10, 0);
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
	public boolean eliminarVuelo(VueloDTO a) {
		Connection con = ConexionBD.getConexion();
		try {
			String query = "{call VUELOABM (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
			con.setAutoCommit(false);
			CallableStatement cs = con.prepareCall(query);
			cs.setString(1, "BAJA");
			cs.setString(2, "");
			cs.setInt(3, 0);
			cs.setObject(4, null);
			cs.setObject(5, null);
			cs.setInt(6, 0);
			cs.setString(7, "");
			cs.setString(8, "");
			cs.setString(9, "");
			cs.setInt(10, a.getId());
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
	public VueloDTO obtenerVuelo(VueloDTO a) {
		Connection con = ConexionBD.getConexion();
		try {
			String query = "{call VUELOABM (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
			con.setAutoCommit(false);
			CallableStatement cs = con.prepareCall(query);
			cs.setString(1, "CONSULTA");
			cs.setString(2, a.getNumeroVuelo());
			cs.setInt(3, a.getCantAsientos());
			cs.setObject(4, a.getFecSalida());
			cs.setObject(5, a.getFecLlegada());
			cs.setInt(6, a.getTiempoVuelo());
			cs.setString(7, a.getAeropuertoSalida().getCodigo());
			cs.setString(8, a.getAeropuertoLlegada().getCodigo());
			cs.setString(9, a.getAerolinea().getNombre());
			cs.setInt(10, a.getId());
			VueloDTO vueloDTO = null;
			ResultSet rs = cs.executeQuery();
			if (rs.next()) {
				vueloDTO = new VueloDTO (rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getObject(4, LocalDateTime.class), rs.getObject(5, LocalDateTime.class), rs.getInt(6), 
				new AeropuertoDTO (rs.getInt(7), rs.getString(8), new PaisDTO (rs.getString(10)), new ProvinciaDTO (rs.getString(11)), rs.getString(9)), new AeropuertoDTO (rs.getInt(12), 
				rs.getString(13), new PaisDTO (rs.getString(15)), new ProvinciaDTO (rs.getString(16)), rs.getString(14)), new LineaAereaDTO (rs.getInt(17), rs.getString(18), new AlianzaDTO (rs.getString(19))));
			}
			cs.close();
			con.commit();
			return vueloDTO;
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
	public void modificarVuelo(VueloDTO a) {
		Connection con = ConexionBD.getConexion();
		try {
			String query = "{call VUELOABM (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
			con.setAutoCommit(false);
			CallableStatement cs = con.prepareCall(query);
			cs.setString(1, "MODIFICACIÓN");
			cs.setString(2, a.getNumeroVuelo());
			cs.setInt(3, a.getCantAsientos());
			cs.setObject(4, a.getFecSalida());
			cs.setObject(5, a.getFecLlegada());
			cs.setInt(6, a.getTiempoVuelo());
			cs.setString(7, a.getAeropuertoSalida().getCodigo());
			cs.setString(8, a.getAeropuertoLlegada().getCodigo());
			cs.setString(9, a.getAerolinea().getNombre());
			cs.setInt(10, a.getId());
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
	public List<VueloDTO> obtenerVuelos() {
		Connection con = ConexionBD.getConexion();
		List <VueloDTO> lista = new ArrayList <VueloDTO>();
		try {
			String query = "{call VUELOABM (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
			con.setAutoCommit(false);
			CallableStatement cs = con.prepareCall(query);
			cs.setString(1, "CONSULTATOTAL");
			cs.setString(2, "");
			cs.setInt(3, 0);
			cs.setObject(4, null);
			cs.setObject(5, "");
			cs.setInt(6, 0);
			cs.setString(7, "");
			cs.setString(8, "");
			cs.setString(9, "");
			cs.setInt(10, 0);
			ResultSet rs = cs.executeQuery();
			while (rs.next()) {
				lista.add(new VueloDTO (rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getObject(4, LocalDateTime.class), rs.getObject(5, LocalDateTime.class), rs.getInt(6), 
				new AeropuertoDTO (rs.getInt(7), rs.getString(8), new PaisDTO (rs.getString(10)), new ProvinciaDTO (rs.getString(11)), rs.getString(9)), new AeropuertoDTO (rs.getInt(12), 
				rs.getString(13), new PaisDTO (rs.getString(15)), new ProvinciaDTO (rs.getString(16)), rs.getString(14)), new LineaAereaDTO (rs.getInt(17), rs.getString(18), new AlianzaDTO (rs.getString(19)))));
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
