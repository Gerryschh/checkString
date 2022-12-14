package com.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.dao.CountryDao;
import com.paesi.Alias;
import com.paesi.Bean;
import com.paesi.Country;

public class CountryDaoImpl extends BaseDao implements CountryDao {
	public void create(Country c) {
		super.create(c);
	}

	@Override
	public Country get(String id) {
		return (Country) super.get(Country.class, id);
		
	}
	
	public List<String> getAll() {
		Session session = getSession();
		//session.beginTransaction();
		Query query = session.createQuery("select countryName from Country");
		// Bean b =session.get(class1, id);
		//session.getTransaction().commit();
		//session.close();
		return (List<String>) query.list();
		
	}
}
