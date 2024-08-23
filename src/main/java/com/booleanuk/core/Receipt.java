package com.booleanuk.core;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import static com.booleanuk.core.StringUtils.*;
import static com.booleanuk.core.StringUtils.leftAlignStringWithPadding;


public class Receipt {
	public final ArrayList<String> receiptOrder;
	public final double price;
	public final LocalDateTime date;
	public final double totalCartPrice;

	public Receipt(ArrayList<String> receipt, double price, double fullPriceNoDiscount){
		this.receiptOrder = receipt;
		this.price = price;
		this.date = LocalDateTime.now();
		this.totalCartPrice = fullPriceNoDiscount;
	}

	public String getYYYYMMDD(){
		return date.toLocalDate().toString();
	}

	public String getISOTime(){
		return date.format(DateTimeFormatter.ISO_TIME);
	}


	public String getTotalDiscountRecieptString(){
		String prettyReceipt = "";

		int itemLengthWithPadding = 23;
		int quantityWithPadding = 2;
		int priceWithPadding = 8;
		int totalWidth = itemLengthWithPadding+quantityWithPadding+priceWithPadding;
		String bobsString = "~~~Bob's Bagels~~~";
		prettyReceipt += centerAlignStringWithPadding(bobsString, totalWidth) + "\n";
		String dateString = getYYYYMMDD() + "\n";
		prettyReceipt += centerAlignStringWithPadding(dateString, totalWidth);
		String dateTime = getISOTime();
		int a = dateTime.lastIndexOf('.');
		dateTime = dateTime.substring(0, a);
		prettyReceipt += centerAlignStringWithPadding(dateTime, totalWidth);

		prettyReceipt += "\n";


		String receiptBreak = "=".repeat(totalWidth);
		prettyReceipt += receiptBreak + "\n";

//		padd each item and pretty-print
		for(String str: receiptOrder){
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

		double sumSaved = totalCartPrice-price;
		String sumSavedStr = String.format("%.2f", sumSaved);
		String sumSavedAmountPadded = leftAlignStringWithPadding("£ " + sumSavedStr, priceWithPadding);
		prettyReceipt += "\n" + sumStart + " ".repeat(quantityWithPadding) + sumSavedAmountPadded;

		// total sum
		String totalSumPrice = String.format("%.2f", price);
		String totalStart = String.format("%-" + itemLengthWithPadding + "s", "Total");
		String totalSum = String.format("%" + priceWithPadding + "s", "£ " + totalSumPrice);
		prettyReceipt += "\n" + totalStart + " ".repeat(quantityWithPadding) + totalSum;


		prettyReceipt += "\n" + receiptBreak + "\n";

		return prettyReceipt;
	}
}
