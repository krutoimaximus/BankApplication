package com.bankapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import com.bankapp.entites.AddNews;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class NewsDaoImpl implements NewsDao {
	
	@Autowired
	EntityManager manager;

	@Override
	@Transactional
	public boolean addNews(AddNews add) {
		manager.persist(add);
		return true;
	}
	@Override
	public List<AddNews> getAllNews() {
		TypedQuery<AddNews> query = manager.createQuery("From AddNews", AddNews.class);
		return query.getResultList();
	}

}
