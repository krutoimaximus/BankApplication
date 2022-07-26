package com.bankapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankapp.dao.CustomerDao;
import com.bankapp.entites.Customers;
@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerDao dao;
	@Override
	public boolean addCustomer(Customers customers) {
		return dao.addCustomer(customers);
	}

	@Override
	public List<Customers> getAllCustomers() {
		// TODO Auto-generated method stub
		return dao.getAllCustomers();
	}

	@Override
	public boolean updateCustomer(Customers customers) {
		// TODO Auto-generated method stub
		return dao.updateCustomer(customers);
	}

	@Override
	public Customers getCustomerById(int customerid) {
		
		return dao.getCustomerById(customerid);
	}

	@Override
	public boolean deleteCustomer(int customerid) {
		// TODO Auto-generated method stub
		return dao.deleteCustomer(customerid);
	}
	
	@Override
	public Customers validateReciever(String firstName, String lastName, String accNo){
		return dao.validateReciever(firstName, lastName, accNo);
	}
	@Override
	public Customers getPassword(int customerid) {
		// TODO Auto-generated method stub
		return dao.getPassword(customerid);
	}
	@Override
	public int customerDebit(int customerid, String accountno, int debit) {
		// TODO Auto-generated method stub
		return dao.customerDebit(customerid, accountno, debit);
	}
	@Override
	public boolean changePassword(int customerid, String password) {
		// TODO Auto-generated method stub
		return dao.changePassword(customerid, password);
	}

}
