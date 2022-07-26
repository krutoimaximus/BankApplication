package com.bankapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankapp.dao.GrevianceDao;
import com.bankapp.entites.Greviance;

@Service
public class GrevianceServiceImpl implements GrevianceService {
	
	@Autowired
	GrevianceDao dao;
	
	@Override
	public boolean addGrevieance(Greviance grevieance) {
		// TODO Auto-generated method stub
		return dao.addGrevieance(grevieance);
	}

	@Override
	public List<Greviance> getAllGrevieance(int customerid) {
		// TODO Auto-generated method stub
		return dao.getAllGrevieance(customerid);
	}
	@Override
	public boolean acceptGrevieance(int grevieanceid) {
		// TODO Auto-generated method stub
		return dao.acceptGrevieance(grevieanceid);
	}

	@Override
	public boolean declineGrevieance(int grevieanceid) {
		// TODO Auto-generated method stub
		return dao.declineGrevieance(grevieanceid);
	}
	@Override
	public List<Greviance> getAllGreviance() {
		// TODO Auto-generated method stub
		return dao.getAllGreviance();
	}

}
