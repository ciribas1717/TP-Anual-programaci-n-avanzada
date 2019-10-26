package edu.usal.dao.factory;

import edu.usal.dao.VueloDAO;
import edu.usal.dao.impl.VueloDAOImpl;

public class VueloFactory {
		
	public static VueloDAO getVueloDAO (String type) { 

		if (type.equalsIgnoreCase("sql")){
			
		return new VueloDAOImpl();
		
		} else {
		return null;
		}
		
		
		    }
	}
