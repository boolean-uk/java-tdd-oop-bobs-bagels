package com.booleanuk.core;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

public class Receipt {
	public ArrayList<String> receipt;
	public Double price;
	public LocalDateTime date;

	public Receipt(ArrayList<String> receipt, Double price){
		this.receipt = receipt;
		this.price = price;
		this.date = LocalDateTime.now();
		System.out.println(receipt);
	}
}
