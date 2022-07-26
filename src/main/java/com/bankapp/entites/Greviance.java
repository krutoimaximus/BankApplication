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
@Table(name="greviance")
public class Greviance {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="grevieanceid")
	private int grevieanceid;
	
	@Column(name="customerid")
	private int customerid;
	
	@Column(name="firstName")
	private String firstName;
	
	@Column(name="service")
	private String service;
	
	@Column(name="details")
	private String details;
	
	@Column(name="status")
	private String status="pending";

}
