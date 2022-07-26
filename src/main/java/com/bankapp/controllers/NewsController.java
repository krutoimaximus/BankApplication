package com.bankapp.controllers;

import java.util.List;

import com.bankapp.dto.ResponseData;
import com.bankapp.entites.AddNews;
import com.bankapp.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class NewsController {
	
	@Autowired(required=true)
	NewsService service;
	
	@Autowired
	ResponseData response;
	
	@PostMapping("/postnews")
	public ResponseData addNews(@RequestBody AddNews add) {
		if (service.addNews(add)) {
			response.setStatusCode(200);
			response.setMessage("Success");
			response.setDescription("News Added successfully");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("failed");
		}
		return response;
	}
	@GetMapping ("/allnews")
	public ResponseData getAllNews() {
		List<AddNews> news=service.getAllNews();
		if (news != null) {
			response.setStatusCode(200);
			response.setMessage("Success");
			response.setDescription("All news recieved");
			response.setNews(news);
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Failed to load");
		}
		return response;
	}
}
