package com.wellsfargo.training.fargoloans.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="loan_card_master")
public class Loan {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="loan_id")
	private long loanId;
	
	@Column(name="loan_type")
	private String loanType;
	
	@Column(name="duration_in_years")
	private int durationInYears;

	@OneToMany(cascade=CascadeType.ALL, mappedBy = "loan")
	@Column(name="employee_card_details")
	private List<EmployeeCard> cardIdsList= new ArrayList<>();

	public long getLoanId() {
		return loanId;
	}

	public void setLoanId(long loanId) {
		this.loanId = loanId;
	}

	public String getLoanType() {
		return loanType;
	}

	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}

	public int getDurationInYears() {
		return durationInYears;
	}

	public void setDurationInYears(int durationInYears) {
		this.durationInYears = durationInYears;
	}

	public List<EmployeeCard> getCardIdsList() {
		return cardIdsList;
	}

	public void setCardIdsList(List<EmployeeCard> cardIdsList) {
		this.cardIdsList = cardIdsList;
	}

	
}
