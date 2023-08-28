package com.wellsfargo.training.fargoloans.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "loan_card_master")
@NoArgsConstructor
@Getter
@Setter
public class Loan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "loan_id")
	private long loanId;

	@Column(name = "loan_type")
	private String loanType;

	@Column(name = "duration_in_years")
	private int durationInYears;

	// @OneToMany(cascade=CascadeType.ALL, mappedBy = "loan")
	// @Column(name="employee_issue_details")
	// @JsonBackReference
	// private List<EmployeeIssue> employeeIssueList= new ArrayList<>();

	// @OneToMany(cascade=CascadeType.ALL, mappedBy = "loan")
	// @Column(name="employee_card_details")
	//// @JsonBackReference
	// @JsonIgnore
	// private List<EmployeeCard> employeeCardList= new ArrayList<>();

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

	public Loan(long loanId, String loanType, int durationInYears) {
		super();
		this.loanId = loanId;
		this.loanType = loanType;
		this.durationInYears = durationInYears;
	}

	// public List<EmployeeIssue> getEmployeeIssueList() {
	// return employeeIssueList;
	// }
	//
	// public void setEmployeeIssueList(List<EmployeeIssue> employeeIssueList) {
	// this.employeeIssueList = employeeIssueList;
	// }
	//
	// public List<EmployeeCard> getEmployeeCardList() {
	// return employeeCardList;
	// }
	//
	// public void setEmployeeCardList(List<EmployeeCard> employeeCardList) {
	// this.employeeCardList = employeeCardList;
	// }

}
