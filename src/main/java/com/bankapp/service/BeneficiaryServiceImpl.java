package com.bankapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankapp.dao.BeneficiaryDao;
import com.bankapp.entites.Beneficiary;
@Service
public class BeneficiaryServiceImpl implements BeneficiaryService {
	
	@Autowired
	private BeneficiaryDao dao;
	
	@Override
	public boolean addBeneficiary(Beneficiary beneficiary) {
		// TODO Auto-generated method stub
		return dao.addBeneficiary(beneficiary);
	}

	@Override
	public List<Beneficiary> getAllBeneficiary(int customerid) {
		// TODO Auto-generated method stub
		return dao.getAllBeneficiary(customerid);
	}

	@Override
	public boolean deleteBeneficiary(int beneficiaryid) {
		// TODO Auto-generated method stub
		return dao.deleteBeneficiary(beneficiaryid);
	}

}
