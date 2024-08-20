package com.booleanuk.core;

import java.io.File;
import java.util.HashMap;

import java.util.Scanner;

public class OrderManager {
	private static int maxCartSize = 16; // max default size of basket
	private static HashMap<ItemEnumInterface, String[]> storeItemInfo = null;
									// SKU, Price, Name, Variant{
	private static HashMap<ItemEnumInterface, Integer> storeItemStock = null;

	private HashMap<ItemEnumInterface, Integer> cart;

	public OrderManager(){
		this.cart = new HashMap<>();
		openUpShopAndSetInventory(); // ensure the store always opens with stock
	}


	public static void openUpShopAndSetInventory(){
		storeItemInfo = new HashMap<>();
		storeItemStock = new HashMap<>();
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
						int defaultBagelAmount = 20;
						storeItemInfo.put(bagel, line);
						storeItemStock.put(bagel, defaultBagelAmount);
						break;
					case "Coffee":
						CoffeeType coffee = CoffeeType.valueOf(variant);
						int defaultCoffeeAmount = 30;
						storeItemInfo.put(coffee, line);
						storeItemStock.put(coffee, defaultCoffeeAmount);
						break;
					case "Filling":
						FillingType filling = FillingType.valueOf(variant);
						int defaultFillingAmount = 25;
						storeItemInfo.put(filling, line);
						storeItemStock.put(filling, defaultFillingAmount);
						break;
				}
			}
		} catch (Exception e) {
			// add error to LogFile
			e.printStackTrace();
		}


	}

	public String addItem(ItemEnumInterface item){
		// check if in store
		int stock = storeItemStock.get(item);
		if (stock > 0){
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
		return "Item not in stock.";
	}

	public double getPrice(){
		double calculatedPrice = 0;
		for(ItemEnumInterface item: cart.keySet()){
			int amountOfItemInCart = cart.get(item);
			String priceOfItemString = storeItemInfo.get(item)[1];
			double itemPrice = Double.valueOf(priceOfItemString);
			calculatedPrice += amountOfItemInCart * itemPrice;
		}
		return calculatedPrice;
	}



	public void printFillingsMenu(){
		StringBuilder fillingsMenu = new StringBuilder();
		int itemCounter = 1;
		for (FillingType t: FillingType.values()){
			fillingsMenu.append(itemCounter++ + ": " + t + "\n");
		}
		System.out.println(fillingsMenu);
	}

}
