package com.restaurant.human_resource.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.restaurant.human_resource.Employee;
import com.restaurant.util.SqlConnection;


public class ValidateEmp {
	public static boolean validate(Employee emp){
		ResultSet rs;
		try{
			Connection con=SqlConnection.getConnection();
			PreparedStatement stmt=con.prepareStatement("select * from RESTAURANTUSERS where username=? and password=?");
			
			stmt.setString(1,emp.getUserName());
			stmt.setString(2,emp.getPassWord());
			rs=stmt.executeQuery();
			if(rs.next())
				return true;
			/*while(rs.next()){
				if(usr.getUserName().equals(rs.getString(1))&&usr.getPassWord().equals(rs.getString(2))&&usr.getRole().equals(rs.getString(3)))
					return true;
			}*/
		}catch(Exception ex){ex.printStackTrace();}	
		
		
		return false;
	}
}
