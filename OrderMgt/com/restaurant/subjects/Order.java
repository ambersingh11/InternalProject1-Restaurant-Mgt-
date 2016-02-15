package com.restaurant.subjects;

import java.io.Serializable;
import java.util.List;

public class Order implements Serializable{
	private int orderID;
	private List<Item> items;
	private float orderPrice;
	
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(int orderID, List<Item> items) {
		super();
		this.orderID = orderID;
		this.items = items;
	}
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
	public float getOrderPrice() {
		for(Item item : items)
			orderPrice += item.getItemPrice();
		return orderPrice;
	}
	@Override
	public String toString() {
		return "Order [orderID=" + orderID + ", items=" + items + ", orderPrice=" + orderPrice + "]";
	}
}
