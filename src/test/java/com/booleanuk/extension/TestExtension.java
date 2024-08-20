package com.booleanuk.extension;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestExtension {

    Store store = new Store(20);

    Product bagel1 = new Bagel("BGLO", "Onion", 49);
    Product bagel2 = new Bagel("BGLP", "Plain", 39);
    Product bagel3 = new Bagel("BGLE", "Everything", 49);
    Product bagel4 = new Bagel("BGLS", "Sesame", 49);
    Product coffee1 = new Coffee("COFB", "Black", 99);
    Product coffee2 = new Coffee("COFW", "White", 119);
    Product coffee3 = new Coffee("COFC", "Capuccino", 129);
    Product coffee4 = new Coffee("COFL", "Latte", 129);
    Product filling1 = new Filling("FILB", "Bacon", 12);
    Product filling2 = new Filling("FILE", "Egg", 12);
    Product filling3 = new Filling("FILC", "Cheese", 12);
    Product filling4 = new Filling("FILX", "Cream Cheese", 12);
    Product filling5 = new Filling("FILS", "Smoked Salmon", 12);
    Product filling6 = new Filling("FILH", "Ham", 12);

    void mainTest(){
        store.addProduct(bagel1, 0);
        store.addProduct(bagel2, 1);
        store.addProduct(bagel3, 2);
        store.addProduct(bagel4, 3);
        store.addProduct(coffee1, 4);
        store.addProduct(coffee2, 5);
        store.addProduct(coffee3, 6);
        store.addProduct(coffee4, 7);
        store.addProduct(filling1, 8);
        store.addProduct(filling2, 9);
        store.addProduct(filling3, 10);
        store.addProduct(filling4, 11);
        store.addProduct(filling5, 12);
        store.addProduct(filling6, 13);
    }

    @Test
    public void testDiscountSix() throws Exception {
        mainTest();
        Order order1 = new Order();
        order1.addProduct("BGLO", store);
        order1.addProduct("BGLO", store);
        order1.addProduct("BGLO", store);
        order1.addProduct("BGLO", store);
        order1.addProduct("BGLO", store);
        order1.addProduct("BGLO", store);
        Assertions.assertEquals(249, order1.getPrice(store));
    }
}
