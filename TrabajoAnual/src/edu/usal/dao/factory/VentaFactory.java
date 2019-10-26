package edu.usal.dao.factory;

import edu.usal.dao.VentaDAO;
import edu.usal.dao.impl.VentaDAOImpl;

public class VentaFactory {
		
	public static VentaDAO getVentaDAO (String type) { 

		if (type.equalsIgnoreCase("sql")){
			
		return new VentaDAOImpl();
		
		} else {
		return null;
		}
		
		
		    }
	}
