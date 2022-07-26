package com.bankapp.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="addnews")
@Data
public class AddNews {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="newsid")
	private int newsid;
	
	@Column(name="newshead")
	private String newshead;
	
	@Column(name="newsdetails")
	private String newsdetails;
}