package com.dao;

import com.paesi.AliasUnknown;
import com.paesi.Country;

public interface CountryDao {
	public void create(Country c);
	public Country get(String id);
}
