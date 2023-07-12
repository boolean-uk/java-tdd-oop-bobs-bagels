package com.booleanuk.core;

import com.booleanuk.core.products.Product;
import com.booleanuk.core.store.Store;
import org.junit.jupiter.api.Test;

import java.util.List;

public class StoreTest {


    @Test
    public void shouldLoadDataFromJsonFile() {
        Store store = new Store();
        List<Product> availableProducts = store.getAvailableProducts();

        String json = store.getJson();


    }
}
