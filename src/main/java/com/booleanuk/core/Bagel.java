package com.booleanuk.core;

import java.util.ArrayList;

public class Bagel extends Item{
	String id;
	String name;
	double price;
	ArrayList<Filling> fillings;

	public Bagel(String id, String name, double price) {
		super(id, name, price);
	}

}