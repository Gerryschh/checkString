package com.dao;

import java.util.List;

import com.paesi.AliasUnknown;
import com.paesi.Country;

public interface CountryDao {
	public void create(Country c);
	public Country get(String id);
	public List<String> getAll();
	
}
