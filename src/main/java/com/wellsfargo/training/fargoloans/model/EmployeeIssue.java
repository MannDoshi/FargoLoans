package com.wellsfargo.training.fargoloans.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

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
public class EmployeeIssue {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="issue_id")
	private long issueId;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="employee_id")
	private Employee employee;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="item_id")
	private Item item;
	
	@Column(name="issue_date")
	@JsonFormat (pattern="yyyy-MM-dd")
	private Date issueDate;
	
	@JsonFormat (pattern="yyyy-MM-dd")
	@Column(name="return_date")
	private Date return_date;

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

	
	
}
