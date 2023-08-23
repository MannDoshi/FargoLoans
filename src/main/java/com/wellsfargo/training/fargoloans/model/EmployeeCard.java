package com.wellsfargo.training.fargoloans.model;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="employee_card_details")
public class EmployeeCard {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="card_id")
	private long cardId;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="employee_id")
	private Employee employee;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="loan_id")
	private Loan loan;
	
	@Column(name="card_issue_date")
	private Date cardIssueDate;

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Loan getLoan() {
		return loan;
	}

	public void setLoan(Loan loan) {
		this.loan = loan;
	}

	public Date getCardIssueDate() {
		return cardIssueDate;
	}

	public void setCardIssueDate(Date cardIssueDate) {
		this.cardIssueDate = cardIssueDate;
	}
	
	
}
