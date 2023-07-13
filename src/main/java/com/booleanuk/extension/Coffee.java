package com.booleanuk.extension;

public class Coffee extends Item {
    public Coffee(SKU sku) {
        super(sku);
        if (!sku.getName().equals("Coffee")) {
            throw new IllegalArgumentException("Wrong coffee SKU");
        }
    }

    public Coffee(String variant) {
        super(SKU.getConstant("Coffee", variant));
    }
}
