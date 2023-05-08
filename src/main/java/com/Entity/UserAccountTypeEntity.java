package com.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_account_type")
public class UserAccountTypeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userAccountId;
	private String accountName;
	private Integer displayValue;

	public Integer getUserAccountId() {
		return userAccountId;
	}

	public void setUserAccountId(Integer userAccountId) {
		this.userAccountId = userAccountId;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public Integer getDisplayValue() {
		return displayValue;
	}

	public void setDisplayValue(Integer displayValue) {
		this.displayValue = displayValue;
	}

}
