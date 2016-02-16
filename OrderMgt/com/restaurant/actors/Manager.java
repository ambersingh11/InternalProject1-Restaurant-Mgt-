package com.restaurant.actors;

import java.util.ArrayList;
import java.util.List;

import com.restaurant.human_resource.Employee;
import com.restaurant.subjects.Item;
import com.restaurant.subjects.Table;


public class Manager extends Employee {
private List<Waiter> waiters;
private Chef chef;
	public Manager(){
		super();
		waiters=new ArrayList<Waiter>();
		chef=new Chef();
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
				System.out.println("Table ID "+table.getTableID()+" Bill Amount "+waiter.getOrder(table).getOrderPrice());
			}
		}
			
	}
}
