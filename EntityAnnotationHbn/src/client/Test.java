package client;

import javax.persistence.Transient;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import bean.Student;

public class Test {

	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure("resource/student.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session s= sf.openSession();
		Transaction t =s.beginTransaction();
		
		Student s1=new Student();
		s1.setId(111);
		s1.setName("ALok");
		s1.setMail("Alok@gmail.com");
		s1.setAge(24);
		System.out.println("success");
		s.save(s1);
		t.commit();
		s.close();
		
		

	}

}
