package com.booleanuk.core;

import com.booleanuk.core.models.Bagel;
import com.booleanuk.core.models.Filling;
import com.booleanuk.core.models.Item;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class BasketTest {
    Invetory invetory = new Invetory();


    @Test
    void addItem() {
        Basket basket = new Basket();
        Item bagel = invetory.bagels.get(0);
        List<Integer> quantityArray = new ArrayList<>();
        List<Item> itemArray = new ArrayList<>();
        itemArray.add(bagel);
        quantityArray.add(2);
        Assertions.assertTrue(basket.add(bagel, 2));
        Assertions.assertIterableEquals(quantityArray, basket.basketQuantity);
        Assertions.assertIterableEquals(itemArray, basket.basket);
        //no more than the capacity of the basket
        Assertions.assertFalse(basket.add(bagel, 5));
        //no item of the invetory!
        Assertions.assertFalse(basket.add(new Item("newVariant", 10000.0, "invalidSKU"), 1));
    }

    @Test
    void removeItem() {
        Item bagel = invetory.bagels.get(0);
        Item anotherBagel = invetory.bagels.get(1);
        Item coffee = invetory.coffees.get(0);

        List<Item> itemArray = new ArrayList<>();
        itemArray.add(anotherBagel);
        itemArray.add(coffee);

        List<Integer> quantityArray = new ArrayList<>();
        quantityArray.add(1);
        quantityArray.add(1);

        Basket basket = new Basket();
        basket.setCapacity(10);
        basket.add(bagel, 3);
        basket.add(anotherBagel, 1);
        basket.add(coffee, 2);


        Assertions.assertEquals(6, basket.sizeOfBasket);
        Assertions.assertTrue(basket.remove(bagel, 3));
        Assertions.assertIterableEquals(itemArray, basket.basket);
        //attempt to remove item that is not in the list
        Assertions.assertFalse(basket.remove(bagel, 3));
        //attempt to remove more quantity
        Assertions.assertFalse(basket.remove(anotherBagel, 3));
        basket.remove(coffee, 1);
        Assertions.assertIterableEquals(quantityArray, basket.basketQuantity);

    }

    @Test
    void SetGetCapacity() {
        Basket basket = new Basket();
        Item bagel = invetory.bagels.get(0);
        basket.setCapacity(10);
        Assertions.assertEquals(10,basket.getCapacity());
        Assertions.assertTrue(basket.add(bagel, 7));
        Assertions.assertFalse(basket.setCapacity(6));
        Assertions.assertTrue(basket.setCapacity(8));
        Assertions.assertEquals(8,basket.getCapacity());


    }

    @Test
    void getTotalPriceOfBasket() {
        Basket basket = new Basket();
        basket.setCapacity(100);
        Item bagel = invetory.bagels.get(0);

        Item coffee = invetory.coffees.get(0);
        basket.add(bagel, 1);
        Assertions.assertEquals(basket.getTotalOfBasket(), 0.49);
        basket.add(coffee, 1);
        Assertions.assertEquals(basket.getTotalOfBasket(), 0.49 + 0.99);
        basket.add(bagel, 1);
        Assertions.assertEquals(basket.getTotalOfBasket(), 0.49 + 0.49 + 0.99);
        Bagel bagelConstactor = invetory.bagels.get(0); //Price 0.49
        Bagel bagelWithFilling =new Bagel(bagelConstactor.getVariant(),bagelConstactor.getPrice(),bagelConstactor.getSKU());
        Filling filling = invetory.fillings.get(0);//Price 0.12
        bagelWithFilling.setFillings(filling);
        Assertions.assertTrue(basket.add(bagelWithFilling, 1));
        Assertions.assertEquals(basket.getTotalOfBasket(), 0.49 + 0.49 + 0.99 + 0.49 + 0.12);
    }


}
