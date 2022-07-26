package com.bankapp.dao;

import java.util.List;

import com.bankapp.entites.AddNews;

public interface NewsDao {

	public boolean addNews(AddNews add);
	
	public List<AddNews> getAllNews();
}
