package com.spring.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.spring.model.Account;
import com.spring.model.User;

public class Test {

	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();
        
        Account acc = new Account();
        acc.setBalance(100);
        
        User user = (User) sf.getCurrentSession().get(User.class, 1);
        user.setAccount(acc);
        
        session.saveOrUpdate(user);
        session.getTransaction().commit();
        session.close();

	}

}
