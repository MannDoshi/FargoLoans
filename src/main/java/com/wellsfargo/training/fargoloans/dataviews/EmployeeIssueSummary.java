package com.wellsfargo.training.fargoloans.dataviews;

import java.sql.Date;

import com.wellsfargo.training.fargoloans.model.Loan;
import com.wellsfargo.training.fargoloans.model.User;

public interface EmployeeIssueSummary {
	long getIssueId();

	long getItemValue();

	Loan getLoan();
}