package com.Entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_expense")
public class UserExpenseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userExpenseId;
	private float amount;
	private float payee;
	private boolean status;
	private String description;
	private Date date;

	public Integer getUserExpenseId() {
		return userExpenseId;
	}

	public void setUserExpenseId(Integer userExpenseId) {
		this.userExpenseId = userExpenseId;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public float getPayee() {
		return payee;
	}

	public void setPayee(float payee) {
		this.payee = payee;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
