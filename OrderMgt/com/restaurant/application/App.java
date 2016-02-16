package com.restaurant.application;

import java.util.*;

import com.restaurant.actors.Chef;
import com.restaurant.actors.Waiter;
import com.restaurant.subjects.Item;
import com.restaurant.subjects.Table;

public class App {

	public static void main(String[] args) {
		List<Item> items=new ArrayList<Item>();
		items.add(new Item(233,"mix rice",560.00f,"veg"));
		items.add(new Item(345,"kadhai panner",578.00f,"veg"));
		Waiter waiter=new Waiter();
		waiter.assignTable(new Table(565),waiter.createOrder(1011,items));
		items=new ArrayList<Item>();
		items.add(new Item(234,"kurma makahni",430.00f,"veg"));
		items.add(new Item(346,"fried daal",534.00f,"veg"));
		
		waiter.assignTable(new Table(324),waiter.createOrder(1233,items));
		waiter.publishOrders();
		//System.out.println(waiter.);
		Chef chef=new Chef();
		chef.addObserver(waiter);
		chef.readOrder();
		chef.readOrder();
		//System.out.println(chef.getOrder());
		chef.prepareOrder();
	}

}
