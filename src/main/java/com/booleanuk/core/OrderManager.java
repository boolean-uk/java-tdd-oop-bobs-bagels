package com.booleanuk.core;

import java.io.File;
import java.time.format.DateTimeFormatter;
import java.util.*;


/** My assumptions
 *  Discounts are applied by the following rules:
 *  12 of the same bagel -> 3.99
 *  6 of the same bagel -> 2.49
 *  if there is a black coffee AND a plain bagel in the cart:
 *      convert them to a bagel-coffee combo.
 *
 *  Filling does noe change the price of any bagel and is calculated separately.
 *
 *  Changes made:
 *  Started off with a class hierarchy of Item <-- {coffee, bagel, filling} bagel has a list of fillings
 *  Created a way to create a bagel and add fillings to the bagel-object
 *  Created a func to take user input and build the order through interaction with terminal
 *  --> that was very difficult to test
 *  --> Scrapped the Item classes for an interface and created an enum for each item, and a hashmap of
 *   values connected to the enum.
 *   --> this is the current implementation.
 *
 *
 */

public class OrderManager {
	// created static in case we want to extend the OrderManager to use multiple cashiers at one
	// SKU, Price, Name, Variant
	private static HashMap<Item, String[]> storeItemInfo = null; // may simulate a database of item pricing and information
	private static HashMap<Item, Integer> storeItemStock = null;
	static private int defaultMaxBagels;
	static private int defaultMaxCoffees;
	static private int defaultMaxFillings;


	// private variables
	private HashMap<Item, Integer> cart;
	private ArrayList<Item> cartOrder;
	private int maxCartSize = 24; // max default size of basket

