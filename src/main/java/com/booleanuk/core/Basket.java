package com.booleanuk.core;

import java.util.ArrayList;

public class Basket {
	int size = 3;
	Inventory inventory;
	ArrayList<String> items;

	public Basket(Inventory inventory) {
		this.items = new ArrayList<>();
		this.inventory = inventory;
	}

	public boolean inBasket(String id) {
		return items.contains(id);
	}

	public void addItem(String id) throws NotInInventoryException {
		if (inventory.inInventory(id)) {
			if (!isFull()) {
				items.add(id);
			}
		}
		else {throw new NotInInventoryException(id);}
	}

	public void removeItem(String id) throws NotInBasketException {
		if (items.contains(id)) {
			items.remove(id);
		} else {
			throw new NotInBasketException(id);
		}
	}

	public boolean isFull() {
		return items.size() >= size;
	}
	public void setSize(int size){
		this.size=size;
	}

}
