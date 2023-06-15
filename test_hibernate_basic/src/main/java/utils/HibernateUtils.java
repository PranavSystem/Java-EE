package utils;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	// create a singleton immutable object / database
	private static SessionFactory factory;
	
	// create a static block
	static {
		// build sessionfactory object
		factory=new Configuration()		// empty configuration
				.configure()			// read properties and mappings from hibernate.cfg.xml
				.buildSessionFactory(); // building SessionFactory
	}
	
	public static SessionFactory getFactory() {
		return factory;
	}
	
}
