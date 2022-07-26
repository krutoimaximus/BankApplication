package com.bankapp.controllers;

import java.util.List;

import com.bankapp.dto.ResponseData;
import com.bankapp.entites.Logins;
import com.bankapp.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AdminRegisterController {
	@Autowired
	AdminService service;
	@Autowired(required = true)
	ResponseData response;

	@PostMapping("/addlogin")
	public ResponseData addLogins(@RequestBody Logins login) {
		if (service.addLogins(login)) {
			response.setStatusCode(200);
			response.setMessage("Success");
			response.setDescription("credentials is present");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("credentials Not exists");
		}
		return response;
	}
	
	@GetMapping("/bankapplogin")
	public ResponseData getAllLogins(){
		List<Logins> login=service.getAllLogins();
		if (login != null) {
			response.setStatusCode(200);
			response.setMessage("Success");
			response.setDescription("credentials is present");
			response.setLogin(login);
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("credentials Not exists");
		}
		return response;
	}
}
