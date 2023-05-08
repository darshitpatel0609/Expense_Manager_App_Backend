package com.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "manage_income")
public class IncomeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer incomeId;
	private Integer totalIncome;
	private Integer monthlyExpenditure;
	private Integer weeklyExpenditure;

	public Integer getIncomeId() {
		return incomeId;
	}

	public void setIncomeId(Integer incomeId) {
		this.incomeId = incomeId;
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
