package com.booleanuk.extension;

import com.booleanuk.core.Bagel;
import com.booleanuk.core.Coffee;
import com.booleanuk.core.Filling;
import com.booleanuk.core.Order;
import com.booleanuk.core.Product;
import com.booleanuk.core.Store;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestExtension {

    com.booleanuk.core.Store store = new Store(20);

    com.booleanuk.core.Product bagel1 = new com.booleanuk.core.Bagel("BGLO", "Onion", 49);
    com.booleanuk.core.Product bagel2 = new com.booleanuk.core.Bagel("BGLP", "Plain", 39);
    com.booleanuk.core.Product bagel3 = new com.booleanuk.core.Bagel("BGLE", "Everything", 49);
    com.booleanuk.core.Product bagel4 = new Bagel("BGLS", "Sesame", 49);
    com.booleanuk.core.Product coffee1 = new com.booleanuk.core.Coffee("COFB", "Black", 99);
    com.booleanuk.core.Product coffee2 = new com.booleanuk.core.Coffee("COFW", "White", 119);
    com.booleanuk.core.Product coffee3 = new com.booleanuk.core.Coffee("COFC", "Capuccino", 129);
    com.booleanuk.core.Product coffee4 = new Coffee("COFL", "Latte", 129);
    com.booleanuk.core.Product filling1 = new com.booleanuk.core.Filling("FILB", "Bacon", 12);
    com.booleanuk.core.Product filling2 = new com.booleanuk.core.Filling("FILE", "Egg", 12);
    com.booleanuk.core.Product filling3 = new com.booleanuk.core.Filling("FILC", "Cheese", 12);
    com.booleanuk.core.Product filling4 = new com.booleanuk.core.Filling("FILX", "Cream Cheese", 12);
    com.booleanuk.core.Product filling5 = new com.booleanuk.core.Filling("FILS", "Smoked Salmon", 12);
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
        com.booleanuk.core.Order order1 = new Order();
        order1.addProduct("BGLO", store);
        order1.addProduct("BGLO", store);
        order1.addProduct("BGLO", store);
        order1.addProduct("BGLO", store);
        order1.addProduct("BGLO", store);
        order1.addProduct("BGLO", store);
        Assertions.assertEquals(249, order1.getPrice(store));
    }
}
