package com.winvest.data;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

@Document(collection = "transactions")
public class Transaction {

	@Id
	private String id;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private Date createdDate;

	private String text;
	
	private Double amount;
	
	private String type;


	// TODO need to set dynamic
	private String belongToUser = "Aditya";

	public String getBelongToUser() {
		return belongToUser;
	}

	public void setBelongToUser(String belongToUser) {
		this.belongToUser = belongToUser;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
