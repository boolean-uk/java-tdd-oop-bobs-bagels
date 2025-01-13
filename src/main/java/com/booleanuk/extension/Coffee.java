package com.booleanuk.extension;

public class Coffee extends Item {
    private Bagel discountBagel = null;

    public Coffee(String sku, double price, String name, String variant, int size) {
        super(sku, price, name, variant, size);
    }

    public Coffee(String sku, double price, String name, String variant) {
        super(sku, price, name, variant);
    }

    public Bagel getDiscountBagel() {
        return discountBagel;
    }

    public void setDiscountBagel(Bagel discountBagel) {
        this.discountBagel = discountBagel;
    }

    @Override
    public int getSize() {
        if (discountBagel == null) {
            return super.getSize();
        }
        return super.getSize() + discountBagel.getSize();
    }
}
