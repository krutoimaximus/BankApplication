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
@Table(name="transactions")
public class Transactions {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="trasactionid")
	private int transactionid;
	
	@Column(name="customerid")
	private int customerid;
	
	@Column(name="senderName")
	private String senderName;
	
	@Column(name="beneficiaryname")
	private String beneficiaryname;
	
	@Column(name="accountNo")
	private String accountNo;
	
	@Column(name="date")
	private String date;
	
	@Column(name="credit",columnDefinition="Integer default '0'" )
	private int credit;
	
	@Column(name="debit")
	private int debit;
	
//	@Column(name="amount")
//	private int amount;
	
	@Column(name="remarks")
	private String remarks;
}
