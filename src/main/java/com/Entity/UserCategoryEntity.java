package com.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_category")
public class UserCategoryEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userCategoryId;
	private String userCategoryName;


	public Integer getUserCategoryId() {
		return userCategoryId;
	}

	public void setUserCategoryId(Integer userCategoryId) {
		this.userCategoryId = userCategoryId;
	}

	public String getUserCategoryName() {
		return userCategoryName;
	}

	public void setUserCategoryName(String userCategoryName) {
		this.userCategoryName = userCategoryName;
	}

}
