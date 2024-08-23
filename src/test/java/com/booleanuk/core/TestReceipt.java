package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class TestReceipt {

	@Test
	public void testReceiptConstr(){
		Receipt r = new Receipt(null, 15, 17);
	}

	@Test
	public void testReceipt(){
		ArrayList<String> items = new ArrayList<>();
		items.add("Coffee and Bagel,2,2.50,(-0.26)");
		Receipt r = new Receipt(items, 15, 17);
		String result = r.getTotalDiscountReceiptString();
		String expected = "Coffee and Bagel       2   £ 2.50\n" +
				"                          (-0.26)\n" +
				"――――――――――――――――――――\n" +
				"Saved                      £ 2.00\n" +
				"Total                     £ 15.00";
		System.out.println(result);
		Assertions.assertTrue(result.contains(expected));
	}


}
