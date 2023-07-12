package com.booleanuk.core;

import com.booleanuk.core.types.BagelType;
import com.booleanuk.core.types.CoffeeType;
import com.booleanuk.core.types.FillingType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BasketTest {

    private Basket basket;
    private Item bagel;
    private Item coffee;
    private List<Item> expectedItems;

    @BeforeEach
    public void setup() {
        basket = new Basket(5);
        bagel = new Bagel(BagelType.PLAIN, FillingType.BACON);
        coffee = new Coffee(CoffeeType.BLACK);
        expectedItems = List.of(bagel, coffee);
    }

    @Test
    public void addAddsItemIfBasketIsNotFull() {
        List<Item> expectedItems = List.of(bagel, coffee);
        basket.add(bagel);
        basket.add(coffee);

        assertEquals(2 ,basket.getItems().size());
        assertEquals(basket.getItems(), expectedItems);
    }

    @Test
    public void addThrowsExceptionIfBasketIsFull() {
        basket.add(bagel);
        basket.add(bagel);
        basket.add(bagel);
        basket.add(coffee);
        basket.add(coffee);

        assertThrows(IllegalStateException.class, () -> basket.add(coffee));
    }

    @Test
    public void removeRemovesItems() {
        basket.add(bagel);
        basket.add(bagel);
        basket.add(coffee);

        basket.remove(bagel);

        Assertions.assertEquals(2 ,basket.getItems().size());
        Assertions.assertEquals(basket.getItems(), expectedItems);
    }

    @Test
    public void removeThrowsExceptionIfItemIsNotInBasket() {
        basket.add(bagel);
        basket.add(bagel);

        assertThrows(IllegalArgumentException.class, () -> basket.remove(coffee));
    }

    @Test
    public void isFullReturnsTrueIfBasketIsFull() {
        Assertions.assertFalse(basket.isFull());
        basket.add(bagel);
        basket.add(bagel);
        basket.add(coffee);
        basket.add(bagel);
        basket.add(bagel);

        Assertions.assertTrue(basket.isFull());

        Assertions.assertThrows(IllegalStateException.class, () -> basket.add(bagel));
    }

    @Test
    public void isFullReturnsFalseIfBasketIsNotFull() {
        Assertions.assertFalse(basket.isFull());
        basket.add(bagel);
        basket.add(bagel);

        Assertions.assertFalse(basket.isFull());
    }

    @Test
    public void changeCapacityChangesCapacity() {
        Assertions.assertEquals(5, basket.getCapacity());

        basket.changeCapacity(7);

        Assertions.assertEquals(7, basket.getCapacity());

        basket.changeCapacity(3);

        Assertions.assertEquals(3, basket.getCapacity());
    }

    @Test
    public void removeItemRemovesItemProperly() {
        basket.add(bagel);
        basket.add(coffee);
        Assertions.assertEquals(2 ,basket.getItemCount());
        Assertions.assertTrue(basket.getItems().contains(bagel));

        basket.remove(coffee);

        Assertions.assertTrue(basket.checkIfExists(bagel));
        Assertions.assertFalse(basket.checkIfExists(coffee));

    }

    @Test
    public void getTotalCostReturnsTotalCost() {
        basket.add(bagel);
        basket.add(coffee);

        Assertions.assertEquals(basket.getTotalCost(), (bagel.getPrice() + coffee.getPrice()) / 100.0);
    }

    @Test
    public void getItemCountReturnsProperValue() {
        basket.add(bagel);
        basket.add(coffee);

        Assertions.assertEquals(2 ,basket.getItemCount());
        Assertions.assertTrue(basket.getItems().contains(bagel));

        basket.remove(bagel);

        Assertions.assertEquals(1 ,basket.getItemCount());

        basket.add(coffee);

        Assertions.assertEquals(2 ,basket.getItemCount());

        basket.remove(coffee);

        Assertions.assertEquals(1 ,basket.getItemCount());
    }

    @Test
    public void hasItemReturnsProperValue() {
        basket.add(bagel);
        Assertions.assertTrue(basket.checkIfExists(bagel));
        Assertions.assertFalse(basket.checkIfExists(coffee));
    }

    @Test
    public void freeSpaceReturnsProperValue() {
        basket.add(bagel);
        Assertions.assertEquals(4, basket.freeSpace());

        basket.remove(bagel);

        Assertions.assertEquals(5, basket.freeSpace());
    }

    @Test
    public void getItemsReturnProperList() {
        basket.add(bagel);

        Assertions.assertEquals(1, basket.getItems().size());

        basket.add(coffee);

        Assertions.assertEquals(2, basket.getItems().size());
        Assertions.assertEquals(expectedItems, basket.getItems());
        Assertions.assertTrue(basket.getItems().contains(bagel));
        Assertions.assertTrue(basket.getItems().contains(coffee));
    }

    @Test
    public void clearItemsClearsListOfItems() {
        basket.add(bagel);
        basket.add(bagel);
        basket.add(bagel);

        Assertions.assertEquals(3, basket.getItemCount());

        basket.clearBasket();

        Assertions.assertEquals(0, basket.getTotalCost());
    }
}

