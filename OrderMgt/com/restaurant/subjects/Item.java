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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + itemID;
		result = prime * result + ((itemName == null) ? 0 : itemName.hashCode());
		result = prime * result + Float.floatToIntBits(itemPrice);
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
		Item other = (Item) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (itemID != other.itemID)
			return false;
		if (itemName == null) {
			if (other.itemName != null)
				return false;
		} else if (!itemName.equals(other.itemName))
			return false;
		if (Float.floatToIntBits(itemPrice) != Float.floatToIntBits(other.itemPrice))
			return false;
		return true;
	}
}
