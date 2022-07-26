package com.bankapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bankapp.entites.Greviance;
@Repository
public class GrevianceDaoImpl implements GrevianceDao{
	
	@Autowired
	EntityManager manager;
	@Override
	@Transactional
	public boolean addGrevieance(Greviance grevieance) {
		manager.persist(grevieance);
		return true;
	}

	@Override
	public List<Greviance> getAllGrevieance(int customerid) {
		String query=" Select q From Greviance q where q.customerid="+customerid;
		TypedQuery<Greviance> result=manager.createQuery(query,Greviance.class);
		return result.getResultList();
	}

	@Override
	@Transactional
	public boolean acceptGrevieance(int grevieanceid) {
		
		Greviance grevieance = manager.find(Greviance.class,grevieanceid);
		grevieance.setStatus("Approved");
		return true;
	}

	@Override
	@Transactional
	public boolean declineGrevieance(int grevieanceid) {
		Greviance grevieance = manager.find(Greviance.class,grevieanceid);
		grevieance.setStatus("Rejected");
		return true;
	}
	@Override
	public List<Greviance> getAllGreviance() {
		TypedQuery<Greviance> query = manager.createQuery("From Greviance", Greviance.class);
		return query.getResultList();
	}

}
