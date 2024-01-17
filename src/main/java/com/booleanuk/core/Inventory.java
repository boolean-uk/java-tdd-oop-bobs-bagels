package com.booleanuk.core;

import java.util.ArrayList;

public class Inventory {
	ArrayList<Integer> inventory;

	public Inventory() {
		this.inventory = new ArrayList<>();
	}

	public void addItem(int id) {
		inventory.add(id);
	}

	public boolean inInventory(int id) {
		return inventory.contains(id);
	}
}
