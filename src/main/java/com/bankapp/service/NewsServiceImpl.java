package com.bankapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankapp.dao.NewsDao;
import com.bankapp.entites.AddNews;
@Service
public class NewsServiceImpl implements NewsService{
	
	@Autowired
	NewsDao dao;
	
	@Override
	public boolean addNews(AddNews add) {
		return dao.addNews(add);
	}
	@Override
	public List<AddNews> getAllNews() {
		
		return dao.getAllNews();
	}

}
