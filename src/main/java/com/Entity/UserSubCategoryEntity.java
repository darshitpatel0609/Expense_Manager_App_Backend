package com.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_sub_category")
public class UserSubCategoryEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userSubCategoryId;
	private String userSubCategoryName;

	

	public Integer getUserSubCategoryId() {
		return userSubCategoryId;
	}

	public void setUserSubCategoryId(Integer userSubCategoryId) {
		this.userSubCategoryId = userSubCategoryId;
	}

	public String getUserSubCategoryName() {
		return userSubCategoryName;
	}

	public void setUserSubCategoryName(String userSubCategoryName) {
		this.userSubCategoryName = userSubCategoryName;
	}

}
