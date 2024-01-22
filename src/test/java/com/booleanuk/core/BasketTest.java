package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
			for (int i = 0; i < 30; i++) {

				basket.addItem("BGLP");
			}


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
		Assertions.assertEquals(30, basket.getSize());
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

	@Test
	public void buyBulkTest() {
		Inventory inventory = new Inventory();
		Basket basket2 = new Basket(inventory);
		for (int i = 0; i < 12; i++) {
			try {
				basket2.addItem("BGLP");
			} catch (NotInInventoryException e) {
				throw new RuntimeException(e);
			}
		}
		Assertions.assertEquals(3.99, basket2.getTotalCost(), 0.01);

		for (int i = 0; i < 6; i++) {
			try {
				basket2.addItem("BGLO");
			} catch (NotInInventoryException e) {
				throw new RuntimeException(e);
			}
		}
		Assertions.assertEquals(3.99 + 2.49, basket2.getTotalCost(), 0.001);

		Basket basket3 = new Basket(inventory);
		try {
			basket3.addItem("BGLO");
			basket3.addItem("COFB");
		} catch (NotInInventoryException e) {
			throw new RuntimeException(e);
		}
		Assertions.assertEquals(1.25, basket3.getTotalCost(), 0.01);
		Basket basket = new Basket(inventory);
		try {
			for (int i = 0; i < 12; i++) {

				basket.addItem("BGLP");
			}
			Assertions.assertEquals(3.99, basket.getTotalCost(), 0.1);
			basket.addItem("BGLP");
			basket.addItem("BGLP");
			basket.addItem("BGLP");
			basket.addItem("BGLP");
			Assertions.assertEquals(5.55, basket.getTotalCost(), 0.1);
		} catch (NotInInventoryException e) {
			throw new RuntimeException(e);
		}
		Basket basket4 = new Basket(inventory);
		try {
			basket4.addItem("BGLO");
			basket4.addItem("BGLO");
			Assertions.assertEquals(0.49 + 0.49, basket4.getTotalCost(), 0.1);

			for (int i = 0; i < 12; i++) {

				basket4.addItem("BGLP");
			}
			Assertions.assertEquals(0.49 + 0.49 + 3.99, basket4.getTotalCost(), 0.1);

			for (int i = 0; i < 6; i++) {

				basket4.addItem("BGLE");
			}
			Assertions.assertEquals(0.49 + 0.49 + 3.99 + 2.49, basket4.getTotalCost(), 0.1);
			basket4.addItem("COFB");
			basket4.addItem("COFB");
			Assertions.assertEquals(1.25 + 1.25 + 3.99 + 2.49, basket4.getTotalCost(), 0.1);
			basket4.addItem("COFB");
			Assertions.assertEquals(1.25 + 1.25 + 3.99 + 2.49 + 0.99, basket4.getTotalCost(), 0.1);

		} catch (NotInInventoryException e) {
			throw new RuntimeException(e);
		}
		Basket basket5 = new Basket(inventory);

		try {
			basket5.addItem("BGLP");
			basket5.addItem("BGLP");
			basket5.addItem("BGLP");
			basket5.addItem("BGLP");
			basket5.addItem("BGLP");
			basket5.addItem("BGLP");
			Assertions.assertEquals(0.39 * 6, basket5.getTotalCost(), 0.1);


		} catch (NotInInventoryException e) {
			throw new RuntimeException(e);
		}

	}

	@Test
	public void printReceiptTest() {
		Inventory inventory = new Inventory();
		Basket basket = new Basket(inventory);
		String receipt = basket.printReceipt();
		LocalDateTime currentTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String formattedTime = currentTime.format(formatter);
		String example = "\n    ~~~ Bob's Bagels ~~~\n" +
				"    " + formattedTime + "\n" +
				"----------------------------\n" +
				"----------------------------\n" +
				"Total\t\t\t\t\t\u00A30.00\n" +
				"\n" +
				"        Thank you\n" +
				"\t for your order !\n";
		Assertions.assertEquals(example, receipt);

		try {
			basket.addItem("BGLP");
			example = "\n    ~~~ Bob's Bagels ~~~\n" +
					"    " + formattedTime + "\n" +
					"----------------------------\n" +
					"Plain            1\t\t\u00A30.39\n" +
					"----------------------------\n" +
					"Total\t\t\t\t\t\u00A30.39\n" +
					"\n" +
					"        Thank you\n" +
					"\t for your order !\n";
			receipt = basket.printReceipt();
			Assertions.assertEquals(example, receipt);
		} catch (NotInInventoryException e) {
			throw new RuntimeException(e);
		}

		try {
			basket.addItem("BGLP");
			example = "\n    ~~~ Bob's Bagels ~~~\n" +
					"    " + formattedTime + "\n" +
					"----------------------------\n" +
					"Plain            2\t\t\u00A30.39\n" +
					"----------------------------\n" +
					"Total\t\t\t\t\t\u00A30.78\n" +
					"\n" +
					"        Thank you\n" +
					"\t for your order !\n";
			receipt = basket.printReceipt();
			Assertions.assertEquals(example, receipt);
		} catch (NotInInventoryException e) {
			throw new RuntimeException(e);
		}
		try {
			basket.addItem("BGLP");
			basket.addItem("BGLP");
			basket.addItem("BGLP");
			basket.addItem("BGLP");
			example = "\n    ~~~ Bob's Bagels ~~~\n" +
					"    " + formattedTime + "\n" +
					"----------------------------\n" +
					"Plain            6\t\t\u00A30.39\n" +
					"----------------------------\n" +
					"Total\t\t\t\t\t\u00A32.34\n" +
					"\n" +
					"        Thank you\n" +
					"\t for your order !\n";
			receipt = basket.printReceipt();
			Assertions.assertEquals(example, receipt);
		} catch (NotInInventoryException e) {
			throw new RuntimeException(e);
		}
		try {
			for (int i = 0; i < 5; i++) {
				basket.addItem("BGLO");
			}
			example = "\n    ~~~ Bob's Bagels ~~~\n" +
					"    " + formattedTime + "\n" +
					"----------------------------\n" +
					"Plain            6\t\t\u00A30.39\n" +
					"Onion            5\t\t\u00A30.49\n" +
					"----------------------------\n" +
					"Total\t\t\t\t\t\u00A34.79\n" +
					"\n" +
					"        Thank you\n" +
					"\t for your order !\n";
			receipt = basket.printReceipt();
			Assertions.assertEquals(example, receipt);
		} catch (NotInInventoryException e) {
			throw new RuntimeException(e);
		}
		try {
			basket = new Basket(inventory);
			basket.addItem("COFB");

			example = "\n    ~~~ Bob's Bagels ~~~\n" +
					"    " + formattedTime + "\n" +
					"----------------------------\n" +
					"Black            1\t\t\u00A30.99\n" +
					"----------------------------\n" +
					"Total\t\t\t\t\t\u00A30.99\n" +
					"\n" +
					"        Thank you\n" +
					"\t for your order !\n";
			receipt = basket.printReceipt();
			Assertions.assertEquals(example, receipt);
		} catch (NotInInventoryException e) {
			throw new RuntimeException(e);
		}
		try {
			basket = new Basket(inventory);
			basket.addItem("BGLP");
			basket.addExtra(0, "FILX");
			basket.addExtra(0, "FILS");

			example = "\n    ~~~ Bob's Bagels ~~~\n" +
					"    " + formattedTime + "\n" +
					"----------------------------\n" +
					"Plain            1\t\t\u00A30.39\n" +
					"Cream Cheese     1\t\t\u00A30.12\n" +
					"Smoked Salmon    1\t\t\u00A30.12\n" +
					"----------------------------\n" +
					"Total\t\t\t\t\t\u00A30.63\n" +
					"\n" +
					"        Thank you\n" +
					"\t for your order !\n";
			receipt = basket.printReceipt();
			Assertions.assertEquals(example, receipt);
		} catch (NotInInventoryException e) {
			throw new RuntimeException(e);
		}
		try {
			basket = new Basket(inventory);
			basket.addItem("BGLP");
			basket.addItem("BGLO");
			basket.addItem("BGLO");
			basket.addExtra(0, "FILX");
			basket.addExtra(0, "FILS");
			basket.addExtra(1, "FILH");
			example = "\n    ~~~ Bob's Bagels ~~~\n" +
					"    " + formattedTime + "\n" +
					"----------------------------\n" +
					"Plain            1\t\t\u00A30.39\n" +
					"Onion            2\t\t\u00A30.49\n" +
					"Cream Cheese     1\t\t\u00A30.12\n" +
					"Smoked Salmon    1\t\t\u00A30.12\n" +
					"Ham              1\t\t\u00A30.12\n" +
					"----------------------------\n" +
					"Total\t\t\t\t\t\u00A31.73\n" +
					"\n" +
					"        Thank you\n" +
					"\t for your order !\n";
			receipt = basket.printReceipt();
			Assertions.assertEquals(example, receipt);
		} catch (NotInInventoryException e) {
			throw new RuntimeException(e);
		}
	}
}
