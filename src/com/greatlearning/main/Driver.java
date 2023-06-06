package com.greatlearning.main;

import com.greatlearning.model.Employee;
import com.greatlearning.services.*;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		execProcedure(new Employee("Mythili", "Ravichandran"));
	}
	
	
	private static Employee setDepartment(int departmentChoice, Employee employee) {
		if(departmentChoice == 1) {
			employee.setDepartment("tech");
		}	else if(departmentChoice == 2){
			employee.setDepartment("admin");
		}	else if(departmentChoice == 3){
			employee.setDepartment("hr");
		}	else if(departmentChoice == 4){
			employee.setDepartment("legal");
		}	else if(departmentChoice == 5){
			employee.setDepartment("finance");
		}
		return employee;
	}
	private static void displayMenu() {
		System.out.println("Please choose a department:");
		System.out.println("1. Tech");
		System.out.println("2. Admin");
		System.out.println("3. Human Resources");
		System.out.println("4. Legal");
		System.out.println("5. Finance");
	}
	
	private static void execProcedure(Employee employee) {
		displayMenu();
		Scanner scanner = new Scanner(System.in);
		int department = scanner.nextInt();
		employee = setDepartment(department, employee);
		scanner.close();
		CredentialService credService = new CredentialService();
		employee.setEmail(credService.generateEmailAddress(employee));
		employee.setPassword(credService.generatePassword());
		credService.showCredentials(employee);
	}

}
