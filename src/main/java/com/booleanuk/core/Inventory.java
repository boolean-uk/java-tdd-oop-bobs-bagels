package com.booleanuk.core;

import java.util.ArrayList;



public class Inventory {
	ArrayList<Item> inventory;

	public Inventory() {
		this.inventory = new ArrayList<>();
		init();
	}

	public boolean inInventory(String id) {
		boolean inInventory=false;
		for (Item item : inventory) {
			if (item.id.equals(id)) {
				return true;
			}
		}
		return false;
	}
	private void init(){
		Item item1 = new Bagel("BGLO","Onion",0.49);
		Item item2 = new Bagel("BGLP","Plain",0.39);
		Item item3 = new Bagel("BGLE","Everything",0.49);
		Item item4 = new Bagel("BGLS","Sesame",0.49);
		Item item5 = new Coffee("COFB","Black",0.99);
		Item item6 = new Coffee("COFW","White",1.19);
		Item item7 = new Coffee("COFC","Cappuccino",1.29);
		Item item8 = new Coffee("COFL","Latte",1.29);
		Item item9 = new Filling("FILB","Bacon",0.12);
		Item item10 = new Filling("FILE","Egg",0.12);
		Item item11 = new Filling("FILC","Cheese",0.12);
		Item item12 = new Filling("FILX","Cream Cheese",0.12);
		Item item13 = new Filling("FILS","Smoked Salmon",0.12);
		Item item14 = new Filling("FILH","Ham",0.12);

		inventory.add(item1);
		inventory.add(item2);
		inventory.add(item3);
		inventory.add(item4);
		inventory.add(item5);
		inventory.add(item6);
		inventory.add(item7);
		inventory.add(item8);
		inventory.add(item9);
		inventory.add(item10);
		inventory.add(item11);
		inventory.add(item12);
		inventory.add(item13);
		inventory.add(item14);

	}
}
