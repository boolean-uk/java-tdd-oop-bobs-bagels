package com.booleanuk.core;

public class Foods {
    private String sku;
    private int price;
    private String variant;

    public Foods(String sku, double price, String variant) {
        this.sku = sku;
        this.price = (int) (price * 100);
        this.variant = variant;
    }

    public Foods (String sku) {
        this.sku=sku;
    }

    public String getSku() {
        return sku;
    }


}
