package edu.usal.dao.factory;

import edu.usal.dao.LineaAereaDAO;
import edu.usal.dao.impl.LineaAereaDAOImpl;

public class LineaAereaFactory {
		
	public static LineaAereaDAO getLineaAereaDAO (String type) { 

		if (type.equalsIgnoreCase("sql")){
			
		return new LineaAereaDAOImpl();
		
		} else {
		return null;
		}
		
		
		    }
	}
