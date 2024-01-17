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
			basket.removeItem("BGLP");
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
			basket.removeItem("BGLP");
		} catch (NotInBasketException e) {
			throw new RuntimeException(e);
		}
		Assertions.assertFalse(basket.isFull());

	}
	@Test
	public void inBasketTest(){
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

}
