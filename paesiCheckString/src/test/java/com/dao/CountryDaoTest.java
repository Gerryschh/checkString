package com.dao;

import java.util.List;

import com.dao.impl.CountryDaoImpl;
import com.paesi.Country;

public class CountryDaoTest {
	public static void main(String[] args) {
		testGet();
	}
	
	public static void testGetAll() {
		CountryDao dao = new CountryDaoImpl();
		List<String> result = dao.getAll();
		System.out.println(result);
	}
	
	public static void testGet() {
		CountryDao dao = new CountryDaoImpl();
		Country result = dao.get("Libia");
		System.out.println(result);
	}
}
