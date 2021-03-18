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
		
	   Vehicle vehicle=new Vehicle();
	   vehicle.setVehicleName("Car");
	   
	   TwoWheeler twoWheeler=new TwoWheeler();
	   twoWheeler.setVehicleName("Bike");
	   twoWheeler.setSterringHandle("Bike Steering hnadler");
	   
	   FourWheeler fourWheeler=new FourWheeler();
	   fourWheeler.setVehicleName("BMW");
	   fourWheeler.setSteeringWheel("BMW steering wheel");
	   session.save(vehicle);
	   session.save(twoWheeler);
	   session.save(fourWheeler);
		t.commit();
		session.close();
		System.out.println("save successfully..");

	}

}
