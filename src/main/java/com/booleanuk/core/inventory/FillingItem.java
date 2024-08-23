package com.booleanuk.core.inventory;

import com.booleanuk.core.ProductName;

public class FillingItem extends InventoryItem{

    public FillingItem(float price, Enum variant) {
        super(price, variant);
    }

    @Override
    public ProductName setName() {
        return ProductName.FILLING;
    }
}
