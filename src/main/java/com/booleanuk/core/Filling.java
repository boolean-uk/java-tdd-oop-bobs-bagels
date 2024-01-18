package com.booleanuk.core;

public class Filling extends Item {
    public Filling(String variant) {
        super(variant);
        this.setName("Filling");
        this.setPriceOfFilling(variant);
        this.setSkuCode("FIL" + variant.toUpperCase().charAt(0));

    }

    private void setPriceOfFilling(String variant) {
        this.setPrice(0.12);
    }


}