	public static int getMaxFillings(){
		return defaultMaxFillings;
	}
	public static int getMaxBagels(){
		return defaultMaxBagels;
	}
	public static int getMaxCoffees(){
		return defaultMaxCoffees;
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
				String fullUnfilteredLine = sc.nextLine();
				String filteredLine = fullUnfilteredLine.replace(' ', '_');
				String[] line = filteredLine.split(",");

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
	public String addItem(Item item){
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

	// case: 2, 5
	public String removeItem(Item item){
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
	// case: 4
	public void setMaxCartSize(int i){
		maxCartSize = i;
	}

	// case: 6
	public double getTotalCartPrice(){
		double calculatedPrice = 0;
		for(Item item: cart.keySet()){
			int amountOfItemInCart = cart.get(item);
			String priceOfItemString = storeItemInfo.get(item)[1];
			double itemPrice = Double.valueOf(priceOfItemString);
			calculatedPrice += amountOfItemInCart * itemPrice;
		}
		String adjustedPrice = String.format("%.2f", calculatedPrice);
		return Double.valueOf(adjustedPrice);
	}


	// case: 7, 9
	public double getPriceOfItem(Item item){
		String priceOfItemString = storeItemInfo.get(item)[1];
		return Double.valueOf(priceOfItemString);
	}

	public static String leftAlignStringWithPadding(String s, int pad){
		return String.format("%" + pad + "s", s);
	}
	public static String rightAlignStringWithPadding(String s, int pad){
		return String.format("%-" + pad + "s", s);
	}
	public static String centerAlignStringWithPadding(String s, int pad){
		return String.format("%" + ((pad + s.length())/2) + "s", s); // only pads half to left. not center with padding on
																	 // both sides
	}

	public static void main(String[] args) {
		System.out.println(leftAlignStringWithPadding("Hello", 10));
		System.out.println(rightAlignStringWithPadding("Hello", 10));
		System.out.println(centerAlignStringWithPadding("Hello", 10));
	}

	// case: 10
	public int getStockOfItem(Item item){
		return storeItemStock.get(item);

	}


	public double getTotalDiscountedPrice(){
		return getTotalDiscountReciept().price;
	}


	public String getTotalDiscountRecieptString(){
		Receipt r =  getTotalDiscountReciept();
		ArrayList<String> recieptRaw = r.receipt;
		String prettyReceipt = "";

		int itemLengthWithPadding = 23;
		int quantityWithPadding = 2;
		int priceWithPadding = 8;
		int totalWidth = itemLengthWithPadding+quantityWithPadding+priceWithPadding;
		String bobsString = "~~~Bob's Bagels~~~";
		prettyReceipt += centerAlignStringWithPadding(bobsString, totalWidth) + "\n";
		String dateString = r.date.toLocalDate().toString() + "\n";
		prettyReceipt += centerAlignStringWithPadding(dateString, totalWidth);
		String dateTime = r.date.format(DateTimeFormatter.ISO_TIME);
		int a = dateTime.lastIndexOf('.');
		dateTime = dateTime.substring(0, a);
		prettyReceipt += centerAlignStringWithPadding(dateTime, totalWidth);

		prettyReceipt += "\n";


		String receiptBreak = "=".repeat(totalWidth);
		prettyReceipt += receiptBreak + "\n";

//		padd each item and pretty-print
		for(String str: recieptRaw){
			String[] items = str.split(",");
			String type = items[0];
			String amount = items[1];
			String price = "£ " + items[2];
			String discounted = items.length==4 ? items[3] : "";


			//  eg: Bagel: Onion          2         £ 0.98
			String curLine = "";
			String formattedType = rightAlignStringWithPadding(type, itemLengthWithPadding);
			String formattedAmount = rightAlignStringWithPadding(amount, quantityWithPadding);
			String fomrattedPrice = leftAlignStringWithPadding(price, priceWithPadding);
			String formattedDiscount = "";

			// eg: (-0.13)
			if (discounted != ""){
				formattedDiscount = "\n" + leftAlignStringWithPadding(discounted, totalWidth);
			}

			curLine += formattedType + formattedAmount + fomrattedPrice + formattedDiscount;
			prettyReceipt += "\n" + curLine;
		}
		String bars = "―".repeat(totalWidth-bobsString.length() + 5);
		prettyReceipt += "\n" + bars;

		// sum saved
		String sumStart =  rightAlignStringWithPadding("Saved", itemLengthWithPadding);

		double sumSaved = getTotalCartPrice()-r.price;
		String sumSavedStr = String.format("%.2f", sumSaved);
		String sumSavedAmountPadded = leftAlignStringWithPadding("£ " + sumSavedStr, priceWithPadding);
		prettyReceipt += "\n" + sumStart + " ".repeat(quantityWithPadding) + sumSavedAmountPadded;

		// total sum
		String totalSumPrice = String.format("%.2f", r.price);
		String totalStart = String.format("%-" + itemLengthWithPadding + "s", "Total");
		String totalSum = String.format("%" + priceWithPadding + "s", "£ " + totalSumPrice);
		prettyReceipt += "\n" + totalStart + " ".repeat(quantityWithPadding) + totalSum;


		prettyReceipt += "\n" + receiptBreak + "\n";

		return prettyReceipt;
	}



	// case: e1
	public Receipt getTotalDiscountReciept(){

		HashMap<Item, Integer> cartCopy = new HashMap<>(cart);

		double totalPrice = 0;
		ArrayList<String> reciept = new ArrayList<>();

		// first check for bagel types
		for (Item item: cartCopy.keySet()){
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
						reciept.add(item + " Bagel x 12," + iters + ",3.99,(-"+ discountString + ")");
					}

					iters = 0;
					while (amountOfBagels >= 6) {
						amountOfBagels -= 6;
						iters++;
					}
					if(iters > 0){
						totalPrice += 2.49*iters;
						String discountString = String.format("%.2f", (actualPrice*6-2.49));
						reciept.add(item + " Bagel x 6," + iters + ",2.49,(-" + discountString + ")");
					}

					// update if used
					cartCopy.put(item, amountOfBagels);

					break;
				default:
					break;
			}
		}

		// check for coffee discount
		for (Item item: cartCopy.keySet()){
			switch (item){
				case CoffeeType.Black:
					try{
						int amountOfBlackCoffee = cartCopy.get(item);
						int amountOfPlainBagels = cartCopy.get(BagelType.Plain);
						int amountOfCoffeeBagelCombos= 0;
						while(amountOfBlackCoffee-- > 0 && amountOfPlainBagels-- > 0)
							amountOfCoffeeBagelCombos++;

						if (amountOfCoffeeBagelCombos == 0) break;

						cartCopy.put(BagelType.Plain, amountOfPlainBagels);
						cartCopy.put(CoffeeType.Black, amountOfBlackCoffee);

						double actualDiscountPrice = amountOfCoffeeBagelCombos * 1.25;
						totalPrice += actualDiscountPrice;
						String discountString = String.format("%.2f", actualDiscountPrice);
						double saved = (getPriceOfItem(CoffeeType.Black) + getPriceOfItem(BagelType.Plain)) * amountOfCoffeeBagelCombos - 1.25*amountOfCoffeeBagelCombos;
						String savedString = String.format("%.2f", saved);
						saved = Double.valueOf(savedString);
						String discountReceiptString = "Coffee and Bagel," + amountOfCoffeeBagelCombos + "," + discountString + ",(-" + saved + ")";

						reciept.add(discountReceiptString);
					}catch (NullPointerException e){}
					break;
				default:
					break;
			}
		}


		// the rest
		for (Item item: cartCopy.keySet()){
			try{
				int amountOfItemsLeftInCart = cartCopy.get(item);
				if (amountOfItemsLeftInCart > 0){
					double itemPricePer = getPriceOfItem(item);
					double sumItemsPriceLeftInCart = itemPricePer * amountOfItemsLeftInCart;
					totalPrice += sumItemsPriceLeftInCart;

					String type = "";
					if (item instanceof BagelType) type = "Bagel";
					if (item instanceof CoffeeType) type = "Coffee";
					if (item instanceof FillingType) type = "Filling";

					String currItemRecieptString =  type +": " + item + ","+ amountOfItemsLeftInCart + "," + String.format("%.2f", sumItemsPriceLeftInCart);
					reciept.add(currItemRecieptString);
				}
			} catch (NullPointerException e){}
		}

		String strPrice = String.format("%.2f", totalPrice);
		totalPrice = Double.valueOf(strPrice);
		Collections.sort(reciept);

		return new Receipt(reciept, totalPrice);
	}



}
