package com.booleanuk.extension;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static com.booleanuk.extension.Basket.*;
import static com.booleanuk.extension.types.BagelType.PLAIN;
import static com.booleanuk.extension.types.BagelType.SESAME;
import static com.booleanuk.extension.types.CoffeeType.BLACK;
import static com.booleanuk.extension.types.FillingType.BACON;
import static com.booleanuk.extension.types.FillingType.WITHOUT_FILLING;
import static org.junit.jupiter.api.Assertions.*;

class BasketTest {

    private Basket basket;
    private Bagel bagel;
    private Bagel bagelWithoutFilling;
    private Coffee coffee;

    private Map<Item, Integer> expectedItems;

    @BeforeEach
    public void setup() {
        TwilioService twilioService = new TwilioService();
        basket = new Basket(20, twilioService);
        bagel = new Bagel(SESAME, BACON);
        bagelWithoutFilling = new Bagel(PLAIN, WITHOUT_FILLING);
        coffee = new Coffee(BLACK);
        expectedItems = new HashMap<>();
        expectedItems.put(bagel, 1);
        expectedItems.put(coffee, 2);

    }

    @Test
    public void addAddsItemIfBasketIsNotFull() {
        basket.add(bagel);
        basket.add(coffee);
        basket.add(coffee);

        assertEquals(3, basket.getItemCount());

        assertEquals(basket.getItems(), expectedItems);
    }

    @Test
    public void addThrowsExceptionIfBasketIsFull() {
        basket.setCapacity(5);
        basket.add(bagel);
        basket.add(bagel);
        basket.add(bagel);
        basket.add(coffee);
        basket.add(coffee);

        assertThrows(IllegalStateException.class, () -> basket.add(coffee));
    }

    @Test
    public void removeRemovesItems() {
        Map<Item, Integer> expected = new HashMap<>();
        expected.put(coffee, 1);

        basket.add(bagel);
        basket.add(bagel);
        basket.add(coffee);
        basket.remove(bagel);

        assertEquals(1, basket.getItems().size());
        assertEquals(basket.getItems(), expected);
    }

    @Test
    public void removeThrowsExceptionIfItemIsNotInBasket() {
        basket.add(bagel);
        basket.add(bagel);

        assertThrows(IllegalArgumentException.class, () -> basket.remove(coffee));
    }

    @Test
    public void isFullReturnsTrueIfBasketIsFull() {
        assertFalse(basket.isFull());
        basket.setCapacity(5);
        basket.add(bagel);
        basket.add(bagel);
        basket.add(coffee);
        basket.add(bagel);
        basket.add(bagel);

        assertTrue(basket.isFull());

        Assertions.assertThrows(IllegalStateException.class, () -> basket.add(bagel));
    }

    @Test
    public void isFullReturnsFalseIfBasketIsNotFull() {
        assertFalse(basket.isFull());
        basket.add(bagel);
        basket.add(bagel);

        assertFalse(basket.isFull());
    }

    @Test
    public void changeCapacityChangesCapacity() {
        assertEquals(20, basket.getCapacity());

        basket.setCapacity(7);

        assertEquals(7, basket.getCapacity());

        basket.setCapacity(3);

        assertEquals(3, basket.getCapacity());
    }

    @Test
    public void removeItemRemovesItemProperly() {
        basket.add(bagel);
        basket.add(coffee);
        assertEquals(2, basket.getItemCount());
        assertTrue(basket.getItems().containsKey(bagel));

        basket.remove(coffee);

        assertTrue(basket.checkIfExists(bagel));
        assertFalse(basket.checkIfExists(coffee));

    }

    @Test
    public void getTotalCostReturnsTotalCost() {
        basket.add(bagelWithoutFilling);
        basket.add(bagel);

        assertEquals((bagelWithoutFilling.getPrice() + bagel.getPrice()) / 100.0, basket.getTotalCost());
    }

    @Test
    public void getTotalCostWithCoffeeAndBagelDiscountReturnsTotalCost() {
        basket.add(bagelWithoutFilling);
        basket.add(bagel);
        basket.add(coffee);
        assertEquals((COFFEE_PLUS_BAGEL + bagel.getPrice()) / 100.0, basket.getTotalCost());
    }

    @Test
    public void getTotalCostReturnsTotalCostFor6BagelsSpecialOffer() {
        basket.add(bagelWithoutFilling);
        basket.add(bagelWithoutFilling);
        basket.add(bagelWithoutFilling);
        basket.add(bagelWithoutFilling);
        basket.add(bagelWithoutFilling);
        basket.add(bagelWithoutFilling);

        assertEquals(SIX_BAGELS_PRICE / 100.0, basket.getTotalCost());
    }

