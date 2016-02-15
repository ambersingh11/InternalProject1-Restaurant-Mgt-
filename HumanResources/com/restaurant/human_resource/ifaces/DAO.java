package com.restaurant.human_resource.ifaces;

import java.util.List;

public interface DAO<T> {
	public int add(T t);
	public T find(int key);
	public List<T> finaAll();
	//public int update(int key,long newSal);
	public int delete(int key);
}
