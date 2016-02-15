package com.restaurant.human_resource;

import com.restaurant.util.*;

public class Employee {
	private int empID;
	private String empName;
	private EmployeeTypes empType;
	private String userName;
	private String passWord;
	
	
	@Override
	public String toString() {
		return "Employee [empID=" + empID + ", empName=" + empName + ", empType=" + empType + ", userName=" + userName
				+ ", passWord=" + passWord + "]";
	}

	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Employee(int empID, String empName, EmployeeTypes empType, String userName, String passWord) {
		super();
		this.empID = empID;
		this.empName = empName;
		this.empType = empType;
		this.userName = userName;
		this.passWord = passWord;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public int getEmpID() {
		return empID;
	}
	public void setEmpID(int empID) {
		this.empID = empID;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public EmployeeTypes getType() {
		return empType;
	}
	public void setType(EmployeeTypes type) {
		this.empType = type;
	}
	
}
