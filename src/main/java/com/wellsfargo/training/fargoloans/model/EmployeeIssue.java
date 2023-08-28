package com.wellsfargo.training.fargoloans.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.wellsfargo.training.fargoloans.enums.EmployeeIssueStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "employee_issue_details")
@NoArgsConstructor
@Getter
@Setter
public class EmployeeIssue {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "issue_id")
	private long issueId;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "employee_id")
	// @JsonIgnore
	// @JsonManagedReference
	private Employee employee;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "item_id")
	// @JsonIgnore
	// @JsonManagedReference
	private Item item;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "loan_id")
	// @JsonIgnore
	// @JsonManagedReference
	private Loan loan;

	@Column(name = "issue_date")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date issueDate;

	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name = "return_date")
	private Date return_date;

	@Enumerated(EnumType.STRING)
	@Column(name = "issue_status", columnDefinition = "varchar(32) default 'WAITING' ")
	private EmployeeIssueStatus issueStatus = EmployeeIssueStatus.WAITING;

	@Column(name = "item_value")
	private String itemValue;

	@Column(name = "item_make")
	private String itemMake;

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

	public Loan getLoan() {
		return loan;
	}

	public void setLoan(Loan loan) {
		this.loan = loan;
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

	public EmployeeIssueStatus getIssueStatus() {
		return issueStatus;
	}

	public void setIssueStatus(EmployeeIssueStatus issueStatus) {
		this.issueStatus = issueStatus;
	}

	public void setIssueStatus(String issueStatus) {
		this.issueStatus = EmployeeIssueStatus.valueOf(issueStatus);
	}

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

}
