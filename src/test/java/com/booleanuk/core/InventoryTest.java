package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class InventoryTest {
	@Test
	public void getDiscountsTest() {
		Inventory inventory = new Inventory();
		ArrayList<DiscountBulk> db = inventory.getDiscountsBulk();
		Assertions.assertEquals("BGLO",db.get(0).getId());
		ArrayList<DiscountCombo> dc = inventory.getDiscountsCombo();
		Assertions.assertEquals("BGL",dc.get(0).comboItems[0]);
		Assertions.assertEquals("COF",dc.get(0).comboItems[1]);

	}

	@Test
	public void hasDiscountTest() {
		Inventory inventory = new Inventory();
		Assertions.assertTrue(inventory.hasDiscount("BGLO"));
		Assertions.assertFalse(inventory.hasDiscount("BGLX"));
	}
	@Test
	public void getDiscountBulkIdsTest(){
		Inventory inventory= new Inventory();
		ArrayList<String> items = inventory.getDiscountBulkIds();
		Assertions.assertEquals(3,items.size());
		Assertions.assertEquals("BGLO",items.get(0));
		Assertions.assertEquals("BGLP",items.get(1));
		Assertions.assertEquals("BGLE",items.get(2));

	}

}
