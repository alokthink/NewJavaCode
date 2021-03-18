package test;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Client {

	public static void main(String[] args) {
		
	Configuration cfg=new Configuration();
	cfg.configure("resource/autoddl.cfg.xml");
	SessionFactory sf=cfg.buildSessionFactory();
	System.out.println("table created successfully");
	
	try {
		Thread.sleep(1000*10);
	}catch(Exception e) {
		e.printStackTrace();
	}
	sf.close();
	System.out.println("all table drop");
	}

}
