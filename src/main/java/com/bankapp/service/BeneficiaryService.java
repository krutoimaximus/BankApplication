package com.bankapp.service;

import java.util.List;

import com.bankapp.entites.Beneficiary;

public interface BeneficiaryService {
	
	public boolean addBeneficiary(Beneficiary beneficiary);
	 
	public List<Beneficiary> getAllBeneficiary(int customerid);
	 
	public boolean deleteBeneficiary(int beneficiaryid);

}
