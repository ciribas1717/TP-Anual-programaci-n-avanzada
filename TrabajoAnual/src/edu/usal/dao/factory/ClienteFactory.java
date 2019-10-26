package edu.usal.dao.factory;

import edu.usal.dao.ClienteDAO;
import edu.usal.dao.impl.ClienteDAOImpl;

public class ClienteFactory {
		
	public static ClienteDAO getClienteDAO (String type) { 

		if (type.equalsIgnoreCase("sql")){
			
		return new ClienteDAOImpl();
		
		} else {
		return null;
		}
		
		
		    }
	}
