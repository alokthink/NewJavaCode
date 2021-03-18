package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import bean.Student;


public class Client {

	public static void main(String[] args) {
		Configuration cfg= new Configuration();
		cfg.configure("resource/student.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session s= sf.openSession();
	Transaction t=s.beginTransaction();
	Student st=new Student();
	st.setId(333);
	st.setName("anshi");
	st.setEmail("alok@gmail.com");
	//int pk=(int)s.save(st);
	//s.persist(st);
	s.saveOrUpdate(st);
	//System.out.println(pk);
	t.commit();
	s.close();
	sf.close();
	System.out.println("data insertion successfully");

	}

}
