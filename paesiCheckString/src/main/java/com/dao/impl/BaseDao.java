package com.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.paesi.Alias;
import com.paesi.Bean;
import com.paesi.Country;

public abstract class BaseDao {
	public Session getSession() {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
		SessionFactory factory = meta.getSessionFactoryBuilder().build();  
		Session session = factory.openSession();  
		
		return session;
	}
	
	public Transaction getTransaction() {
		return getSession().beginTransaction();
	}
	
	protected void create(Bean b) {
		Session session = getSession();
		session.beginTransaction();
		session.save(b);
		session.getTransaction().commit();
		//session.close();
	}

	protected Bean get(Class<? extends Bean> class1, String id) {
		Session session = getSession();
		session.beginTransaction();
		Bean b =session.get(class1, id);
		session.getTransaction().commit();
		session.close();
		return b;
		
	}
}
