package com.restaurant.subjects;

import java.io.Serializable;
import java.util.List;

import com.restaurant.actors.Manager;

public class Order implements Serializable{
	private int orderID;
	private List<Item> items;
	private float orderPrice;
	private boolean pending=true;
	
	
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
	public float setOrderPrice() {
		for(Item item : items)
			orderPrice += item.getItemPrice();
		return orderPrice;
	}
	public float getOrderPrice(){
		return orderPrice;
	}
	public boolean isPending() {
		return pending;
	}
	public void setPending(boolean pending) {
		this.pending = pending;
	}
	@Override
	public String toString() {
		return "Order [orderID=" + orderID + ", items=" + items + ", orderPrice=" + orderPrice + "]";
	}
	private Object readResolve(){
		return Manager.locateOrder(this.orderID);
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((items == null) ? 0 : items.hashCode());
		result = prime * result + orderID;
		result = prime * result + Float.floatToIntBits(orderPrice);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (items == null) {
			if (other.items != null)
				return false;
		} else if (!items.equals(other.items))
			return false;
		if (orderID != other.orderID)
			return false;
		if (Float.floatToIntBits(orderPrice) != Float.floatToIntBits(other.orderPrice))
			return false;
		return true;
	}
}
