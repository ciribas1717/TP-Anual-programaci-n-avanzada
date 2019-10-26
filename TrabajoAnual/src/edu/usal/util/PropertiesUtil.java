package edu.usal.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {
	private static Properties properties;

	
	//PROPERTIES NORMAL ES ESTATICO ACA
public static String getString(String string) {
	
	    InputStream in;
		properties = new Properties();
		try {
			//in = new FileInputStream("config.properties");
			//in = getClass().getClassLoader().getResourceAsStream("config.properties");
			in = PropertiesUtil.class.getClassLoader().getResourceAsStream("config.properties");
			if (in != null) {
				properties.load(in);
			}
		    in.close();
		    return properties.getProperty(string);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
}


}