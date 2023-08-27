package com.wellsfargo.training.fargoloans.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="employee_master")
public class Employee {

	@Id
	@Column(name="employee_id")
	private long empId;
	
	@Column(name="employee_name")
	private String empName;
	
	@Column(name="password")
	private String password;
	
	public Employee() {}
	
	public Employee(long empId, String empName, String password, String designation, String department, Boolean isAdmin,
			Date dob, Date doj, List<EmployeeIssue> issueIdsList, List<EmployeeCard> empCardsList) {
		this.empId = empId;
		this.empName = empName;
		this.password = password;
		this.designation = designation;
		this.department = department;
		this.isAdmin = isAdmin;
		this.dob = dob;
		this.doj = doj;
		this.issueIdsList = issueIdsList;
		this.empCardsList = empCardsList;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name="designation")
	private String designation;
	
	@Column(name="department")
	private String department;
	
	@Column(name="is_admin")
	private Boolean isAdmin;
	
	public Boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	@JsonFormat (pattern="yyyy-MM-dd")
	@Column(name="date_of_birth")
	private Date dob;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@JsonFormat (pattern="yyyy-MM-dd")
	@Column(name="date_of_joining")
	private Date doj;
	
	@OneToMany(mappedBy = "employee", cascade=CascadeType.ALL)
	private List<EmployeeIssue> issueIdsList= new ArrayList<>();

	@OneToMany(mappedBy = "employee", cascade=CascadeType.ALL)
	@Column(name="card_ids")
	private List<EmployeeCard> empCardsList= new ArrayList<>();
	
	@OneToOne
	@JoinColumn(name="user_id")
	private User user;
	
	public long getEmpId() {
		return empId;
	}

	public void setEmpId(long empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Date getDoj() {
		return doj;
	}

	public void setDoj(Date doj) {
		this.doj = doj;
	}

	public List<EmployeeIssue> getIssueIdsList() {
		return issueIdsList;
	}

	public void setIssueIdsList(List<EmployeeIssue> issueIdsList) {
		this.issueIdsList = issueIdsList;
	}

	public List<EmployeeCard> getEmpCardsList() {
		return empCardsList;
	}

	public void setEmpCardsList(List<EmployeeCard> empCardsList) {
		this.empCardsList = empCardsList;
	}
	
	
}
