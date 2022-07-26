package com.bankapp.controllers;

import java.util.List;

import com.bankapp.dto.ResponseData;
import com.bankapp.entites.Beneficiary;
import com.bankapp.service.BeneficiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin
@RestController
public class BeneficiaryController {
	
	
	@Autowired(required = true)
    BeneficiaryService service;
	
	@Autowired
	private ResponseData response;
	
	@PostMapping("/addBeneficiary")
	public ResponseData addBeneficiary(@RequestBody Beneficiary beneficiary) {
		if (service.addBeneficiary(beneficiary)) {
			response.setStatusCode(200);
			response.setMessage("Success");
			response.setDescription("beneficiary added successfully");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("failed to add");
		}
		return response;
	}
	@GetMapping("/allbeneficiary")
	public ResponseData getAllBeneficiary(int customerid){
		List<Beneficiary> beneficiary=service.getAllBeneficiary(customerid);
		if (beneficiary != null) {
			response.setStatusCode(200);
			response.setMessage("Success");
			response.setDescription("All Beneficiaries recieved");
			response.setBeneficiary(beneficiary);
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Failed to load");
		}
		return response;
	}
	@DeleteMapping("/beneficiary")
	public ResponseData deleteBeneficiary(int beneficiaryid) {
		if (service.deleteBeneficiary(beneficiaryid)) {
			response.setStatusCode(200);
			response.setMessage("Success");
			response.setDescription("deleted benficiary successfully");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("failed to delete");
		}
		return response;
	}

}
