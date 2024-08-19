package com.booleanuk.core;

import javafx.util.Pair;

import javax.sound.midi.Soundbank;
import java.util.HashMap;
import java.util.Scanner;

public class OrderManager {
	private static HashMap<Pair<Item, Integer>, Integer> discounts;
	private static HashMap<Item, Integer> inventory;
	private static int maxBasketSize;

	private HashMap<Item, Integer> basketOfItems;
	private double price;

	public OrderManager(){
		this.basketOfItems = new HashMap<>();
		this.price = 0;
	}



	public void createItem(){
		System.out.println("Here's the menu:");
		int itemCounter = 0;
		String menu = itemCounter++ + ": No thanks. I'd like to pay.";
		for (BagelType t: BagelType.values()){
			menu += itemCounter++ + ": " + t + " bagel\n";
		}
		for (CoffeeType t: CoffeeType.values()){
			menu += itemCounter++ + ": " + t + " coffee\n";
		}

		boolean notFinished;
		Item item = null;
		do{
		notFinished = false;
		System.out.println(menu);
		String userAns = "";
		userAns = getUserString();


		switch(userAns) {
			case "1":
				item = new Bagel("BGLO", "Bagel", BagelType.Onion);
			case "2":
				item = new Bagel("BGLP", "Bagel", BagelType.Plain);
			case "3":
				item = new Bagel("BGLE", "Bagel", BagelType.Everything);
			case "4":
				item = new Bagel("BGLS", "Bagel", BagelType.Sesame);
			case "5":
				item = new Coffee("COFB", "Coffee", CoffeeType.Black);
			case "6":
				item = new Coffee("COFW", "Coffee", CoffeeType.White);
			case "7":
				item = new Coffee("COFC", "Coffee", CoffeeType.Cappuccino);
			case "8":
				item = new Coffee("COFL", "Coffee", CoffeeType.Latte);
			default:
				notFinished = true;

		}} while(notFinished);


		String userAns = "not";
		if (item instanceof Bagel){
			System.out.println("Do you want filling?");
			System.out.println("[y] / [n]");
			userAns = getUserString().toLowerCase();
			switch (userAns){
				case "y":
					addFillings((Bagel)item);
				case "n":
					System.out.println("Not adding any fillings to bagel.");
				default:
					System.out.println("Try again");

			}
		}
	}

	public void addFillings(Bagel b){
		String userInput = "";

		// create the fillingsmenu:
		String fillingsMenu = "";
		int itemCounter = 1;
		for (FillingType t: FillingType.values()){
			fillingsMenu += itemCounter++ + ": " + t + "\n";
		}
		fillingsMenu += "Done? [n]";

		int maxToppings = 5;
		int currToppings = 0;


		while(!userInput.equals("n") && currToppings++ < maxToppings){
			System.out.println("What fillings do you want?");
			System.out.println(fillingsMenu);
			userInput = getUserString();
			Filling filling = null;
			switch (userInput){
				case "1":
					filling = new Filling("FILB", "Filling", FillingType.Bacon);
				case "2":
					filling = new Filling("FILE", "Filling", FillingType.Egg);
				case "3":
					filling = new Filling("FILC", "Filling", FillingType.Cheese);
				case "4":
					filling = new Filling("FILX", "Filling", FillingType.CremeCheese);
				case "5":
					filling = new Filling("FILS", "Filling", FillingType.SmokedSalmon);
				case "6":
					filling = new Filling("FILH", "Filling", FillingType.Ham);
				default:
					currToppings--;
					System.out.println("I didn't quite get that.");
					System.out.println("Please select a number 1-6 or [n]");
			}
			if(filling != null){
				b.addFilling(filling);
			}
		}
	}


	public HashMap<Item, Integer>getItems(){
		return this.basketOfItems;
	}


	static int getUserInt(){
		int ans = -1;
		try {
			Scanner sc = new Scanner(System.in);
			ans = sc.nextInt();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ans;
	}

	static String getUserString(){
		String ans = "";
		try {
			Scanner sc = new Scanner(System.in);
			ans = sc.nextLine();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ans;
	}
}
