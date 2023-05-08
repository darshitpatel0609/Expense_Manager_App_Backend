package com.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_income")
public class UserIncomeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userIncomeId;
	private Integer totalIncome;
	private Integer monthlyExpenditure;
	private Integer weeklyExpenditure;

	public Integer getUserIncomeId() {
		return userIncomeId;
	}

	public void setUserIncomeId(Integer userIncomeId) {
		this.userIncomeId = userIncomeId;
	}

	public Integer getTotalIncome() {
		return totalIncome;
	}

	public void setTotalIncome(Integer totalIncome) {
		this.totalIncome = totalIncome;
	}

	public Integer getMonthlyExpenditure() {
		return monthlyExpenditure;
	}

	public void setMonthlyExpenditure(Integer monthlyExpenditure) {
		this.monthlyExpenditure = monthlyExpenditure;
	}

	public Integer getWeeklyExpenditure() {
		return weeklyExpenditure;
	}

	public void setWeeklyExpenditure(Integer weeklyExpenditure) {
		this.weeklyExpenditure = weeklyExpenditure;
	}

}