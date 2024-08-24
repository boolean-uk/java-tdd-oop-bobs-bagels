package com.booleanuk.core.inventory;

import com.booleanuk.core.enums.ProductName;

public class BagelItem extends InventoryItem {

    public BagelItem(float price, Enum variant) {
        super(price, variant);
    }

    @Override
    public ProductName setName() {
        return ProductName.BAGEL;
    }
}
