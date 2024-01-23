package com.booleanuk.core;

public class Coffee extends Item {
    public Coffee(String variant) {
        super(variant);
        this.setName("Coffee");
        this.setPriceOfCoffee(variant);
        this.setSkuCode("COF" + variant.toUpperCase().charAt(0));
    }

    private void setPriceOfCoffee(String variant) {
        if(variant.equalsIgnoreCase("Black")) {
            this.setPrice(0.99);
        } else if(variant.equalsIgnoreCase("White")) {
            this.setPrice(1.19);
        } else {
            this.setPrice(1.29);
        }
    }
}
