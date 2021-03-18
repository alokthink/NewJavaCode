package com.think.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.think.dto.UserDetails;

public class MainClass {

	public static void main(String[] args) {
	
		UserDetails user1=new UserDetails();
		user1.setName("vivek");
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		Transaction t =session.beginTransaction();
		session.save(user1);
		//session.save(s);
		//object persistence state
		t.commit();
		//student object move to date base
		session.evict(user1);
		
		//For Retrieving data from table
		session = sessionFactory.openSession();
		 t=session.beginTransaction();
		user1= session.load(UserDetails.class, 1);
		//System.out.println(user1);
		//System.out.println(user1.getName());
		
		
		

	}

}
