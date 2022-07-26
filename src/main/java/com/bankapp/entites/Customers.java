package com.bankapp.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity 
@Data
@Table(name="Customers")
public class Customers {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="customerid")
	private int customerid;

	@Column(name="first")
	private String first;
	
	@Column(name="last")
	private String last;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="dob")
	private String dob;
	
	@Column(name="aadhar")
	private String aadhar;
	
	@Column(name="email")
	private String email;
	
	@Column(name="phone")
	private String phone;
	
	@Column(name="address")
	private String address;
	
	@Column(name="branch")
	private String branch;
	
	@Column(name="accountno")
	private String accountno;
	
	@Column(name="balance")
	private int balance;
	
	@Column(name="pin")
	private String pin;
	
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@Column(name="type")
	private String type ="user";
}

