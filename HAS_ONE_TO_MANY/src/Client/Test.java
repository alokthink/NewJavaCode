package Client;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import bean.Actor;
import bean.Movies;

public class Test {

	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure("resource/hibernate.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session session =sf.openSession();
		Transaction t = session.beginTransaction();
		
		Actor actor = new Actor();
		actor.setAid(1);
		actor.setAname("tiger");
		
		Movies m1=new Movies();
		m1.setMid(1);
		m1.setMoviesName("war");
		
		Movies m2=new Movies();
		m2.setMid(2);
		m2.setMoviesName("baaghi");
		
		Set<Movies> set = new  HashSet<Movies>();
		set.add(m1);
		set.add(m2);
		
		actor.setMovies(set);
		
		session.save(actor);
//		session.save(m1);
//		session.save(m2);
		t.commit();
		System.out.println("insertion successfully...........");
		session.close();
		
		

	}

}
