package com.wellsfargo.training.fargoloans.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
@Table(name="employee_issue_details")
public class EmployeeIssue{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="issue_id")
	private long issueId;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="employee_id")
//	@JsonManagedReference
	private Employee employee;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="item_id")
	private Item item;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="loan_id")
	private Loan loan;
	
	public Loan getLoan() {
		return loan;
	}

	public void setLoan(Loan loan) {
		this.loan = loan;
	}

	@Column(name="issue_date")
	@JsonFormat (pattern="yyyy-MM-dd")
	private Date issueDate;
	
	@JsonFormat (pattern="yyyy-MM-dd")
	@Column(name="return_date")
	private Date return_date;
	
	@Column(name="issue_status")
//	YES, NO, default?
	private String issueStatus;
	
	@Column(name="item_value")
	private String itemValue;
	
	@Column(name="item_make")
	private String itemMake;

	public String getItemValue() {
		return itemValue;
	}

	public void setItemValue(String itemValue) {
		this.itemValue = itemValue;
	}

	public String getItemMake() {
		return itemMake;
	}

	public void setItemMake(String itemMake) {
		this.itemMake = itemMake;
	}

	public void setIssueStatus(String issueStatus) {
		this.issueStatus = issueStatus;
	}

	public long getIssueId() {
		return issueId;
	}

	public void setIssueId(long issueId) {
		this.issueId = issueId;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public Date getReturn_date() {
		return return_date;
	}

	public void setReturn_date(Date return_date) {
		this.return_date = return_date;
	}

	public String getIssueStatus() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
