package com.booleanuk.core;

import com.booleanuk.core.store.Store;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StoreTest {

    @Test
    public void shouldLoadDataFromJsonFile() {
        Store store = new Store();

        Assertions.assertEquals(14, store.getAvailableProducts().size());
    }
}
