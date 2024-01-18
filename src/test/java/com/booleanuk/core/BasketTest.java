package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BasketTest {


	@Test
	public void addItemTest() {
		Inventory inventory = new Inventory();
		Basket basket = new Basket(inventory);
		Assertions.assertFalse(basket.inBasket("BGLP"));
		Assertions.assertFalse(basket.inBasket("BGLO"));
		try {
			basket.addItem("BGLP");
		} catch (NotInInventoryException e) {
			throw new RuntimeException(e);
		}
		Assertions.assertTrue(basket.inBasket("BGLP"));
		Assertions.assertFalse(basket.inBasket("BGLO"));
	}

	@Test
	public void removeItemTest() {
		Inventory inventory = new Inventory();
		Basket basket = new Basket(inventory);
		try {
			basket.addItem("BGLP");
		} catch (NotInInventoryException e) {
			throw new RuntimeException(e);
		}
		Assertions.assertTrue(basket.inBasket("BGLP"));
		Assertions.assertFalse(basket.inBasket("BGLO"));
		try {
			basket.removeItem(0);
		} catch (NotInBasketException e) {
			throw new RuntimeException(e);
		}
		Assertions.assertFalse(basket.inBasket("BGLP"));
		Assertions.assertFalse(basket.inBasket("BGLO"));
	}

	@Test
	public void basketIsFullTest() {
		Inventory inventory = new Inventory();
		Basket basket = new Basket(inventory);
		Assertions.assertFalse(basket.isFull());
		try {
			basket.addItem("BGLP");
			basket.addItem("BGLO");
			basket.addItem("BGLP");
		} catch (NotInInventoryException e) {
			throw new RuntimeException(e);
		}
		Assertions.assertTrue(basket.isFull());

		try {
			basket.removeItem(0);
		} catch (NotInBasketException e) {
			throw new RuntimeException(e);
		}
		Assertions.assertFalse(basket.isFull());

	}

	@Test
	public void inBasketTest() {
		Inventory inventory = new Inventory();
		Basket basket = new Basket(inventory);
		Assertions.assertFalse(basket.inBasket("BGLP"));
		try {
			basket.addItem("BGLP");
		} catch (NotInInventoryException e) {
			throw new RuntimeException(e);
		}
		Assertions.assertTrue(basket.inBasket("BGLP"));
	}

	@Test
	public void showFillingsTest() {
		Inventory inventory = new Inventory();
		Basket basket = new Basket(inventory);
		Assertions.assertEquals("Bacon:\t0.12\nEgg:\t0.12\nCheese:\t0.12\nCream Cheese:\t0.12\nSmoked Salmon:\t0.12\nHam:\t0.12", basket.showFillings());
	}

	@Test
	public void setSizeTest() {
		Inventory inventory = new Inventory();
		Basket basket = new Basket(inventory);
		Assertions.assertEquals(3, basket.getSize());
		try {
			basket.setSize(2);
		} catch (UnableToChangeBasketSizeException e) {
			throw new RuntimeException(e);
		}
		try {
			basket.addItem("BGLO");
			basket.addItem("BGLP");
		} catch (NotInInventoryException e) {
			throw new RuntimeException(e);
		}
		Assertions.assertThrows(UnableToChangeBasketSizeException.class, () -> {
			basket.setSize(1);
		});
	}

	@Test
	public void getTotalCostTest() {
		Inventory inventory = new Inventory();
		Basket basket = new Basket(inventory);
		try {
			basket.addItem("BGLP");
		} catch (NotInInventoryException e) {
			throw new RuntimeException(e);
		}
		Assertions.assertEquals(0.39, basket.getTotalCost());
	}

	@Test
	public void addFillingTest() {
		Inventory inventory = new Inventory();
		Basket basket = new Basket(inventory);
		try {
			basket.addItem("BGLP");
			basket.addExtra(0, "FILS");
		} catch (NotInInventoryException e) {
			throw new RuntimeException(e);
		}


	}

	@Test
	public void removeFillingTest() {
		Inventory inventory = new Inventory();
		Basket basket = new Basket(inventory);
		try {
			basket.addItem("BGLP");
			basket.addExtra(0, "FILS");
		} catch (NotInInventoryException e) {
			throw new RuntimeException(e);
		}
		basket.removeExtra(0, "FILS");
	}

	@Test
	public void getPriceTest() {
		Inventory inventory = new Inventory();
		Basket basket = new Basket(inventory);
		try {
			Assertions.assertEquals(0.39, basket.getPrice("BGLP"));
			Assertions.assertEquals(0.49, basket.getPrice("BGLO"));
			Assertions.assertEquals(0.12, basket.getPrice("FILS"));
		} catch (NotInInventoryException e) {
			throw new RuntimeException(e);
		}
	}
}
