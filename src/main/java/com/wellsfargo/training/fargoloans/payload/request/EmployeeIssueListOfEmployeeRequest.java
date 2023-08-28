package com.wellsfargo.training.fargoloans.payload.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EmployeeIssueListOfEmployeeRequest {
	private long employeeId;
	private String employeeIssueStatus;
	
}
