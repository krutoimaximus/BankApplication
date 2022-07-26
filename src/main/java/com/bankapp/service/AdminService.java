package com.bankapp.service;

import java.util.List;

import com.bankapp.entites.Logins;

public interface AdminService {

	 public boolean addLogins(Logins login);

	 public List<Logins> getAllLogins();
	
}
