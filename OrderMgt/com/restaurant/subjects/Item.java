package com.restaurant.subjects;

import java.io.Serializable;

public class Item implements Serializable{
	private int itemID;
	private String itemName;
	private float itemPrice;
	private String category;
	
	
	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Item(int itemID, String itemName, float itemPrice, String category) {
		super();
		this.itemID = itemID;
		this.itemName=itemName;
		this.itemPrice = itemPrice;
		this.category = category;
	}
	public int getItemID() {
		return itemID;
	}
	public void setItemID(int itemID) {
		this.itemID = itemID;
	}
	public float getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(float itemPrice) {
		this.itemPrice = itemPrice;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	@Override
	public String toString() {
		return "Item [itemID=" + itemID + ", itemName=" + itemName + ", itemPrice=" + itemPrice + ", category="
				+ category + "]";
	}
}
