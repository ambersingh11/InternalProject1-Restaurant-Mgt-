package com.restaurant.actors;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.restaurant.human_resource.Employee;
import com.restaurant.subjects.Item;
import com.restaurant.util.EmployeeTypes;
import com.restaurant.util.SqlConnection;

public class ChefDAO {
	private Connection con;
	public ChefDAO(){
		super();
		con=SqlConnection.getConnection();
	}
	public List<Item> retrieveItems(){
		String sql="select * from ITEM";
		List<Item> lst=new ArrayList<Item>();
		try{
			Statement stmt=con.createStatement();
			ResultSet rs1=stmt.executeQuery(sql);
			while(rs1.next()){
				int itemID=rs1.getInt("ITEMID");
				String itemName=rs1.getString("ITEMNAME");
				float itemPrice=rs1.getFloat("ITEMPRICE");
				String itemCategory=rs1.getString("CATEGORY");
				int quantity=rs1.getInt("QUANTITY");
				lst.add(new Item(itemID,itemName,itemPrice,itemCategory,quantity));
			}
		}catch(Exception ex){ex.printStackTrace();}
		return lst;
	}
}
