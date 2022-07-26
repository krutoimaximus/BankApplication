package com.bankapp.service;

import java.util.List;

import com.bankapp.entites.AddNews;

public interface NewsService {

	public boolean addNews(AddNews add);
	 
	 public List<AddNews> getAllNews(); 
}
