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
		Vehcile vehcile=new Vehcile();
		vehcile.setVehcileName("Car");
		user.setVehcile(vehcile);
		
		session.save(user);
		session.save(vehcile);
		t.commit();
		session.close();
		System.out.println("save successfully..");

	}

}
