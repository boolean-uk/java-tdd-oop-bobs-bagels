package com.booleanuk.core;

import java.io.File;
import java.util.HashMap;

import java.util.Scanner;

public class OrderManager {
	private int maxCartSize = 16; // max default size of basket
									// SKU, Price, Name, Variant
	private static HashMap<ItemInterface, String[]> storeItemInfo = null; // may simulate a database of item pricing and information
	private static HashMap<ItemInterface, Integer> storeItemStock = null;
	static private int defaultMaxBagels;
	static private int defaultMaxCoffees;
	static private int defaultMaxFillings;

	private HashMap<ItemInterface, Integer> cart;

	public static int getMaxFillings(){
		return defaultMaxFillings;
	}
	public static int getMaxBagels(){
		return defaultMaxBagels;
	}
	public static int getMaxCoffees(){
		return defaultMaxCoffees;
	}
	public void setMaxCartSize(int i){
		maxCartSize = i;
	}

	public OrderManager(){
		this.cart = new HashMap<>();
		openUpShopAndSetInventory(); // ensure the store always opens with stock
	}


	public static void openUpShopAndSetInventory(){
		storeItemInfo = new HashMap<>();
		storeItemStock = new HashMap<>();
		defaultMaxBagels = 20;
		defaultMaxCoffees = 15;
		defaultMaxFillings = 25;
		try{
			File f = new File("src/main/java/com/booleanuk/core/menu.csv");
			Scanner sc = new Scanner(f);
			String csvOrder = sc.nextLine();
			while(sc.hasNext()){
				String fullLine = sc.nextLine();
				String filtedLine = fullLine.replace(' ', '_');
				String[] line = filtedLine.split(",");

				// SKU, Price, Name, Variant
				String name = line[2];
				String variant = line[3];

				switch(name){
					case "Bagel":
						BagelType bagel = BagelType.valueOf(variant);
						storeItemInfo.put(bagel, line);
						storeItemStock.put(bagel, defaultMaxBagels);
						break;
					case "Coffee":
						CoffeeType coffee = CoffeeType.valueOf(variant);
						storeItemInfo.put(coffee, line);
						storeItemStock.put(coffee, defaultMaxCoffees);
						break;
					case "Filling":
						FillingType filling = FillingType.valueOf(variant);
						storeItemInfo.put(filling, line);
						storeItemStock.put(filling, defaultMaxFillings);
						break;
				}
			}
		} catch (Exception e) {
			// add error to LogFile
			e.printStackTrace();
		}


	}

	public String addItem(ItemInterface item){
		// check if in store
		int stock = storeItemStock.get(item);
		if (stock < 1) {
			return "Item not in stock.";
		}

		// sum of all items in cart
		int amountOfItemsInCart = cart
				.values()
				.stream()
				.mapToInt(i -> i.intValue())
				.sum();

		if (amountOfItemsInCart >= maxCartSize){
			return "Cart is full.";
		}


		// update stock
		storeItemStock.put(item, stock - 1);

		boolean inCart = cart.containsKey(item);
		if (inCart) {
			int amountInCart = cart.get(item);
			amountInCart++; // add one more
			cart.put(item, amountInCart);
			return item + ": " + amountInCart;
		}
		cart.put(item, 1);
		return item + ": 1";
	}

	public int getStockOfItem(ItemInterface item){
		return storeItemStock.get(item);

	}

	public double getPriceOfItem(ItemInterface item){
		String priceOfItemString = storeItemInfo.get(item)[1];
		return Double.valueOf(priceOfItemString);
	}


	public String removeItem(ItemInterface item){
		String result;
		// first check if exists in basket
		boolean isInCart = cart.containsKey(item);
		if (!isInCart){
			result = item + " is not in cart.";
			System.out.println(result);
			return result;
		}
		int amountInCart = cart.get(item);
		if (amountInCart < 1){
			result = item + " is not in cart.";
			System.out.println(result);
			return result;
		}

		// remove from cart
		cart.put(item, amountInCart - 1);

		// put back in stock
		storeItemStock.compute(item, (k, stock) -> stock + 1);
		result = "Removed " + item + " from cart.";
		System.out.println(result);
		return result;




	}

	public double getPrice(){
		double calculatedPrice = 0;
		for(ItemInterface item: cart.keySet()){
			int amountOfItemInCart = cart.get(item);
			String priceOfItemString = storeItemInfo.get(item)[1];
			double itemPrice = Double.valueOf(priceOfItemString);
			calculatedPrice += amountOfItemInCart * itemPrice;
		}
		return calculatedPrice;
	}


}
