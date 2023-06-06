package com.greatlearning.interfaces;

import com.greatlearning.model.Employee;

public interface ICredentials {
	public String generatePassword();
	public String generateEmailAddress(Employee employee);
	public void showCredentials(Employee employee);
}