    @Test
    public void getTotalCostReturnsTotalCostFor6BagelsSpecialOfferPlusOneBagel() {
        basket.add(bagelWithoutFilling);
        basket.add(bagelWithoutFilling);
        basket.add(bagelWithoutFilling);
        basket.add(bagelWithoutFilling);
        basket.add(bagelWithoutFilling);
        basket.add(bagelWithoutFilling);
        basket.add(bagel);

        assertEquals((SIX_BAGELS_PRICE + bagel.getPrice()) / 100.0, basket.getTotalCost());
    }

    @Test
    public void getTotalCostReturnsTotalCostFor6BagelsSpecialOfferPlusOneCoffeeOffer() {
        basket.add(bagelWithoutFilling);
        basket.add(bagelWithoutFilling);
        basket.add(bagelWithoutFilling);
        basket.add(bagelWithoutFilling);
        basket.add(bagelWithoutFilling);
        basket.add(bagelWithoutFilling);
        basket.add(bagel);
        basket.add(coffee);

        assertEquals((SIX_BAGELS_PRICE + COFFEE_PLUS_BAGEL + SINGLE_FILLING_PRICE) / 100.0, basket.getTotalCost());
    }

    @Test
    public void getTotalCostReturnsTotalCostFor6BagelsSpecialOfferPlusOneCoffeeOfferAndOneBagel() {
        basket.add(bagelWithoutFilling);
        basket.add(bagelWithoutFilling);
        basket.add(bagelWithoutFilling);
        basket.add(bagelWithoutFilling);
        basket.add(bagelWithoutFilling);
        basket.add(bagelWithoutFilling);
        basket.add(bagel);
        basket.add(bagel);
        basket.add(coffee);

        assertEquals((SIX_BAGELS_PRICE + COFFEE_PLUS_BAGEL + SINGLE_FILLING_PRICE + bagel.getPrice()) / 100.0, basket.getTotalCost());
    }

    @Test
    public void getTotalCostReturnsTotalCostFor12BagelsSpecialOfferPlusOneCoffeeOffer() {
        basket.add(bagel);
        basket.add(bagel);
        basket.add(bagel);
        basket.add(bagel);
        basket.add(bagel);
        basket.add(bagel);
        basket.add(bagel);
        basket.add(bagel);
        basket.add(bagel);
        basket.add(bagel);
        basket.add(bagel);
        basket.add(bagel);
        basket.add(coffee);

        assertEquals((TWELVE_BAGELS_PRICE + 12 * SINGLE_FILLING_PRICE + coffee.getPrice()) / 100.0, basket.getTotalCost());
    }

    @Test
    public void getItemCountReturnsProperValue() {
        basket.add(bagel);
        basket.add(coffee);
        assertEquals(2, basket.getItemCount());
        assertTrue(basket.getItems().containsKey(bagel));

        basket.remove(bagel);

        assertEquals(1, basket.getItemCount());

        basket.add(coffee);

        assertEquals(2, basket.getItemCount());

        basket.remove(coffee);
        assertEquals(0, basket.getItemCount());
    }

    @Test
    public void hasItemReturnsProperValue() {
        basket.add(bagel);
        assertTrue(basket.checkIfExists(bagel));
        assertFalse(basket.checkIfExists(coffee));
    }

    @Test
    public void freeSpaceReturnsProperValue() {
        basket.add(bagel);
        assertEquals(19, basket.getRemainingSpace());

        basket.remove(bagel);

        assertEquals(20, basket.getRemainingSpace());
    }

    @Test
    public void getItemsReturnProperMap() {
        basket.add(bagel);

        assertEquals(1, basket.getItems().keySet().size());

        basket.add(coffee);
        basket.add(coffee);

        assertEquals(2, basket.getItems().keySet().size());
        assertEquals(expectedItems, basket.getItems());
        assertTrue(basket.getItems().containsKey(bagel));
        assertTrue(basket.getItems().containsKey(coffee));
    }

    @Test
    public void clearItemsClearsListOfItems() {
        basket.add(bagel);
        basket.add(bagel);
        basket.add(bagel);

        assertEquals(3, basket.getItemCount());

        basket.clearBasket();

        assertEquals(0, basket.getTotalCost());
    }

//    @Test
//    public void getReceiptPrintsReceipt() {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
//        String date = LocalDateTime.now().format(formatter);
//
//        basket.add(bagel);
//        basket.add(bagelWithoutFilling);
//        basket.add(coffee);
//
//        assertEquals("Bob's Bagels - Receipt\n" + date + "\n" +
//                        """
//                                PLAIN Bagel x1 at $0.39 = $0.39
//                                SESAME Bagel x1 at $0.61 = $0.61
//                                Coffee x1 at $0.99 = $0.99
//                                 (Special Offer: Coffee+Bagel: 1 for $1.25)
//                                Total Cost: $1.86
//                                Total Discount: $0.99
//                                Thank you for your order!""",
//                basket.getReceipt());
//    }

    @Test
    public void orderSendsMessage() {
        basket.add(bagel);
        basket.add(bagel);
        basket.add(bagel);
        basket.add(coffee);

        assertDoesNotThrow(() -> basket.order());
    }

}

