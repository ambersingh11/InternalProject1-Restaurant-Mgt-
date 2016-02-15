package Application;

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
		waiter.assignTable(new Table(565),waiter.createOrder(1011, items));
		waiter.publishOrders();
		Chef chef=new Chef();
		chef.readOrders();
		System.out.println(chef.getOrder());
	}

}
