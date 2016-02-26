package com.restaurant.actors;

import java.util.ArrayList;
import java.util.List;

import com.restaurant.human_resource.Employee;
import com.restaurant.subjects.*;


public class Manager extends Employee {
private static List<Waiter> waiters;
private Chef chef;
	public Manager(){
		super();
		waiters=new ArrayList<Waiter>();
		chef=new Chef();
	}
	public static Order locateOrder(int orderID){
		for(Waiter waiter : waiters){
			for(Table table : waiter.getTables()){
				if(waiter.getOrder(table).getOrderID()==orderID)
					return waiter.getOrder(table);
			}
		}
			return null;
	}
	public void greetCustomer(int tableID,int orderID,List<Item> items){
		Waiter waiter=new Waiter();
		waiter.assignTable(new Table(tableID),waiter.createOrder(orderID,items));
		waiters.add(waiter);
		
	}
	public void manageOrders(){
		for(Waiter waiter : waiters){
			waiter.publishOrders();
			chef.addObserver(waiter);
		}
		chef.readOrder();
		chef.readOrder();
		chef.prepareOrder();
	}
	public void generateBills(){
		for(Waiter waiter : waiters){
			for(Table table : waiter.getTables()){
				if(waiter.getOrder(table).isPending())
					System.out.println("Table ID: "+table.getTableID()+" Order ID: "+waiter.getOrder(table).getOrderID()+" Bill Amount: Order Pending!!!");
				else
					System.out.println("Table ID: "+table.getTableID()+" Order ID: "+waiter.getOrder(table).getOrderID()+" Bill Amount: "+waiter.getOrder(table).getOrderPrice());
			}
			
		}
			
	}
}
