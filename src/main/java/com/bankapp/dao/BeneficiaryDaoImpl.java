package com.bankapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bankapp.entites.Beneficiary;
@Repository
public class BeneficiaryDaoImpl implements BeneficiaryDao {
	@Autowired
	EntityManager manager;
	
	@Override
	@Transactional
	public boolean addBeneficiary(Beneficiary beneficiary) {
		manager.persist(beneficiary);
		return true;
	}

	@Override
	public List<Beneficiary> getAllBeneficiary(int customerid) {
		String query=" Select p From Beneficiary p where p.customerid="+customerid;
		TypedQuery<Beneficiary> result=manager.createQuery(query,Beneficiary.class);
		return result.getResultList();
	}
	@Override
	@Transactional
	public boolean deleteBeneficiary(int beneficiaryid) {
		Beneficiary beneficiary=manager.find(Beneficiary.class, beneficiaryid);
		manager.remove(beneficiary);
		return true;
	}

}
