package com.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.Gerardo.ConnectionToDB;
import com.dao.AliasUnknownDao;
import com.paesi.AliasUnknown;

public class AliasUnknownDaoImpl extends BaseDao implements AliasUnknownDao {
	
	public void create(AliasUnknown au) {
		super.create(au);
	}
}
