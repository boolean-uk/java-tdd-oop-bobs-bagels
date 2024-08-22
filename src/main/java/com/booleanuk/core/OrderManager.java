package com.booleanuk.core;

import java.io.File;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.HashMap;
//import java.time.format.DateTimeFormatter.


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
	private ArrayList<ItemInterface> cartOrder;

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
		this.cartOrder = new ArrayList<>();
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
			System.out.println("Item not in stock");
			return "Item not in stock.";
		}

		// sum of all items in cart
		int amountOfItemsInCart = cart
				.values()
				.stream()
				.mapToInt(i -> i.intValue())
				.sum();

		if (amountOfItemsInCart >= maxCartSize){
			System.out.println("Cart is full");
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

	public double getTotalDiscountedPrice(){
		return getTotalDiscountReciept().price;
	}

	public String getTotalDiscountRecieptString(){
		Receipt r =  getTotalDiscountReciept();
		ArrayList<String> recieptRaw = r.receipt;
		String prettyReciept = "";


		// do some
		int itemLengthWithPadding = 22;
		int quantityWithPadding = 8;
		int priceWithPadding = 8;
		int totalWidth = itemLengthWithPadding+quantityWithPadding+priceWithPadding;
		String bobsString = "~~~Bob's Bagels~~~\n";
		prettyReciept += String.format("%" + ((totalWidth + bobsString.length())/2) + "s", bobsString);
		String dateString = r.date.toLocalDate().toString() + "\n";
		prettyReciept += String.format("%" + ((totalWidth + dateString.length())/2) + "s", dateString);
		String dateTime = r.date.format(DateTimeFormatter.ISO_TIME);
		int a = dateTime.lastIndexOf('.');
		dateTime = dateTime.substring(0, a);
		prettyReciept += String.format("%" + (((totalWidth + dateTime.length())/2) - 1)  + "s", dateTime);

		prettyReciept += "\n";


		String receiptBreak = "=".repeat(totalWidth);
		prettyReciept += receiptBreak + "\n";

//		padd each item and pretty-print
//  eg: Bagel: Onion          2         £ 0.98
		for(String str: recieptRaw){
			String[] items = str.split(",");
			String type = items[0];
			String amount = items[1];
			String price = "£ " + items[2];
			String discounted = items.length==4 ? items[3] : "";


			String curLine = "";
			String formattedType = String.format("%-" +itemLengthWithPadding + "s", type); int lenT = formattedType.length();
			String formattedAmount = String.format("%-" + quantityWithPadding + "s", amount); int lenA  = formattedAmount.length();
			String fomrattedPrice = String.format("%" + priceWithPadding + "s", price); int lenP = fomrattedPrice.length();

			String formattedDiscount = "";

			if (discounted != ""){
				formattedDiscount = String.format("%" + totalWidth + "s", discounted);
				formattedDiscount = "\n" + formattedDiscount;
			}

			curLine += formattedType + formattedAmount + fomrattedPrice + formattedDiscount;
			prettyReciept += "\n" + curLine;
		}
		String bars = "―".repeat(totalWidth-bobsString.length() + 5);
		prettyReciept += "\n" + bars;
		String totalStart = String.format("%-" + itemLengthWithPadding + "s", "Total");
		String totalSum = String.format("%" + priceWithPadding + "s", "£ " + r.price);
		prettyReciept += "\n" + totalStart + " ".repeat(quantityWithPadding) + totalSum;


		prettyReciept += "\n" + receiptBreak + "\n";



		// some more work

		return prettyReciept;
	}



	// case: e1
	public Receipt getTotalDiscountReciept(){

		HashMap<ItemInterface, Integer> cartCopy = new HashMap<>(cart);

		double totalPrice = 0;
		ArrayList<String> reciept = new ArrayList<>();

		// first check for bagel types
		for (ItemInterface item: cartCopy.keySet()){
			switch (item){
				case BagelType.Everything, BagelType.Onion, BagelType.Plain, BagelType.Sesame:
					int amountOfBagels = 0;
					double actualPrice = getPriceOfItem(item);
					try{
						amountOfBagels = cartCopy.get(item);
					} catch (NullPointerException e){}


					int iters = 0;
					while (amountOfBagels >= 12){
						amountOfBagels -= 12;
						iters++;

					}
					if (iters > 0){
						totalPrice += 3.99*iters;
						String discountString = String.format("%.2f", (actualPrice*12-3.99));
						reciept.add(item + " Bagel," + iters + ",3.99,("+ discountString + ")");

					}
					iters = 0;
					while (amountOfBagels >= 6) {
						amountOfBagels -= 6;
						iters++;
					}
					if(iters > 0){
						totalPrice += 2.49*iters;
						String discountString = String.format("%.2f", (actualPrice*6-2.49));
						reciept.add(item + " Bagel," + iters + ",2.49,(" + discountString + ")");
					}

					// update if used
					cartCopy.put(item, amountOfBagels);

					break;
				default:
					break;
			}
		}

		// check for coffee discount
		for (ItemInterface item: cartCopy.keySet()){
			switch (item){
				case CoffeeType.Black:
					try{
					int amountOfBlackCoffee = cartCopy.get(item);
					for(int i = 0; i < amountOfBlackCoffee; i++){
						int amountOfPlainBagel = cartCopy.get(BagelType.Plain);
						if(amountOfPlainBagel > 0){
							double actualPrice = getPriceOfItem(item) + getPriceOfItem(CoffeeType.Black);
							cartCopy.put(BagelType.Plain, amountOfPlainBagel -1);
							cartCopy.put(CoffeeType.Black, amountOfBlackCoffee-1-i);
							totalPrice+=1.25;
							String discountString = String.format("%.2f", (actualPrice-1.25));
							reciept.add("Coffee and Bagel,1,1.25,(-"+ discountString+ ")");
						}
					}
					}catch (NullPointerException e){}
					break;
				default:
					break;
			}
		}


		// the rest
		for (ItemInterface item: cartCopy.keySet()){
			try{
				int amountOfItemsLeftInCart = cartCopy.get(item);
				int amounfOfCoffeesAdded = 0;
				int amountOfPlainBagels = 0;
				if (amountOfItemsLeftInCart > 0){
					double itemPricePer = getPriceOfItem(item);
					double sumItemsPriceLeftInCart= itemPricePer * amountOfItemsLeftInCart;
					String doublePriceStr = String.format("%.2f", sumItemsPriceLeftInCart);
					totalPrice += sumItemsPriceLeftInCart;
//					reciept.add( item + " x " + amountOfItemsLeftInCart + " for " + String.format("%.2f", sumItemsPriceLeftInCart) + "\t");
					String type = "";

					if (item instanceof BagelType) type = "Bagel";
					if (item instanceof CoffeeType) type = "Coffee";
					if (item instanceof FillingType) type = "Filling";
					String currItemRecieptString =  type +": " + item + ","+ amountOfItemsLeftInCart + "," + String.format("%.2f", sumItemsPriceLeftInCart);

					reciept.add(currItemRecieptString);
				}
			} catch (NullPointerException e){}
		}

		System.out.println(reciept);

		String strPrice = String.format("%.2f", totalPrice);
		totalPrice = Double.valueOf(strPrice);

		return new Receipt(reciept, totalPrice);
	}



}
