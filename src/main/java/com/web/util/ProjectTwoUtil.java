package com.web.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ProjectTwoUtil {
	
	// need try catch block using the .forName to grab the driver for the war app
		static {
			try {
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	
	private static SessionFactory sesfact;
	
	private static SessionFactory buildSessionFactory() {
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		return config.buildSessionFactory();
	}
	
	public static SessionFactory getSessionFactory() {
		if(sesfact==null) {
			sesfact = buildSessionFactory();
		}
		return sesfact;
	}

}
