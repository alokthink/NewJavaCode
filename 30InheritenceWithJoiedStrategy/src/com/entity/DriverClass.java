package com.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DriverClass {

	public static void main(String[] args) {
		SessionFactory factory=new Configuration().configure("com/resource/hibernate.cfg.xml").buildSessionFactory();
        Session session=factory.openSession();
        Transaction t=session.beginTransaction();
        Vehicle v=new Vehicle();
        v.setVehicleName("Car");
        
        TW tw=new TW();
        tw.setVehicleName("Bike");
        tw.setSteeringHandle("Steering Hnadler");
        
        FW fw=new FW();
        fw.setVehicleName("BMW");
        fw.setSteeringWheel("steering Wheel");
        
        session.save(v);
        session.save(tw);
        session.save(fw);
        t.commit();
        session.close();
        
	}

}
