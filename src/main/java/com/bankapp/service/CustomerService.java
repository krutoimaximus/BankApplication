package com.bankapp.service;

import java.util.List;

import com.bankapp.entites.Customers;

public interface CustomerService {

	public boolean addCustomer(Customers customers);
	 
	 public List<Customers> getAllCustomers();
	 
	 public boolean updateCustomer(Customers customers);
	 
	 public Customers getCustomerById(int customerid);
	 
	 public boolean deleteCustomer(int customerid);
	 
	 public Customers validateReciever(String firstName, String lastName, String accNo);
	 
	 public Customers getPassword(int customerid);

	 public int customerDebit(int customerid,String accountno,int debit);
	 
	 public boolean changePassword(int customerid, String password);
}

