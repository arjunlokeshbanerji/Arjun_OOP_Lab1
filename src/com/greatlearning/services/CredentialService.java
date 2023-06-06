package com.greatlearning.services;

import com.greatlearning.interfaces.ICredentials;
import com.greatlearning.model.Employee;
import java.util.Random;

public class CredentialService implements ICredentials{

	
	private static final String LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";
    private static final String SPECIALS = "!@#$%&*()_+-=[]|,./?><";
    
	@Override
	public String generatePassword() {
		String passwordBuffer = LOWER+UPPER+DIGITS+SPECIALS;
		String password = "";
		Random randomGenerator = new Random();
		for (int i=0;i<8;i++) {
			password = password + passwordBuffer.charAt(randomGenerator.nextInt(passwordBuffer.length()));
		}
		return password;
	}

	@Override
	public String generateEmailAddress(Employee employee) {
		if(!employee.equals(null)) {
			return(employee.getFirstName().toLowerCase()+"."+employee.getLastName().toLowerCase()+"@"+employee.getDepartment()+".experis.com");
		}
		return null;
	}

	@Override
	public void showCredentials(Employee employee) {
		System.out.println("Welcome " + employee.getFirstName() + ", your generated credentials are as follows: ");
		System.out.println("Name- " + employee.getFirstName() + " " + employee.getLastName());
		System.out.println("Department- " + employee.getDepartment().toUpperCase());
		System.out.println("Email- " + employee.getEmail());
		System.out.println("Password- " + employee.getPassword());
		System.out.println("Please enjoy your stay and work at Experis!");
	}

}
