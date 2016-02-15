package com.restaurant.util;
import java.io.*;
import java.sql.*;
import java.util.Properties;
public class SqlConnection {
	public static Connection getConnection(){
		Connection con=null;
		try {
			Properties prop=new Properties();
			FileInputStream in=new FileInputStream(new File("resources//DbConnection.properties"));
			prop.load(in);
			
			Class.forName(prop.getProperty("db.className"));
			con=DriverManager.getConnection(prop.getProperty("db.url"),prop.getProperty("db.userName"),prop.getProperty("db.passWord"));
		
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}
}
