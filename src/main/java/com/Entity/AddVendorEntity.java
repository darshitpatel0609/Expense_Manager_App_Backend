package com.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_add_vendor")
public class AddVendorEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userVendorId;
	private String userVendorName;

	public Integer getUserVendorId() {
		return userVendorId;
	}

	public void setUserVendorId(Integer userVendorId) {
		this.userVendorId = userVendorId;
	}

	public String getUserVendorName() {
		return userVendorName;
	}

	public void setUserVendorName(String userVendorName) {
		this.userVendorName = userVendorName;
	}

}
