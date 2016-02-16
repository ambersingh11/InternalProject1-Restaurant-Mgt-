package com.restaurant.actors;

import java.io.*;
import java.util.*;
import com.restaurant.subjects.*;

public class Chef extends Observable {
	private List<Order> orders=new ArrayList<Order>();
	private ObjectInputStream in;
	private ChefDAO dao;
	private List<Item> items;
	public Chef(){
		try {
			in=new ObjectInputStream(new FileInputStream(new File("resources//orders.ser")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void readOrder(){
		try {
			orders.add((Order)in.readObject());
		} catch(ClassNotFoundException |IOException ex){
			ex.printStackTrace();}
	}
	
	public boolean validateOrder(Order order){
		dao=new ChefDAO();
		items=dao.retrieveItems();
		for(Item item : order.getItems())
			if(!(items.contains(item)) || item.getQuantity()>items.get(items.indexOf(item)).getQuantity())
				return false;
		return true;
	}
	public void prepareOrder(){
		for(Order order : orders){
			if(validateOrder(order)){
				try {
					Thread.sleep(3000);
					setChanged();
					notifyObservers(order);
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
			}else{
				setChanged();
				notifyObservers(order);
			}
		}
				
	}
	public List<Order> getOrder() {
		return orders;
	}
	public void setOrder(List<Order> orders) {
		this.orders = orders;
	}
	
}
