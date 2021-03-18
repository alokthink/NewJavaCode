package com.think.dto;

import java.nio.channels.SeekableByteChannel;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainClass {

	public static void main(String[] args) {
		EmployeeDetails emp1=new EmployeeDetails();
		emp1.setName("ALOK");
		
		Address address1=new Address();
		address1.setCity("LMP");
		address1.setState("UP");
		address1.setStreet("RUSAAV");
		
		Address address2=new Address();
		address2.setCity("LMP2");
		address2.setState("UP2");
		address2.setStreet("RUSAAV2");
		
		emp1.getListOfAddress().add(address2);
		emp1.getListOfAddress().add(address1);
		
		SessionFactory sessionFactory=new Configuration().configure("com/think/dto/hibernate.cfg.xml").buildSessionFactory();
		Session session=sessionFactory.openSession();
		Transaction t=session.beginTransaction();
		session.save(emp1);
		t.commit();
		session.close();
		System.out.println("added successfully..");
		 session=sessionFactory.openSession();
		 emp1 = session.get(EmployeeDetails.class, 1);
		 session.close();
		 System.out.println(emp1.getListOfAddress().size());
		
		
		
		
		
		
	}

}
