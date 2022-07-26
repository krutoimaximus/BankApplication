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
@Table(name="beneficiary")
public class Beneficiary {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="beneficiaryid")
	private int beneficiaryid;
	
	@Column(name="customerid")
	private int customerid;
	
	@Column(name="firstName")
	private String firstName;
	
	@Column(name="lastName")
	private String lastName;
	
	@Column(name="userName")
	private String userName;
	
	@Column(name="accountNo")
	private String accountNo;
	
	@Column(name="phone")
	private String phone;
}

