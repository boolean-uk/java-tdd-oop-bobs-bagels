package com.booleanuk.core;

import java.util.ArrayList;
import java.util.HashMap;

public class Basket {
	private int itemIndex;
	private int size = 3;
	final Inventory inventory;
	private HashMap<Integer, String> items;
	private HashMap<Integer, ArrayList<String>> extra;

	public Basket(Inventory inventory) {
		this.items = new HashMap<>();
		this.extra = new HashMap<>();
		this.inventory = inventory;

	}

	public boolean inBasket(String id) {
		return items.containsValue(id);
	}

	public void addItem(String id) throws NotInInventoryException {
		if (inventory.inInventory(id)) {
			if (!isFull()) {
				items.put(itemIndex++, id);
			}
		} else {
			throw new NotInInventoryException(id);
		}
	}

	public void removeItem(int index) throws NotInBasketException {
		if (items.containsKey(index)) {
			items.remove(index);
		} else {
			throw new NotInBasketException(index);
		}
	}

	public boolean isFull() {
		return items.size() >= size;
	}

	public void setSize(int size) throws UnableToChangeBasketSizeException {
		if (items.size() > size) {
			throw new UnableToChangeBasketSizeException(size, items.size());
		}
		this.size = size;
	}

	public String showFillings() {
		return inventory.getFillings();
	}

	public void addExtra(int index, String id) throws NotInInventoryException {
		if (inventory.inInventory(id)) {
			if (items.get(index).contains("BGL") && id.contains("FIL")) {
				if (extra.containsKey(index)) {
					extra.get(index).add(id);
				} else {
					ArrayList<String> itemsExtra = new ArrayList<>();
					itemsExtra.add(id);
					extra.put(index, itemsExtra);
				}
			} else throw new NotInInventoryException(id);

		}
	}

	public void removeExtra(int index,String id) {
		if (inventory.inInventory(id)) {
			if (items.get(index).contains("BGL") && id.contains("FIL")) {
				if (extra.containsKey(index)) {
					extra.get(index).remove(id);
				}
			}
			}
	}

	public double getTotalCost() {
		double total = 0;
		for (String id : items.values()) {
			total += inventory.getPrice(id);
		}

		for (ArrayList<String> extras : extra.values()) {
			for (String id : extras) {
				total += inventory.getPrice(id);
			}
		}

		return total;
	}

	public int getSize() {
		return this.size;
	}
}
