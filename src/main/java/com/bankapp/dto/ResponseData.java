package com.bankapp.dto;

import java.util.List;

import org.springframework.stereotype.Component;

import com.bankapp.entites.AddNews;
import com.bankapp.entites.Beneficiary;
import com.bankapp.entites.Customers;
import com.bankapp.entites.Greviance;
import com.bankapp.entites.Logins;
import com.bankapp.entites.Transactions;

import lombok.Data;

@Component
@Data
public class ResponseData {
//			private String msg;
//			private Object data;
		
			private int statusCode;
			private String message;
			private String description;
			private List<AddNews> news;
			private List<Beneficiary>beneficiary;
			private List<Greviance>greviance;
			private List<Logins>login;
			private List<Transactions>transaction;
			private List<Customers>customer;
	
}
