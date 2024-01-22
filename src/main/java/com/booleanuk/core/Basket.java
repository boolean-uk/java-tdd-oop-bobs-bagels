package com.booleanuk.core;

import java.util.*;

public class Basket {
	private int itemIndex;
	private int size = 30;
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

	public void removeExtra(int index, String id) {
		if (inventory.inInventory(id)) {
			if (items.get(index).contains("BGL") && id.contains("FIL")) {
				if (extra.containsKey(index)) {
					extra.get(index).remove(id);
				}
			}
		}
	}


	public double getTotalCost() {
		ArrayList<String> itemsLeft = new ArrayList<>(items.values());
		ArrayList<String> discountItems = new ArrayList<>();
		double total = 0;
		HashSet<String> uniqueItems = new HashSet<>(items.values());
		ArrayList<String> hasDiscount = new ArrayList<>();
		HashMap<String, Integer> bulkAmount = new HashMap<>();
		for (String item : uniqueItems) {
			if (inventory.hasDiscountBulk(item)) {
				hasDiscount.add(item);
			}
		}
		for (String item : hasDiscount) {
			bulkAmount.put(item, Collections.frequency(items.values(), item));
		}


		for (String bulkItem : bulkAmount.keySet()) {
			int input = bulkAmount.get(bulkItem);
			int target = inventory.getBulkBulk(bulkItem);

			int closestMultiple = Math.round((float) input / target) * target;
			int movedItems = 0;
				for (int i = 0; i < itemsLeft.size(); i++) {
					if(!(movedItems<closestMultiple)){
						break;
					}
					if (itemsLeft.get(i).equals(bulkItem)) {
						discountItems.add(bulkItem);
						itemsLeft.remove(i);
						i--;
						movedItems++;

					}


			}
		}
		for (String item : discountItems) {
			double price = inventory.getBulkAmount(item);
			total += price;
		}

		HashSet<String[]> discountPairs = new HashSet<>();
		ArrayList<String[]> comboPairs = inventory.getDiscountComboPairs();
		for (String[] pair : comboPairs) {
			if (containsAllItems(itemsLeft, pair)) {
				discountPairs.add(pair);
			}
		}
		for (String[] pair : discountPairs) {
			HashMap<String, Integer> occurrences = countOccurrences(itemsLeft, pair);
			int smallest = Integer.MAX_VALUE;
			for (Integer i : occurrences.values()) {
				if (i < smallest) {
					smallest = i;
				}
			}

			for (int i = 0; i < pair.length; i++) {
				int removed = 0;
				for (int j = 0; j < itemsLeft.size(); j++) {
					if (removed < smallest && itemsLeft.get(j).contains(pair[i])) {
						itemsLeft.remove(j);
						removed++;
						j--;

					}
				}
				removed=0;


			}
			for (int j = 0; j < smallest; j++) {
				total += inventory.getDiscountComboAmount(pair);
			}
		}
		for (String item : itemsLeft) {
			total += inventory.getPrice(item);
		}
		for (ArrayList<String> extras : extra.values()) {
			for (String item : extras) {
				total += inventory.getPrice(item);
			}
		}

		return total;
	}

	public int getSize() {
		return this.size;
	}

	public double getPrice(String id) throws NotInInventoryException {
		if (inventory.inInventory(id)) {
			return inventory.getPrice(id);
		} else {
			throw new NotInInventoryException(id);
		}
	}

	private static boolean containsAllItems(ArrayList<String> items, String[] array) {
		for (String str : array) {
			boolean found = false;

			for (String item : items) {
				if (item.contains(str)) {
					found = true;
					break;
				}
			}

			if (!found) {
				return false;
			}
		}
		return true;
	}

	private static HashMap<String, Integer> countOccurrences(ArrayList<String> items, String[] stringsToCount) {
		HashMap<String, Integer> occurrences = new HashMap<>();
		for (String str : items) {
			if (containsString(stringsToCount, str)) {
				occurrences.put(str, occurrences.getOrDefault(str, 0) + 1);
			}
		}

		return occurrences;
	}

	private static boolean containsString(String[] array, String target) {
		for (String str : array) {
			if (target.contains(str)) {
				return true;
			}
		}
		return false;
	}
}
