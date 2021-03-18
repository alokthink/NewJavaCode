package client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import bean.OldStudent;

public class Test {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("resource/student.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		OldStudent oldS1 = new OldStudent(111, "abc", "abc@gmail.com", "hyd");
		OldStudent oldS2 = new OldStudent(222, "lmn", "lmn@gmail.com", "hyd");
		OldStudent oldS3 = new OldStudent(333, "xyz", "xyz@gmail.com", "hyd");
		s.save(oldS1);
		s.save(oldS2);
		s.save(oldS3);
		t.commit();
		s.close();
		sf.close();

	}

}
