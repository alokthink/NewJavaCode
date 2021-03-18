package client;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HQL_TABLE_TO_TABLE {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("resource/student.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		String query = "insert into NewStudent(id,name,email,address) select s.id,s.name,s.email,s.address from OldStudent s";
		Query q = s.createQuery(query);
		int i= q.executeUpdate();
		System.out.println(i);
		s.close();
		sf.close();
	}

}
