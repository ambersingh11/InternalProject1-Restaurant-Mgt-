package com.restaurant.human_resource;

import java.sql.*;
import java.util.*;
import com.restaurant.human_resource.ifaces.*;
import com.restaurant.util.EmployeeTypes;
import com.restaurant.util.SqlConnection;



public class EmployeeDAO implements DAO<Employee>{
	private Connection con;
	public EmployeeDAO() {
		super();
		con=SqlConnection.getConnection();
	}

	@Override
	public int add(Employee t) {
		String sql1="insert into EMPLOYEEDETAILS values(?,?,?)";
		String sql2="insert into RESTAURANTUSERS values(?,?)";
		int rowAdded=0;
		try{
			PreparedStatement pstmt=con.prepareStatement(sql1);
			pstmt.setInt(1,t.getEmpID());
			pstmt.setString(2,t.getEmpName());
			pstmt.setString(3,t.getType().name());
			rowAdded+=pstmt.executeUpdate();
			pstmt=con.prepareStatement(sql2);
			pstmt.setString(1,t.getUserName());
			pstmt.setString(2,t.getPassWord());
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return rowAdded;
		
	}

	@Override
	public Employee find(int key) {
		String sql1="select * from EMPLOYEEDETAILS where EMPID=?";
		String sql2="select * from RESTAURANTUSERS where EID=?";
		try{
			PreparedStatement pstmt=con.prepareStatement(sql1);
			pstmt.setInt(1,key);
			ResultSet rs1=pstmt.executeQuery();
			pstmt=con.prepareStatement(sql2);
			pstmt.setInt(1,key);
			ResultSet rs2=pstmt.executeQuery();
			while(rs1.next()&&rs2.next()){
				int empID=rs1.getInt("EMPID");
				String empName=rs1.getString("EMPNAME");
				String empType=rs1.getString("EMPTYPE");
				String userName=rs2.getString("USERNAME");
				String passWord=rs2.getString("PASSWORD");
				
				return new Employee(empID,empName,EmployeeTypes.newEmployeeType(empType),userName,passWord);
			}
		}catch(Exception ex){ex.printStackTrace();}
		return null;
	}

	@Override
	public List<Employee> finaAll() {
		String sql1="select * from EMPLOYEEDETAILS";
		String sql2="select * from RESTAURANTUSERS";
		List<Employee> lst=new ArrayList<Employee>();
		try{
			Statement stmt=con.createStatement();
			ResultSet rs1=stmt.executeQuery(sql1);
			stmt=con.createStatement();
			ResultSet rs2=stmt.executeQuery(sql2);
			while(rs1.next()&&rs2.next()){
				int empID=rs1.getInt("EMPID");
				String empName=rs1.getString("EMPNAME");
				String empType=rs1.getString("EMPTYPE");
				String userName=rs2.getString("USERNAME");
				String passWord=rs2.getString("PASSWORD");
				lst.add(new Employee(empID,empName,EmployeeTypes.newEmployeeType(empType),userName,passWord));
			}
		}catch(Exception ex){ex.printStackTrace();}
		return lst;
	}

	/*@Override
	public int update(int key, long newSal) {
		
	}*/

	@Override
	public int delete(int key) {
		String sql="delete from EMPLOYEEDETAILS where EMPID=?";
		int i=0;
		try{
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,key);
			i=pstmt.executeUpdate();
		}catch(Exception ex){ex.printStackTrace();}
		return i;
	}

}
