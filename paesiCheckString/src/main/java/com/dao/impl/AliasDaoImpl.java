package com.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.dao.AliasDao;
import com.paesi.Alias;
import com.paesi.AliasUnknown;

public class AliasDaoImpl extends BaseDao implements AliasDao {
	
	public void create(Alias a) {
		super.create(a);
	}
}
