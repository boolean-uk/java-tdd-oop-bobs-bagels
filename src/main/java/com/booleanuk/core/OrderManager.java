package com.booleanuk.core;

import java.io.File;
import java.util.HashMap;

import java.util.Scanner;

public class OrderManager {
	private int maxCartSize = 24; // max default size of basket
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

	// case: 4
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

	// case: 1, 3, 8
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

	// case: 10
	public int getStockOfItem(ItemInterface item){
		return storeItemStock.get(item);

	}

	// case: 7, 9
	public double getPriceOfItem(ItemInterface item){
		String priceOfItemString = storeItemInfo.get(item)[1];
		return Double.valueOf(priceOfItemString);
	}

	// case: 2, 5
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

	// case: 6
	public double getTotalCartPrice(){
		double calculatedPrice = 0;
		for(ItemInterface item: cart.keySet()){
			int amountOfItemInCart = cart.get(item);
			String priceOfItemString = storeItemInfo.get(item)[1];
			double itemPrice = Double.valueOf(priceOfItemString);
			calculatedPrice += amountOfItemInCart * itemPrice;
		}
		return calculatedPrice;
	}

	public int getAmountOfItemInCart(ItemInterface item){
		int amount = 0;
		if (cart.containsKey(item)){
			amount = cart.get(item);
		}
		return amount;
	}
	// case: e1
	public double getTotalDiscountedPrice(){

		HashMap<ItemInterface, Integer> cartCopy = new HashMap<>(cart);

		double totalPrice = 0;
		String reciept = "";
		for(ItemInterface item: cartCopy.keySet()){
			int amountInCart = cartCopy.get(item);

			// sort list -> take bagel special offers then coffees
			switch (item){

				// any bagel
				case BagelType.Everything, BagelType.Onion, BagelType.Plain, BagelType.Sesame:
					while (amountInCart > 12){
						totalPrice += 3.99;
						amountInCart -= 12;
						reciept += item + ": 12 for 3.99\n";
					}

					while(amountInCart > 6){
						totalPrice += 2.49;
						amountInCart -= 6;
						reciept += item + ": 6 for 2.49\n";
					}

					while(amountInCart-->0){
						double pricePer = getPriceOfItem(item);
						totalPrice += pricePer;
						reciept += item	+ ": 1 for " + pricePer + "\n";
					}


					// or black coffee
				case CoffeeType.Black:
					for(int i = 0; i < amountInCart; i++){
						// check if a bagel is in cart.
						for (BagelType bagel: BagelType.values()){
							if (getStockOfItem(bagel) > 0){
								cart.compute(bagel, (k, amountOfBagelInCart) -> amountOfBagelInCart - 1);
								totalPrice += 1.25;
								reciept += "Black Coffee and " + bagel + " for 1.25\n";
								break;
							}
						}
					}

				default:
					totalPrice += getPriceOfItem(item);
					reciept += item + " for " + getPriceOfItem(item);
			}

		}


		return totalPrice;
	}



}
