package com.wellsfargo.training.fargoloans.model;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.wellsfargo.training.fargoloans.model.Address;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Employee")
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long empId;
	
	@Column(name="empName", nullable = false)
	private String empName;
	
	@Column(name="designation")
	private String designation;
	
	@Column(name="department")
	private String department;
	
	@JsonFormat (pattern="yyyy-MM-dd")
	private Date dob;
	
	@JsonFormat (pattern="yyyy-MM-dd")
	private Date doj;
	
	public Employee() {
		
	}

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
	
	
	

}
