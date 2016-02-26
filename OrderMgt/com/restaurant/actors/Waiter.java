package com.restaurant.actors;

import java.io.*;
import java.util.*;

import com.restaurant.human_resource.Employee;
import com.restaurant.subjects.Item;
import com.restaurant.subjects.Order;
import com.restaurant.subjects.Table;

public class Waiter extends Employee implements Observer{
	private HashMap<Table,Order> tables;
	private double collection;
	private static ObjectOutputStream out;
	static{
		try {
			out=new ObjectOutputStream(new FileOutputStream(new File("resources//orders.ser")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Waiter(){
		tables=new HashMap<Table,Order>();
		
	}
	
	public Order createOrder(int orderID, List<Item> items){
		Order order=new Order(orderID,items);
		order.setOrderPrice();
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
	public double getCollection(){
		for(Table table : tables.keySet())
			collection += tables.get(table).getOrderPrice();
		return collection;
	}
	public void publishOrders(){
		try{
			
			for(Table table : tables.keySet()){
				out.writeObject(tables.get(table));
				
			}
			
			
		}catch(IOException ex){ex.printStackTrace();}
	}

	@Override
	public void update(Observable o, Object arg) {
		if(tables.containsValue((Order)arg)){
			if(((Order)arg).isPending()){
				alterOrder((Order)arg);
					
			}
			else{
				System.out.println("Order no. "+((Order) arg).getOrderID()+" Prepared");
				
			}
		}
		
	}
	public void alterOrder(Order order){
		System.out.println(" bad order...update order no "+order.getOrderID());
	}
	
}
