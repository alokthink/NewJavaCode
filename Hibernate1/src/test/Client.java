package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import bean.Student;

public class Client {

	public static void main(String[] args) {
		
		Student s=new Student();
		s.setId(1);
		s.setName("anshi");
		s.setMail("anshi@gmail.com");
		s.setMarks(60);
		//object transiant state
		Configuration cfg=new Configuration();
		cfg.configure("resource/student.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session session=sf.openSession();
		session.save(s);
		//object persistence state
		session.beginTransaction().commit();
		//student object move to date base
		session.evict(s);
		// object remove from pesistence state
		//then gc collect our student object 
	}

}
