package com.bankapp.controllers;

import java.util.List;

import com.bankapp.dto.ResponseData;
import com.bankapp.entites.Greviance;
import com.bankapp.service.GrevianceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class GrevianceController {
	
	@Autowired
	ResponseData response;
	
	@Autowired
	GrevianceService service;
	
	@PostMapping("/addgrevieance")
	private ResponseData addGrevieance(@RequestBody Greviance grevieance) {
		if (service.addGrevieance(grevieance)) {
			response.setStatusCode(200);
			response.setMessage("Success");
			response.setDescription("New Greviance Added successfully");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("failed");
		}
		return response;
	}
	@GetMapping("/allgrevieance")
	public ResponseData getAllGrevieance(int customerid) {
		List<Greviance> greviance=service.getAllGrevieance (customerid);
		if (greviance != null) {
			response.setStatusCode(200);
			response.setMessage("Success");
			response.setDescription("All Transactions Recieved");
			response.setGreviance(greviance);
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Failed to load");
		}
		return response;
	}
	
	@GetMapping("/acceptgrevience")
	public ResponseData acceptGrevieance(int grevieanceid) {
		boolean greviance = service.acceptGrevieance(grevieanceid);
		if (greviance ==true) {
			response.setStatusCode(200);
			response.setMessage("Success");
			response.setDescription("Accepted Grevience successfully");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("failed");
		}
		return response;
	}
	@GetMapping("/declinegrevience")
	public ResponseData declineGrevieance(int grevieanceid) {
		boolean greviance = service.declineGrevieance(grevieanceid);
		if (greviance ==true) {
			response.setStatusCode(200);
			response.setMessage("Success");
			response.setDescription("Rejected Grevieance");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("failed");
		}
		return response;
	}
	@GetMapping("/allqueue")
	public  ResponseData getAllGreviance(){
		List<Greviance> greviance=service. getAllGreviance();
		if (greviance != null) {
			response.setStatusCode(200);
			response.setMessage("Success");
			response.setDescription("All Greviance recieved");
			response.setGreviance(greviance);
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Failed to load");
		}
		return response;
	}	

}
