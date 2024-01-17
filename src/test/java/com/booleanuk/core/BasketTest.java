package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BasketTest {
	Inventory inventory;

	@Test
	public void addBagelTest() {
		initInventory();
		Basket basket = new Basket(inventory);
		Assertions.assertFalse(basket.inBasket(1));
		Assertions.assertFalse(basket.inBasket(2));
		try {
			basket.addBagel(1);
		} catch (NotInInventoryException e) {
			throw new RuntimeException(e);
		}
		Assertions.assertTrue(basket.inBasket(1));
		Assertions.assertFalse(basket.inBasket(2));
	}

	@Test
	public void removeBagelTest() {
		initInventory();
		Basket basket = new Basket(inventory);
		try {
			basket.addBagel(1);
		} catch (NotInInventoryException e) {
			throw new RuntimeException(e);
		}
		Assertions.assertTrue(basket.inBasket(1));
		Assertions.assertFalse(basket.inBasket(2));
		try {
			basket.removeBagel(1);
		} catch (NotInBasketException e) {
			throw new RuntimeException(e);
		}
		Assertions.assertFalse(basket.inBasket(1));
		Assertions.assertFalse(basket.inBasket(2));
	}

	@Test
	public void basketIsFullTest() {
		initInventory();
		Basket basket = new Basket(inventory);
		Assertions.assertFalse(basket.isFull());
		try {
			basket.addBagel(1);
			basket.addBagel(2);
			basket.addBagel(2);
		} catch (NotInInventoryException e) {
			throw new RuntimeException(e);
		}
		Assertions.assertTrue(basket.isFull());

		try {
			basket.removeBagel(1);
		} catch (NotInBasketException e) {
			throw new RuntimeException(e);
		}

		Assertions.assertFalse(basket.isFull());

	}

	private void initInventory() {
		inventory = new Inventory();
		Bagel bagel1 = new Bagel(0, "Plain", 1.99);
		Bagel bagel2 = new Bagel(1, "Ham", 1.99);
		Bagel bagel3 = new Bagel(2, "Cheese", 1.99);
		Bagel bagel4 = new Bagel(3, "Everything", 2.49);
		inventory.addItem(bagel1.id);
		inventory.addItem(bagel2.id);
		inventory.addItem(bagel3.id);
		inventory.addItem(bagel4.id);
	}
}
