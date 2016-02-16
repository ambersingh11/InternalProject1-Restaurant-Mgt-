package com.restaurant.human_resource.login;

import com.restaurant.human_resource.Employee;
import com.restaurant.human_resource.EmployeeDAO;

public class Login {

	public static void main(String[] args) {
		EmployeeDAO dao=new EmployeeDAO();
		Employee emp=dao.find(101);
		emp.setUserName("ads");
		System.out.println(ValidateEmp.validate(emp));
		
		//System.out.println(dao.finaAll());
		//dao.delete(102);
		//System.out.println(dao.finaAll());
	}

}
