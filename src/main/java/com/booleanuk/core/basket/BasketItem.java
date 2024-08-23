package com.booleanuk.core.basket;

public class BasketItem {

    private String SKU;
    private int Id;

    public BasketItem(String SKU) {
        this.Id = -1;
        this.SKU = SKU;
    }

    protected void setId(int itemId){
        this.Id = itemId;
    }

    public int getId() {
        return Id;
    }

    public String getSKU() {
        return SKU;
    }
}
