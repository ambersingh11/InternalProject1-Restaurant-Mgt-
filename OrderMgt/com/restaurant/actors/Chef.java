package com.restaurant.actors;

import java.io.*;
import com.restaurant.human_resource.Employee;
import com.restaurant.subjects.Order;

public class Chef extends Employee {
	private Order order;
	public void readOrders(){
		try {
			ObjectInputStream in=new ObjectInputStream(new FileInputStream(new File("resources//orders.ser")));
			order=(Order)in.readObject();
		} catch(ClassNotFoundException ex){
			ex.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	
}
