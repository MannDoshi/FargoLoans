package com.wellsfargo.training.fargoloans.dataviews;

import java.sql.Date;

import com.wellsfargo.training.fargoloans.model.User;

public interface EmployeeDetails{
	 
	long getEmpId();
	String getDesignation();
	String getDepartment();
	Date getDoj();
	User getUser();
}
