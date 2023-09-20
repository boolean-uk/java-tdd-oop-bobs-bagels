package com.booleanuk.core;

public abstract class Foods {
    private String sku;
    protected int price = -1;
    private String variant = "";

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

    public double getCost(){
        return (double) (this.price / 100.0);
    }

    public int getPrice() {
        return this.price;
    }

    protected void setPrice() {
        if (price < 0) {
            Inventory inv = new Inventory();
            this.price = inv.get(this.sku).getPrice();
        }
    }

    public String getVariant() {
        return this.variant;
    }

    protected void setVariant() {
        if (this.variant.isEmpty()) {
            Inventory inv = new Inventory();
            this.variant = inv.get(this.sku).getVariant();
        }
    }
}
