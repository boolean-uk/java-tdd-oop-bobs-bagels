package com.booleanuk.extension;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.booleanuk.extension.types.BagelType.*;
import static com.booleanuk.extension.types.CoffeeType.*;
import static com.booleanuk.extension.types.FillingType.*;
import static org.junit.jupiter.api.Assertions.*;

class BasketTest {

    private Basket basket;
    private Bagel bagel;
    private Coffee coffee;
    private Map<Item,Integer> expectedItems;

    @BeforeEach
    public void setup() {
        basket = new Basket(15);
        bagel = new Bagel(PLAIN,BACON);
        coffee = new Coffee(BLACK);
        expectedItems = new HashMap<>();
        expectedItems.put(bagel,1);
        expectedItems.put(coffee,2);

    }

    @Test
    public void addAddsItemIfBasketIsNotFull() {


        basket.add(bagel);
        basket.add(coffee);
        basket.add(coffee);

        assertEquals(3 ,basket.getItemCount());

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
        Map<Item,Integer> expected = new HashMap<>();
        expected.put(coffee,1);

        basket.add(bagel);
        basket.add(bagel);
        basket.add(coffee);
        basket.remove(bagel);

        assertEquals(1 ,basket.getItems().size());
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
        assertTrue(basket.getItems().keySet().contains(bagel));

        basket.remove(coffee);

        assertTrue(basket.checkIfExists(bagel));
        assertFalse(basket.checkIfExists(coffee));

    }

    @Test
    public void getTotalCostReturnsTotalCost() {
        basket.add(bagel);
        basket.add(coffee);
        basket.add(bagel);
        basket.add(bagel);
        basket.add(bagel);
        basket.add(bagel);
        basket.add(bagel);

        assertEquals(basket.getTotalCost(), (249 + coffee.getPrice()) / 100.0);
        basket.add(bagel);
        basket.add(bagel);
        basket.add(bagel);
        basket.add(bagel);
        basket.add(bagel);
        basket.add(bagel);
        assertEquals(basket.getTotalCost(), (399 + coffee.getPrice()) / 100.0);

    }

    @Test
    public void getItemCountReturnsProperValue() {
        basket.add(bagel);
        basket.add(coffee);
        assertEquals(2 ,basket.getItemCount());
        assertTrue(basket.getItems().keySet().contains(bagel));

        basket.remove(bagel);

        assertEquals(1 ,basket.getItemCount());

        basket.add(coffee);

        assertEquals(2 ,basket.getItemCount());

        basket.remove(coffee);
        assertEquals(0 ,basket.getItemCount());
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
    public void getItemsReturnProperMap() {
        basket.add(bagel);

        assertEquals(1, basket.getItems().keySet().size());

        basket.add(coffee);
        basket.add(coffee);

        assertEquals(2, basket.getItems().keySet().size());
        assertEquals(expectedItems, basket.getItems());
        assertTrue(basket.getItems().keySet().contains(bagel));
        assertTrue(basket.getItems().keySet().contains(coffee));
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

