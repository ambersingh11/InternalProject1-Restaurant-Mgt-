package com.restaurant.util;

public enum EmployeeTypes {
	ADMIN,
	WAITER,
	MANAGER;
	public static EmployeeTypes newEmployeeType(String type){
		switch(type){
		case "ADMIN":
			return EmployeeTypes.ADMIN;
		case "WAITER":
			return EmployeeTypes.WAITER;
		case "MANAGER":
			return EmployeeTypes.MANAGER;
		default:
			return null;
		}
	}
	
}
