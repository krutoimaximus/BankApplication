package com.bankapp.controllers;

import java.util.List;

import com.bankapp.service.TransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.dto.ResponseData;
import com.bankapp.entites.Transactions;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TransactionsController {
	
	@Autowired
	ResponseData response;
	
	@Autowired
	TransactionsService service;
	
	@PostMapping("/addtransaction")
	public ResponseData addTransaction(@RequestBody Transactions transaction) {	
		if (service.addTransaction(transaction)) {
			response.setStatusCode(200);
			response.setMessage("Success");
			response.setDescription("New Transaction Added successfully");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("failed");
		}
		return response;
	}
	@GetMapping("/transactions")
	public ResponseData customerCredit(int customerid) {
//		ResponseData response=new ResponseData();
//		response.setMsg("transaction");
//		response.setData();
//		return response;	
		
		List<Transactions> transaction = service.customerCredit(customerid);
		if (transaction !=null) {
			response.setStatusCode(200);
			response.setMessage("Success");
			response.setDescription("Credited customer successfully");
			response.setTransaction(transaction);
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("failed to validate");
		}
		return response;
	}
	@GetMapping("/transactionbyname")
	public ResponseData getTransactionByName(String beneficiaryname) {
		List<Transactions> transaction = service.getTransactionByName(beneficiaryname);
		if (transaction !=null) {
			response.setStatusCode(200);
			response.setMessage("Success");
			response.setDescription("Recieved Transaction details successfully");
			response.setTransaction(transaction);
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("failed to validate");
		}
		return response;
	}
	@GetMapping("/alltransactions")
	public ResponseData getAllTransactions() {	
		List<Transactions> transaction=service.getAllTransactions();
		if (transaction != null) {
			response.setStatusCode(200);
			response.setMessage("Success");
			response.setDescription("All Transactions Recieved");
			response.setTransaction(transaction);
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Failed to load");
		}
		return response;
		
	}

}
