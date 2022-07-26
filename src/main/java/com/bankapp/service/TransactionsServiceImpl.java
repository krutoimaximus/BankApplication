package com.bankapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankapp.dao.TransactionsDao;
import com.bankapp.entites.Transactions;

@Service
public class TransactionsServiceImpl implements TransactionsService {

	@Autowired
	TransactionsDao dao;
	
	@Override
	public boolean addTransaction(Transactions transaction) {
		// TODO Auto-generated method stub
		return dao.addTransaction(transaction);
	}
	@Override
	public List<Transactions> customerCredit(int customerid) {
		// TODO Auto-generated method stub
		return dao.customerCredit(customerid);
	}
	@Override
	public List<Transactions> getTransactionByName(String beneficiaryname) {
		// TODO Auto-generated method stub
		return dao.getTransactionByName(beneficiaryname);
	}
	@Override
	public List<Transactions> getAllTransactions() {
		// TODO Auto-generated method stub
		return dao.getAllTransactions();
	}
}
