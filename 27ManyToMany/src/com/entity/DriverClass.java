package com.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DriverClass {

	public static void main(String[] args) {
		SessionFactory sessionFactory=new Configuration().configure("com/resource/hibernate.cfg.xml").buildSessionFactory();
		Session session =sessionFactory.openSession();
		Transaction t=session.beginTransaction();
		
		UserDetails user=new UserDetails();
		user.setUserName("First User");
		
		UserDetails user1=new UserDetails();
		user.setUserName("Second User");
		
		Vehcile vehcile=new Vehcile();
		vehcile.setVehcileName("Car");
		vehcile.getUserDetails().add(user);
		vehcile.getUserDetails().add(user1);
		
		Vehcile vehcile1=new Vehcile();
		vehcile1.setVehcileName("Bike");
		vehcile1.getUserDetails().add(user);
		vehcile.getUserDetails().add(user1);
		user.getVehcileList().add(vehcile);
		user.getVehcileList().add(vehcile1);
		user1.getVehcileList().add(vehcile);
		user1.getVehcileList().add(vehcile1);
		session.save(user);
		session.save(user1);
		session.save(vehcile);
		session.save(vehcile1);
		t.commit();
		session.close();
		System.out.println("save successfully..");

	}

}
