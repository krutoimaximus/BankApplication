package com.bankapp.dao;

import java.util.List;

import com.bankapp.entites.Greviance;

public interface GrevianceDao {
	
     public boolean addGrevieance(Greviance grevieance);
	 
	 public List<Greviance> getAllGrevieance(int customerid);
	 
	 public boolean acceptGrevieance(int grevieanceid);
	 
	 public boolean declineGrevieance(int grevieanceid);
	 
	 public List<Greviance> getAllGreviance();
}
