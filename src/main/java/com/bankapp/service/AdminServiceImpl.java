package com.bankapp.service;

import java.util.List;

import com.bankapp.entites.Logins;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankapp.dao.AdminDao;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	AdminDao dao;
	@Override
	public boolean addLogins(Logins login) {
		return dao.addLogins(login);
	}
	
	@Override
	public List<Logins> getAllLogins() {
		return dao.getAllLogins();
	}

}
