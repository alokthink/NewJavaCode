package com.entity;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

public class DriverClass {

	public static void main(String[] args) {
		SessionFactory factory=new Configuration().configure("com/resource/hibernate.cfg.xml").buildSessionFactory();
			Session s=factory.openSession();
			Transaction t =s.beginTransaction();
			
			User user1=s.get(User.class, 1);
			
			s.close();
			
			Session session=factory.openSession();
			
			User user2=session.get(User.class, 1);
			session.beginTransaction().commit();
			
			
		/*
		 * Criteria criteria=s.createCriteria(User.class);
		 * criteria.add(Restrictions.eq("userName", "user 9"));
		 */
//			Query query=s.getNamedQuery("User.byId");
//			query.setInteger("userId", 2);
		/*
		 * List<User> list=(List<User>)criteria.list(); t.commit(); s.close(); for(User
		 * user:list) { System.out.println(user.getUserName());
		 * System.out.println(user.getUserId()); } System.out.println(list.size());
		 * 
		 */
		
		
		
	}

}
