package com.strategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import com.Gerardo.ConnectionToDB;
import com.dao.AliasUnknownDao;
import com.dao.CountryDao;
import com.dao.impl.AliasUnknownDaoImpl;
import com.dao.impl.CountryDaoImpl;
import com.paesi.Alias;
import com.paesi.AliasUnknown;

public class StrategyDB implements Strategy{
	CountryDao countryDao = new CountryDaoImpl();
	static Session session = ConnectionToDB.getSession();
	private AliasUnknownDao dao = new AliasUnknownDaoImpl();
	
	public String getAliases(String input) {
	    String query = "select nome_paese from alias where alias_paese = " + input;
	    NativeQuery<String> q = session.createSQLQuery(query);
	    return q.getSingleResult();
	}	

	
	public Map<String,List<String>> veryBigMapOfTheWorld() {
        //NativeQuery<String> q = session.createSQLQuery("Select * From country");
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        for (String s: countryDao.getAll()) {
            map.put(s.toLowerCase(), new ArrayList<String>());
        }
        NativeQuery<Object []> mq = session.createSQLQuery("Select alias_paese, nome_paese from alias");
        List<Object[]>  l =mq.list();
        System.out.println(l.size());
        for(Object[] o: l) { 
	        List<String> temp = map.get(((String)o[1]).toLowerCase());
	        temp.add((String) o[0]);
	        map.put((String) o[1], temp);            
        }
        return map;
    }


	public void addStupidInput(String input) {

		AliasUnknown au = new AliasUnknown();
		au.setIncognita(input);
		dao.create(au);
	}


	@Override
	public Set<String> getStandards() {
		//return (Set<String>) countryDao.getAll();
		return null;
	}
}


