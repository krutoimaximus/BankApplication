package com.bankapp.dao;

import java.util.List;

import com.bankapp.entites.Logins;

public interface AdminDao {

	 public boolean addLogins(Logins login);

	 public List<Logins> getAllLogins();
	
}
