package com.bankapp.dao;

import java.util.List;

import com.bankapp.entites.Beneficiary;

public interface BeneficiaryDao {
	
	public boolean addBeneficiary(Beneficiary beneficiary);
	
	public List<Beneficiary> getAllBeneficiary(int customerid);
	
	public boolean deleteBeneficiary(int beneficiaryid);

}
