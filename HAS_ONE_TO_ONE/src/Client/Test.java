package Client;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import bean.Vote;
import bean.Voter;

public class Test {

	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure("resource/hibernate.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session session =sf.openSession();
		Transaction t = session.beginTransaction();
		
		Voter v = new Voter();
		v.setVid(111);
		v.setVname("alok");
		v.setVage(24);
		
		Vote vote=new Vote();
		 vote.setPname("pdp");
		 vote.setCdate(new Date());
		 vote.setVoter(v);
		
		
		
		
		session.save(v);
		session.save(vote);
		t.commit();
		System.out.println("insertion successfully...........");
		session.close();
		
		

	}

}
