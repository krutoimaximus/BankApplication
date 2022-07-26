package com.bankapp.controllers;

import java.util.Arrays;
import java.util.List;

import com.bankapp.entites.Customers;
import com.bankapp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.dto.ResponseData;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CustomersController {
	@Autowired
	ResponseData response;
	@Autowired
	CustomerService service;
	
	@PostMapping("/addcustomer")
	public ResponseData addCustomer(@RequestBody Customers customers) {
		if (service.addCustomer(customers)) {
			response.setStatusCode(200);
			response.setMessage("Success");
			response.setDescription("New customer  Added successfully");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("failed");
		}
		return response;
	}
	@GetMapping("/allcustomers")
	public ResponseData getAllCustomers(){
		List<Customers> customer=service.getAllCustomers();
		if (customer != null) {
			response.setStatusCode(200);
			response.setMessage("Success");
			response.setDescription("All Customers recieved");
			response.setCustomer(customer);
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Failed to load");
		}
		return response;
	}
	@PutMapping("/updatecustomers")
	public ResponseData updateCustomer(@RequestBody Customers customers) {
		if (service.updateCustomer(customers)) {
			response.setStatusCode(200);
			response.setMessage("Success");
			response.setDescription("Customers updated successfully");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("failed to update");
		}
		return response;
	}
	@GetMapping("/customer")
	public Customers getCustomerById(int customerid){
		return service.getCustomerById(customerid);	
	}
	@DeleteMapping("/deletecustomer")
	public ResponseData deleteCustomer(int customerid) {
		if (service.deleteCustomer(customerid)) {
			response.setStatusCode(200);
			response.setMessage("Success");
			response.setDescription("deleted customer successfully");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("failed to delete");
		}
		return response;
	}

	@GetMapping("/validatebeneficiary")
	public ResponseData validateReciever(String first, String last, String accountno){
		Customers customer = service.validateReciever(first, last, accountno);
		if (customer !=null) {
			response.setStatusCode(200);
			response.setMessage("Success");
			response.setDescription("Validated customer successfully");
			response.setCustomer(Arrays.asList(customer));
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("failed to validate");
		}
		return response;
	}
	@GetMapping("/getpassword")
	public ResponseData getPassword(int customerid) {		
		Customers customer = service.getPassword(customerid);
		if (customer !=null) {
			response.setStatusCode(200);
			response.setMessage("Success");
			response.setDescription("Validated customer Password successfully");
			response.setCustomer(Arrays.asList(customer));
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("failed to validate");
		}
		return response;
	}
	@GetMapping("/debitcal")
	public ResponseData customerDebit(int customerid,String accountno,int debit) {
//		return service.customerDebit(customerid, accountno, debit);
		
		int customer = service.customerDebit(customerid, accountno, debit);
		if (customer !=0) {
			response.setStatusCode(200);
			response.setMessage("Success");
			response.setDescription("Transeffered amount to customer successfully");
		
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("No sufficient Balance");
		}
		return response;
		
	}
	@GetMapping("/changepassword")
	public ResponseData changePassword(int customerid,String password) {
		boolean customer = service.changePassword(customerid, password);
		if (customer ==true) {
			response.setStatusCode(200);
			response.setMessage("Success");
			response.setDescription("password Changed");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("failed");
		}
		return response;
		
	}
}
