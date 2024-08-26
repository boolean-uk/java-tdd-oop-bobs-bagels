package com.booleanuk.core.inventory;

import com.booleanuk.core.enums.ProductName;

public class CoffeeItem extends InventoryItem {

    public CoffeeItem(float price, Enum variant) {
        super(price, variant);
    }

    @Override
    public ProductName setName() {
        return ProductName.COFFEE;
    }
}
