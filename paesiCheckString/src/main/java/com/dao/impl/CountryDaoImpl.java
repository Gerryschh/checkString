package com.dao.impl;

import com.dao.CountryDao;
import com.paesi.Alias;
import com.paesi.Country;

public class CountryDaoImpl extends BaseDao implements CountryDao {
	public void create(Country c) {
		super.create(c);
	}

	@Override
	public Country get(String id) {
		return (Country) super.get(Country.class, id);
		
	}
}
