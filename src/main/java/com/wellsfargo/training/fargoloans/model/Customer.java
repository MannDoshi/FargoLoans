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
@Table(name="customer")
public class Customer {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long custId;
	
	@Column(unique=true)
	private String email;
	
	@Column(name="first_name", nullable = false)
	private String fname;
	
	@Column(name="last_name")
	private String lname;
	
	private String password;
	
	@JsonFormat (pattern="yyyy-MM-dd")
	private Date dob;
	
	@Column(name="phone")
	private String phoneNo;
	
	// Modelling One to One Relationship between Dealer and Address classes
	@OneToOne(mappedBy="customer", cascade = CascadeType.ALL)
	private Address address;

	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public Long getCustId() {
		return custId;
	}

	public void setCustId(Long custId) {
		this.custId = custId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	

}
