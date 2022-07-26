package com.bankapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import com.bankapp.entites.Transactions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TransactionsDaoImpl implements TransactionsDao {

	@Autowired
	EntityManager manager;
	
	@Override
	@Transactional
	public boolean addTransaction(Transactions transaction) {
		manager.persist(transaction);
		return true;
	}
	@Override
	public List<Transactions> customerCredit(int customerid) {
		String query=" Select t From Transactions t where t.customerid='"+customerid+"'";
		TypedQuery<Transactions> result=manager.createQuery(query,Transactions.class);
		return result.getResultList(); 
	}
	
	@Override
	public List<Transactions> getTransactionByName(String beneficiaryname) {
		String query=" Select t From Transactions t where t.beneficiaryname='"+beneficiaryname+"'";
		TypedQuery<Transactions> result=manager.createQuery(query,Transactions.class);
		return result.getResultList(); 
	}
	
	@Override
	public List<Transactions> getAllTransactions() {
		TypedQuery<Transactions> query = manager.createQuery("From Transactions", Transactions.class);
		return query.getResultList();
	}
}
