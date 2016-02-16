package com.restaurant.application;

import java.util.*;

import com.restaurant.actors.Chef;
import com.restaurant.actors.Manager;
import com.restaurant.actors.Waiter;
import com.restaurant.subjects.Item;
import com.restaurant.subjects.Table;

public class App {

	public static void main(String[] args) {
		List<Item> items=new ArrayList<Item>();
		items.add(new Item(233,"mix rice",560.00f,"veg",2));
		items.add(new Item(345,"kadhai panner",578.00f,"veg",3));

		Manager manager=new Manager();
		manager.greetCustomer(234,1244,items);
		
		items=new ArrayList<Item>();
		items.add(new Item(234,"kurma makahni",430.00f,"veg",3));
		items.add(new Item(346,"fried daal",534.00f,"veg",1));
		manager.greetCustomer(655,2345,items);
		
		manager.manageOrders();
		manager.generateBills();
	}

}
