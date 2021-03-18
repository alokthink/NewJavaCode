package com.entity;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class DriverClass {

	public static void main(String[] args) {
		SessionFactory factory=new Configuration().configure("com/resource/hibernate.cfg.xml").buildSessionFactory();
			Session s=factory.openSession();
			Transaction t =s.beginTransaction();
			Query query=s.createQuery("from User where userId>5");
			List list=query.list();
			t.commit();
			s.close();
			System.out.println(list.size());
			
		
		
		
		
	}

}
