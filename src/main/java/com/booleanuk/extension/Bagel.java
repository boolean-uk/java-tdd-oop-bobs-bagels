package com.booleanuk.extension;

public class Bagel extends Item {
    private Item filling = null;
    public Bagel(String sku, double price, String name, String variant, int size) {
        super(sku, price, name, variant, size);
    }

    public Bagel(String sku, double price, String name, String variant) {
        super(sku, price, name, variant);
    }

    public void setFilling(Item filling) {
        this.filling = filling;
    }

    public Item getFilling() {
        return this.filling;
    }

//    @Override
//    public double getPrice() {
//        if (filling == null) return getBasePrice();
//        return super.getPrice() + filling.getPrice();
//    }

//    public double getBasePrice() {
//        return super.getPrice();
//    }
}
