package edu.usal.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.usal.dao.LineaAereaDAO;
import edu.usal.dto.AlianzaDTO;
import edu.usal.dto.LineaAereaDTO;
import edu.usal.util.ConexionBD;

public class LineaAereaDAOImpl implements LineaAereaDAO {

	@Override
	public void agregarLineaAerea(LineaAereaDTO a) {
		Connection con = ConexionBD.getConexion();
		try {
			String query = "INSERT INTO LíneaAérea VALUES (?, ?)";
			con.setAutoCommit(false);
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, a.getNombre());
			ps.setString(2, a.getAlianza().getNombre());
			ps.execute();
			ps.close();
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
	public boolean eliminarLineaAerea(LineaAereaDTO a) {
		Connection con = ConexionBD.getConexion();
		try {
			String query = "DELETE FROM LíneaAérea WHERE LÍNEAAÉREA.IDLÍNEAAÉREA = ?";
			con.setAutoCommit(false);
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, a.getId());
			ps.execute();
			ps.close();
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
	public LineaAereaDTO obtenerLineaAerea(LineaAereaDTO a) {
		Connection con = ConexionBD.getConexion();
		try {
			String query = "SELECT * FROM LÍNEAAÉREA WHERE LÍNEAAÉREA.IDLÍNEAAÉREA = ?";
			con.setAutoCommit(false);
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, a.getId());
			ResultSet rs = ps.executeQuery();
			LineaAereaDTO lineaAereaDTO = null;
			if (rs.next()) {
				lineaAereaDTO = new LineaAereaDTO (rs.getInt(1), rs.getString(2), new AlianzaDTO (rs.getString(3)));
			}
			ps.close();
			con.commit();
			return lineaAereaDTO;
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
	public void modificarLineaAerea(LineaAereaDTO a) {
		Connection con = ConexionBD.getConexion();
		try {
			String query = "UPDATE LÍNEAAÉREA SET NOMBRE = ?, ALIANZA = ? WHERE LÍNEAAÉREA.IDLÍNEAAÉREA = ?";
			con.setAutoCommit(false);
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, a.getNombre());
			ps.setString(2, a.getAlianza().getNombre());
			ps.setInt(3, a.getId());
			ps.execute();
			ps.close();
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
	public List<LineaAereaDTO> obtenerLineasAereas() {
		Connection con = ConexionBD.getConexion();
		List <LineaAereaDTO> lista = new ArrayList <LineaAereaDTO>();
		try {
			String query = "SELECT * FROM LÍNEAAÉREA";
			con.setAutoCommit(false);
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				lista.add(new LineaAereaDTO (rs.getInt(1), rs.getString(2), new AlianzaDTO (rs.getString(3))));
			}
			ps.close();
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
