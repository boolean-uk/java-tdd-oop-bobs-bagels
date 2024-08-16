package com.booleanuk.extension;

import com.booleanuk.core.BasketManager;
import com.booleanuk.core.InventoryManager;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ReceiptTest {

    @Test
    public void testPrintReceipt() {
        BasketManager basket = new BasketManager();
        InventoryManager inv = new InventoryManager();
        Receipt receipt = new Receipt(basket, inv);
    }
}

