package com.restaurant.actors;

import java.io.*;
import java.util.*;

import com.restaurant.human_resource.Employee;
import com.restaurant.subjects.Item;
import com.restaurant.subjects.Order;
import com.restaurant.subjects.Table;

public class Waiter extends Employee{
	private HashMap<Table,Order> tables;
	private float collection;
	public Waiter(){
		tables=new HashMap<Table,Order>();
		
	}
	
	public Order createOrder(int orderID, List<Item> items){
		Order order=new Order(orderID,items);
		order.getOrderPrice();
		return order;
	}
	public void assignTable(Table table,Order order){
		tables.put(table,order);
	}
	public Set<Table> getTables(){
		return this.tables.keySet();
	}
	public Order getOrder(Table table){
		return tables.get(table);
	}
	public float getCollection(){
		for(Table table : tables.keySet())
			collection += tables.get(table).getOrderPrice();
		return collection;
	}
	public void publishOrders(){
		for(Table table : tables.keySet()){
			try{
				ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(new File("resources//orders.ser")));
				out.writeObject(tables.get(table));
				out.close();
				
			}catch(IOException ex){ex.printStackTrace();}
		}
	}
	
}
