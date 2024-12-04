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

        assertEquals(2 ,basket.getItems().size());
        assertEquals(basket.getItems(), expectedItems);
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
        assertEquals(5, basket.getCapacity());

        basket.changeCapacity(7);

        assertEquals(7, basket.getCapacity());

        basket.changeCapacity(3);

        assertEquals(3, basket.getCapacity());
    }

    @Test
    public void removeItemRemovesItemProperly() {
        basket.add(bagel);
        basket.add(coffee);
        assertEquals(2 ,basket.getItemCount());
        assertTrue(basket.getItems().contains(bagel));

        basket.remove(coffee);

        assertTrue(basket.checkIfExists(bagel));
        assertFalse(basket.checkIfExists(coffee));

    }

    @Test
    public void getTotalCostReturnsTotalCost() {
        basket.add(bagel);
        basket.add(coffee);

        assertEquals(basket.getTotalCost(), (bagel.getPrice() + coffee.getPrice()) / 100.0);
    }

    @Test
    public void getItemCountReturnsProperValue() {
        basket.add(bagel);
        basket.add(coffee);

        assertEquals(2 ,basket.getItemCount());
        assertTrue(basket.getItems().contains(bagel));

        basket.remove(bagel);

        assertEquals(1 ,basket.getItemCount());

        basket.add(coffee);

        assertEquals(2 ,basket.getItemCount());

        basket.remove(coffee);

        assertEquals(1 ,basket.getItemCount());
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
        assertEquals(4, basket.freeSpace());

        basket.remove(bagel);

        assertEquals(5, basket.freeSpace());
    }

    @Test
    public void getItemsReturnProperList() {
        basket.add(bagel);

        assertEquals(1, basket.getItems().size());

        basket.add(coffee);

        assertEquals(2, basket.getItems().size());
        assertEquals(expectedItems, basket.getItems());
        assertTrue(basket.getItems().contains(bagel));
        assertTrue(basket.getItems().contains(coffee));
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
}

