package com.neerav.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.neerav.dao.WhatWentWellDao;
import com.neerav.model.WhatWentWell;

@Repository
public class WhatWentWellDaoImpl implements WhatWentWellDao {
	
	private static final Logger logger = LoggerFactory.getLogger(WhatWentWellDaoImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addWhatWentWell(WhatWentWell p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("Person saved successfully, Person Details="+p);
		
	}

	@Override
	public void updateWhatWentWell(WhatWentWell p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("Person updated successfully, Person Details="+p);
	}

	

	@Override
	public void removeWhatWentWell(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		WhatWentWell p = (WhatWentWell) session.load(WhatWentWell.class, new Integer(id));
		if(null != p){
			session.delete(p);
		}
		logger.info("Person deleted successfully, person details="+p);
		
	}

	@Override
	public List<WhatWentWell> listWhatWentWell() {
		Session session = this.sessionFactory.getCurrentSession();
		List<WhatWentWell> personsList = session.createQuery("from Person").list();
		for(WhatWentWell p : personsList){
			logger.info("Person List::"+p);
		}
		return personsList;
	}

	@Override
	public WhatWentWell getWhatWentWellById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		WhatWentWell p = (WhatWentWell) session.load(WhatWentWell.class, new Integer(id));
		logger.info("Person loaded successfully, Person details="+p);
		return p;
	}
}